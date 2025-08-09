package Tests;//Autotests
import com.codeborne.selenide.*;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Allure;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
//Support
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
//Custom methods
import Tests.Pages.Methods.Elements.M_TextBox;


public class Tests_TextBox {

   @BeforeAll
    public static void setupSelenide() {
      Configuration.baseUrl = "https://demoqa.com";
      Configuration.pageLoadTimeout = 100000;
      Configuration.browser = "firefox";
      Configuration.pageLoadStrategy =  "eager";
      SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
               .screenshots(true)
               .savePageSource(true));
    }

    @Test
    public void testTextBox_Fill() {

        M_TextBox m_textBox = new M_TextBox();

        String name = "My Name";

        String email = "email@who.com";
        String emailPlaceholder = "name@example.com";

        String currentAddress = "Current Address Country, City, Street, house, flat";

        String permanentAddress = "Permanent Address Country, City, Street, house, flat";

        m_textBox.openTextBoxPage();

        m_textBox.inputUserName_Exists();
        m_textBox.inputEmail_Exists();
        m_textBox.inputCurrentAddress_Exists();
        m_textBox.inputPermanentAddress_Exists();

        m_textBox.inputEmail_PlaceholderVerification(emailPlaceholder);

        m_textBox.inputUserName_Set(name);
        m_textBox.inputEmail_Set(email);
        m_textBox.inputCurrentAddress_Set(currentAddress);
        m_textBox.inputPermanentAddress_Set(permanentAddress);

        m_textBox.buttonSubmit_Click();

        m_textBox.outputName_Exists();
        m_textBox.outputEmail_Exists();
        m_textBox.outputCurrentAddress_Exists();
        m_textBox.outputPermanentAddress_Exists();

        m_textBox.outputName_Compare(name);
        m_textBox.outputEmail_Compare(email);
        m_textBox.outputCurrentAddress_Compare(currentAddress);
        m_textBox.outputPermanentAddress_Compare(permanentAddress);

    }

    @Test
    @Epic("User Management") // This test belongs to the "User Management" epic
    @Feature("Login Functionality")
    @Story("Successful Login with Valid Credentials")
    public void testTextBox_EmailInputError(){

        M_TextBox m_textBox = new M_TextBox();

        String email = "123";
        Allure.step("Open ");
        m_textBox.openTextBoxPage();
        Allure.step("Verify that field 'Email' exists");
        m_textBox.inputEmail_Exists();
        Allure.step("Set value '" + email + "' to 'Email' field");
        m_textBox.inputEmail_Set(email);
        Allure.step("Click SUBMIT button");
        m_textBox.buttonSubmit_Click();
        Allure.step("Verify that field 'Email' border is highlighted RED");
        m_textBox.inputEmail_InputErrorHighlightCheck();
    }
}