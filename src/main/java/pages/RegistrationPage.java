package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class RegistrationPage extends HeaderPage {
    private static final String RegistrationURL = BaseURL + "customer/account/create/";
    private final Locator firstNameInput;
    private final Locator lastNameInput;
    private final Locator emailInput;
    private final Locator passwordInput;
    private final Locator confirmPasswordInput;
    private final Locator registerButton;

    public RegistrationPage(Page page) {
        super(page);
        this.firstNameInput = page.locator("#firstname");
        this.lastNameInput = page.locator("#lastname");
        this.emailInput = page.locator("#email_address");
        this.passwordInput = page.locator("#password");
        this.confirmPasswordInput = page.locator("#confirmation");
        this.registerButton = getByRole(AriaRole.BUTTON, "Register");
    }

    public void navigateToRegistrationPage() {
        navigate(RegistrationURL);
    }

    public void enterFirstName(String firstName) {
        fill(firstNameInput, firstName);
    }

    public void enterLastName(String lastName) {
        fill(lastNameInput, lastName);
    }

    public void enterEmail(String email) {
        fill(emailInput, email);
    }

    public void enterPassword(String password) {
        fill(passwordInput, password);
    }

    public void enterConfirmPassword(String password) {
        fill(confirmPasswordInput, password);
    }

    public void clickRegisterButton() {
        click(registerButton);
    }

    public void registerUser(String firstName, String lastName, String email, String password) {
        enterFirstName(firstName);
        enterLastName(lastName);
        enterEmail(email);
        enterPassword(password);
        enterConfirmPassword(password);
        clickRegisterButton();
    }

    public String generateRandomEmail() {
        return "test" + System.currentTimeMillis() + "@test.com";
    }
}