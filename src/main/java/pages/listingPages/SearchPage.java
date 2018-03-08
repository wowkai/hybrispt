package pages.listingPages;

/**
 * Search page is used to show listing of products which was returned after using site search feature
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.ParentPage;

public class SearchPage extends ParentPage {
    String countParts;
    String countModels;

    public SearchPage(WebDriver webDriver) {
        super(webDriver);
    }

    public String getPartsCount() {
        countParts = "";
        countParts = webDriver.findElement(By.cssSelector(".active.product-tabs-item")).getAttribute("data-parts-count");
        //System.out.println(count);
        return countParts;
        }


    public String getModelCount() {
        countModels = "";
        countModels = webDriver.findElement(By.xpath(".//ul[@class='product-tabs product-tabs--space']/li[2]")).getText();
        return countModels;
    }
}

    // method for check if searched keyword was applied as refinement
