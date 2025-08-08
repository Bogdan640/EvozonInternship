package UserConnection;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import init.BaseTest;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import java.util.regex.Pattern;

@DisplayName("User Registration Tests")
public class RegistrationPageTests extends BaseTest {

    @Test
    @DisplayName("Should register a new user successfully")
    void testUserRegistration() {

        registrationPage.navigateToRegistrationPage();
        assertThat(page).hasTitle(Pattern.compile(".*Create.*Account.*", Pattern.CASE_INSENSITIVE));
        String randomEmail = registrationPage.generateRandomEmail();
        registrationPage.registerUser("Test", "User", randomEmail, "Password123");
        assertThat(page).not().hasTitle(Pattern.compile(".*Create.*Account.*", Pattern.CASE_INSENSITIVE));
        assertThat(page.locator(".success-msg")).isVisible();
    }

}