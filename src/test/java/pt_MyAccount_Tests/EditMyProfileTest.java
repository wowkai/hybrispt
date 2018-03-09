package pt_MyAccount_Tests;

import libs.ConfigData;
import libs.UIMap;
import libs.Utils;
import org.testng.annotations.Test;
import parentTest.ParentTest;


public class EditMyProfileTest extends ParentTest {
    // check that user is able to change First Name on MyProfile page
    @Test
    public void changeFirstNameTest() throws Exception {
        LoginToTheSystem.validLogin();
        homePage.hoverOnMyAccountIcon();
        homePage.clickOnMyProfileLink();

        String old_name = myProfilePage.getFirstName();
        String firstName = "First" + Utils.randomValue();
        myProfilePage.setNewFirstName(firstName);

        myProfilePage.clickOnUpdateMyProfileButton();
        String new_name = myProfilePage.getFirstName();

        checkAcceptanceCriteria("First Name wasn't changed", old_name.equals(new_name), false);
    }
}
