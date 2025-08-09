package java.Pages.Methods.Bookstore;
import java.Pages.Elements.Bookstore.E_Profile;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class M_Profile {
    private final E_Profile eProfile = new E_Profile();
    private final M_Common mCommon = new M_Common();

    //Main Window
    public void clickBtnDeleteAccount(){
        eProfile.btnDeleteAccount
                .shouldBe(enabled)
                .scrollTo()
                .shouldBe(interactable)
                .click();
        mCommon.waitForLoading();
    }

    public void clickBtnLogout(){
        eProfile.btnLogOut
                .shouldBe(enabled)
                .scrollTo()
                .shouldBe(interactable)
                .click();
        mCommon.waitForLoading();
    }

    //Delete pop-up
    //Click OK button
    public void clickBtnOk(){
        eProfile.btnOk
                .shouldBe(enabled)
                .scrollTo()
                .shouldBe(interactable)
                .click();
    }
    //Click CANCEL button
    public void clickBtnCancel(){
        eProfile.btnCancel
                .shouldBe(enabled)
                .scrollTo()
                .shouldBe(interactable)
                .click();
    }
    //Confirm deletion
    public void confirmDelete(){
        // Get alert text
        String alertText = switchTo().alert().getText();;
        assertThat(alertText).isEqualTo("User Deleted.");
        // Then accept it
        confirm();
    }

}
