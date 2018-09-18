package pt_Global_Header_Tests;

/**
 * These are tests for verification site search logic by general keyword, manufacturer, model keywords
 */

import libs.ConfigData;
import org.testng.annotations.Test;
import parentTest.ParentTest;

import java.io.IOException;
import java.util.Map;

public class Global_Search_Tests extends ParentTest {

    @Test
    // test with search by general search keyword
    public void generalSearchKeywordTest() throws IOException {
        Map dataFromExcelForSearch = excelDriver.getData(ConfigData.getCfgValue("GlobalHeader_Config_file"), "keywords");
        homePage.openHomePage();
        homePage.searchBySearchKeyword("thermostat");
        //homePage.searchBySearchKeyword(dataFromExcelForSearch.get("GENERAL_SEARCH_KEYWORD").toString());
        checkAcceptanceCriteria("Search page isn't opened", searchPage.getTemplate().contains("searchListPage"), true);
        checkAcceptanceCriteria("Search keyword isn't applied as refinement", searchPage.checkIfRefinementIsApplied(dataFromExcelForSearch.get("GENERAL_SEARCH_KEYWORD").toString()), true);
    }

    @Test
    // test with search by Manufacturer search keyword
    public void manufacturerSearchKeywordTest() throws IOException {
        Map dataFromExcelForSearch = excelDriver.getData(ConfigData.getCfgValue("GlobalHeader_Config_file"), "keywords");
        homePage.openHomePage();
        homePage.searchBySearchKeyword(dataFromExcelForSearch.get("MANUFACTURER_SEARCH_KEYWORD").toString());
        checkAcceptanceCriteria("Manufacture landing page isn't  opened", manufacturerLandingPage.getTemplate().contains("searchListPage"), true);
        checkAcceptanceCriteria("Search keyword isn't applied as refinement", manufacturerLandingPage.checkIfRefinementIsApplied(dataFromExcelForSearch.get("MANUFACTURER_SEARCH_KEYWORD").toString()), true);
    }

    @Test
    // test with search by Model search keyword
    public void modelSearchKeywordTest() throws IOException {
        Map dataFromExcelForSearch = excelDriver.getData(ConfigData.getCfgValue("GlobalHeader_Config_file"), "keywords");
        homePage.openHomePage();
        homePage.searchBySearchKeyword(dataFromExcelForSearch.get("MODEL_SEARCH_KEYWORD").toString());
        checkAcceptanceCriteria("Model details page isn't opened", modelDetailsPage.getTemplate().contains("productListPage"), true);
    }

    @Test
    // test with search by Product search keyword
    public void productSearchKeywordTest() throws IOException {
        Map dataFromExcelForSearch = excelDriver.getData(ConfigData.getCfgValue("GlobalHeader_Config_file"), "keywords");
        homePage.openHomePage();
        homePage.searchBySearchKeyword(dataFromExcelForSearch.get("PRODUCT_SEARCH_KEYWORD").toString());
        checkAcceptanceCriteria("Model details page isn't  opened", productDetailsPage.getTemplate().contains("ProductPage"), true);
    }

    @Test
    // test with search keyword which shows No search result page
    public void noSearchResultsPage() throws IOException {
        Map dataFromExcelForSearch = excelDriver.getData(ConfigData.getCfgValue("GlobalHeader_Config_file"), "keywords");
        homePage.openHomePage();
        homePage.searchBySearchKeyword(dataFromExcelForSearch.get("NORESULTS_KEYWORD").toString());
        checkAcceptanceCriteria("No search results page isn't opened", searchPage.getTemplate().contains("searchEmptyPage"), true);
    }
}
