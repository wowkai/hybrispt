package pt_Global_Header_Tests;

import libs.ConfigData;
import org.testng.annotations.Test;
import parentTest.ParentTest;

import java.io.IOException;
import java.util.Map;

public class LoginAndRegisterPages_Tests extends ParentTest {

    @Test
    // test checks if LoginPage can be opened
    public void loginPageOpenTest() {
        homePage.openHomePage();
        homePage.clickOnLoginLink();
        System.out.println(loginPage.getTemplate());
        checkAcceptanceCriteria("Login page isn't opened", loginPage.getTemplate().contains("pageLabel-login"), true);
    }

    @Test
    // test checks if Create an Account page is opened
    public void  registerPageOpenTest() {
        homePage.openHomePage();
        homePage.clickOnRegisterLink();
        checkAcceptanceCriteria("Create an account page isn't opened", registrationPage.getTemplate().contains("pageLabel-PTRegisterPage"), true);
    }

    @Test(enabled = true)
    // new user registration test
    public void newUserRegistrationTest() throws IOException {
        Map dataFromExcelForRegistration = excelDriver.getData(ConfigData.getCfgValue("GlobalHeader_Config_file"), "keywords");
        // Open Homepage page and click Register Link
        homePage.openHomePage();
        homePage.clickOnRegisterLink();

        // Check if user was redirected to Registration Page
        checkAcceptanceCriteria("Create an account page isn't opened", registrationPage.getTemplate().contains("pageLabel-PTRegisterPage"), true);

        // Enter valid data for registration from Excel file
        registrationPage.enterFirstName(dataFromExcelForRegistration.get("FirstName").toString());
        registrationPage.enterLastName(dataFromExcelForRegistration.get("LastName").toString());
        registrationPage.selectBirthdayMonth(dataFromExcelForRegistration.get("BirthdayMonth").toString());
        registrationPage.enterCompanyName(dataFromExcelForRegistration.get("CompanyName").toString());
        registrationPage.selectPrimaryBusiness(dataFromExcelForRegistration.get("PrimaryBusiness").toString());
        registrationPage.enterAddressLine1(dataFromExcelForRegistration.get("AddressLine1").toString());
        registrationPage.selectCountry(dataFromExcelForRegistration.get("Country").toString());
        registrationPage.selectState(dataFromExcelForRegistration.get("State").toString());
        registrationPage.enterCity(dataFromExcelForRegistration.get("City").toString());
        registrationPage.enterPostCode(dataFromExcelForRegistration.get("ZipCode").toString());
        registrationPage.enterPhone(dataFromExcelForRegistration.get("Phone").toString());
        registrationPage.enterEmail();
        // Password field must be at least 8 characters long
        registrationPage.enterPassword(dataFromExcelForRegistration.get("Password").toString());
        registrationPage.enterConfirmationPassword(dataFromExcelForRegistration.get("Password").toString());

        // State for checkboxes should be only 'Checked' or 'Unchecked'
        //registrationPage.setStateForPostalMailList(dataFromExcelForRegistration.get("Checkbox1State").toString());
        //registrationPage.setStateForEmailList(dataFromExcelForRegistration.get("Checkbox2State").toString());

        registrationPage.clickOnCreateAccountButton();
        checkAcceptanceCriteria("User wasn't registered", homePage.isRegistrationMessagePresent(), true);
        checkAcceptanceCriteria("User isn't logged to the system", homePage.myAccountMenuIsPresent(), true);
    }

    @Test
    // check if registered user can login to the system
    public void loginToSystemTest() throws IOException {
        Map dataFromExcelForLogin = excelDriver.getData(ConfigData.getCfgValue("GlobalHeader_Config_file"), "keywords");

        homePage.openHomePage();
        homePage.clickOnLoginLink();
        loginPage.validLogin(dataFromExcelForLogin.get("Valid_login").toString(), dataFromExcelForLogin.get("Valid_password").toString());
        checkAcceptanceCriteria("User isn't logged to the system", homePage.myAccountMenuIsPresent(), true);
    }
}
