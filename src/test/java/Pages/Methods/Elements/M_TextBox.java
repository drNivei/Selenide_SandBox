package Pages.Methods.Elements;
import Pages.Elements.Elements.E_TextBox;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.support.Color;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

import java.time.Duration;

public class M_TextBox {

    private final E_TextBox eTextBox = new E_TextBox();
    //Service
    public void openTextBoxPage() {
        open("/text-box");
    }

    //inputUserName
    public void inputUserName_Exists() {
        eTextBox.inputUserName
                .should(exist)
                .shouldBe(visible);
    }

    public void inputUserName_Set(String name) {
        eTextBox.inputUserName
                .shouldBe(visible)
                .shouldBe(enabled)
                .scrollTo()
                .shouldBe(interactable)
                .setValue(name);
    }

    //inputEmail
    public void inputEmail_Exists() {
        eTextBox.inputEmail
                .should(exist)
                .shouldBe(visible);
    }

    public void inputEmail_Set(String email) {
        eTextBox.inputEmail
                .shouldBe(visible)
                .shouldBe(enabled)
                .scrollTo()
                .shouldBe(interactable)
                .setValue(email);
    }

    public void inputEmail_InputErrorHighlightCheck(){
        eTextBox.inputEmail
                .shouldBe(visible)
                .shouldHave(cssValue("border-top-color", "rgb(255, 0, 0)"));
        // Convert to Hex (if needed)
        //Color color = Color.fromString(borderColorRgba);
        //String hexColor = color.asHex(); // Format: #rrggbb

        //Check class changes
        Assertions.assertTrue(eTextBox.inputEmail
                .getAttribute("class")
                .contains("field-error"));
       }

    //inputCurrentAddress
    public void inputCurrentAddress_Exists() {
        eTextBox.inputCurrentAddress
                .should(exist)
                .shouldBe(visible);
    }

    public void inputCurrentAddress_Set(String email) {
        eTextBox.inputCurrentAddress
                .shouldBe(visible)
                .shouldBe(enabled)
                .scrollTo()
                .shouldBe(interactable)
                .setValue(email);
    }

    //inputPermanentAddress
    public void inputPermanentAddress_Exists() {
        eTextBox.inputPermanentAddress
                .should(exist)
                .shouldBe(visible);
    }

    public void inputPermanentAddress_Set(String email) {
        eTextBox.inputPermanentAddress
                .shouldBe(visible)
                .shouldBe(enabled)
                .scrollTo()
                .shouldBe(interactable)
                .setValue(email);
    }

    //buttonSubmit
    public void buttonSubmit_Click() {
        eTextBox.buttonSubmit
                .pressEnter();
    }

    //outputName
    public void outputName_Exists() {
        eTextBox.outputName
                .should(exist)
                .shouldBe(visible);
    }

    public void outputName_Compare(String str) {
        eTextBox.outputName
                .shouldBe(visible)
                .scrollTo()
                .shouldHave(exactText("Name:" + str), Duration.ofSeconds(4));;
    }
    //outputEmail
    public void outputEmail_Exists() {
        eTextBox.outputEmail
                .should(exist)
                .shouldBe(visible);
    }

    public void outputEmail_Compare(String str) {
        eTextBox.outputEmail
                .shouldBe(visible)
                .scrollTo()
                .shouldHave(exactText("Email:" + str), Duration.ofSeconds(4));;
    }

    public void inputEmail_PlaceholderVerification(String str) {
        eTextBox.inputEmail
                .shouldHave(attribute("placeholder", str));
    }

    //outputCurrentAddress
    public void outputCurrentAddress_Exists() {
        eTextBox.outputCurrentAddress
                .should(exist).shouldBe(visible);
    }

    public void outputCurrentAddress_Compare(String str) {
        eTextBox.outputCurrentAddress
                .shouldBe(visible)
                .scrollTo()
                .shouldHave(exactText("Current Address :" + str), Duration.ofSeconds(4));;
    }
    //outputPermanentAddress
    public void outputPermanentAddress_Exists() {
        eTextBox.outputPermanentAddress
                .should(exist)
                .shouldBe(visible);
    }

    public void outputPermanentAddress_Compare(String str) {
        eTextBox.outputPermanentAddress
                .shouldBe(visible)
                .scrollTo()
                .shouldHave(exactText("Permananet Address :" + str), Duration.ofSeconds(4));;
    }

}
