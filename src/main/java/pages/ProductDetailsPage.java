package pages;

/**
 * Product details page shows information about product: name, image, stock status, quantity and add to cart feature, etc
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends ParentPage {

    @FindBy(id = "pdpAddtoCartInput")
    private WebElement inputQuantity;

    @FindBy(css = "div.product-block button.js-add-to-cart")
    private WebElement buttonAddToCart;

    @FindBy(className = "addtocart__header")
    private WebElement addToCartPopupHeader;

    @FindBy(css = "a[data-type='pop-up view cart']")
    private WebElement addToCartPopupViewCartButton;

    @FindBy(css = "button[data-type='pop-up continue shopping']")
    private WebElement continueShoppingButtonOnAddToCartPopup;

    public ProductDetailsPage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean isItProductDetailsPage() {
        return checkPageTemplate("pageType-ProductPage");
    }

    public void changeProductQuantity(int quantity) {
        actionsWithOurWebElements.enterTextIntoInput(inputQuantity, Integer.toString(quantity));
    }

    public void clickOnAddToCartButton() {
        actionsWithOurWebElements.clickOnWebElement(buttonAddToCart);
    }

    public boolean checkIfAddToCartPopupAppears () {
        return actionsWithOurWebElements.isElementPresent(addToCartPopupHeader);
    }

    public void clickOnViewCartButtonAddToCartPopup() {
        actionsWithOurWebElements.clickOnWebElement(addToCartPopupViewCartButton);
    }

    public void closeAddToCartPopup() {
        actionsWithOurWebElements.clickOnWebElement(continueShoppingButtonOnAddToCartPopup);
    }
}
