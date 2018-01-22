package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TrackMyOrderPage extends ParentPage {

    @FindBy(id = "orderNo")
    WebElement orderNumberInputField;

    @FindBy(id = "postalCode")
    WebElement postalCodeInputField;

    @FindBy(css = "form#orderLookUpForm button")
    WebElement trackMyOrderButton;



    public TrackMyOrderPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void enterOrderInfo(String order_number, String zip_code) {
        actionsWithOurWebElements.enterTextIntoInput(orderNumberInputField, order_number);
        actionsWithOurWebElements.enterTextIntoInput(postalCodeInputField, zip_code);
    }

    public void clickTrackMyOrderButton() {
        actionsWithOurWebElements.clickOnWebElement(trackMyOrderButton);
    }

    public boolean isOrderStatusPage() {
        return actionsWithOurWebElements.isElementPresent(".//h2[@class=' account-content__title title']"); // h2.account-content__title
    }

    public boolean isTrackMyOrderPage() {
        return actionsWithOurWebElements.isElementPresent(".//h2[@class='account-title account-title--dropdown-menu']");
    }
}
