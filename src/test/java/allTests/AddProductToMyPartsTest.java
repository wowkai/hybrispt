package allTests;

/**
 * This is a test for verification add to MyParts feature
 */

import org.testng.annotations.Test;
import parentTest.ParentTest;

public class AddProductToMyPartsTest extends ParentTest {

    final private String HOMEPAGE_TITLE = "Homepage";
    final private String EMAIL = "orderhistory";
    final private String PASSWORD = "111";
    final private String MODEL_KEYWORD = "GSM-100";
    private String ADDED_PRODUCT;

    @Test
    public void addProductToMyParts() {

        // open Homepage and click on Login link
        homePage.openHomePage();
        homePage.checkTitle(HOMEPAGE_TITLE);
        homePage.clickOnLoginLink();

        // on Login page enter valid email_id and password
        loginPage.validLogin(EMAIL,PASSWORD);
        checkAcceptanceCriteria("User isn't login to the system", homePage.checkIfUserIsLogIn(), true);

        // perform search by model keyword
        homePage.searchBySearchKeyword(MODEL_KEYWORD);
        checkAcceptanceCriteria("Model details page isn't shown", modelDetailsPage.checkIfItIsModelPage(), true);

        // add product to MyParts and save ID of added product to variable
        ADDED_PRODUCT = modelDetailsPage.addProductToMyParts();

        // go to MyParts page via MyAccount fly-out menu
        modelDetailsPage.activateMyAccountMenu();
        modelDetailsPage.clickOnMyPartsLink();

        // verify if added product is present on MyParts page
        checkAcceptanceCriteria("Cannot find added product on MyParts page. ", myAccountPages.searchAddedProduct(ADDED_PRODUCT) , true);
    }
}
