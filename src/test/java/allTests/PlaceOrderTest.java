package allTests;

/**
 * This is a test for verification of placing new order as guest user
 * Before start test, test data for test should be set into testData.xls file
 */

import libs.ConfigData;
import org.testng.annotations.Test;
import parentTest.ParentTest;

import java.io.IOException;
import java.util.Map;

public class PlaceOrderTest extends ParentTest {

    final private String HOMEPAGE_TITLE = "Homepage";
    final private String MLP_TITLE = "Manufacture Landing Page";
    final private String MANUFACTURER_NAME = "General";
    final private String GUEST_CHECKOUT_LOGIN_PAGE = "Proceed to Checkout";
    final private String CHECKOUT_PAGE = "Checkout";
    final private String ORDER_CONFIRMATION_PAGE = "Order Confirmation";
    private String GUEST_EMAIL = "testemail@test.com";

    @Test
    public void placeOrderAsGuestTest() throws IOException {

        Map dataFromExcelForRegistration = excelDriver.getData(ConfigData.getCfgValue("DATA_FILE"), "validLogOn");

        // open Homepage and click on Shop By Manufactuter link
        homePage.openHomePage();
        homePage.checkTitle(HOMEPAGE_TITLE);
        homePage.clickOnShopByManufacturerLink();

        // click on manufacturer link on Manufacturer landing page
        manufacturerLandingPage.checkTitle(MLP_TITLE);
        manufacturerLandingPage.clickOnManufactureLink(MANUFACTURER_NAME);
        //checkAcceptanceCriteria("Manufacturer product listing page isn't opened", productListingPage.checkIfItIsManufacturerProductListingPage(), true);

        // add any product which is on Stock to shopping cart and go to checkout login page
        productListingPage.addProductInStockToCartFromTheList(0);
        checkAcceptanceCriteria("Add to cart popup isn't shown", productListingPage.checkIfAddToCartPopupAppears(), true);
        productListingPage.clickOnCheckoutButtonAddToCartPopup();
        guestCheckoutLoginPage.checkTitle(GUEST_CHECKOUT_LOGIN_PAGE);

        // enter email on guest checkout login page and go to checkout
        guestCheckoutLoginPage.enterGuestCheckoutEmail(GUEST_EMAIL);
        guestCheckoutLoginPage.clickOnCheckoutAsGuestButton();
        checkoutPage.checkTitle(CHECKOUT_PAGE);
        checkAcceptanceCriteria("Shipping information checkout step isn't active", checkoutPage.checkIfShippingInformationStepIsActive(), true);


        // on checkout page enter valid data on each step
        // Enter valid data into Shipping Information form from Excel file
        checkoutPage.enterFirstName(dataFromExcelForRegistration.get("FirstName").toString());
        checkoutPage.enterLastName(dataFromExcelForRegistration.get("LastName").toString());
        checkoutPage.enterCompanyName(dataFromExcelForRegistration.get("CompanyName").toString());
        checkoutPage.selectPrimaryBusiness(dataFromExcelForRegistration.get("PrimaryBusiness").toString());
        checkoutPage.enterAddressLine1(dataFromExcelForRegistration.get("AddressLine1").toString());
        checkoutPage.selectCountry(dataFromExcelForRegistration.get("Country").toString());
        checkoutPage.selectState(dataFromExcelForRegistration.get("State").toString());
        checkoutPage.enterCity(dataFromExcelForRegistration.get("City").toString());
        checkoutPage.enterPostCode(dataFromExcelForRegistration.get("ZipCode").toString());
        checkoutPage.enterPhone(dataFromExcelForRegistration.get("Phone").toString());
        checkoutPage.clickOnContinueToShippingMethodButton();
        checkAcceptanceCriteria("Shipping method checkout step isn't active", checkoutPage.checkIfShippingMethodStepIsActive(), true);

        // on Shipping Method step click on button 'ContinueToPaymentMethod'
        checkoutPage.clickOnContinueToPaymentMethodButton();
        checkAcceptanceCriteria("Payment & Billing information step isn't active", checkoutPage.checkIfPaymentInformationStepIsActive(), true);

        // on Payment & Billing information step enter payment information from Excel and check checkbox SameAsShippingAddress
        checkoutPage.enterCreditCartNumber(dataFromExcelForRegistration.get("CreditCartNumber").toString());
        checkoutPage.selectCreditCardExpirationDate(dataFromExcelForRegistration.get("CCExpiredMonth").toString(), dataFromExcelForRegistration.get("CCExpiredYear").toString());
        checkoutPage.enterCreditCardCCVNumber(dataFromExcelForRegistration.get("CreditCartCCV").toString());
        checkoutPage.setStateForSameAsShippingAddressCheckbox("Checked");
        checkoutPage.clickOnContinueToOrderReviewButton();
        checkAcceptanceCriteria("Order reivew step isn't active",  checkoutPage.checkIfOrderReviewStepIsActive(), true);

        // click Place order button
        checkoutPage.clickOnPlaceOrderButton();
        orderConfirmationPage.checkTitle(ORDER_CONFIRMATION_PAGE);
    }
}
