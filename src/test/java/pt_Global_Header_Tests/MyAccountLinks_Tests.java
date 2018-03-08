package pt_Global_Header_Tests;

import libs.ConfigData;
import libs.ExcelDriver;
import org.testng.annotations.Test;
import parentTest.ParentTest;

import java.io.IOException;
import java.util.Map;

public class MyAccountLinks_Tests extends ParentTest {

    @Test
    // test if user can open MyProfile page
    public void openMyProfilePageTest() throws IOException {
        Map dataFromExcelForLogin = ExcelDriver.getData(ConfigData.getCfgValue("GlobalHeader_Config_file"), "keywords");

        homePage.openHomePage();
        homePage.clickOnLoginLink();
        loginPage.validLogin(dataFromExcelForLogin.get("Valid_login").toString(), dataFromExcelForLogin.get("Valid_password").toString());
        homePage.hoverOnMyAccountIcon();
        homePage.clickOnMyProfileLink();
        checkAcceptanceCriteria("My profile page isn't opened", myPartsPage.getTemplate().contains("update-profile"), true);
    }

    @Test
    // test if user can open AddressBook page
    public void openAddressBookPageTest() throws IOException {
        Map dataFromExcelForLogin = ExcelDriver.getData(ConfigData.getCfgValue("GlobalHeader_Config_file"), "keywords");

        homePage.openHomePage();
        homePage.clickOnLoginLink();
        loginPage.validLogin(dataFromExcelForLogin.get("Valid_login").toString(), dataFromExcelForLogin.get("Valid_password").toString());
        homePage.hoverOnMyAccountIcon();
        homePage.clickOnMyAddressBookLink();
        checkAcceptanceCriteria("My profile page isn't opened", myPartsPage.getTemplate().contains("address-book"), true);
    }

    @Test
    // test if user can open PaymentDetails page
    public void openPaymentDetailsPageTest() throws IOException {
        Map dataFromExcelForLogin = ExcelDriver.getData(ConfigData.getCfgValue("GlobalHeader_Config_file"), "keywords");

        homePage.openHomePage();
        homePage.clickOnLoginLink();
        loginPage.validLogin(dataFromExcelForLogin.get("Valid_login").toString(), dataFromExcelForLogin.get("Valid_password").toString());
        homePage.hoverOnMyAccountIcon();
        homePage.clickOnPaymentDetailsLink();
        checkAcceptanceCriteria("My profile page isn't opened", myPartsPage.getTemplate().contains("accountLayoutPage"), true);
    }
}
