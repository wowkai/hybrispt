package pt_Global_Header_Tests;

import org.testng.annotations.Test;
import parentTest.ParentTest;

public class LiveChat_Tests extends ParentTest {

    @Test
    // check if LiveChat is opened on Homepage
    public void liveChatHomepageTest() {
        homePage.openHomePage();
        homePage.clickOnLiveChatLink();
        checkAcceptanceCriteria("Live chat window isn't opened", homePage.liveChatWindowIsShown(), true);

    }
}
