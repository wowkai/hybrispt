package pages;

/**
 * Shopping cart page shows all added products by user
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends ParentPage {

    @FindBy(xpath = ".//*[text()='Remove all']" )
    WebElement buttonRemoveAll;

    @FindBy(css = "span.js-btn-confirm")
    WebElement buttonYesOnRemoveAllPopup;

    @FindBy(className = "empty-cart__headline")
    WebElement emptyShoppingCartHeadline;

    public ShoppingCartPage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean isItShoppingCartPage() {
        return checkPageTemplate("page-cartPage");
    }

    public void removeAllProductsFromCart() {
        actionsWithOurWebElements.clickOnWebElement(buttonRemoveAll);
        actionsWithOurWebElements.clickOnWebElement(buttonYesOnRemoveAllPopup);
    }

    public boolean isItEmptyShoppingCart() {
        return actionsWithOurWebElements.isElementPresent(emptyShoppingCartHeadline);
    }
}
