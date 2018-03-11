package pages.myAccountPages;

import libs.UIMap;
import libs.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.ParentPage;

import java.util.List;

public class AddressBookPage extends ParentPage {

    private UIMap uimap;

    public AddressBookPage(WebDriver webDriver) {
        super(webDriver);
        webDriverWait20 = new WebDriverWait(webDriver, 30);
        uimap = new UIMap("src/locator.properties");
    }

    public void clickOnAddNewAddressButton() throws Exception {
        actionsWithOurWebElements.clickOnWebElement(webDriver.findElement(uimap.
                getLocator("btnAddNewAddress")));
    }

    public void enterAddressName(String addressName) throws Exception {
        actionsWithOurWebElements.enterTextIntoInput(webDriver.findElement(uimap
                        .getLocator("myaccount.addressBook.btnAddNewAddress")),
                addressName);
    }

    public void enterFirstName() throws Exception {
        actionsWithOurWebElements.enterTextIntoInput(webDriver.findElement(uimap
                        .getLocator("myaccount.addressBook.edtFirstName")),
                datafile.getData("FirstName"));
    }

    public void enterLastName() throws Exception {
        actionsWithOurWebElements.enterTextIntoInput(webDriver.findElement(uimap
                        .getLocator("myaccount.addressBook.edtLastName")),
                datafile.getData("LastName"));
    }

    public void enterValidAddressLine1() throws Exception {
        actionsWithOurWebElements.enterTextIntoInput(webDriver.findElement(uimap
                        .getLocator("myaccount.addressBook.edtAddressLine1")),
                datafile.getData("AddressLine1"));
    }

    public void enterValidAddressLine2() throws Exception {
        actionsWithOurWebElements.enterTextIntoInput(webDriver.findElement(uimap
                        .getLocator("myaccount.addressBook.edtAddressLine2")),
                datafile.getData("AddressLine2"));
    }

    public void selectCountry() throws Exception {
        actionsWithOurWebElements.selectItemInDropdownByVisibleText(webDriver.findElement(uimap
                        .getLocator("myaccount.addressBook.cbxCountry")),
                datafile.getData("Country"));
    }

    public void selectRegion() throws Exception {
        actionsWithOurWebElements.selectItemInDropdownByVisibleText(webDriver.findElement(uimap
                        .getLocator("myaccount.addressBook.cbxRegion")),
                datafile.getData("Region"));
    }

    public void enterValidCity() throws Exception {
        actionsWithOurWebElements.enterTextIntoInput(webDriver.findElement(uimap
                        .getLocator("myaccount.addressBook.edtCity")),
                datafile.getData("City"));
    }

    public void enterValidZipCode() throws Exception {
        actionsWithOurWebElements.enterTextIntoInput(webDriver.findElement(uimap
                        .getLocator("myaccount.addressBook.edtZipCode")),
                datafile.getData("ZipCode"));
    }

    public void enterValidPhone() throws Exception {
        actionsWithOurWebElements.enterTextIntoInput(webDriver.findElement(uimap
                        .getLocator("myaccount.addressBook.edtPhone")),
                datafile.getData("Phone"));
    }


    public void clickOnButtonApply() throws Exception {
        actionsWithOurWebElements.clickOnWebElement(webDriver.findElement(uimap.
                getLocator("myaccount.addressBook.btnApply")));
    }

    public void enterValidAddress(String addressName) throws Exception {
        enterFirstName();
        enterLastName();
        enterAddressName(addressName);
        enterValidAddressLine1();
        //enterValidAddressLine2();
        selectCountry();
        selectRegion();
        enterValidCity();
        enterValidZipCode();
        enterValidPhone();
    }

    public boolean newAddressIsPresent(String newAddress) {
        return actionsWithOurWebElements.isElementPresentByXpath("//h2[contains(text(),'"+newAddress+"')]");
    }

    public void enterAddressForValidation(String addressName) throws Exception {
        enterAddressName(addressName);
        enterFirstName();
        enterLastName();
        enterValidAddressLine1();
        //enterValidAddressLine2();
        selectCountry();
        selectRegion();
        actionsWithOurWebElements.enterTextIntoInput(webDriver.findElement(uimap
                .getLocator("myaccount.addressBook.edtCity")), "Wrong city");
        //enterValidCity();
        enterValidZipCode();
        enterValidPhone();
    }


    public void deleteAllAddedAddresses() throws Exception {
        List<WebElement> addresses = webDriver.findElements(uimap.getLocator("myaccount.addressBook.lnkRemoveAddress"));

        for (int i = 0; i<addresses.size(); i++) {

            actionsWithOurWebElements.clickOnWebElement(webDriver.findElements(uimap
                    .getLocator("myaccount.addressBook.lnkRemoveAddress")).get(0));
            actionsWithOurWebElements.clickOnWebElement(webDriver.findElement(uimap
                    .getLocator("myaccount.addressBook.lnkConfirmDeletingAddress")));
            webDriver.navigate().refresh();
        }
    }
}
