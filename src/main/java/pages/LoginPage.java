package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LoginPage extends BasePage {

    private static final String LoginURL = BaseURL + "customer/account/login/";
    private final Locator emailInput;
    private final Locator passwordInput;
    private final Locator loginButton;

    public LoginPage(Page page) {
        super(page);
        this.emailInput = page.locator("#email");
        this.passwordInput = page.locator("#pass");
        this.loginButton = page.locator("#send2");
    }

    public void navigateToLoginPage() {
        navigate(LoginURL);
    }

    public void enterEmail(String email) {
        fill(emailInput, email);
    }

    public void enterPassword(String password) {
        fill(passwordInput, password);
    }

    public void clickLoginButton() {
        click(loginButton);
    }


    public void login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
    }


}