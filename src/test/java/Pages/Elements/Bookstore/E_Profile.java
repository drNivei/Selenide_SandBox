package Pages.Elements.Bookstore;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class E_Profile {
    //Page elements
    public final SelenideElement btnLogOut = $x("//button[text()='Log out']");
    public final SelenideElement btnDeleteAccount = $x("//button[text()='Delete Account']");
    //public SelenideElement btnGoToBookStore = $x("//button[text()='Go To Book Store']");
    //public SelenideElement btnDeleteAllBooks = $x("//button[text()='Delete All Books']");

    //Delete Account Confirmation Pop-up elements
    public final SelenideElement btnOk = $("#closeSmallModal-ok");
    public final SelenideElement btnCancel = $("#closeSmallModal-cancel");
}
