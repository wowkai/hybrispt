package pt_Global_Header_Tests;

import org.testng.annotations.Test;
import parentTest.ParentTest;

public class BulkOrderHeader_Tests extends ParentTest {

    @Test
    // test that user can reach Bulk Order Page by link in header
    public void bulkOrderHeaderLinkTest() {
        homePage.openHomePage();
        homePage.clickOnBulkOrderLink();
        checkAcceptanceCriteria("Bulk Order page isn't opened", bulkOrderPage.getTemplate().contains("QuickOrderPageTemplate"), true);
    }
}
