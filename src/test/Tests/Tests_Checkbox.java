package Tests;
import com.codeborne.selenide.*;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
//Support
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
//Custom methods

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class Tests_Checkbox {
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
    public void testCheckBox_SelectItem(){
        open("/checkbox");
// Select all li elements within an ol
        ElementsCollection listItems = $$("#tree-node li");

        List<String> listCompare = new ArrayList<>();
        listCompare.add("Home"); listCompare.add("Desktop"); listCompare.add("Notes"); listCompare.add("Commands");
        listCompare.add("Documents"); listCompare.add("WorkSpace"); listCompare.add("React"); listCompare.add("Angular");
        listCompare.add("Veu"); listCompare.add("Office"); listCompare.add("Public"); listCompare.add("Private"); listCompare.add("Classified");
        listCompare.add("General"); listCompare.add("Downloads"); listCompare.add("Word File.doc"); listCompare.add("Excel File.doc");


        SelenideElement expandCollapseButton_lvl0 = $("#tree-node > ol > li:nth-child(1) > .rct-text > .rct-collapse.rct-collapse-btn > svg");
        expandCollapseButton_lvl0.shouldBe(visible).click();
        SelenideElement expandCollapseButton_lvl1 = $("#tree-node > ol > li:nth-child(1) > ol > li:nth-child(1) >.rct-text > .rct-collapse.rct-collapse-btn > svg");
        expandCollapseButton_lvl1.shouldBe(visible).click();

        SelenideElement ele2 = $("#tree-node > ol > li:nth-child(1) > .rct-text > label > .rct-checkbox > svg");
        ele2.shouldBe(visible).click();

        SelenideElement ele3 = $("#tree-node > .rct-options > .rct-option.rct-option-expand-all");
        ele3.shouldBe(visible).click();

        StringTokenizer st = new StringTokenizer(listItems.get(0).getText());

        listItems.shouldHave(CollectionCondition.size(17));
        for (int i=0; i<listCompare.size()-1; i++) {
            Assertions.assertEquals(listCompare.get(i), st.nextToken("\n"));
        }

        SelenideElement ele4 = $("#tree-node > .rct-options > .rct-option.rct-option-collapse-all");
        ele4.shouldBe(visible).click();


        ElementsCollection listItems2 = $$("#tree-node > ol > li:nth-child(1) > ol > li");

        //System.out.println(ele1.getText());

// Iterate through the collection
        for (SelenideElement item : listItems2) {
            System.out.println(item.getText());
        }
    }
}
