package pt_MyAccount_Tests;

import org.testng.annotations.Test;
import parentTest.ParentTest;

public class AddressBookTests extends ParentTest {

    @Test
    public void AddNewAddressWithoutAvalaraValidation () throws Exception {

        LoginToTheSystem.validLogin();
        homePage.hoverOnMyAccountIcon();
        homePage.clickOnMyAddressBookLink();



    }
}
