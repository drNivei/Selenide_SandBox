import Pages.Elements.Elements.E_Checkbox;
import Pages.Methods.Elements.M_Checkbox;
import com.codeborne.selenide.*;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
//Support
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
//Custom methods

import java.util.ArrayList;
import java.util.List;

public class Tests_Checkbox {

    private final M_Checkbox mCheckbox = new M_Checkbox();

    @BeforeAll
    public static void setupSelenide() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadTimeout = 100000;
        Configuration.browser = "firefox";
        Configuration.pageLoadStrategy =  "eager";
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(true));
    }

    @Test
    @Epic("Elements")
    @Feature("Check Box")
    @Story("Basic verifications.")
    public void testCheckBox_SelectItem(){
        //List to compare with
        List<String> listCompare = new ArrayList<>();
        listCompare.add("Home"); listCompare.add("Desktop"); listCompare.add("Notes"); listCompare.add("Commands");
        listCompare.add("Documents"); listCompare.add("WorkSpace"); listCompare.add("React"); listCompare.add("Angular");
        listCompare.add("Veu"); listCompare.add("Office"); listCompare.add("Public"); listCompare.add("Private"); listCompare.add("Classified");
        listCompare.add("General"); listCompare.add("Downloads"); listCompare.add("Word File.doc"); listCompare.add("Excel File.doc");
        //Home element
        int[] lvl1 = {1};
        E_Checkbox eCheckboxlvl1 = new E_Checkbox(lvl1);
        //Desktop element
        int[] lvl1_2 = {1,2};
        E_Checkbox eCheckboxlvl1_2 = new E_Checkbox(lvl1_2);
        //Test
        Allure.step("Open Checkbox page");
            mCheckbox.openCheckboxPage();
        Allure.step("Click on expand all button");
            mCheckbox.clickBtnExpandAll();
        Allure.step("Verify all items in list");
            mCheckbox.checkItemsUnderSelectedArea(eCheckboxlvl1, listCompare);
        Allure.step("Click on collapse all button");
            mCheckbox.clickBtnCollapseAll();
        Allure.step("Click on Expand/Collapse button for Home");
            mCheckbox.clickExpandCollapseButton(eCheckboxlvl1);
        Allure.step("Click on Expand/Collapse button for Desktop");
            mCheckbox.clickExpandCollapseButton(eCheckboxlvl1_2);
        Allure.step("Click on Expand/Collapse button for Desktop");
            mCheckbox.clickSelectCheckBox(eCheckboxlvl1_2);
    }
}
