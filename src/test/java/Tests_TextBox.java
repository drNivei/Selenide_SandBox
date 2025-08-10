import com.codeborne.selenide.*;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Allure;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
//Support
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
//Custom methods
import Pages.Methods.Elements.M_TextBox;


public class Tests_TextBox {
    private final M_TextBox m_textBox = new M_TextBox();

   @BeforeAll
    public static void setupSelenide() {
      Configuration.baseUrl = "https://demoqa.com";
      Configuration.pageLoadTimeout = 100000;
      Configuration.browser = "firefox";
      Configuration.pageLoadStrategy =  "eager";
      SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
               .screenshots(true)
               .savePageSource(true)
               .includeSelenideSteps(true));
       // Firefox-specific settings
       Configuration.browserCapabilities.setCapability("acceptInsecureCerts", true);
    }

    @Test
    @Epic("Elements")
    @Feature("Text Box")
    @Story("Positive test with output verification")
    public void testTextBox_Fill() {
        //Name field value
        String name = "My Name";
        //Email field value
        String email = "email@who.com";
        //Email placeholder text
        String emailPlaceholder = "name@example.com";
        //Current Address field value
        String currentAddress = "Current Address Country, City, Street, house, flat";
        //Permanent Address field value
        String permanentAddress = "Permanent Address Country, City, Street, house, flat";
        //Test
        Allure.step("Open Text box page");
            m_textBox.openTextBoxPage();
        Allure.step("Check that all field exists");
            m_textBox.inputUserName_Exists();
            m_textBox.inputEmail_Exists();
            m_textBox.inputCurrentAddress_Exists();
            m_textBox.inputPermanentAddress_Exists();
        Allure.step("Check email placeholder text");
         m_textBox.inputEmail_PlaceholderVerification(emailPlaceholder);
        Allure.step("Fill all field with data");
            m_textBox.inputUserName_Set(name);
            m_textBox.inputEmail_Set(email);
            m_textBox.inputCurrentAddress_Set(currentAddress);
            m_textBox.inputPermanentAddress_Set(permanentAddress);
        Allure.step("Click Submit Button");
         m_textBox.buttonSubmit_Click();
        Allure.step("Check that output results exist");
            m_textBox.outputName_Exists();
            m_textBox.outputEmail_Exists();
            m_textBox.outputCurrentAddress_Exists();
            m_textBox.outputPermanentAddress_Exists();
        Allure.step("Verify output results");
            m_textBox.outputName_Compare(name);
            m_textBox.outputEmail_Compare(email);
            m_textBox.outputCurrentAddress_Compare(currentAddress);
            m_textBox.outputPermanentAddress_Compare(permanentAddress);
    }

    @Test
    @Epic("Elements")
    @Feature("Text Box")
    @Story("Verify that Email field is higlighted RED when format is not correct.")
    public void testTextBox_EmailInputError(){
        //Email field value - incorrect format
        String email = "123";
        //Test
        Allure.step("Open Text box page");
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