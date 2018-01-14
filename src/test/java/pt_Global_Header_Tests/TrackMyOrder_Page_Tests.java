package pt_Global_Header_Tests;

import libs.ConfigData;
import org.junit.Test;
import parentTest.ParentTest;

import java.io.IOException;
import java.util.Map;

public class TrackMyOrder_Page_Tests extends ParentTest {

    @Test
    // test to check that Track My Order page is opened and user can find order
    public void trackMyOrderPageTest () throws IOException {
        Map dataFromExcelForSearch = excelDriver.getData(ConfigData.getCfgValue("GlobalHeader_Config_file"), "keywords");
        homePage.openHomePage();
        homePage.clickOnTrackMyOrderLink();
        trackMyOrderPage.enterOrderInfo(dataFromExcelForSearch.get("ORDER_NUMBER").toString(), dataFromExcelForSearch.get("ZIP_CODE").toString());
        trackMyOrderPage.clickTrackMyOrderButton();
        checkAcceptanceCriteria("Order Status page isn't opened", trackMyOrderPage.isOrderStatusPage(), true);
    }
}
