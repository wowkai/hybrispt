package pt_MyAccount_Tests;

import libs.ConfigData;
import org.testng.annotations.Test;
import parentTest.ParentTest;

import java.io.IOException;
import java.util.Calendar;
import java.util.Map;
import java.util.TimeZone;

public class editMyProfileTests extends ParentTest {

    // general method for user login
    public void loginToTheSystem() throws IOException {
        Map dataFromExcelForLogin = excelDriver.getData(ConfigData.getCfgValue("GlobalHeader_Config_file"), "keywords");

        homePage.openHomePage();
        homePage.clickOnLoginLink();
        loginPage.validLogin(dataFromExcelForLogin.get("General_user_login").toString(), dataFromExcelForLogin.get("General_user_password").toString());
        checkAcceptanceCriteria("User isn't logged to the system", homePage.myAccountMenuIsPresent(), true);
    }

    // check that user is able to change First Name on MyProfile page
    @Test
    public void changeFirstNameTest() throws IOException {
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        int day = calendar.get(Calendar.MINUTE)+calendar.get(Calendar.SECOND);
        String name = "test" + Integer.toString(day);

        loginToTheSystem();
        homePage.hoverOnMyAccountIcon();
        homePage.clickOnMyProfileLink();
        String old_name = myProfilePage.getFirstName();
        myProfilePage.setNewFirstName(name);
        myProfilePage.clickOnUpdateMyProfileButton();
        String new_name = myProfilePage.getFirstName();
        checkAcceptanceCriteria("First Name wasn't changed", old_name.equals(new_name), false);
    }
}
