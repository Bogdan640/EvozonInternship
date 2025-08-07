package UserConnection;

import com.microsoft.playwright.Page;
import init.Init;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import java.util.regex.Pattern;


public class UserRegistrationTests extends Init {

    private static final String RegistrationURL = "http://qa3magento.dev.evozon.com/customer/account/create/";

    @Test
    @DisplayName("Should register a new user successfully")
    void testUserRegistration() {

        page.navigate(RegistrationURL);
        //System.out.println("Page title: " + page.title());
        assertThat(page).hasTitle(Pattern.compile(".*Create.*Account.*", Pattern.CASE_INSENSITIVE));

        fillRegistrationForm();
        Locator registerButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Register"));
        registerButton.click();

        //System.out.println("Page title after registration: " + page.title());
        assertThat(page).not().hasTitle(Pattern.compile(".*Create.*Account.*", Pattern.CASE_INSENSITIVE));
    }

    private void fillRegistrationForm() {
        Locator firstNameInput = page.locator("#firstname");
        firstNameInput.clear();
        firstNameInput.fill("test1");

        Locator lastNameInput = page.locator("#lastname");
        lastNameInput.clear();
        lastNameInput.fill("test1");

        Locator emailInput = page.locator("#email_address");
        emailInput.clear();
        //emailInput.fill("test1@test1.com");
        String randomEmail = "test" + System.currentTimeMillis() + "@test.com";
        emailInput.fill(randomEmail);

        Locator passwordInput = page.locator("#password");
        passwordInput.clear();
        passwordInput.fill("test1234");

        Locator confirmPasswordInput = page.locator("#confirmation");
        confirmPasswordInput.clear();
        confirmPasswordInput.fill("test1234");
    }
}