package pages.listingPages;

/**
 * Product listing page is page where located all products and models.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.ParentPage;

import java.util.List;

public class ProductListingPage extends ParentPage {

    @FindBy(className = "manuf-info__title")
    WebElement manufacturerPageTitle;

    @FindBy(className = "addtocart__header")
    private WebElement addToCartPopupHeader;

    @FindBy(css = "button[data-type='pop-up continue shopping']")
    private WebElement addToCartPopupContinueShoppingButton;

    @FindBy(css = "a[href='/cart/checkout']")
    private WebElement addToCartPopupCheckoutButton;

    public ProductListingPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void addProductInStockToCartFromTheList(int productID) {
        List<WebElement> elementsList = webDriver.findElements(By.xpath(".//*[contains(text(), 'In Stock') and @class = 'js-product-stockmsg']/../../..//button[@data-mobile='false']"));
            actionsWithOurWebElements.clickOnWebElement(elementsList.get(productID));
    }

    public boolean checkIfAddToCartPopupAppears () {
        return actionsWithOurWebElements.isElementPresent(addToCartPopupHeader);
    }

    public void clickOnContinueShoppingButtonAddToCartPopup() {
        actionsWithOurWebElements.clickOnWebElement(addToCartPopupContinueShoppingButton);
    }

    public void clickOnCheckoutButtonAddToCartPopup() {
        actionsWithOurWebElements.clickOnWebElement(addToCartPopupCheckoutButton);
    }
}
