package libs;

/**
 * This is class which desribes all basic and reusable operation with web elements
 * */

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionsWithOurWebElements {
    WebDriver webDriver;
    Logger logger;
    WebDriverWait webDriverWait20;

    public ActionsWithOurWebElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        logger = Logger.getLogger(getClass());
        webDriverWait20 = new WebDriverWait(webDriver, 30);
    }

    public void enterTextIntoInput(WebElement input, String text) {
        try {
            input.clear();
            input.sendKeys(text);
            logger.info(text + " was inputed to input ");
        } catch (Exception e) {
            logger.error("Can not work with input ");
            Assert.fail("Can not work with input ");
        }
    }


    public void clickOnWebElement(WebElement element) {
        try {
            webDriverWait20.until(ExpectedConditions.visibilityOf(element));
            String elementText = element.getText();
            element.click();
            logger.info("Element " + elementText + " was clicked");
        } catch (Exception e) {
            logger.error("Can not work with element ");
            Assert.fail("Can not work with element ");
        }
    }

    public void clickOnWebElement(String locator) {
        try {
            WebElement element = webDriver.findElement(By.xpath(locator));
            webDriverWait20.until(ExpectedConditions.visibilityOf(element));
            String elementText = element.getText();
            element.click();
            logger.info("Element " + elementText + " was clicked");
        } catch (Exception e) {
            logger.error("Can not work with element ");
            Assert.fail("Can not work with element ");
        }
    }


    public boolean isElementPresent(WebElement element) {
        try {
            webDriverWait20.until(ExpectedConditions.visibilityOf(element));
            return element.isDisplayed() && element.isEnabled();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isElementPresent(String locator) {
        try {
            WebElement webElement = webDriver.findElement(By.xpath(locator));
            webDriverWait20.until(ExpectedConditions.visibilityOf(webElement));
            return webElement.isDisplayed() && webElement.isEnabled();
        } catch (Exception e) {
            return false;
        }
    }

    public void selectItemInDropdownByVisibleText(WebElement elementDD, String textForSelect) {
        try {
            webDriverWait20.until(ExpectedConditions.visibilityOf(elementDD));
            Select optionsFromDD = new Select(elementDD);
            optionsFromDD.selectByVisibleText(textForSelect);
            logger.info(textForSelect + " was selected in DD");

        } catch (Exception e) {
            logger.error("Can not work with element");
            Assert.fail("Can not work with element");
        }
    }

    public void selectItemInDropdownByValue(WebElement elementDD, String valueForSelect) {
        try {
            Select valuesFromDD = new Select(elementDD);
            valuesFromDD.selectByValue(valueForSelect);
            logger.info(valueForSelect + " was selected in DD");
        } catch (Exception e) {
            logger.error("Can not work with element");
            Assert.fail("Can not work with element");
        }
    }

    /**
     * @param checkBoxElement
     * @param neededState     !! Only Checked or Unchecked
     */
    public void setStateToCheckBox(WebElement checkBoxElement, String neededState) {
        if (checkBoxElement.isSelected() && "Checked".equals(neededState)) {
            logger.info("Element is checked");
        } else if (checkBoxElement.isSelected() && "Unchecked".equals(neededState)) {
            clickOnWebElement(checkBoxElement);
        } else if (!checkBoxElement.isSelected() && "Checked".equals(neededState)) {
            clickOnWebElement(checkBoxElement);
        } else if (!checkBoxElement.isSelected() && "Unchecked".equals(neededState)) {
            logger.info("Element is Unchecked");
        }
    }

    public void moveToElement(WebElement element) {
        try {
            Actions builder = new Actions(webDriver);
            builder.moveToElement(element).perform();
            webDriverWait20.until(ExpectedConditions.visibilityOf(element));
            String elementText = element.getText();
            logger.info("Element " + elementText + " was activate");
        } catch (Exception e) {
            logger.error("Can not work with element ");
            Assert.fail("Can not work with element ");
        }
    }

    public void clickOnWebElementWitBuilder(WebElement element) {
        try {
            Actions builder = new Actions(webDriver);
            builder.click(element).build().perform();
            webDriverWait20.until(ExpectedConditions.visibilityOf(element));
            String elementText = element.getText();
            logger.info("Element " + elementText + " was clicked");
        } catch (Exception e) {
            logger.error("Can not work with element ");
            Assert.fail("Can not work with element ");
        }
    }

    public void hoverOnWebElement(WebElement element) {
        try {
            Actions builder = new Actions(webDriver);
            builder.moveToElement(element).build().perform();
            webDriverWait20.until(ExpectedConditions.visibilityOf(element));
            String elementText = element.getText();
            logger.info("Element " + elementText + " was hovered");
        } catch (Exception e) {
            logger.error("Can not hover on element ");
            Assert.fail("Can not hover on element ");
        }
    }

    public String getValueFromInputField(WebElement input) {
        try {
            logger.info("Value was get from input ");
            System.out.println(input.getAttribute("Value"));
            return input.getAttribute("Value");

        } catch (Exception e) {
            logger.error("Can not work with input ");
            Assert.fail("Can not work with input ");
            return "";
        }
    }
}
