package pages.myAccountPages;

import libs.UIMap;
import org.openqa.selenium.WebDriver;
import pages.ParentPage;

public class MyProfilePage extends ParentPage {

    private UIMap uimap;

    public MyProfilePage(WebDriver webDriver) {
        super(webDriver);
        uimap = new UIMap("src/locator.properties");
    }

    public String getFirstName() throws Exception {

        return actionsWithOurWebElements.getValueFromInputField(webDriver.findElement(uimap.getLocator("edtFirstName")));
    }

    public void setNewFirstName(String name) throws Exception {
        actionsWithOurWebElements.enterTextIntoInput(webDriver.findElement(uimap.getLocator("edtFirstName")), name);
    }

    public void clickOnUpdateMyProfileButton() throws Exception {
        actionsWithOurWebElements.clickOnWebElement(webDriver.findElement(uimap.getLocator("buttonUpdateMyProfle")));
    }
}
