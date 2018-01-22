package pages;
/**
 * Registration or Create an Account page is the page where user could create new account
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class RegistrationPage extends ParentPage {

    @FindBy(id = "text.partstownaccelerator.register.firstName")
    WebElement inputFirstName;

    @FindBy(name = "lastName")
    WebElement inputLastName;

    @FindBy(name = "birthdayMonth")
    WebElement dropdownBirthdayMonth;

    @FindBy(name = "companyName")
    WebElement inputCompanyName;

    @FindBy(name = "primaryBusiness")
    WebElement dropdownPrimaryBusiness;

    @FindBy(name = "line1")
    WebElement inputAddressLine1;

    @FindBy(name = "line2")
    WebElement inputAddressLine2;

    @FindBy(name = "countryIso")
    WebElement dropdownCountry;

    @FindBy(name = "regionIso")
    WebElement dropdownStateProvince;

    @FindBy(name = "townCity")
    WebElement inputTownCity;

    @FindBy(name = "postcode")
    WebElement inputPostCode;

    @FindBy(name = "phone")
    WebElement inputPhone;

    @FindBy(id = "register.email")
    WebElement inputEmail;

    @FindBy(name = "password")
    WebElement inputPassword;

    @FindBy(name = "confirmPassword")
    WebElement inputConfirmPassword;

    @FindBy(name = "signForEmailList")
    WebElement checkboxSignForEmailList;

    @FindBy(name = "signForPostalMailList")
    WebElement checkboxSignForPostalMailList;

    @FindBy(css = "button.js-secureportal-register-button")
    WebElement buttonCreateAccount;

    public RegistrationPage(WebDriver webDriver) {
        super(webDriver);
    }

    // bunch of methods to fill in all fields which could be use during registration

    public void enterFirstName(String firstName) {
        actionsWithOurWebElements.enterTextIntoInput(inputFirstName, firstName);
    }

    public void enterLastName(String lastName) {
        actionsWithOurWebElements.enterTextIntoInput(inputLastName, lastName);
    }

    public void selectBirthdayMonth(String month) {
        actionsWithOurWebElements.selectItemInDropdownByVisibleText(dropdownBirthdayMonth, month);
    }

    public void enterCompanyName(String companyName) {
        actionsWithOurWebElements.enterTextIntoInput(inputCompanyName, companyName);
    }

    public void selectPrimaryBusiness(String primaryBusiness) {
        actionsWithOurWebElements.selectItemInDropdownByValue(dropdownPrimaryBusiness, primaryBusiness);
    }

    public void enterAddressLine1(String addressLine1) {
        actionsWithOurWebElements.enterTextIntoInput(inputAddressLine1, addressLine1);
    }

    public void enterAddressLine12(String addressLine2) {
        actionsWithOurWebElements.enterTextIntoInput(inputAddressLine2, addressLine2);
    }

    public void selectCountry(String country) {
        actionsWithOurWebElements.selectItemInDropdownByVisibleText(dropdownCountry, country);
    }

    public void selectState(String state) {
        actionsWithOurWebElements.selectItemInDropdownByValue(dropdownStateProvince, state);
    }

    public void enterCity(String city) {
        actionsWithOurWebElements.enterTextIntoInput(inputTownCity, city);
    }

    public void enterPostCode(String postcode) {
        actionsWithOurWebElements.enterTextIntoInput(inputPostCode, postcode);
    }

    public void enterPhone(String phone) {
        actionsWithOurWebElements.enterTextIntoInput(inputPhone, phone);
    }

    // this method generates random prefix +n, which is joined to real an.vovk@astoundcommerce.com email
    public void enterEmail() {
        int a = (int) (Math.random() * 30000);
        actionsWithOurWebElements.enterTextIntoInput(inputEmail, "an.vovk+" + a + "@astoundcommerce.com");
    }

    // the minimal length of password is 8 symbols
    public void enterPassword(String password) {
        if (password.length() < 8) {
            Assert.fail("Minimal length of password should be at least 8 symbols. Change password and try again! ");
            logger.error("Minimal length of password should be at least 8 symbols. Change password and try again! ");
        } else {
            actionsWithOurWebElements.enterTextIntoInput(inputPassword, password);
        }
    }

    public void enterConfirmationPassword(String confirmationPassword) {
        if (confirmationPassword.length() < 8) {
            Assert.fail("Minimal length of password should be at least 8 symbols. Change password and try again! ");
            logger.error("Minimal length of password should be at least 8 symbols. Change password and try again! ");
        } else {
            actionsWithOurWebElements.enterTextIntoInput(inputConfirmPassword, confirmationPassword);
        }
    }

    public void setStateForPostalMailList(String status) {
        actionsWithOurWebElements.setStateToCheckBox(checkboxSignForPostalMailList, status);
    }

    public void setStateForEmailList(String status) {
        actionsWithOurWebElements.setStateToCheckBox(checkboxSignForEmailList, status);
    }

    public void clickOnCreateAccountButton() {
        actionsWithOurWebElements.clickOnWebElement(buttonCreateAccount);
    }
}
