package pages;
/**
 * Homepage is the main page of site.
 * Here user can login/logout or register new account, perform search and go to Manufacturer and Equipments page via
 * navigation menu in header
 */

import libs.ConfigData;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;

public class HomePage extends ParentPage {

    //@FindBy(css="div:contains('Thank you for registering!')")
    @FindBy(xpath = ".//div[text()='Thank you for registering!']")
    WebElement registrationText;

    @FindBy(css = "input.form-control[type='text']")
    //@FindBy(xpath = ".//*[@class='form-control' and @type='text']")
    WebElement inputSearchForm;

    @FindBy(className = "input-group-btn")
    WebElement buttonSearch;

    @FindBy(css = "span.nav__link a[href='/manufacturers']")
    WebElement linkShopByManufacturer;

    @FindBy(css = "a.sub-navigation__link--primary")
    WebElement linkViewAllManufacturer;

    @FindBy(css = "span.nav__link a[href='/equipment-categories']")
    WebElement linkShopByEquipment;

    @FindBy(css = "li.nav-item--inside-partstown span.nav-item__link a")
    WebElement linkInsidePT;

    @FindBy(css = "a[data-type='techtown']")
    WebElement linkTechTown;

    @FindBy(css = "a.nav__link-login")
    //@FindBy(xpath = ".//*[@class='not-logged-nav-wr']/div/a[@href='/login']")
    WebElement linkLogin;

    @FindBy(css = "div.not-logged-nav a[href='/register']")
    //@FindBy(xpath = ".//*[@class='not-logged-nav-wr']/div/a[@href='/register']")
    WebElement linkRegister;

    @FindBy(css = "a.myAccountLinksHeader")
    WebElement linkMyAccount;

    @FindBy(css = "div#accNavComponentDesktopOne a[href='/my-account/update-profile']")
    WebElement linkMyProfile;

    @FindBy(css = "div#accNavComponentDesktopOne a[href='/my-account/address-book']")
    WebElement linkAddressBook;

    @FindBy(name = "manufacturer")
    WebElement dropDownSelectManufacturer;

    @FindBy(name = "model")
    WebElement dropDownSelectModel;

    @FindBy(name = "docType")
    WebElement dropDownDocumentType;

    @FindBy(css = "form#findEquipManuals use[href='#svg-search']")
    WebElement searchManualsIcon;

    @FindBy(css = "div[data-location='header']")
    WebElement liveChatHeaderLink;

    @FindBy(css = "div.lp_desktop")
    WebElement liveChatPopUp;

    @FindBy(css = "a[href='/bulk-order")
    WebElement bulkOrderLink;

    @FindBy(css = "span.nav__link a[data-type='track my order']")
    WebElement trackMyOrderLink;

    @FindBy(css = "a.lang-currencies-btn")
    WebElement countryFlagHeader;

    @FindBy(css = "a.change-country-link")
    WebElement changeCountryLink;

    @FindBy(css = "li[attr-code='US']")
    WebElement countryUSListItem;

    @FindBy(css = "button.js-change-country")
    WebElement buttonStartShopping;

    @FindBy(className = "lang-currencies-selected")
    WebElement languageSelector;

    //@FindBy(xpath = ".//*[@class='lang-selector__item'][2]")
    @FindBy(xpath = ".//input[@lang='fr']/..")
    WebElement frenchLanguageInputField;

    @FindBy(xpath = ".//input[@lang='en']/..")
    WebElement englishLanguageInputField;

    @FindBy(className = "lang-currencies-selected")
    WebElement currentSiteLanguage;

    @FindBy(id = "country")
    WebElement inputFieldCountry;

    @FindBy(css = "div.nav__minicart div.not-empty")
    WebElement miniCartIconWithProducts;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    // method that opens Homepage by url which should be set in config.properties file in base_url variable
    public void openHomePage() {
        try {
            webDriver.get(ConfigData.getCfgValue("base_url"));
            logger.info("Homepage was opened");
        } catch (Exception e) {
            logger.error("Can not open homepage url");
            Assert.fail("Can not open homepage url");
        }
    }

    // method that checks if message about success registration is shown
    public boolean isRegistrationMessagePresent() {
        return actionsWithOurWebElements.isElementPresent(registrationText);
    }

    public void searchBySearchKeyword(String searchKeyword) {
        actionsWithOurWebElements.enterTextIntoInput(inputSearchForm, searchKeyword);
        clickOnSearchButton();
    }

    public void clickOnSearchButton() {
        actionsWithOurWebElements.clickOnWebElement(buttonSearch);
    }

    public void clickOnShopByManufacturerLink() {
        actionsWithOurWebElements.clickOnWebElement(linkShopByManufacturer);
    }

    public void clickOnLoginLink() {
        actionsWithOurWebElements.clickOnWebElement(linkLogin);
    }

    public void clickOnRegisterLink() {
        actionsWithOurWebElements.clickOnWebElement(linkRegister);
    }

    public boolean myAccountMenuIsPresent() {
        return actionsWithOurWebElements.isElementPresent(linkMyAccount);
    }

    public boolean checkIfUserIsLogIn() {
        return actionsWithOurWebElements.isElementPresent(linkMyAccount);
    }

    public void setDropDownSelectManufacturer(String manufacturer) {
        actionsWithOurWebElements.selectItemInDropdownByVisibleText(dropDownSelectManufacturer, manufacturer);
    }

