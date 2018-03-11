package pages.myAccountPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pages.ParentPage;

public class MyPartsPage extends ParentPage {

    @FindBy(className = "js-search-my-parts")
    WebElement inputSearchKeyword;

    public MyPartsPage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean searchAddedProduct(String addedProduct) {
        try {
            actionsWithOurWebElements.enterTextIntoInput(inputSearchKeyword, addedProduct);
            return actionsWithOurWebElements.isElementPresentByXpath(".//*[@class='parts-info__code' and contains(text(), '" + addedProduct + "')]");
        } catch (Exception e) {
            logger.error("Can not find " + addedProduct + " on the MyParts page.");
            Assert.fail("Can not find " + addedProduct + " on the MyParts page.");
            return false;
        }
    }

}
