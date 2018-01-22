package pages;

import junit.framework.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPages extends ParentPage {

    @FindBy(className = "js-search-my-parts")
    WebElement inputSearchKeyword;

    public MyAccountPages(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean searchAddedProduct(String addedProduct) {
        try {
            actionsWithOurWebElements.enterTextIntoInput(inputSearchKeyword, addedProduct);
            return actionsWithOurWebElements.isElementPresent(".//*[@class='parts-info__code' and contains(text(), '" + addedProduct + "')]");
        } catch (Exception e) {
            logger.error("Can not find " + addedProduct + " on the MyParts page.");
            Assert.fail("Can not find " + addedProduct + " on the MyParts page.");
            return false;
        }
    }

}
