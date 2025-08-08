package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.SelectOption;

import java.util.ArrayList;
import java.util.List;

public class ProductPage extends HeaderPage {
    private final Locator quantityInput;
    private final Locator addToCartButton;
    private final Locator addToWishlistButton;

    public ProductPage(Page page) {
        super(page);
        this.quantityInput = page.locator("#qty");
        this.addToCartButton = getByRole(AriaRole.BUTTON, "Add to Cart");
        this.addToWishlistButton = getByRole(AriaRole.LINK, "Add to Wishlist");
    }

    public void navigateToProductPage(String productUrl) {
        navigate(productUrl);
    }

    public void setQuantity(String quantity) {
        if (quantityInput.isVisible()) {
            fill(quantityInput, quantity);
        }
    }

    public void clickAddToCartButton() {
        click(addToCartButton);
    }

    public void clickAddToWishlistButton() {
        click(addToWishlistButton);
    }

    public CartPage addToCart() {
        selectMandatoryAttributes();
        clickAddToCartButton();
        return new CartPage(page);
    }

    public CartPage addToCart(String quantity) {
        selectMandatoryAttributes();
        setQuantity(quantity);
        clickAddToCartButton();
        return new CartPage(page);
    }

    public CartPage addToCartWithAllAttributes(String quantity) {
        selectMandatoryAttributes();
        selectOptionalAttributes();
        setQuantity(quantity);
        clickAddToCartButton();
        return new CartPage(page);
    }

    public WishlistPage addToWishlist() {
        clickAddToWishlistButton();
        return new WishlistPage(page);
    }

    public void selectMandatoryAttributes() {
        selectMandatorySwatchAttributes();
        selectMandatoryDropdownAttributes();
    }

    public void selectOptionalAttributes() {
        selectOptionalSwatchAttributes();
        selectOptionalDropdownAttributes();
    }

    private void selectMandatorySwatchAttributes() {
        Locator swatchGroups = page.locator("#product-options-wrapper ul[id *='swatch']");
        try {
            if(swatchGroups.count() > 0) {
                for (int i = 0; i < swatchGroups.count(); i++) {
                    Locator swatchGroup = swatchGroups.nth(i);
                    Locator validOptions = swatchGroup.locator("li:not(.not-available)");
                    for (int j = 0; j < validOptions.count(); j++) {
                        Locator option = validOptions.nth(j);
                        option.click();
                        Locator outOfStockButton = page.getByRole(AriaRole.BUTTON,
                                new Page.GetByRoleOptions().setName("OUT OF STOCK"));
                        if (!outOfStockButton.isVisible()) {
                            break;
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("No mandatory swatch attributes found");
        }
    }

    private void selectMandatoryDropdownAttributes() {
        Locator dropdowns = page.locator("#product-options-wrapper select.required-entry[id*='bundle']");
        try {
            if (dropdowns.count() > 0) {
                for (int i = 0; i < dropdowns.count(); i++) {
                    Locator dropdown = dropdowns.nth(i);
                    dropdown.click();

                    List<String> valueList = new ArrayList<>();
                    Locator options = dropdown.locator("option");

                    for (int j = 0; j < options.count(); j++) {
                        Locator option = options.nth(j);
                        String optionText = option.textContent().trim();
                        String optionValue = option.getAttribute("value");
                        String optionClass = option.getAttribute("class");

                        if(optionText.matches(".*Choose.* | .*Select.*") ||
                                optionValue == null || optionValue.isEmpty() ||
                                (optionClass != null && optionClass.contains("not-available"))) continue;

                        valueList.add(optionValue);
                    }

                    for (String value : valueList) {
                        dropdown.selectOption(new SelectOption().setValue(value));
                        Locator outOfStock = page.getByRole(AriaRole.BUTTON,
                                new Page.GetByRoleOptions().setName("OUT OF STOCK"));
                        if (outOfStock.isVisible()) continue;
                        break;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("No mandatory dropdown attributes found");
        }
    }

    private void selectOptionalSwatchAttributes() {
        Locator swatchGroups = page.locator("#product-options-wrapper select:not(.required-entry)~ul[id *='swatch']");

        try {
            if(swatchGroups.count() > 0) {
                for (int i = 0; i < swatchGroups.count(); i++) {
                    Locator swatchGroup = swatchGroups.nth(i);
                    Locator validOptions = swatchGroup.locator("li:not(.not-available)");
                    for (int j = 0; j < validOptions.count(); j++) {
                        Locator option = validOptions.nth(j);
                        option.click();
                        Locator outOfStockButton = page.getByRole(AriaRole.BUTTON,
                                new Page.GetByRoleOptions().setName("OUT OF STOCK"));
                        if (!outOfStockButton.isVisible()) {
                            break;
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("No optional swatch attributes found");
        }
    }

    private void selectOptionalDropdownAttributes() {
        Locator dropdowns = page.locator("#product-options-wrapper dd select:not(.required-entry)");

        try {
            if (dropdowns.count() > 0) {
                for (int i = 0; i < dropdowns.count(); i++) {
                    Locator dropdown = dropdowns.nth(i);
                    dropdown.click();

                    List<String> valueList = new ArrayList<>();
                    Locator options = dropdown.locator("option");

                    for (int j = 0; j < options.count(); j++) {
                        Locator option = options.nth(j);
                        String optionText = option.textContent().trim();
                        String optionValue = option.getAttribute("value");
                        String optionClass = option.getAttribute("class");

                        if(optionText.matches(".*Choose.* | .*Select.*") ||
                                optionValue == null || optionValue.isEmpty() ||
                                (optionClass != null && optionClass.contains("not-available"))) continue;

                        valueList.add(optionValue);
                    }

                    for (String value : valueList) {
                        dropdown.selectOption(new SelectOption().setValue(value));
                        Locator outOfStock = page.getByRole(AriaRole.BUTTON,
                                new Page.GetByRoleOptions().setName("OUT OF STOCK"));
                        if (outOfStock.isVisible()) continue;
                        break;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("No optional dropdown attributes found");
        }
    }
}