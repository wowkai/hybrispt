package pages.cart_checkoutPages;

/**
 * Guest Checkout Login page is the page where user could login to the system with existing credentials or enter email for guest checkout
 */


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.ParentPage;

public class GuestCheckoutLoginPage extends ParentPage {

    @FindBy(id = "guest.email")
    WebElement guestCheckoutEmailInput;

    @FindBy(css = "form#PTGuestForm button")
    WebElement buttonCheckoutsAsGuest;

    public GuestCheckoutLoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void enterGuestCheckoutEmail(String email) {
        guestCheckoutEmailInput.clear();
        actionsWithOurWebElements.enterTextIntoInput(guestCheckoutEmailInput, email);
    }

    public void clickOnCheckoutAsGuestButton() {
        actionsWithOurWebElements.clickOnWebElement(buttonCheckoutsAsGuest);
    }
}
