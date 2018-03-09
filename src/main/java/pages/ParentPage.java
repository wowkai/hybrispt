package pages;

import libs.ActionsWithOurWebElements;
import libs.UIMap;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ParentPage {
    protected WebDriver webDriver;
    protected Logger logger;
    protected ActionsWithOurWebElements actionsWithOurWebElements;
    protected WebDriverWait webDriverWait20;
    protected UIMap datafile;



    @FindBy(tagName = "h1")
    private WebElement zagolovok;

    public ParentPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        logger = Logger.getLogger(getClass());
        actionsWithOurWebElements = new ActionsWithOurWebElements(webDriver);
        PageFactory.initElements(webDriver, this);
        webDriverWait20 = new WebDriverWait(webDriver, 30);
        datafile = new UIMap("src/datafile.properties");
    }

    private String getTitle() {
        return webDriver.getTitle();
    }

    public String getTemplate() {
        webDriverWait20.until(ExpectedConditions.presenceOfElementLocated(By.tagName("Body")));
        return webDriver.findElement(By.tagName("Body")).getAttribute("class");
    }

    public String getUrl() {
        return webDriver.getCurrentUrl();
    }

    public void checkTitle(String title) {
        Assert.assertEquals("Title not expected",getTitle(),title);
    }

    protected boolean checkPageTemplate(String pageTemplate) {
        return actionsWithOurWebElements.isElementPresent(".//*[contains(@class, '"+ pageTemplate + "')]");
    }

    public boolean checkIfRefinementIsApplied(String search_keyword) {
        return actionsWithOurWebElements.isElementPresent(".//*[@class='facet__values' and contains(text(),'" + search_keyword + "')]");
    }
}
