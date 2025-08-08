package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.SelectOption;

public class BasePage {

    protected Page page;
    protected static final String BaseURL = "http://qa3magento.dev.evozon.com/";

    public BasePage(Page page) {
        this.page = page;
    }

    public void navigate(String url) {
        page.navigate(url);
    }

    public void navigateToHomePage() {
        navigate(BaseURL);
    }

    protected void click(Locator locator) {
        locator.click();
    }

    protected void fill(Locator locator, String text) {
        locator.clear();
        locator.fill(text);
    }




    protected void selectOption(Locator locator, String value) {
        locator.selectOption(new SelectOption().setValue(value));
    }


    protected Locator getByRole(AriaRole role, String name) {
        return page.getByRole(role, new Page.GetByRoleOptions().setName(name));
    }

    protected String getPageTitle() {
        return page.title();
    }



}