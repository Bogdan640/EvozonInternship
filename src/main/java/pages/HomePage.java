package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class HomePage extends HeaderPage {
    private final Locator newProductsList;

    public HomePage(Page page) {
        super(page);
        this.newProductsList = page.locator("ul.products-grid.products-grid--max-5-col-widget > li");
    }

    public int getNewProductsCount() {
        return newProductsList.count();
    }

    public ProductPage clickNewProduct(int index) {
        newProductsList.nth(index).locator("a.product-image").click();
        return new ProductPage(page);
    }

    public void navigateToHomePage() {
        navigate(BaseURL);
    }
}