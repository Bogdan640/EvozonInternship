package cart;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.SelectOption;
import init.Init;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;


@DisplayName("Add Product To Shopping Cart Test")
public class ShoppingCartTests extends Init {

    private static final String HomepageURL = "http://qa3magento.dev.evozon.com/";

    @Test
    @DisplayName("Should add a product to the cart successfully")
    void testAddProductToCart() {

        page.navigate(HomepageURL);
        navigateToJackieOSunglasses();
        Locator quantity = page.locator("#qty");
        assertThat(quantity).isVisible();
        quantity.clear();
        quantity.fill("5");
        assertThat(quantity).hasValue("5");

        Locator addToCartButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add to Cart"));
        assertThat(addToCartButton).isVisible();
        assertThat(addToCartButton).isEnabled();
        addToCartButton.click();

        //System.out.println("Page title after add to cart: " + page.title());
    }

    @Test
    @DisplayName("Should remove a product from cart successfully")
    void testRemoveProductFromCart() {

        page.navigate(HomepageURL);

        // Add first product to cart
        navigateToJackieOSunglasses();

        Locator quantity = page.locator("#qty");
        assertThat(quantity).isVisible();
        quantity.clear();
        quantity.fill("5");

        Locator addToCartButton = page.getByRole(AriaRole.BUTTON,
                new Page.GetByRoleOptions().setName("Add to Cart"));
        assertThat(addToCartButton).isVisible();
        addToCartButton.click();

        // Navigate back and add second product
        page.navigate(HomepageURL);
        Locator coolStuffButton = page.getByRole(AriaRole.LINK,
                new Page.GetByRoleOptions().setName("Cool Stuff"));
        assertThat(coolStuffButton).isVisible();
        coolStuffButton.click();
        //System.out.println("Page title after cool stuff button click: " + page.title());

        addToCartButton = page.getByRole(AriaRole.BUTTON,
                new Page.GetByRoleOptions().setName("Add to Cart"));
        assertThat(addToCartButton.first()).isVisible();
        addToCartButton.first().click();
       // System.out.println("Page title after add to cart button click: " + page.title());

        // Remove first product from cart
        Locator removeButton = page.locator(".first .product-cart-remove a[title='Remove Item']");
        assertThat(removeButton).isVisible();
        removeButton.click();

       // System.out.println("Page title after remove from cart: " + page.title());
    }

    private void navigateToJackieOSunglasses() {
        Locator saleButton = page.getByRole(AriaRole.LINK,
                new Page.GetByRoleOptions().setName("Sale")).first();
        assertThat(saleButton).isVisible();
        saleButton.click();
       // System.out.println("Page title after sale button click: " + page.title());

        Locator productImage = page.locator("a.product-image[title='Jackie O Round Sunglasses']");
        assertThat(productImage).isVisible();
        productImage.click();
       // System.out.println("Page title after product image click: " + page.title());
    }


    private void selectMandatoryAttributes(){

        //TODO: this


    }

    private void selectMandatoryDropdownAttributes(){


        Locator dropdowns = page.locator("#product-options-wrapper dd .required-entry  ");

       // System.out.println(dropdowns.count());

        if (dropdowns.count() > 0){
            for (int i = 0; i < dropdowns.count(); i++){
               // System.out.println(i);
                Locator dropdown = dropdowns.nth(i);
                assertThat(dropdown).isVisible();
                assertThat(dropdown).isEnabled();
                dropdown.click();


                Locator optionsFromDropdown = dropdown.locator("option");

                List<String> optionList = new ArrayList<>();
                List<String> valueList = new ArrayList<>();

                for (Locator option : optionsFromDropdown.all()) {
                    String optionText = option.textContent().trim();
                    String optionValue = option.getAttribute("value");
                    String optionClass = option.getAttribute("class");


                    if(optionText.matches(".*Choose.* | .*Select.*") ||
                        optionValue == null || optionValue.isEmpty() ||
                            (optionClass != null && optionClass.contains("not-available"))) continue;


                    optionList.add(optionText);
                    valueList.add(optionValue);
                    //System.out.println("Option text: " + optionText + ", Value: " + optionValue);
                }



                for (int j = 0; j < optionList.size(); j++){
                   // System.out.println("Option " + j + " = " + optionList.get(j));

                    dropdown.selectOption(new SelectOption().setValue(valueList.get(j)));

                    Locator outOfStock = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("OUT OF STOCK"));
                    if (outOfStock.isVisible()) continue;
                    break;
                }
            }

        }
    }


    private void selectOptionalDropdownAttributes(){
        Locator dropdowns = page.locator("#product-options-wrapper dd select:not(.required-entry) ");

       // System.out.println(dropdowns.count());

        if (dropdowns.count() > 0){
            for (int i = 0; i < dropdowns.count(); i++){
               // System.out.println(i);
                Locator dropdown = dropdowns.nth(i);
                assertThat(dropdown).isVisible();
                assertThat(dropdown).isEnabled();
                dropdown.click();


                Locator optionsFromDropdown = dropdown.locator("option");

                List<String> optionList = new ArrayList<>();
                List<String> valueList = new ArrayList<>();

                for (Locator option : optionsFromDropdown.all()) {
                    String optionText = option.textContent().trim();
                    String optionValue = option.getAttribute("value");
                    String optionClass = option.getAttribute("class");


                    if(optionText.matches(".*Choose.* | .*Select.*") ||
                            optionValue == null || optionValue.isEmpty() ||
                            (optionClass != null && optionClass.contains("not-available"))) continue;


                    optionList.add(optionText);
                    valueList.add(optionValue);
                   // System.out.println("Option text: " + optionText + ", Value: " + optionValue);
                }



                for (int j = 0; j < optionList.size(); j++){
                   // System.out.println("Option " + j + " = " + optionList.get(j));

                    dropdown.selectOption(new SelectOption().setValue(valueList.get(j)));

                    Locator outOfStock = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("OUT OF STOCK"));
                    if (outOfStock.isVisible()) continue;
                    break;
                }
            }

        }
    }

    @Test
    @DisplayName("Should add a product to the cart successfully")
    void mockTestToTestMethods() {

        page.navigate(HomepageURL);

        page.navigate("http://qa3magento.dev.evozon.com/home-decor/electronics/camera-travel-set.html");

        selectMandatoryDropdownAttributes();
        selectOptionalDropdownAttributes();

        Locator addToCartButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add to Cart"));
        assertThat(addToCartButton).isVisible();
        assertThat(addToCartButton).isEnabled();
        addToCartButton.click();



    }
}