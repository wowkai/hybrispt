package pages;

/**
 * Search page is used to show listing of products which was returned after using site search feature
 */

import org.openqa.selenium.WebDriver;

public class SearchPage extends ParentPage {

    public SearchPage(WebDriver webDriver) {
        super(webDriver);
    }

    // method for check if searched keyword was applied as refinement
}
