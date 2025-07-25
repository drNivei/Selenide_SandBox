//Autotests
import com.codeborne.selenide.*;
import com.codeborne.selenide.junit5.TextReportExtension;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
//Support
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
//Custom methods
import Pages.Methods.M_TextBox;


public class Tests {

   @BeforeAll
    public static void setupSelenide() {
      Configuration.baseUrl = "https://demoqa.com";
      Configuration.pageLoadTimeout = 100000;
      Configuration.browser = "firefox";
      Configuration.pageLoadStrategy =  "eager";
      SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
               .screenshots(false)
               .savePageSource(true));
    }

    @Test
    public void testTextBox_Fill() {

        M_TextBox m_textBox = new M_TextBox();

        String name = "My Name";
        String email = "email@who.com";
        String emailPlaceholder = "name@example.com";
        String currentAdress = "Current Address Country, City, Street, house, flat";
        String permanentAdress = "Permanent Address Country, City, Street, house, flat";

        m_textBox.openTextBoxPage();

        m_textBox.inputUserName_Exists();
        m_textBox.inputEmail_Exists();
        m_textBox.inputCurrentAddress_Exists();
        m_textBox.inputPermanentAddress_Exists();

        m_textBox.inputEmail_PlaceholderVerification(emailPlaceholder);

        m_textBox.inputUserName_Set(name);
        m_textBox.inputEmail_Set(email);
        m_textBox.inputCurrentAddress_Set(currentAdress);
        m_textBox.inputPermanentAddress_Set(permanentAdress);

        m_textBox.buttonSubmit_Click();

        m_textBox.outputName_Exists();
        m_textBox.outputEmail_Exists();
        m_textBox.outputCurrentAddress_Exists();
        m_textBox.outputPermanentAddress_Exists();

        m_textBox.outputName_Compare(name);
        m_textBox.outputEmail_Compare(email);
        m_textBox.outputCurrentAddress_Compare(currentAdress);
        m_textBox.outputPermanentAddress_Compare(permanentAdress);

    }

    @Test
    public void testTextBox_EmailInputError(){

        M_TextBox m_textBox = new M_TextBox();
        String email = "123";
        m_textBox.openTextBoxPage();
        m_textBox.inputEmail_Exists();
        m_textBox.inputEmail_Set(email);
        m_textBox.buttonSubmit_Click();
        m_textBox.inputEmail_InputErrorHighlightCheck();
    }

}