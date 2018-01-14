package pages;

/**
 * Login page is the page where user could login to the system with existing credentials
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPage {

    @FindBy(id = "j_username")
    WebElement inputEmail;

    @FindBy(id = "j_password")
    WebElement inputPassword;

    @FindBy(xpath = ".//button[contains(text(), 'Login')]")
    WebElement buttonLogin;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }


    public void validLogin(String email, String password) {
        actionsWithOurWebElements.enterTextIntoInput(inputEmail, email);
        actionsWithOurWebElements.enterTextIntoInput(inputPassword, password);
        actionsWithOurWebElements.clickOnWebElement(buttonLogin);
    }

}
