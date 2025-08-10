package Pages.Methods.Elements;

import Pages.Elements.Elements.E_Checkbox;
import com.codeborne.selenide.CollectionCondition;
import org.junit.jupiter.api.Assertions;

import java.util.List;
import java.util.StringTokenizer;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.open;

public class M_Checkbox {

    public void openCheckboxPage(){
        open("/checkbox");
    }

    public void clickExpandCollapseButton(E_Checkbox eCheckbox){
        eCheckbox.btnExpandCollapse.shouldBe(visible)
                .shouldBe(enabled)
                .scrollTo()
                .shouldBe(interactable)
                .click();
    }

    public void clickSelectCheckBox(E_Checkbox eCheckbox){
        eCheckbox.selectCheckBox.shouldBe(visible)
                .shouldBe(enabled)
                .scrollTo()
                .shouldBe(interactable)
                .click();
    }

    public void clickBtnExpandAll(){
        E_Checkbox eCheckbox = new E_Checkbox();
        eCheckbox.btnExpandAll.shouldBe(visible)
                .shouldBe(enabled)
                .scrollTo()
                .shouldBe(interactable)
                .click();
    }

    public void clickBtnCollapseAll(){
        E_Checkbox eCheckbox = new E_Checkbox();
        eCheckbox.btnCollapseAll.shouldBe(visible)
                .shouldBe(enabled)
                .scrollTo()
                .shouldBe(interactable)
                .click();
    }
    //Check available items under specific element (depends on collapsing)
    public void checkItemsUnderSelectedArea(E_Checkbox eCheckbox, List<String> listCompare){
        StringTokenizer st = new StringTokenizer(eCheckbox.listItems.get(0).getText());
        //eCheckbox.listItems.shouldHave(CollectionCondition.size(expNum));
        for (int i=0; i<listCompare.size()-1; i++) {
            Assertions.assertEquals(listCompare.get(i), st.nextToken("\n"));
        }
    }
}
