package Pages.Methods.Bookstore;
import Pages.Elements.Bookstore.E_Login;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class M_Login {
    private final E_Login eLogin = new E_Login();
    private final M_Common mCommon = new M_Common();

   public void openLoginPage(){
        open("/login");
    }

     public void clickBtnNewUser(){
        eLogin.btnNewUser.shouldBe(visible)
                .shouldBe(enabled)
                .scrollTo()
                .shouldBe(interactable)
                .click();
         webdriver().shouldHave(url("https://demoqa.com/register"));
         mCommon.waitForLoading();
    }

    public void clickBtnLogin(){
        eLogin.btnLogin.shouldBe(visible)
                .shouldBe(enabled)
                .scrollTo()
                .shouldBe(interactable)
                .click();
        mCommon.waitForLoading();
    }

    public void fillUserName(String userName){
        eLogin.inputUserName.shouldBe(visible, Duration.ofSeconds(30))
                .shouldBe(enabled)
                .scrollTo()
                .shouldBe(interactable)
                .setValue(userName);
    }

    public void fillPassword(String password){
        eLogin.inputPassword.shouldBe(visible)
                .shouldBe(enabled)
                .scrollTo()
                .shouldBe(interactable)
                .setValue(password);
    }

    public void outputInvalidUserNameOrPassword(){
      eLogin.outputMessage.shouldHave(exactText("Invalid username or password!"));
    }



}
