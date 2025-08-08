package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class HeaderPage extends BasePage {
    private final Locator saleLink;
    private final Locator accountLink;
    private final Locator cartLink;
    private final SearchPage searchPage;

    public HeaderPage(Page page) {
        super(page);
        this.saleLink = getByRole(AriaRole.LINK, "Sale").first();
        this.accountLink = getByRole(AriaRole.LINK, "Account");
        this.cartLink = getByRole(AriaRole.LINK, "Cart");
        this.searchPage = new SearchPage(page);
    }

    public SearchPage getSearchPage() {
        return searchPage;
    }

    public ProductListingPage navigateToSalePage() {
        saleLink.click();
        return new ProductListingPage(page);
    }

    public LoginPage navigateToAccount() {
        accountLink.click();
        return new LoginPage(page);
    }

    public CartPage navigateToCart() {
        cartLink.click();
        return new CartPage(page);
    }
}