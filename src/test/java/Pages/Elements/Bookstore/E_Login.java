package Pages.Elements.Bookstore;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class E_Login {

    public SelenideElement inputUserName = $("#userName");
    public SelenideElement inputPassword = $("#password");

    public SelenideElement btnLogin = $("#login");
    public SelenideElement btnNewUser = $("#newUser");

    public SelenideElement outputMessage = $("#output");


}
