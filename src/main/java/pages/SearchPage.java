package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class SearchPage extends BasePage {
    private final Locator searchField;

    public SearchPage(Page page) {
        super(page);
        this.searchField = page.locator("#search");
    }

    public ProductListingPage searchForProduct(String searchTerm) {
        searchField.clear();
        searchField.fill(searchTerm);
        searchField.press("Enter");
        return new ProductListingPage(page);
    }
}