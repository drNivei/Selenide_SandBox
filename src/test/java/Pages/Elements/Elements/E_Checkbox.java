package Pages.Elements.Elements;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class E_Checkbox {

    public ElementsCollection listItems;
    public SelenideElement btnExpandCollapse;
    public SelenideElement selectCheckBox;

    public final SelenideElement btnExpandAll = $(".rct-option-expand-all");
    public final SelenideElement btnCollapseAll = $(".rct-option-collapse-all");

    //How it works: massive element position = layer in file tree; value = position on layer.
    //For example: Home is {1}, Home -> Desktop is {1,2}.
    public E_Checkbox(int[] a){
        String level = "";
        for(int x: a){
         level = level + " li:nth-child(" + x + ")";
        }

        btnExpandCollapse = $("#tree-node" + level + " .rct-collapse-btn > svg");
        selectCheckBox = $("#tree-node" + level + " .rct-checkbox > svg");
        listItems = $$("#tree-node" + level);
    }
    //For methods with final variables.
    public E_Checkbox(){
    }
}
