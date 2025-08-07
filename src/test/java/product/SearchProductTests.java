package product;

import init.Init;
import com.microsoft.playwright.Locator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import java.util.regex.Pattern;

@DisplayName("Product Search Tests")
public class SearchProductTests extends Init {

    private static final String HomepageURL = "http://qa3magento.dev.evozon.com/";

    @Test
    @DisplayName("Should search for products successfully")
    void testProductSearch() {

        page.navigate(HomepageURL);
        Locator searchField = page.locator("#search");
        assertThat(searchField).isVisible();
        searchField.clear();
        searchField.fill("woman");
        searchField.press("Enter");
        //System.out.println("Page title after search: " + page.title());
        assertThat(page).hasTitle(Pattern.compile(".*Search.*Woman.*", Pattern.CASE_INSENSITIVE));
    }
}