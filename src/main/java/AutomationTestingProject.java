
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

public class AutomationTestingProject {



    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions().setHeadless(false) );




            //registerTest(playwright);
            //loginTest(playwright);
            //addToWishlistTest(playwright);

            //smoketest(playwright);
            //registerTest(playwright);
            //addToWishlistTest(playwright);
            //newProductListTest(playwright);
            //addProductToCartTest(playwright);
            RemoveProductFromCartTest(playwright);
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


        Locator registerButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Register") );
        registerButton.click();

//        Locator registerButtonLocator = page.locator("#form-validate > div.buttons-set > button");
//        registerButtonLocator.click();


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


        Locator saleButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Sale")).first();
        saleButton.click();
        System.out.println("Page title after sale button click: " + page.title());

        Locator productImage = page.locator("a.product-image[title='Jackie O Round Sunglasses']");
        productImage.click();
        System.out.println("Page title after product image click: " + page.title());


        Locator addToWishlistButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Add to Wishlist"));
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
        Locator newProducts = page.locator("ul.products-grid.products-grid--max-5-col-widget");
        int count = newProducts.all().size();
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

        Locator saleButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Sale")).first();
        saleButton.click();
        System.out.println("Page title after sale button click: " + page.title());

        Locator productImage = page.locator("a.product-image[title='Jackie O Round Sunglasses']");
        productImage.click();
        System.out.println("Page title after product image click: " + page.title());


        Locator quantity = page.locator("#qty");
        quantity.clear();
        quantity.fill("5");
        Locator addToCartButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add to Cart"));
        addToCartButton.click();
        System.out.println("Page title after add to cart button click: " + page.title());
        browser.close();



    }

    public static void RemoveProductFromCartTest(Playwright playwright) {
        Browser browser = initiateBrowser(playwright);
        Page page = browser.newPage();
        page.navigate("http://qa3magento.dev.evozon.com/");

        Locator saleButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Sale")).first();
        saleButton.click();
        System.out.println("Page title after sale button click: " + page.title());

        Locator productImage = page.locator("a.product-image[title='Jackie O Round Sunglasses']");
        productImage.click();
        System.out.println("Page title after product image click: " + page.title());


        Locator quantity = page.locator("#qty");
        quantity.clear();
        quantity.fill("5");
        Locator addToCartButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add to Cart"));
        addToCartButton.click();
        System.out.println("Page title after add to cart button click: " + page.title());


        page.navigate("http://qa3magento.dev.evozon.com/");
        Locator coolStuffButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Cool Stuff"));
        coolStuffButton.click();
        System.out.println("Page title after cool stuff button click: " + page.title());

        addToCartButton.first().click();
        System.out.println("Page title after add to cart button click: " + page.title());

        Locator removeButton = page.locator(".first .product-cart-remove a[title='Remove Item']");
        removeButton.click();
        System.out.println("Page title after remove button click: " + page.title());

        browser.close();
    }


}
