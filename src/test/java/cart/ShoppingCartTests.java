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

        selectMandatorySwatchAttributes();
        selectMandatoryDropdownAttributes();

    }

    private void selectOptionalAttributes(){

        selectOptionalSwatchAttributes();
        selectOptionalDropdownAttributes();

    }

    private void selectMandatoryDropdownAttributes(){


        Locator dropdowns = page.locator("#product-options-wrapper select.required-entry[id*='bundle']");
        try {
            if (dropdowns.count() > 0){

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
        }catch (Exception e){
            System.out.println("SKIPPED");
        }

    }


    private void selectOptionalDropdownAttributes(){
        Locator dropdowns = page.locator("#product-options-wrapper dd select:not(.required-entry) ");

        try{


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

        }catch (Exception e){
            System.out.println("SKIPPED");
        }
    }


    private void selectMandatorySwatchAttributes() {

        Locator swatchGroups = page.locator("#product-options-wrapper ul[id *='swatch']");
        try{

            System.out.println(swatchGroups.count());

            if(swatchGroups.count() > 0){

                int groupCount = swatchGroups.count();
                //System.out.println("Swatch groups count : " + groupCount);

                for (int i = 0; i < groupCount; i++) {

                    Locator swatchGroup = swatchGroups.nth(i);
                    assertThat(swatchGroup).isVisible();

                    Locator validOptions = swatchGroup.locator("li:not(.not-available)");

                    int optionCount = validOptions.count();
                   // System.out.println("Valid options in group " + i + ": " + optionCount);


                    for (int j = 0; j < optionCount; j++) {

                        Locator option = validOptions.nth(j);
                        assertThat(option).isVisible();
                        option.click();

                        Locator outOfStockButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("OUT OF STOCK"));
                        if (!outOfStockButton.isVisible()) {
                            break;
                        }
                    }

                }
            }
        } catch (Exception e) {
            System.out.println("SKIPPED");
        }
    }

    private void selectOptionalSwatchAttributes(){
        Locator swatchGroups = page.locator("#product-options-wrapper select:not(.required-entry)~ul[id *='swatch' ]");

        try{

            System.out.println(swatchGroups.count());
            if(swatchGroups.count() > 0){

                int groupCount = swatchGroups.count();
                //System.out.println("Swatch groups count : " + groupCount);

                for (int i = 0; i < groupCount; i++) {

                    Locator swatchGroup = swatchGroups.nth(i);
                    assertThat(swatchGroup).isVisible();

                    Locator validOptions = swatchGroup.locator("li:not(.not-available)");

                    int optionCount = validOptions.count();
                    //System.out.println("Valid options in group " + i + ": " + optionCount);


                    for (int j = 0; j < optionCount; j++) {

                        Locator option = validOptions.nth(j);
                        assertThat(option).isVisible();
                        option.click();

                        Locator outOfStockButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("OUT OF STOCK"));
                        if (!outOfStockButton.isVisible()) {
                            break;
                        }
                    }

                }
            }
        }catch (Exception e){
            System.out.println("SKIPPED");
        }
    }


    /// /////////////////////////////////////////////////
    /// ////////////////////////
    /// //////////////////



    private void setQuantityAndAddToCart(String quantity) {
        Locator quantityField = page.locator("#qty");
        if (quantityField.isVisible()) {
            assertThat(quantityField).isVisible();
            quantityField.clear();
            quantityField.fill(quantity);
            assertThat(quantityField).hasValue(quantity);
        }

        Locator addToCartButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add to Cart"));
        assertThat(addToCartButton).isVisible();
        assertThat(addToCartButton).isEnabled();
        addToCartButton.click();
    }


    private void ClickAddToCartButton(){
        Locator addToCartButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add to Cart"));
        assertThat(addToCartButton).isVisible();
        assertThat(addToCartButton).isEnabled();
        addToCartButton.click();
    }


    public void addProductToCartByUrl(String productUrl, String quantity) {
        page.navigate(productUrl);
        assertThat(page.locator(".product-view")).isVisible();

        selectMandatoryAttributes();
        //selectOptionalAttributes();

        setQuantityAndAddToCart(quantity);
    }

    public void addProductToCartByUrl(String productUrl) {
        page.navigate(productUrl);
        assertThat(page.locator(".product-view")).isVisible();

        selectMandatoryAttributes();
        //selectOptionalAttributes();

        ClickAddToCartButton();
    }





    private void searchForProduct(String searchTerm) {
        Locator searchField = page.locator("#search");
        assertThat(searchField).isVisible();
        searchField.clear();
        searchField.fill(searchTerm);
        searchField.press("Enter");
        assertThat(page.locator(".category-products")).isVisible();
    }




    public void addProductToCartBySearch(String searchTerm, String quantity) {

        page.navigate(HomepageURL);
        searchForProduct(searchTerm);

        Locator firstProduct = page.locator(".products-grid .item .product-image").first();
        assertThat(firstProduct).isVisible();
        firstProduct.click();
        assertThat(page.locator(".product-view")).isVisible();

        selectMandatoryAttributes();
        selectOptionalAttributes();

        setQuantityAndAddToCart(quantity);
    }

    public void addProductToCartBySearch(String searchTerm) {

        page.navigate(HomepageURL);
        searchForProduct(searchTerm);

        Locator firstProduct = page.locator(".products-grid .item .product-image").first();
        assertThat(firstProduct).isVisible();
        firstProduct.click();
        assertThat(page.locator(".product-view")).isVisible();

        selectMandatoryAttributes();
        selectOptionalAttributes();

        ClickAddToCartButton();
    }


    private void removeProductFromCart() {
        Locator removeButton = page.locator(".product-cart-remove a[title='Remove Item']").first();
        assertThat(removeButton).isVisible();
        removeButton.click();
    }




    private void verifyProductAddedToCart() {
        Locator successMessage = page.locator(".success-msg");
        assertThat(successMessage).isVisible();
    }


    private void verifyProductRemovedFromCart() {
        Locator removalMessage = page.locator(".success-msg");
        assertThat(removalMessage).isVisible();
    }




    ///
    ///  TESTS
    ///

    @Test
    @DisplayName("Should add a product to cart by URL")
    void testAddProductToCartByUrl() {
        String productUrl = "http://qa3magento.dev.evozon.com/jackie-o-round-sunglasses.html";
        addProductToCartByUrl(productUrl, "2");
        verifyProductAddedToCart();
    }

    @Test
    @DisplayName("Should add a product to cart by search")
    void testAddProductToCartBySearch() {
        addProductToCartBySearch("Jackie O Round Sunglasses", "3");
        verifyProductAddedToCart();
    }

    @Test
    @DisplayName("Should add a product to the cart successfully")
    void testAddProductToCart() {
        page.navigate(HomepageURL);
        navigateToJackieOSunglasses();

        setQuantityAndAddToCart("5");
        verifyProductAddedToCart();
    }

    @Test
    @DisplayName("Should remove a product from cart successfully")
    void testRemoveProductFromCart() {
        page.navigate(HomepageURL);
        navigateToJackieOSunglasses();
        setQuantityAndAddToCart("5");
        removeProductFromCart();

    }

    @Test
    @DisplayName("Should remove a product from cart successfully and display a confirmation message")
    void testRemoveMessageProductFromCart() {
        page.navigate(HomepageURL);
        navigateToJackieOSunglasses();
        setQuantityAndAddToCart("5");
        removeProductFromCart();
        verifyProductRemovedFromCart();
    }

    @Test
    @DisplayName("Should handle products with mandatory attributes")
    void testAddProductWithMandatoryAttributes() {
        String productWithAttributesUrl = "http://qa3magento.dev.evozon.com/elizabeth-knit-top-601.html";
        addProductToCartByUrl(productWithAttributesUrl);
        verifyProductAddedToCart();
    }



}