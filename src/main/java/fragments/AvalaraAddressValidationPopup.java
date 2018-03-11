package fragments;

import libs.UIMap;
import org.openqa.selenium.WebDriver;

public class AvalaraAddressValidationPopup extends ParentFragment{

    private UIMap uimap;

    public AvalaraAddressValidationPopup(WebDriver webDriver) {
        super(webDriver);
        uimap = new UIMap("src/locator.properties");
    }


    public void clickSelectUpdatedAddressAvalara() throws Exception {
        actionsWithOurWebElements.clickOnWebElement(webDriver.findElement(uimap.
                getLocator("avalarapopup.btnSelectUpdatedAddress")));
    }

    public void clickSelectInitialAddress() throws Exception {
        actionsWithOurWebElements.clickOnWebElement(webDriver.findElement(uimap.
                getLocator("avalarapopup.btnSelectInitialAddress")));
    }
}
