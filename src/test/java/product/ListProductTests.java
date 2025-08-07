package product;

import init.Init;
import com.microsoft.playwright.Locator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;


@DisplayName("Product Listing Tests")
public class ListProductTests extends Init {

    private static final String HomepageURL = "http://qa3magento.dev.evozon.com/";

    @Test
    @DisplayName("Should display new products list")
    void testNewProductsList() {

        page.navigate(HomepageURL);
        Locator newProducts = page.locator("ul.products-grid.products-grid--max-5-col-widget > li");
        if (newProducts.count() > 0) {
            for (int i = 1; i < newProducts.count(); i++) {
                assertThat(newProducts.nth(i)).isVisible();
            }
        }

        int count = newProducts.all().size();
        //System.out.println("Number of new products: " + count);

        for (Locator product : newProducts.all()) {
            String productText = product.textContent();
        }
    }
}