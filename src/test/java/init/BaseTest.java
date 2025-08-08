package init;


import com.microsoft.playwright.*;
import init.Init;
import org.junit.jupiter.api.BeforeEach;
import pages.*;

public class BaseTest extends Init {

    protected HomePage homePage;
    protected LoginPage loginPage;
    protected RegistrationPage registrationPage;
    protected ProductPage productPage;
    protected CartPage cartPage;
    protected WishlistPage wishlistPage;
    protected ProductListingPage productListingPage;
    protected SearchPage searchPage;

    @BeforeEach
    void initializePages() {
        homePage = new HomePage(page);
        loginPage = new LoginPage(page);
        registrationPage = new RegistrationPage(page);
        productPage = new ProductPage(page);
        cartPage = new CartPage(page);
        wishlistPage = new WishlistPage(page);
        productListingPage = new ProductListingPage(page);
        searchPage = new SearchPage(page);
    }
}