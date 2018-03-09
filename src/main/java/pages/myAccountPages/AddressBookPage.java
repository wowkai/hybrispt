package pages.myAccountPages;

import libs.UIMap;
import libs.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.ParentPage;

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


    public void clcikOnButtonApply() throws Exception {
        actionsWithOurWebElements.clickOnWebElement(webDriver.findElement(uimap.
                getLocator("myaccount.addressBook.btnApply")));
    }

    public String enterValidAddress() throws Exception {
        String addressName = "NewAddress" + Utils.randomValue();
        enterAddressName(addressName);
        enterFirstName();
        enterLastName();
        enterValidAddressLine1();
        //enterValidAddressLine2();
        selectCountry();
        selectRegion();
        enterValidCity();
        enterValidZipCode();
        enterValidPhone();
        return addressName;
    }

    public boolean newAddressIsPresent(String newAddress) {
        return actionsWithOurWebElements.isElementDisplayed("//h2[contains(text(),'"+ newAddress +"')]");
    }
}
