package pages;

/**
 * Manufacturer landing page is page where located all list of available manufacturers on site.
 * Each link leads to appropriate Manufacturer Product Listing Page.
 */

import org.openqa.selenium.WebDriver;

public class ManufacturerLandingPage extends ParentPage {

    public ManufacturerLandingPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickOnManufactureLink(String manufacturerName) {
        actionsWithOurWebElements.clickOnWebElement(".//*[@data-name='" + manufacturerName + "'][@data-type='shop manufacturer']");
    }
}
