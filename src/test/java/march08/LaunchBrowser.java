package march08;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LaunchBrowser {

    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(
                new LaunchOptions().setHeadless(false)
        );
        Page page = browser.newPage();
        page.navigate("https://demoqa.com");
        Locator appStoreApplicationTab = page.locator("//*[text()='Book Store Application']");
        appStoreApplicationTab.click();
        Locator loginOption = page.locator("//*[text()='Book Store Application']//ancestor::div[@class='element-group']//*[text() = 'Login']");
        loginOption.click();

        assertThat(page).hasURL("https://demoqa.com/login");

        Locator userNameInput = page.locator("//div[@class='login-wrapper']//input[@id='userName']");
        Locator passwordInput = page.locator("//div[@class='login-wrapper']//input[@id='password']");
        Locator newUserButton = page.locator("//div[@class='login-wrapper']//button[@id='newUser']");

        userNameInput.type("testuser");
        passwordInput.type("Test@123");
        newUserButton.click();

    }
}
