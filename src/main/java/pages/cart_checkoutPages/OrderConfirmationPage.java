package pages.cart_checkoutPages;

import org.openqa.selenium.WebDriver;
import pages.ParentPage;

/**
 * Order Confirmation page is shown only if order was placed successfully.
 * Here is shown information about placed order
 */

public class OrderConfirmationPage extends ParentPage {

    public OrderConfirmationPage(WebDriver webDriver) {
        super(webDriver);
    }
}
