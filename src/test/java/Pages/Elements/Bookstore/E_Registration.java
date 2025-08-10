package Pages.Elements.Bookstore;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class E_Registration {

    public final SelenideElement inputFirstName = $("#firstname");
    public final SelenideElement inputLastName = $("#lastname");
    public final SelenideElement inputUserName = $("#userName");
    public final SelenideElement inputPassword = $("#password");

    public final SelenideElement ReCaptchaCheckbox = $(".recaptcha-checkbox-border");
    public final SelenideElement ReCaptchaCheckmark = $(".recaptcha-checkbox-checkmark");

    public final SelenideElement btnRegister = $("#register");
    public final SelenideElement btnBackToLogin = $("#gotologin");
}
