package pages;

import junit.framework.Assert;
import libs.ActionsWithOurWebElements;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ParentPage {
    WebDriver webDriver;
    Logger logger;
    ActionsWithOurWebElements actionsWithOurWebElements;
    WebDriverWait webDriverWait20;


    @FindBy(tagName = "h1")
    private WebElement zagolovok;

    public ParentPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        logger = Logger.getLogger(getClass());
        actionsWithOurWebElements = new ActionsWithOurWebElements(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public String getTitle() {
        return webDriver.getTitle();
    }

    public String getTemplate() {
        String pageTemplate = webDriver.findElement(By.tagName("Body")).getAttribute("class");
        return pageTemplate;
    }

    public String getUrl() {
        return webDriver.getCurrentUrl();
    }

    public void checkTitle(String title) {
        Assert.assertEquals("Title not expected",getTitle(),title);
    }

    public boolean checkPageTemplate(String pageTemplate) {
        return actionsWithOurWebElements.isElementPresent(".//*[contains(@class, '"+ pageTemplate + "')]");
    }

    public boolean checkIfRefinementIsApplied(String search_keyword) {
        return actionsWithOurWebElements.isElementPresent(".//*[@class='facet__values' and contains(text(),'" + search_keyword + "')]");
    }
}
