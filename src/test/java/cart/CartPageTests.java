package cart;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import init.BaseTest;
import pages.ProductListingPage;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

@DisplayName("Shopping Cart Tests")
public class CartPageTests extends BaseTest {

    @Test
    @DisplayName("Should add a product to cart by URL")
    void testAddProductToCartByUrl() {

        String productUrl = "http://qa3magento.dev.evozon.com/jackie-o-round-sunglasses.html";

        productPage.navigateToProductPage(productUrl);
        productPage.addToCart("2");

        assertThat(page.locator(".success-msg")).isVisible();
    }

    @Test
    @DisplayName("Should add a product to cart by search")
    void testAddProductToCartBySearch() {

        homePage.navigateToHomePage();
        ProductListingPage resultsPage = searchPage.searchForProduct("Jackie O Round Sunglasses");
        productPage = resultsPage.clickProductByName("Jackie O Round Sunglasses");
        cartPage = productPage.addToCart("3");
        assertThat(page.locator(".success-msg")).isVisible();
    }

    //Will fail because no product message
    @Test
    @DisplayName("Should remove a product from cart successfully")
    void testRemoveProductFromCart() {

        homePage.navigateToHomePage();
        productListingPage = homePage.getSearchPage().searchForProduct("Jackie O Round Sunglasses");
        productPage = productListingPage.clickProductByName("Jackie O Round Sunglasses");
        cartPage = productPage.addToCart("5");
        cartPage.removeFirstItemFromCart();
        assertThat(page.locator(".success-msg")).isVisible();
    }
}