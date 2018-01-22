package pt_MyAccount_Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import parentTest.ParentTest;

public class testAssertion extends ParentTest {

    @Test
    public void testAssertTestNG() {
        homePage.openHomePage();
        //checkAcceptanceCriteria("Homepage wasn't opened", homePage.getTitle().toString(),"Homep");
        //checkAcceptanceCriteria("Homepage wasn't opened", homePage.getTitle().contains("Homepages"), true);
    }


}
