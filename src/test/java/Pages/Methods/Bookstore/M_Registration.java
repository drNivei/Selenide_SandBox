package Pages.Methods.Bookstore;
import Pages.Elements.Bookstore.E_Registration;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class M_Registration {

   private final E_Registration eRegistration = new E_Registration();
   private final M_Common mCommon = new M_Common();

   public void fillFirstName(String firstName){
       eRegistration.inputFirstName
               .setValue(firstName);
   }

   public void fillLastName(String lastName){
        eRegistration.inputLastName
                .setValue(lastName);
    }

   public void fillUserName(String userName){
        eRegistration.inputUserName
                .setValue(userName);
   }

   public void fillPassword(String password){
        eRegistration.inputPassword
                .setValue(password);
   }

   public void solveManuallyReCaptcha(){
        $("#g-recaptcha")
                .shouldBe(visible);
        System.out.println("Please solve the CAPTCHA manually within 20 seconds");
        sleep(20000);
   }

   public void clickbtnRegistration(){
       eRegistration.btnRegister
               .shouldBe(visible)
               .shouldBe(enabled)
               .scrollTo()
               .shouldBe(interactable)
               .click();
   }

   public void acceptSuccessRegistrationAlert(){
        // Get alert text
        String alertText = switchTo().alert().getText();;
        assertThat(alertText).isEqualTo("User Register Successfully.");
        // Then accept it
        confirm();
        mCommon.waitForLoading();
   }

   public void clickbtnBackToLogin(){
       eRegistration.btnBackToLogin
               .shouldBe(visible)
                .shouldBe(enabled)
                .scrollTo()
                .shouldBe(interactable)
                .click();
       mCommon.waitForLoading();
   }

}
