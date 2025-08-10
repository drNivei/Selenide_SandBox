package Pages.Elements.Elements;
import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.SelenideElement;

public class E_TextBox {
    //Input fields
    public final SelenideElement inputUserName = $("#userName");

    public final SelenideElement inputEmail = $("#userEmail");

    public final SelenideElement inputCurrentAddress = $("#currentAddress");

    public final SelenideElement inputPermanentAddress = $("#permanentAddress");

    //Output fields
    public final SelenideElement outputName = $("#output #name");

    public final SelenideElement outputEmail = $("#output #email");

    public final SelenideElement outputCurrentAddress = $("#output #currentAddress");

    public final SelenideElement outputPermanentAddress = $("#output #permanentAddress");

    //Buttons
    public final SelenideElement buttonSubmit = $("#submit");

}
