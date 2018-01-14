package pt_Global_Header_Tests;

import libs.ConfigData;
import org.junit.Test;
import parentTest.ParentTest;

import java.io.IOException;
import java.util.Map;

public class MiniCart_Tests extends ParentTest {

    @Test
    // Check that Mini-Cart fly-out opens if user hovers on Mini-Cart area and contains relevant information about in-cart items
    public void miniCartWithProductTest() throws IOException {
        Map dataFromExcelForSearch = excelDriver.getData(ConfigData.getCfgValue("GlobalHeader_Config_file"), "keywords");

        homePage.openHomePage();
        homePage.searchBySearchKeyword(dataFromExcelForSearch.get("PRODUCT_SEARCH_KEYWORD").toString());
        productDetailsPage.clickOnAddToCartButton();
        productDetailsPage.closeAddToCartPopup();
        homePage.hoverOnMiniCartIcon();


    }

}
