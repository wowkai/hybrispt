package pt_Global_Header_Tests;

import libs.ConfigData;
import org.junit.Test;
import parentTest.ParentTest;

import java.io.IOException;
import java.util.Map;

public class Find_Equipment_Manuals_Search_Tests extends ParentTest {

    @Test
    // test that user could select Manufacturer-Model-ManualType and Manual page is opened
    public void searchManuals() throws IOException {
        Map dataFromExcelForSearch = excelDriver.getData(ConfigData.getCfgValue("GlobalHeader_Config_file"), "keywords");
        homePage.openHomePage();
        homePage.setDropDownSelectManufacturer(dataFromExcelForSearch.get("SELECT_MANUFACTURER").toString());
        homePage.setDropDownSelectModel(dataFromExcelForSearch.get("SELECT_MODEL").toString());
        homePage.setDropDownDocumentType(dataFromExcelForSearch.get("SELECT_DOCUMENT_TYPE_1").toString());
        homePage.clickOnManualsSearchButton();
        homePage.checkIfManualWasOpened();
    }

    @Test
    // test that user could select Manufacturer-Model-List of Replacement parts and MDP is opened
    public void searchListOfReplacementParts() throws IOException {
        Map dataFromExcelForSearch = excelDriver.getData(ConfigData.getCfgValue("GlobalHeader_Config_file"), "keywords");
        homePage.openHomePage();
        homePage.setDropDownSelectManufacturer(dataFromExcelForSearch.get("SELECT_MANUFACTURER").toString());
        homePage.setDropDownSelectModel(dataFromExcelForSearch.get("SELECT_MODEL").toString());
        homePage.setDropDownDocumentType(dataFromExcelForSearch.get("SELECT_DOCUMENT_TYPE_2").toString());
        homePage.clickOnManualsSearchButton();
        checkAcceptanceCriteria("Model details page isn't opened", modelDetailsPage.getTemplate().contains("productListPage"), true);
    }
}
