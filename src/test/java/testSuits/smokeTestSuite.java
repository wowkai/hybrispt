package testSuits;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import pt_Global_Header_Tests.BulkOrderHeader_Tests;
import pt_Global_Header_Tests.Find_Equipment_Manuals_Search_Tests;
import pt_Global_Header_Tests.Global_Search_Tests;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        BulkOrderHeader_Tests.class,
        Find_Equipment_Manuals_Search_Tests.class,
        Global_Search_Tests.class,

       //AddProductsToCartTest.class,
        //AddProductToMyPartsTest.class,
        //PlaceOrderTest.class
})


public class smokeTestSuite {
}
