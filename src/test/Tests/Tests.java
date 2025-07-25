import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.*;
import com.codeborne.selenide.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.time.Duration;

import Methods.M_TextBox;
import org.openqa.selenium.By;

public class Tests {

   @BeforeAll
    public static void setUp() {
      Configuration.baseUrl = "https://demoqa.com";
      Configuration.pageLoadTimeout = 100000;
      Configuration.browser = "firefox";
      Configuration.pageLoadStrategy =  "eager";
    }

    @Test
    public void testTextBox_Fill() {

        M_TextBox m_textBox = new M_TextBox();

        String name = "My Name";
        String email = "email@who.com";
        String currentAdress = "Current Address Country, City, Street, house, flat";
        String permanentAdress = "Permanent Address Country, City, Street, house, flat";

        m_textBox.openTextBoxPage();

        m_textBox.inputUserName_Exists();
        m_textBox.inputEmail_Exists();
        m_textBox.inputCurrentAddress_Exists();
        m_textBox.inputPermanentAddress_Exists();

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