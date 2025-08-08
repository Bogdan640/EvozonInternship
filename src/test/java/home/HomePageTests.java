package home;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import init.BaseTest;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Home Page Tests")
public class HomePageTests extends BaseTest {

    @Test
    @DisplayName("Should display new products list")
    void testNewProductsList() {

        homePage.navigateToHomePage();
        int newProductsCount = homePage.getNewProductsCount();
        assertTrue(newProductsCount > 0);
    }

    @Test
    @DisplayName("Should navigate to product from new products list")
    void testNavigateToNewProduct() {

        homePage.navigateToHomePage();
        productPage = homePage.clickNewProduct(0);
        assertThat(page.locator(".product-view")).isVisible();
    }
}