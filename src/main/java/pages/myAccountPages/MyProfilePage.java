package pages.myAccountPages;

import org.openqa.selenium.WebDriver;
import pages.ParentPage;

public class MyProfilePage extends ParentPage {


    public MyProfilePage(WebDriver webDriver) {
        super(webDriver);
    }

    public String getFirstName() throws Exception {

        return actionsWithOurWebElements.getValueFromInputField(webDriver.findElement(uimap.getLocator("inputFirstName")));
    }

    public void setNewFirstName(String name) throws Exception {
        actionsWithOurWebElements.enterTextIntoInput(webDriver.findElement(uimap.getLocator("inputFirstName")), name);
    }

    public void clickOnUpdateMyProfileButton() throws Exception {
        actionsWithOurWebElements.clickOnWebElement(webDriver.findElement(uimap.getLocator("buttonUpdateMyProfle")));
    }
}