    public void setDropDownSelectModel(String model) {
        actionsWithOurWebElements.selectItemInDropdownByVisibleText(dropDownSelectModel, model);
    }

    public void setDropDownDocumentType(String documentType) {
        actionsWithOurWebElements.selectItemInDropdownByVisibleText(dropDownDocumentType, documentType);
    }

    public void clickOnManualsSearchButton() {
        actionsWithOurWebElements.clickOnWebElementWitBuilder(searchManualsIcon);
    }

    public boolean checkIfManualWasOpened() {
        try {
            ArrayList tabs2 = new ArrayList(webDriver.getWindowHandles()); //Получение списка табов
            webDriver.switchTo().window((String) tabs2.get(1)); //Переключение на второй таб в браузере
            return webDriver.getCurrentUrl().contains(".pdf");
        } catch (Exception e) {
            Assert.fail("Can not switch to new tab. Check if new tab with manual was opened");
            return false;
        }
    }

    public void clickOnLiveChatLink() {
        actionsWithOurWebElements.clickOnWebElement(liveChatHeaderLink);
    }

    public boolean liveChatWindowIsShown() {
        return actionsWithOurWebElements.isElementPresent(liveChatPopUp);
    }

    // Name of language in variable should be: 'FR' or 'French', 'EN' or 'English'.
    public void changeLanguage(String language) {
        actionsWithOurWebElements.hoverOnWebElement(languageSelector);
        if (language == "FR" || language == "French" ) {
            actionsWithOurWebElements.clickOnWebElement(frenchLanguageInputField);
        } else if (language == "EN" || language == "English" ) {
            actionsWithOurWebElements.clickOnWebElement(englishLanguageInputField);
        } else {
            logger.error("Name of language should be: FR or French, EN or English. Please try again");
            Assert.fail("Name of language should be: FR or French, EN or English. Please try again");
        }

    }

    public String checkCurrentLanguage() {
        try {
            String text = currentSiteLanguage.getText();
            return text;
        } catch (Exception e) {
            Assert.fail("Cannot work with element");
            return "";
        }
    }

    public void clickOnCountryFlag() {
        actionsWithOurWebElements.clickOnWebElement(countryFlagHeader);
    }

    public void clickOnNotInCountryLink() {
        actionsWithOurWebElements.clickOnWebElement(changeCountryLink);
    }

    public void selectCountryFromList(String country) {
        actionsWithOurWebElements.enterTextIntoInput(inputFieldCountry, country);
        actionsWithOurWebElements.clickOnWebElement(countryUSListItem);
    }

    public void clickStartShoppingButton() {
        actionsWithOurWebElements.clickOnWebElement(buttonStartShopping);
    }

    public void clickOnBulkOrderLink() {
        actionsWithOurWebElements.clickOnWebElement(bulkOrderLink);
    }

    public void clickOnTrackMyOrderLink() {
        actionsWithOurWebElements.clickOnWebElement(trackMyOrderLink);
    }

    public void clickOnMyProfileLink() {
        actionsWithOurWebElements.clickOnWebElement(linkMyProfile);
    }

    public void hoverOnMyAccountIcon() {
        actionsWithOurWebElements.hoverOnWebElement(linkMyAccount);
    }

    public void clickOnMyAddressBookLink() {
        actionsWithOurWebElements.clickOnWebElement(linkAddressBook);
    }

    public void hoverOnMiniCartIcon() {
        actionsWithOurWebElements.hoverOnWebElement(miniCartIconWithProducts);
    }

    public void hoverOnShopByManufacturerLink() {
        actionsWithOurWebElements.hoverOnWebElement(linkShopByManufacturer);
    }

    public boolean shopByManufacturerFlyOutIsActive() {
       return actionsWithOurWebElements.isElementPresent(linkViewAllManufacturer);
    }

    public void hoverOnShopByEquipmentLink() {
        actionsWithOurWebElements.hoverOnWebElement(linkShopByEquipment);
    }

    public boolean shopByEquipmentFlyOutIsActive() {
        return actionsWithOurWebElements.isElementPresent(".//*[@class='nav__links js-equip-list']");
    }

    public void hoverOnInsidePTLink() {
        actionsWithOurWebElements.hoverOnWebElement(linkInsidePT);
    }

    public boolean insidePTFlyOutIsActive() {
        return actionsWithOurWebElements.isElementPresent(".//div[@class='sub__navigation js_sub__navigation js-mobile-accordion']");
    }

    public void clickOnTechTownLink() {
        actionsWithOurWebElements.clickOnWebElement(linkTechTown);
    }

    public boolean checkIfTechTownSitePageIsOpened() {
        try {
            ArrayList tabs2 = new ArrayList(webDriver.getWindowHandles());
            webDriver.switchTo().window((String) tabs2.get(1));
            Boolean result = webDriver.getCurrentUrl().contains("techtown.partstown.com");
            if (result) {
                logger.info("techtown.partstown.com was opened");
                return true;
            } else {
                logger.info("techtown.partstown.com wasn't opened");
                return false;
            }
        } catch (Exception e) {
            Assert.fail("Can not switch to new tab. Check if new tab with manual was opened");
            return false;
        }
    }

    public void clickOnPaymentDetailsLink() {
        actionsWithOurWebElements.clickOnWebElement(".//div[@id='accNavComponentDesktopOne']//a[@href='/my-account/payment-details']");
    }
}
