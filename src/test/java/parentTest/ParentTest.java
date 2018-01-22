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

import java.io.File;
import java.util.concurrent.TimeUnit;


public class ParentTest {
    WebDriver driver;
    public RegistrationPage registrationPage;
    public HomePage homePage;
    public SearchPage searchPage;
    public ProductDetailsPage productDetailsPage;
    public ShoppingCartPage shoppingCartPage;
    public ManufacturerLandingPage manufacturerLandingPage;
    public ProductListingPage productListingPage;
    public GuestCheckoutLoginPage guestCheckoutLoginPage;
    public CheckoutPage checkoutPage;
    public LoginPage loginPage;
    public ModelDetailsPage modelDetailsPage;
    public MyAccountPages myAccountPages;
    public OrderConfirmationPage orderConfirmationPage;
    public BulkOrderPage bulkOrderPage;
    public TrackMyOrderPage trackMyOrderPage;
    public OrderDetailsStatusPage orderDetailsStatusPage;
    public MyProfilePage myProfilePage;

    private Utils utils = new Utils();
    private boolean isTestPass = false;
    private String pathToScreenShot;
    public ExcelDriver excelDriver;

    //@Rule
    //public TestName testName = new TestName();

    @BeforeMethod
    public void setUp() {
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
        myAccountPages = new MyAccountPages(driver);
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

    protected void checkAcceptanceCriteria(String message, boolean actual, boolean expected) {
        if (actual != expected) {
            utils.screenShot(pathToScreenShot, driver);
        }
        Assert.assertTrue(actual == expected, message);
        isTestPass = true;
    }

    protected void checkAcceptanceCriteria(String message, String actual, String expected) {
        if (!actual.equals(expected)) {
            utils.screenShot(pathToScreenShot, driver);
        }
        Assert.assertEquals(actual, expected, message);;
        isTestPass = true;
    }
}
