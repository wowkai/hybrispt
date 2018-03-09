package pt_MyAccount_Tests;

import libs.UIMap;
import pages.HomePage;
import parentTest.ParentTest;

public class LoginToTheSystem extends ParentTest {
    private static UIMap datafile;
    // general method for user login
    public static void validLogin() throws Exception {
        datafile = new UIMap("src/datafile.properties");
        homePage.openHomePage();
        homePage.clickOnLoginLink();

        loginPage.validLogin(datafile.getData("username"), datafile.getData("password"));
        checkAcceptanceCriteria("User isn't logged to the system", homePage.myAccountMenuIsPresent(), true);
    }
}
