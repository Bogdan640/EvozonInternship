package product;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import init.BaseTest;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

@DisplayName("Product Page Tests")
public class ProductPageTests extends BaseTest {

    private static final String productURL = "http://qa3magento.dev.evozon.com/jackie-o-round-sunglasses.html";
    private static final String attributeProductURL = "http://qa3magento.dev.evozon.com/elizabeth-knit-top-601.html";


    @Test
    @DisplayName("Should handle products with mandatory attributes")
    void testProductWithMandatoryAttributes() {

        productPage.navigateToProductPage(attributeProductURL);
        cartPage = productPage.addToCart();
        assertThat(page.locator(".success-msg")).isVisible();
    }

    @Test
    @DisplayName("Should set product quantity")
    void testSetProductQuantity() {

        productPage.navigateToProductPage(productURL);
        productPage.setQuantity("5");
        cartPage = productPage.addToCart();
        assertThat(page.locator(".success-msg")).isVisible();
    }
}