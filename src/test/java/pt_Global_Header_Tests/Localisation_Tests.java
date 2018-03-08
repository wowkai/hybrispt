package pt_Global_Header_Tests;

import org.testng.annotations.Test;
import parentTest.ParentTest;

public class Localisation_Tests extends ParentTest {

    @Test
    // test that user can change language on site
    public void changeLanguageTest() {
        homePage.openHomePage();
        homePage.changeLanguage("FR");
        checkAcceptanceCriteria("Language wasn't changed", homePage.checkCurrentLanguage(), "FR");
        checkAcceptanceCriteria("Language wasn't changed", homePage.getUrl().contains("fr"), true);
    }

    @Test
    // test that user can change country on site and is redirected to .com site
    public void changeCountryTest() {
        homePage.openHomePage();
        homePage.clickOnCountryFlag();
        //homePage.clickOnNotInCountryLink();
        homePage.selectCountryFromList("US");
        homePage.clickStartShoppingButton();
        checkAcceptanceCriteria("Parts Town .com site isn't opened", homePage.getUrl().contains("partstown.com"), true);
    }


}
