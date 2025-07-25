package Pages.Methods;
import Pages.Elements.E_TextBox;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

public class M_TextBox extends E_TextBox {
    //Service
    public void openTextBoxPage() {
        open("/text-box");
    }

    //inputUserName
    public void inputUserName_Exists() {
        inputUserName.should(exist).shouldBe(visible);
    }

    public void inputUserName_Set(String name) {
        inputUserName.setValue(name);
    }

    //inputEmail
    public void inputEmail_Exists() {
        inputEmail.should(exist).shouldBe(visible);
    }

    public void inputEmail_Set(String email) {
        inputEmail.setValue(email);
    }

    public void inputEmail_InputErrorHighlightCheck(){
        if(!inputEmail.getAttribute("class").contains("field-error")){
            fail("Field is not highlighted red because of Error input");
        };
    }

    //inputCurrentAddress
    public void inputCurrentAddress_Exists() {
        inputCurrentAddress.should(exist).shouldBe(visible);
    }

    public void inputCurrentAddress_Set(String email) {
        inputCurrentAddress.setValue(email);
    }

    //inputPermanentAddress
    public void inputPermanentAddress_Exists() {
        inputPermanentAddress.should(exist).shouldBe(visible);
    }

    public void inputPermanentAddress_Set(String email) {
        inputPermanentAddress.setValue(email);
    }

    //buttonSubmit
    public void buttonSubmit_Click() {
        buttonSubmit.pressEnter();
    }

    //outputName
    public void outputName_Exists() {
        outputName.should(exist).shouldBe(visible);
    }

    public void outputName_Compare(String str) {
        outputName.shouldHave(exactText("Name:" + str), Duration.ofSeconds(4));;
    }
    //outputEmail
    public void outputEmail_Exists() {
        outputEmail.should(exist).shouldBe(visible);
    }

    public void outputEmail_Compare(String str) {
        outputEmail.shouldHave(exactText("Email:" + str), Duration.ofSeconds(4));;
    }

    public void inputEmail_PlaceholderVerification(String str) {
        inputEmail.shouldHave(attribute("placeholder", str));
    }

    //outputCurrentAddress
    public void outputCurrentAddress_Exists() {
        outputCurrentAddress.should(exist).shouldBe(visible);
    }

    public void outputCurrentAddress_Compare(String str) {
        outputCurrentAddress.shouldHave(exactText("Current Address :" + str), Duration.ofSeconds(4));;
    }
    //outputPermanentAddress
    public void outputPermanentAddress_Exists() {
        outputPermanentAddress.should(exist).shouldBe(visible);
    }

    public void outputPermanentAddress_Compare(String str) {
        outputPermanentAddress.shouldHave(exactText("Permananet Address :" + str), Duration.ofSeconds(4));;
    }

}
