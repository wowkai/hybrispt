package pages;

/**
 * Model details page is the listing product page which contains all products which belongs to certain Model
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ModelDetailsPage extends ParentPage {

    @FindBy(className = "product-inform-list-name")
    WebElement modelPageTitle;

    @FindBy(xpath = ".//*[@class='product-help-btn__activetext' and contains(text(), 'Parts')]/..")
    WebElement buttonAddToMyParts;

    @FindBy(xpath = ".//*[@class='product-help-btn__activetext' and contains(text(), 'Parts')]/../..//*[@name='productCode']")
    WebElement inputProductCode;

    @FindBy(xpath = ".//*[@class='myAccountLinksHeader  js-myAccount-toggle nav__link']")
    private WebElement linkMyAccount;

    @FindBy(xpath = ".//*[@class='my-account-link-header']//*[@href='/my-account/my-parts']")
    private WebElement linkMyParts;

    public ModelDetailsPage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean checkIfItIsModelPage() {
        return actionsWithOurWebElements.isElementPresent(modelPageTitle);
    }

    public String addProductToMyParts() {
        actionsWithOurWebElements.moveToElement(buttonAddToMyParts);
        actionsWithOurWebElements.clickOnWebElement(buttonAddToMyParts);
        return inputProductCode.getAttribute("Value");
    }

    public void activateMyAccountMenu() {
        actionsWithOurWebElements.moveToElement(linkMyAccount);
    }

    public void clickOnMyPartsLink() {
        actionsWithOurWebElements.clickOnWebElement(linkMyParts);
    }
}
