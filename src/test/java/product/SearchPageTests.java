package product;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import init.BaseTest;
import pages.ProductListingPage;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.regex.Pattern;

@DisplayName("Search Functionality Tests")
public class SearchPageTests extends BaseTest {

    @Test
    @DisplayName("Should search for products successfully")
    void testProductSearch() {

        homePage.navigateToHomePage();
        ProductListingPage resultsPage = searchPage.searchForProduct("t");
        assertThat(page).hasTitle(Pattern.compile(".*Search.*t.*", Pattern.CASE_INSENSITIVE));
        assertTrue(resultsPage.hasResults());
    }

    @Test
    @DisplayName("Should display message for no results")
    void testNoResultsSearch() {

        homePage.navigateToHomePage();
        ProductListingPage resultsPage = searchPage.searchForProduct("blanadenurcanaparlita");
        assertThat(page.locator(".note-msg")).containsText("search returns no results");
    }
}