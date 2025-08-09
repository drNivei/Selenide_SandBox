package java.Pages.Elements.Bookstore;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class E_Registration {

    public SelenideElement inputFirstName = $("#firstname");
    public SelenideElement inputLastName = $("#lastname");
    public SelenideElement inputUserName = $("#userName");
    public SelenideElement inputPassword = $("#password");

    public SelenideElement ReCaptchaCheckbox = $(".recaptcha-checkbox-border");
    public SelenideElement ReCaptchaCheckmark = $(".recaptcha-checkbox-checkmark");

    public SelenideElement btnRegister = $("#register");
    public SelenideElement btnBackToLogin = $("#gotologin");
}
