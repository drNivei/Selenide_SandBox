package Pages.Elements;
import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.SelenideElement;

public class E_TextBox {
    //Input fields
    public SelenideElement inputUserName = $("#userName");

    public SelenideElement inputEmail = $("#userEmail");

    public SelenideElement inputCurrentAddress = $("#currentAddress");

    public SelenideElement inputPermanentAddress = $("#permanentAddress");

    //Output fields
    public SelenideElement outputName = $("#output #name");

    public SelenideElement outputEmail = $("#output #email");

    public SelenideElement outputCurrentAddress = $("#output #currentAddress");

    public SelenideElement outputPermanentAddress = $("#output #permanentAddress");

    //Buttons
    public SelenideElement buttonSubmit = $("#submit");

}
