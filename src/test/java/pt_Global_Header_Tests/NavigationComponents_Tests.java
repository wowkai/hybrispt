package pt_Global_Header_Tests;

import org.testng.annotations.Test;
import parentTest.ParentTest;

public class NavigationComponents_Tests extends ParentTest {

    // test that Shop By Manufacturer fly-out is opened after hover on link 'Shop by Manufacturer'
    @Test
    public void shopByManufacturerFlyOutOpenTest() {
        homePage.openHomePage();
        homePage.hoverOnShopByManufacturerLink();
        checkAcceptanceCriteria("Shop by manufacturer fly-out isn't opened", homePage.shopByManufacturerFlyOutIsActive(), true);
    }

    // test that Shop By Equipment fly-out is opened after hover on link 'Shop by Equipment'
    @Test
    public void shopByEquipmentFlyOutOpenTest() {
        homePage.openHomePage();
        homePage.hoverOnShopByEquipmentLink();
        checkAcceptanceCriteria("Shop by equipment fly-out isn't opened", homePage.shopByEquipmentFlyOutIsActive(), true);
    }

    // test that Inside PT fly-out is opened after hover on link Inside Parts Town
    @Test
    public void insidePTFlyOutOpenTest() {
        homePage.openHomePage();
        homePage.hoverOnInsidePTLink();
        checkAcceptanceCriteria("Insdie PT fly-out isn't opened", homePage.insidePTFlyOutIsActive(), true);
    }

    // test that TechTown site is opened after click on TechTown link
    @Test(enabled = false)
    public void clickOnTechTownLinkTest() {
        homePage.openHomePage();
        homePage.clickOnTechTownLink();
        checkAcceptanceCriteria("TechTown site isn't opened", homePage.checkIfTechTownSitePageIsOpened(), true);

    }

    // test that Track My Order page is opened after clock on 'Track my order' link
    @Test
    public void clickOnTrackMyOrderLink() {
        homePage.openHomePage();
        homePage.clickOnTrackMyOrderLink();
        checkAcceptanceCriteria("Track my order page isn't opened", trackMyOrderPage.isTrackMyOrderPage(), true);
    }


}
