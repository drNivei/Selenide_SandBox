import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class Tests {

   @BeforeAll
    public static void setUp() {
      Configuration.baseUrl = "https://demoqa.com";
      Configuration.pageLoadTimeout = 100000;
      Configuration.browser = "firefox";
      Configuration.pageLoadStrategy =  "eager";
    }

    @Test
    public void testSomething() {

        // ... your test logic
    }

    @Test
    public void testSomethingElse() throws InterruptedException {
        //System.setProperty("webdriver.chrome.driver", "C:\\CromeDriver\\chromedriver.exe");
        open("/text-box");
        $(By.id("userName")).should(exist).shouldBe(visible);
        $(By.id("userName")).setValue("My Name");

        $(By.id("userEmail")).should(exist).shouldBe(visible);
        $(By.id("userEmail")).setValue("email@who.com");

        $(By.id("currentAddress")).should(exist).shouldBe(visible);
        $(By.id("currentAddress")).setValue("Current Address Country, City, Street, house, flat");

        $(By.id("permanentAddress")).should(exist).shouldBe(visible);
        $(By.id("permanentAddress")).setValue("Permanent Address Country, City, Street, house, flat");

        $(By.id("permanentAddress")).setValue("Permanent Address Country, City, Street, house, flat");

        //$("#submit").hover();
        $(By.id("submit")).pressEnter();

        $("#output #name").should(exist).shouldBe(visible).shouldHave(exactText("Name:My Name"), Duration.ofSeconds(18));
        $("#output #email").should(exist).shouldBe(visible).shouldHave(exactText("Email:email@who.com"), Duration.ofSeconds(18));
        $("#output #currentAddress").shouldHave(exactText("Current Address :Current Address Country, City, Street, house, flat"), Duration.ofSeconds(18));
        $("#output #permanentAddress").should(exist).shouldBe(visible).shouldHave(exactText("Permananet Address :Permanent Address Country, City, Street, house, flat"), Duration.ofSeconds(18));
        // ... your test logic
    }
}