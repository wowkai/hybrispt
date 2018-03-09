package pt_MyAccount_Tests;

import libs.UIMap;
import org.testng.annotations.Test;
import parentTest.ParentTest;

public class AddressBookTests extends ParentTest {

    @Test(invocationCount = 1)
    public void AddNewAddressWithoutAvalaraValidation () throws Exception {

        LoginToTheSystem.validLogin();
        homePage.hoverOnMyAccountIcon();
        homePage.clickOnMyAddressBookLink();

        addressBookPage.clickOnAddNewAddressButton();
        String newAddress = addressBookPage.enterValidAddress();
        addressBookPage.clcikOnButtonApply();
        checkAcceptanceCriteria(" ", addressBookPage.newAddressIsPresent(newAddress), true);
    }
}
