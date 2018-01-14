package pages;
/**
 * Homepage is the main page of site.
 * Here user can login/logout or register new account, perform search and go to Manufacturer and Equipments page via
 * navigation menu in header
 */

import libs.ConfigData;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public class HomePage extends ParentPage {

    @FindBy(xpath = ".//*[text()='Thank you for registering!']")
    WebElement registrationText;

    @FindBy(xpath = ".//*[@class='form-control' and @type='text']")
    WebElement inputSearchForm;

    @FindBy(className = "input-group-btn")
    WebElement buttonSearch;

    @FindBy(xpath = ".//*[@title='Shop By Manufacturer']")
    WebElement linkShopByManufacturer;

    @FindBy(xpath = ".//*[@title='Shop By Equipment']")
    WebElement linkShopByEquipment;

    @FindBy(xpath = ".//a[@title='Inside Parts Town']")
    WebElement linkInsidePT;

    @FindBy(xpath = ".//*[@class='not-logged-nav-wr']/div/a[@href='/login']")
    WebElement linkLogin;

    @FindBy(xpath = ".//*[@class='not-logged-nav-wr']/div/a[@href='/register']")
    WebElement linkRegister;

    @FindBy(xpath = ".//*[@title='PT Logo']/..")
    WebElement siteLogo;

    @FindBy(xpath = ".//*[@class='myAccountLinksHeader  js-myAccount-toggle nav__link']")
    WebElement linkMyAccount;

    @FindBy(name = "manufacturer")
    WebElement dropDownSelectManufacturer;

    @FindBy(name = "model")
    WebElement dropDownSelectModel;

    @FindBy(name = "docType")
    WebElement dropDownDocumentType;

    @FindBy(xpath = ".//*[@href='#svg-search']")
    WebElement searchManualsIcon;

    @FindBy(xpath = ".//*[@data-type='live chat']")
    WebElement liveChatHeaderLink;

    @FindBy(xpath = ".//*[@href='/bulk-order']")
    WebElement bulkOrderLink;

    @FindBy(xpath = ".//*[contains(@class, 'nav-item--track-order')]//a")
    WebElement trackMyOrderLink;

    @FindBy(className = "lang-currencies-selected")
    WebElement languageSelector;

    @FindBy(xpath = ".//*[@class='lang-selector__item'][2]")
    WebElement frenchLanguageInputField;

    @FindBy(xpath = ".//*[@class='lang-selector__item'][1]")
    WebElement englishLanguageInputField;

    @FindBy(className = "lang-currencies-selected")
    WebElement currentSiteLanguage;

    @FindBy(id = "country")
    WebElement inputFieldCountry;

    @FindBy(xpath = ".//*[@attr-code='US']")
    WebElement countryUSFromList;

    @FindBy(xpath = ".//*[@class='mini-cart  js-mini-cart not-empty']")
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
        return actionsWithOurWebElements.isElementPresent(".//*[@data-type='live chat']");
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
        actionsWithOurWebElements.clickOnWebElement(".//*[@class='lang-currencies-btn js-select-country-btn']");
    }

    public void clickOnNotInCountryLink() {
        actionsWithOurWebElements.clickOnWebElement(".//*[@class='link change-country-link js-show-country-change']");
    }

    public void selectCountryFromList(String country) {
        actionsWithOurWebElements.enterTextIntoInput(inputFieldCountry, country);
        actionsWithOurWebElements.clickOnWebElement(".//*[@attr-code='US']");
    }

    public void clickStartShoppingButton() {
        actionsWithOurWebElements.clickOnWebElement("//button[@type='submit' and contains(., 'Start shopping')]");
    }

    public void clickOnBulkOrderLink() {
        actionsWithOurWebElements.clickOnWebElement(bulkOrderLink);
    }

    public void clickOnTrackMyOrderLink() {
        actionsWithOurWebElements.clickOnWebElement(trackMyOrderLink);
    }

    public void clickOnMyProfileLink() {
        actionsWithOurWebElements.clickOnWebElement(".//*[@id='accNavComponentDesktopOne']//a[@href='/my-account/update-profile']");
    }

    public void hoverOnMyAccountIcon() {
        actionsWithOurWebElements.hoverOnWebElement(linkMyAccount);
    }

    public void clickOnMyAddressBookLink() {
        actionsWithOurWebElements.clickOnWebElement(".//*[@id='accNavComponentDesktopOne']//a[@href='/my-account/address-book']");
    }

    public void hoverOnMiniCartIcon() {
        actionsWithOurWebElements.hoverOnWebElement(miniCartIconWithProducts);
    }

    public void hoverOnShopByManufacturerLink() {
        actionsWithOurWebElements.hoverOnWebElement(linkShopByManufacturer);
    }

    public boolean shopByManufacturerFlyOutIsActive() {
       return actionsWithOurWebElements.isElementPresent(".//*[@class='sub-navigation-section__header']/a");
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
        actionsWithOurWebElements.clickOnWebElement(".//a[@data-type='techtown']");
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
