package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class WishlistPage extends HeaderPage {
    private static final String WishlistURL = BaseURL + "wishlist/";
    private final Locator wishlistItems;

    public WishlistPage(Page page) {
        super(page);
        this.wishlistItems = page.locator("#wishlist-table tbody tr");
    }

    public void navigateToWishlistPage() {
        navigate(WishlistURL);
    }

    public int getWishlistItemCount() {
        return wishlistItems.count();
    }

    public boolean isProductInWishlist(String productName) {
        return page.locator(".product-name").getByText(productName).isVisible();
    }

}