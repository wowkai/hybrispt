package pages;

/**
 * Checkout page is consist of few steps, where user should enter information about shipping, payment, etc
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends ParentPage {

    @FindBy(name = "firstName")
    WebElement inputFirstName;

    @FindBy(name = "lastName")
    WebElement inputLastName;

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

    @FindBy(id = "addressSubmit")
    WebElement buttonContinueToShoppingMethod;

    @FindBy(id = "deliveryMethodSubmit")
    WebElement buttonContinueToPaymentMethod;

    @FindBy(name = "maskedCardNumber")
    WebElement inputCreditCardNumber;

    @FindBy(id = "endDateMonth")
    WebElement dropdownMonth;

    @FindBy(id = "endDateYear")
    WebElement dropdownYear;

    @FindBy(name = "card_cvNumber")
    WebElement inputCCVNumber;

    @FindBy(css = "button.checkout-next")
    WebElement buttonContinueToOrderReview;

    @FindBy(id = "placeOrder")
    WebElement buttonPlaceOrder;

    @FindBy(css = "a[data-active-step='deliveryAddress.noPickup']")
    WebElement activeStepShippingInformation;

    @FindBy(css = "a[data-active-step='deliveryMethod']")
    WebElement activeStepShippingMethod;

    @FindBy(css = "a[data-active-step='paymentMethod']")
    WebElement activeStepPaymentInformation;

    @FindBy(id = "useDeliveryAddress")
    WebElement checkboxSameAsShippingAddress;

    @FindBy(css = "a[data-active-step='confirmOrder']")
    WebElement activeStepOrderReview;

    public CheckoutPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void enterFirstName(String firstName) {
        actionsWithOurWebElements.enterTextIntoInput(inputFirstName, firstName);
    }

    public void enterLastName(String lastName) {
        actionsWithOurWebElements.enterTextIntoInput(inputLastName, lastName);
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

    public void clickOnContinueToShippingMethodButton() {
        actionsWithOurWebElements.clickOnWebElement(buttonContinueToShoppingMethod);
    }

    public void clickOnContinueToPaymentMethodButton() {
        actionsWithOurWebElements.clickOnWebElement(buttonContinueToPaymentMethod);
    }

    public void enterCreditCartNumber(String creditCard) {
        actionsWithOurWebElements.enterTextIntoInput(inputCreditCardNumber, creditCard);
    }

    public void selectCreditCardExpirationDate (String month, String year) {
        actionsWithOurWebElements.selectItemInDropdownByValue(dropdownMonth, month);
        actionsWithOurWebElements.selectItemInDropdownByValue(dropdownYear, year);
    }

    public void enterCreditCardCCVNumber( String CCV) {
        actionsWithOurWebElements.enterTextIntoInput(inputCCVNumber, CCV);
    }

    public void clickOnContinueToOrderReviewButton() {
        actionsWithOurWebElements.clickOnWebElement(buttonContinueToOrderReview);
    }

    public void clickOnPlaceOrderButton() {
        actionsWithOurWebElements.moveToElement(buttonPlaceOrder);
        actionsWithOurWebElements.clickOnWebElement(buttonPlaceOrder);
    }

    public boolean checkIfShippingInformationStepIsActive() {
        return actionsWithOurWebElements.isElementPresent(activeStepShippingInformation);
    }

    public boolean checkIfShippingMethodStepIsActive() {
        return actionsWithOurWebElements.isElementPresent(activeStepShippingMethod);
    }

    public boolean checkIfPaymentInformationStepIsActive() {
        return actionsWithOurWebElements.isElementPresent(activeStepPaymentInformation);
    }

    public void setStateForSameAsShippingAddressCheckbox (String status) {
        actionsWithOurWebElements.setStateToCheckBox(checkboxSameAsShippingAddress, status);
    }

    public boolean checkIfOrderReviewStepIsActive() {
        return actionsWithOurWebElements.isElementPresent(activeStepOrderReview);
    }
}
