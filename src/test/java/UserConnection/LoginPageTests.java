package UserConnection;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import init.BaseTest;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import java.util.regex.Pattern;

@DisplayName("User Login Tests")
public class LoginPageTests extends BaseTest {

    @Test
    @DisplayName("Should login user successfully")
    void testUserLogin() {

        loginPage.navigateToLoginPage();
        assertThat(page).hasTitle(Pattern.compile(".*Login.*", Pattern.CASE_INSENSITIVE));
        loginPage.login("test1@test1.com", "test1234");
        assertThat(page).not().hasTitle(Pattern.compile(".*Login.*", Pattern.CASE_INSENSITIVE));
        assertThat(page.locator(".hello strong")).containsText("Hello,");
    }

    @Test
    @DisplayName("Should show error for invalid credentials")
    void testInvalidLogin() {

        loginPage.navigateToLoginPage();
        loginPage.login("invalid2342351@example.com", "sporlacafelutza");
        assertThat(page.locator(".error-msg")).isVisible();
    }
}
