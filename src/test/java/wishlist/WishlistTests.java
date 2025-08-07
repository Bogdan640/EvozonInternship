package wishlist;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.SelectOption;
import init.Init;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

@DisplayName("Wishlist Tests")
public class WishlistTests extends Init {

    private static final String LoginURL = "http://qa3magento.dev.evozon.com/customer/account/login/";

    @Test
    @DisplayName("Should add product to wishlist successfully")
    void testAddToWishlist() {

        page.navigate(LoginURL);
        System.out.println("Page title: " + page.title());
        performLogin();
        System.out.println("Page title after login: " + page.title());

        Locator saleButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Sale")).first();
        assertThat(saleButton).isVisible();
        saleButton.click();
        System.out.println("Page title after sale button click: " + page.title());

        Locator productImage = page.locator("a.product-image[title='Jackie O Round Sunglasses']").first();
        assertThat(productImage).isVisible();
        productImage.click();
        System.out.println("Page title after product image click: " + page.title());

        Locator addToWishlistButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Add to Wishlist"));
        assertThat(addToWishlistButton).isVisible();
        addToWishlistButton.click();

        System.out.println("Page title after add to wishlist: " + page.title());
    }

    private void performLogin() {
        Locator emailInput = page.locator("#email");
        assertThat(emailInput).isVisible();
        emailInput.clear();
        emailInput.fill("test1@test1.com");
        assertThat(emailInput).hasValue("test1@test1.com");

        Locator passwordInput = page.locator("#pass");
        assertThat(passwordInput).isVisible();
        passwordInput.clear();
        passwordInput.fill("test1234");

        Locator loginButton = page.locator("#send2");
        assertThat(loginButton).isVisible();
        loginButton.click();
    }
}