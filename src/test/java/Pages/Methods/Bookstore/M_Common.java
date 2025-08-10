package Pages.Methods.Bookstore;

import Pages.Elements.Bookstore.E_Common;

import static com.codeborne.selenide.Condition.disappear;

public class M_Common {
E_Common eCommon =  new E_Common();

    public void waitForLoading(){
        eCommon.loadingLabel
                .should(disappear);
    }
}
