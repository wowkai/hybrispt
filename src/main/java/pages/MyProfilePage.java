package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyProfilePage extends ParentPage {

    @FindBy(id = "firstName")
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

    @FindBy(xpath = ".//div[@class='form-group text-center']//button")
    WebElement buttonUpdateMyProfle;

    public MyProfilePage(WebDriver webDriver) {
        super(webDriver);
    }

    public String getFirstName() {
        return actionsWithOurWebElements.getValueFromInputField(inputFirstName);
    }

    public void setNewFirstName(String name) {
        actionsWithOurWebElements.enterTextIntoInput(inputFirstName, name);
    }

    public void clickOnUpdateMyProfileButton() {
        actionsWithOurWebElements.clickOnWebElement(buttonUpdateMyProfle);
    }
}
