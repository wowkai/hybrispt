package pt_MyAccount_Tests;
import libs.Utils;
import org.testng.annotations.Test;
import parentTest.ParentTest;

public class AddressBookTests extends ParentTest {

    @Test(enabled = true)
    public void DeleteAllAddressFromAddressBook() throws Exception {

        LoginToTheSystem.validLogin();
        homePage.hoverOnMyAccountIcon();
        homePage.clickOnMyAddressBookLink();

        addressBookPage.deleteAllAddedAddresses();
    }


    @Test(invocationCount = 25)
    public void AddNewAddressWithoutAvalaraValidation () throws Exception {
        String addressName = "NewAddress" + Utils.randomValue();
        LoginToTheSystem.validLogin();
        homePage.hoverOnMyAccountIcon();
        homePage.clickOnMyAddressBookLink();

        addressBookPage.clickOnAddNewAddressButton();
        addressBookPage.enterValidAddress(addressName);
        addressBookPage.clickOnButtonApply();
        checkAcceptanceCriteria(" New address wasn't added to Address Book ", addressBookPage.newAddressIsPresent(addressName), true);
    }

    @Test
    public void AddNewAddressWithAvalaraSuggestion() throws Exception {
        String addressName = "NewAddress" + Utils.randomValue();

        LoginToTheSystem.validLogin();
        homePage.hoverOnMyAccountIcon();
        homePage.clickOnMyAddressBookLink();

        addressBookPage.clickOnAddNewAddressButton();
        addressBookPage.enterAddressForValidation(addressName);
        addressBookPage.clickOnButtonApply();
        avalaraAddressValidationPopup.clickSelectUpdatedAddressAvalara();
        checkAcceptanceCriteria("New address with Avalara correction was added to Address Book", addressBookPage.newAddressIsPresent(addressName), true);
    }

    @Test
    public void AddNewAddressWithoutAvalaraSuggestion() throws Exception {
        String addressName = "NewAddress" + Utils.randomValue();

        LoginToTheSystem.validLogin();
        homePage.hoverOnMyAccountIcon();
        homePage.clickOnMyAddressBookLink();

        addressBookPage.clickOnAddNewAddressButton();
        addressBookPage.enterAddressForValidation(addressName);
        addressBookPage.clickOnButtonApply();
        avalaraAddressValidationPopup.clickSelectInitialAddress();
        checkAcceptanceCriteria("New address with Avalara correction was added to Address Book", addressBookPage.newAddressIsPresent(addressName), true);
    }
}
