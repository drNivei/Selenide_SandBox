import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;

public class Tests {

   @BeforeAll
    public static void setUp() {
      // Configuration.timeout = 10000;
      Configuration.pageLoadStrategy = "none";
      Configuration.baseUrl = "https";
      Configuration.browserCapabilities = new ChromeOptions().addArguments("--no-sandbox");
      Configuration.browserCapabilities = new ChromeOptions().addArguments("--disable-dev-shm-usage");
     // Configuration.browserCapabilities = new ChromeOptions().addArguments("--headless");
    }

    @Test
    public void testSomething() {

        // ... your test logic
    }

    @Test
    public void testSomethingElse() {
        System.setProperty("webdriver.chrome.driver", "C:\\CromeDriver\\chromedriver.exe");
       // Configuration.browser = "firefox";
        open("https://example.com/another-page");
        // ... your test logic
    }
}