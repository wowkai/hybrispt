package parentTest;

import libs.ExcelDriver;
import libs.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;
import pages.cart_checkoutPages.*;
import pages.listingPages.ManufacturerLandingPage;
import pages.listingPages.ModelDetailsPage;
import pages.listingPages.ProductListingPage;
import pages.listingPages.SearchPage;
import pages.myAccountPages.MyPartsPage;
import pages.myAccountPages.MyProfilePage;

import java.io.File;
import java.util.concurrent.TimeUnit;


public class ParentTest {
    WebDriver driver;
    protected RegistrationPage registrationPage;
    public static HomePage homePage;
    protected SearchPage searchPage;
    protected ProductDetailsPage productDetailsPage;
    protected ShoppingCartPage shoppingCartPage;
    protected ManufacturerLandingPage manufacturerLandingPage;
    protected ProductListingPage productListingPage;
    protected GuestCheckoutLoginPage guestCheckoutLoginPage;
    protected CheckoutPage checkoutPage;
    protected static LoginPage loginPage;
    protected ModelDetailsPage modelDetailsPage;
    protected MyPartsPage myPartsPage;
    protected OrderConfirmationPage orderConfirmationPage;
    protected BulkOrderPage bulkOrderPage;
    protected TrackMyOrderPage trackMyOrderPage;
    protected OrderDetailsStatusPage orderDetailsStatusPage;
    protected MyProfilePage myProfilePage;

    private Utils utils = new Utils();
    private static boolean isTestPass = false;
    private String pathToScreenShot;
    public ExcelDriver excelDriver;

    //@Rule
    //public TestName testName = new TestName();

    @BeforeMethod
    public void setUp() throws Exception {
        //pathToScreenShot = "..\\VovkA_project\\target\\screenshot\\" + this.getClass().getPackage().getName() + "\\" + this.getClass().getName() + "\\" + this.testName.getMethodName() + ".jpg";
        File fileFF = new File("./drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", fileFF.getAbsolutePath());
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        registrationPage = new RegistrationPage(driver);
        homePage = new HomePage(driver);
        searchPage = new SearchPage(driver);
        productDetailsPage = new ProductDetailsPage(driver);
        shoppingCartPage = new ShoppingCartPage(driver);
        manufacturerLandingPage = new ManufacturerLandingPage(driver);
        productListingPage = new ProductListingPage(driver);
        guestCheckoutLoginPage = new GuestCheckoutLoginPage(driver);
        checkoutPage = new CheckoutPage(driver);
        loginPage = new LoginPage(driver);
        modelDetailsPage = new ModelDetailsPage(driver);
        myPartsPage = new MyPartsPage(driver);
        orderConfirmationPage = new OrderConfirmationPage(driver);
        bulkOrderPage = new BulkOrderPage(driver);
        trackMyOrderPage = new TrackMyOrderPage(driver);
        orderDetailsStatusPage = new OrderDetailsStatusPage(driver);
        myProfilePage = new MyProfilePage(driver);

        excelDriver = new ExcelDriver();
    }

    @AfterMethod
    public void tearDown() {
      driver.quit();
    }

    protected static void checkAcceptanceCriteria(String message, boolean actual, boolean expected) {
        Assert.assertTrue(actual == expected, message);
        isTestPass = true;
    }

    protected void checkAcceptanceCriteria(String message, String actual, String expected) {
        //Assert.assertTrue(result, message);
        isTestPass = true;
        Assert.assertEquals(actual, expected, message);

    }
}

//         //Assert.assertTrue(homePage.getTitle().equals("Test"), "Test failed");
//        Assert.assertEquals(homePage.getTitle(),"Test", "Test failed");