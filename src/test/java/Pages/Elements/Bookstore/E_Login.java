package Pages.Elements.Bookstore;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class E_Login {

    public final SelenideElement inputUserName = $("#userName");
    public final SelenideElement inputPassword = $("#password");

    public final SelenideElement btnLogin = $("#login");
    public final SelenideElement btnNewUser = $("#newUser");

    public final SelenideElement outputMessage = $("#output");


}
