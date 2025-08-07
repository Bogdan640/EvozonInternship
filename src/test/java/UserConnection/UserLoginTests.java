package UserConnection;

import init.Init;
import com.microsoft.playwright.Locator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import java.util.regex.Pattern;



@DisplayName("User Authentication Tests")
public class UserLoginTests extends Init {

    private static final String LoginURL = "http://qa3magento.dev.evozon.com/customer/account/login/";

    @Test
    @DisplayName("Should login user successfully")
    void testUserLogin() {
        page.navigate(LoginURL);
        //System.out.println("Page title: " + page.title());
        assertThat(page).hasTitle(Pattern.compile(".*Login.*", Pattern.CASE_INSENSITIVE));

        performLogin();
        //System.out.println("Page title after login: " + page.title());
        assertThat(page).not().hasTitle(Pattern.compile(".*Login.*", Pattern.CASE_INSENSITIVE));
    }

    private void performLogin() {
        Locator emailInput = page.locator("#email");
        emailInput.clear();
        emailInput.fill("test1@test1.com");

        Locator passwordInput = page.locator("#pass");
        passwordInput.clear();
        passwordInput.fill("test1234");

        Locator loginButton = page.locator("#send2");
        loginButton.click();
    }
}