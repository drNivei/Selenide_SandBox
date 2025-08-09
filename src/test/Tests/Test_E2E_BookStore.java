package Tests;

import Tests.Pages.Methods.Bookstore.*;
import com.codeborne.selenide.Configuration;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;


public class Test_E2E_BookStore {
    //private final M_Common mCommon = new M_Common();
    private final M_Login mLogin = new M_Login();
    private final M_Profile mProfile = new M_Profile();
    private final M_Registration mRegistration = new M_Registration();

    @BeforeAll
    public static void setupSelenide() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadTimeout = 100000;
        Configuration.browser = "firefox";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy =  "eager";
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(true));
    }

    @Test
    public void testUserE2E(){
        String FirstName = "Alex1";
        String LastName = "Alekseev";
        String UserName = "Biba";
        String password = "!1asdfAAdd";

        //Open Login page
        mLogin.openLoginPage();
        //Go to Registration Screen
        mLogin.clickBtnNewUser();
        //Fill user information
        mRegistration.fillFirstName(FirstName);
        mRegistration.fillLastName(LastName);
        mRegistration.fillUserName(UserName);
        mRegistration.fillPassword(password);
        //IMPORTANT! Need to solve CAPTCHA manually
        mRegistration.solveManuallyReCaptcha();
        //Complete registration
        mRegistration.clickbtnRegistration();
        mRegistration.acceptSuccessRegistrationAlert();
        //Back to Login Page
        mRegistration.clickbtnBackToLogin();
        //Fill Login Credentials
        mLogin.fillUserName(UserName);
        mLogin.fillPassword(password);
        //Login and waiting for loading label to disappear
        mLogin.clickBtnLogin();
        webdriver().shouldHave(url("https://demoqa.com/profile"));
        //Log out
        mProfile.clickBtnLogout();
        //Log in again
        //Fill Login Credentials
        mLogin.fillUserName(UserName);
        mLogin.fillPassword(password);
        //Login and waiting for loading label to disappear
        mLogin.clickBtnLogin();
        //Delete account
        mProfile.clickBtnDeleteAccount();
        mProfile.clickBtnOk();
        mProfile.confirmDelete();
        //Log in again
        //Fill Login Credentials
        mLogin.fillUserName(UserName);
        mLogin.fillPassword(password);
        //Login and waiting for loading label to disappear
        mLogin.clickBtnLogin();
        //Check error message 'Invalid username or password!'
        mLogin.outputInvalidUserNameOrPassword();
    }

}
