package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class CartPage extends HeaderPage {
    private static final String CartURL = BaseURL + "checkout/cart/";
    private final Locator cartItems;
    private final Locator successMessage;
    private final Locator removeItemButtons;

    public CartPage(Page page) {
        super(page);
        this.cartItems = page.locator(".cart-table tbody tr");
        this.successMessage = page.locator(".success-msg");
        this.removeItemButtons = page.locator(".product-cart-remove a[title='Remove Item']");
    }

    public void navigateToCartPage() {
        navigate(CartURL);
    }

    public int getCartItemCount() {
        return cartItems.count();
    }

    public void removeItemFromCart(int index) {
        removeItemButtons.nth(index).click();
    }

    public void removeFirstItemFromCart() {
        if (removeItemButtons.count() > 0) {
            removeItemButtons.first().click();
        }
    }

    public boolean isSuccessMessageDisplayed() {
        return successMessage.isVisible();
    }

    public boolean isProductInCart(String productName) {
        return page.locator(".product-name").getByText(productName).isVisible();
    }
}