package testSuits;

/**
 * This is test suit with all tests which are needed for smoke test
 */

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import pt_Global_Header_Tests.Global_Search_Tests;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        //RegistrationTest.class,
        Global_Search_Tests.class,
       //AddProductsToCartTest.class,
        //AddProductToMyPartsTest.class,
        //PlaceOrderTest.class
})


public class smokeTestSuite {
}
