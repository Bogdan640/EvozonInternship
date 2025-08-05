package org.example;

import com.microsoft.playwright.*;

import javax.swing.*;

public class PlaywrightTest {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions().setHeadless(false)
            );

//            homePageTest(playwright);
//            accountTest(playwright);
            //searchTest(playwright);
            //newProductListTest(playwright);
            //navigationTest(playwright);
           // addProductToCartTest(playwright);
            RemoveProductFromCartTest(playwright);



        }
    }

    public static Browser initiateBrowser(Playwright playwright) {
        Browser browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(false)
        );
        return browser;
    }


    public static void homePageTest(Playwright playwright) {
        Browser browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(false)
        );
        Page page = browser.newPage();
        page.navigate("http://qa3magento.dev.evozon.com/");
        System.out.println("Page title: " + page.title());
        System.out.println("Page URL: " + page.url());
        Locator homepageButton = page.locator("#header > div > a > img.large");
        homepageButton.click();
        page.navigate("http://qa3magento.dev.evozon.com/women.html");
        System.out.println("Page title after click: " + page.title());
        page.goBack();
        page.goForward();
        page.reload();
        browser.close();

    }

    public static void accountTest(Playwright playwright) {
        Browser browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(false)
        );
        Page page = browser.newPage();
        page.navigate("http://qa3magento.dev.evozon.com/");
        Locator accountButton = page.locator("#header > div > div.skip-links > div > a");
        accountButton.click();
        System.out.println("Page title after account button click: " + page.title());
        browser.close();
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

    public static void navigationTest(Playwright playwright) {
        Browser browser = initiateBrowser(playwright);
        Page page = browser.newPage();
        page.navigate("http://qa3magento.dev.evozon.com/");
        Locator navigation = page.locator("//*[@id=\"nav\"]/ol/li");
        int count = navigation.count();
        System.out.println("Number of navigation items: " + count);
        for (Locator locator : navigation.all()) {
            String headline = locator.innerText();
            System.out.println("Navigation item : " + headline);
        }
        Locator saleButton = page.locator("#nav > ol > li.level0.nav-5.parent");
        saleButton.click();
        System.out.println("Page title after sale button click: " + page.title());
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