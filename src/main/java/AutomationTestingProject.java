
import com.microsoft.playwright.*;

public class AutomationTestingProject {



    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions().setHeadless(false) );




            //registerTest(playwright);
            //loginTest(playwright);
            //addToWishlistTest(playwright);

            smoketest(playwright);
        }


    }

    public static void smoketest(Playwright playwright) {
        registerTest(playwright);
        loginTest(playwright);
        newProductListTest(playwright);
        searchTest(playwright);
        addProductToCartTest(playwright);
        RemoveProductFromCartTest(playwright);
        addToWishlistTest(playwright);


    }


    public static Browser initiateBrowser(Playwright playwright) {
        Browser browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(false)
        );
        return browser;
    }


    public static void registerTest(Playwright playwright) {
        Browser browser = initiateBrowser(playwright);
        Page page = browser.newPage();
        page.navigate("http://qa3magento.dev.evozon.com/customer/account/create/");
        System.out.println("Page title: " + page.title());

        Locator firstNameInput = page.locator("#firstname");
        firstNameInput.clear();
        firstNameInput.fill("test1");

        Locator lastNameInput = page.locator("#lastname");
        lastNameInput.clear();
        lastNameInput.fill("test1");

        Locator emailInput = page.locator("#email_address");
        emailInput.clear();
        emailInput.fill("test1@test1.com");

        Locator passwordInput = page.locator("#password");
        passwordInput.clear();
        passwordInput.fill("test1234");

        Locator confirmPasswordInput = page.locator("#confirmation");
        confirmPasswordInput.clear();
        confirmPasswordInput.fill("test1234");
        Locator registerButton = page.locator("#form-validate > div.buttons-set > button");
        registerButton.click();

        Locator registerButtonLocator = page.locator("#form-validate > div.buttons-set > button");
        registerButtonLocator.click();


        System.out.println("Page title after registration: " + page.title());

        browser.close();
    }


    public static void loginTest(Playwright playwright) {
        Browser browser = initiateBrowser(playwright);
        Page page = browser.newPage();
        page.navigate("http://qa3magento.dev.evozon.com/customer/account/login/");
        System.out.println("Page title: " + page.title());

        Locator emailInput = page.locator("#email");
        emailInput.clear();
        emailInput.fill("test1@test1.com");

        Locator passwordInput = page.locator("#pass");
        passwordInput.clear();
        passwordInput.fill("test1234");


        Locator login = page.locator("#send2");
        login.click();

        System.out.println("Page title after login: " + page.title());

    }


    public static void addToWishlistTest(Playwright playwright) {
        Browser browser = initiateBrowser(playwright);
        Page page = browser.newPage();
        page.navigate("http://qa3magento.dev.evozon.com/customer/account/login/");
        System.out.println("Page title: " + page.title());

        Locator emailInput = page.locator("#email");
        emailInput.clear();
        emailInput.fill("test1@test1.com");

        Locator passwordInput = page.locator("#pass");
        passwordInput.clear();
        passwordInput.fill("test1234");


        Locator login = page.locator("#send2");
        login.click();

        System.out.println("Page title after login: " + page.title());

        Locator saleButton = page.locator("#nav > ol > li.level0.nav-5.parent");
        saleButton.click();
        System.out.println("Page title after sale button click: " + page.title());

        Locator productImage = page.locator("body > div > div > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > ul > li:nth-child(1) > a");
        productImage.click();
        System.out.println("Page title after product image click: " + page.title());

        Locator color = page.locator("#swatch18 > span.swatch-label > img");
        Locator size = page.locator("#swatch79 > span.swatch-label");
        color.click();
        size.click();

        Locator quantity = page.locator("#qty");
        quantity.clear();
        quantity.fill("5");

        Locator addToWishlistButton = page.locator("#product_addtocart_form > div.product-shop > div.product-options-bottom > ul.add-to-links > li:nth-child(1) > a");
        addToWishlistButton.click();
        System.out.println("Page title after add to wishlist button click: " + page.title());




    }

    public static void searchTest(Playwright playwright) {
        Browser browser = initiateBrowser(playwright);
        Page page = browser.newPage();
        page.navigate("http://qa3magento.dev.evozon.com/");
        Locator searchField = page.locator("#search");
        searchField.clear();
        searchField.fill("woman");
        searchField.press("Enter");
        System.out.println("Page title after search: " + page.title());
        browser.close();

    }


    public static void newProductListTest (Playwright playwright) {
        Browser browser = initiateBrowser(playwright);
        Page page = browser.newPage();
        page.navigate("http://qa3magento.dev.evozon.com/");
        Locator newProducts = page.locator("body > div > div > div.main-container.col1-layout > div > div > div.std > div.widget.widget-new-products > div.widget-products > ul > li");
        int count = newProducts.count();
        System.out.println("Number of new products: " + count);
        for (Locator product : newProducts.all()) {
            System.out.println("Product: " + product.textContent());
        }
        browser.close();
    }


    public static void addProductToCartTest(Playwright playwright) {
        Browser browser = initiateBrowser(playwright);
        Page page = browser.newPage();
        page.navigate("http://qa3magento.dev.evozon.com/");

        Locator saleButton = page.locator("#nav > ol > li.level0.nav-5.parent");
        saleButton.click();
        System.out.println("Page title after sale button click: " + page.title());

        Locator productImage = page.locator("body > div > div > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > ul > li:nth-child(1) > a");
        productImage.click();
        System.out.println("Page title after product image click: " + page.title());

        Locator color = page.locator("#swatch18 > span.swatch-label > img");
        Locator size = page.locator("#swatch79 > span.swatch-label");
        color.click();
        size.click();

        Locator quantity = page.locator("#qty");
        quantity.clear();
        quantity.fill("5");
        Locator addToCartButton = page.locator("#product_addtocart_form > div.product-shop > div.product-options-bottom > div.add-to-cart > div.add-to-cart-buttons");
        addToCartButton.click();
        System.out.println("Page title after add to cart button click: " + page.title());
        browser.close();



    }

    public static void RemoveProductFromCartTest(Playwright playwright) {
        Browser browser = initiateBrowser(playwright);
        Page page = browser.newPage();
        page.navigate("http://qa3magento.dev.evozon.com/");

        Locator saleButton = page.locator("#nav > ol > li.level0.nav-5.parent");
        saleButton.click();
        System.out.println("Page title after sale button click: " + page.title());

        Locator productImage = page.locator("body > div > div > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > ul > li:nth-child(1) > a");
        productImage.click();
        System.out.println("Page title after product image click: " + page.title());

        Locator color = page.locator("#swatch18 > span.swatch-label > img");
        Locator size = page.locator("#swatch79 > span.swatch-label");
        color.click();
        size.click();

        Locator quantity = page.locator("#qty");
        quantity.clear();
        quantity.fill("5");
        Locator addToCartButton = page.locator("#product_addtocart_form > div.product-shop > div.product-options-bottom > div.add-to-cart > div.add-to-cart-buttons");
        addToCartButton.click();
        System.out.println("Page title after add to cart button click: " + page.title());

        // Useful to return maybe the page and browser to a method to use it in other tests
        /// Ask tomorrow about the best way to handle the browser and page lifecycle

        page.navigate("http://qa3magento.dev.evozon.com/");
        Locator coolStuffButton = page.locator("#nav > ol > li.level0.nav-7.last > a");
        coolStuffButton.click();
        System.out.println("Page title after cool stuff button click: " + page.title());

        Locator addToCartButton2 = page.locator("body > div > div > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > ul > li:nth-child(1) > div > div.actions > button > span > span");
        addToCartButton2.click();
        System.out.println("Page title after add to cart button click: " + page.title());

        Locator removeButton = page.locator("#shopping-cart-table > tbody > tr.last.even > td.a-center.product-cart-remove.last > a");
        removeButton.click();
        System.out.println("Page title after remove button click: " + page.title());

        browser.close();
    }


}
