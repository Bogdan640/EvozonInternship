package product;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import init.BaseTest;
import pages.ProductListingPage;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.regex.Pattern;

@DisplayName("Product Listing Tests")
public class ProductListingPageTests extends BaseTest {

    @Test
    @DisplayName("Should display search results correctly")
    void testProductSearch() {
        homePage.navigateToHomePage();
        ProductListingPage resultsPage = searchPage.searchForProduct("t");
        assertThat(page).hasTitle(Pattern.compile(".*Search.*t.*", Pattern.CASE_INSENSITIVE));
        assertThat(page.locator(".category-products")).isVisible();
    }

    @Test
    @DisplayName("Should display sale page products")
    void testSalePageProducts() {
        homePage.navigateToHomePage();
        productListingPage = homePage.navigateToSalePage();
        assertTrue(productListingPage.hasResults());
        assertTrue(productListingPage.getProductCount() > 0);
    }
}