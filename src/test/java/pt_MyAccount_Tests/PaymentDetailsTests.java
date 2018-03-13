package pt_MyAccount_Tests;

import org.testng.annotations.Test;
import parentTest.ParentTest;

public class PaymentDetailsTests extends ParentTest {

    @Test
    public void AddNewCreditCard () throws Exception {
        LoginToTheSystem.validLogin();
        homePage.openHomePage();
        homePage.hoverOnMyAccountIcon();
        homePage.clickOnPaymentDetailsLink();



    }
}
