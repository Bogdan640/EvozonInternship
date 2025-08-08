package wishlist;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import init.BaseTest;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;


@DisplayName("Wishlist Tests")
public class WishlistPageTests extends BaseTest {

    private static final String productName = "Jackie O Round Sunglasses";

    @Test
    @DisplayName("Should add product to wishlist successfully")
    void testAddToWishlist() {

        loginPage.navigateToLoginPage();
        loginPage.login("test1@test1.com", "test1234");
        productListingPage = homePage.navigateToSalePage();
        productPage = productListingPage.clickProductByName(productName);
        wishlistPage = productPage.addToWishlist();
        assertThat(page.locator(".success-msg")).isVisible();
        assertTrue(wishlistPage.isProductInWishlist(productName));
    }

    @Test
    @DisplayName("Should display wishlist items correctly")
    void testWishlistDisplay() {

        loginPage.navigateToLoginPage();
        loginPage.login("test1@test1.com", "test1234");
        wishlistPage.navigateToWishlistPage();
        assertThat(page.locator(".my-account")).isVisible();
        productListingPage = homePage.navigateToSalePage();
        productPage = productListingPage.clickProductByName(productName);
        wishlistPage = productPage.addToWishlist();
        assertTrue(wishlistPage.isProductInWishlist(productName));
    }
}