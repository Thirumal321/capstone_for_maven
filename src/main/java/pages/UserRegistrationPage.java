package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserRegistrationPage {

    private WebDriverWait wait;

    // Locator for the "Account" click element.
    @FindBy(id = "ctl00_lblUser")
    private WebElement Accountclick;

    // Locator for the "Sign Up" link.
    @FindBy(css = ".themecolor.d-block.w-100.mb-3.font-weight-bold.signuplink")
    private WebElement signup;

    // Locator for the "User ID" input field.
    @FindBy(id = "ctl00_phBody_SignIn_txtEmail")
    private WebElement userid;

    // Locator for the "Password" input field.
    @FindBy(id = "ctl00_phBody_SignIn_txtPassword")
    private WebElement pass;

    // Locator for the "Login" button.
    @FindBy(id = "ctl00_phBody_SignIn_btnLogin")
    private WebElement LoginButton;

    // Locators for password change functionality.
    // Locator for the "Change Password" link.
    @FindBy(xpath = "//*[@id=\"site-wrapper\"]/div/div/div/div/div/div[6]/div/a")
    private WebElement changePasswordLink;

    // Locator for the "Old Password" input field.
    @FindBy(id = "ctl00_phBody_ChangePassword_txtCurPwd")
    private WebElement Oldpassword;

    // Locator for the "New Password" input field.
    @FindBy(id = "ctl00_phBody_ChangePassword_txtNewPassword")
    private WebElement newpassword;

    // Locator for the "Confirm New Password" input field.
    @FindBy(id = "ctl00_phBody_ChangePassword_txtConfirmPwd")
    private WebElement confirmnewpassword;

    // Locator for the "Submit" button for password change.
    @FindBy(id = "ctl00_phBody_ChangePassword_imgSubmit")
    private WebElement submitbutton;

    // Locator for the password change verification message.
    @FindBy(id = "ctl00_phBody_ChangePassword_lblmsg")
    private WebElement passwordchangeverify;

    // Constructor to initialize the UserRegistrationPage with WebDriver and WebDriverWait.
    public UserRegistrationPage(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
    }

    // Method to navigate to the registration page.
    public void registration() {
        wait.until(ExpectedConditions.elementToBeClickable(Accountclick)).click();
        wait.until(ExpectedConditions.elementToBeClickable(signup)).click();
    }

    // Method to perform user login.
    public void user_login(String username, String password) {
        wait.until(ExpectedConditions.elementToBeClickable(Accountclick)).click();
        wait.until(ExpectedConditions.elementToBeClickable(userid)).sendKeys(username);
        wait.until(ExpectedConditions.elementToBeClickable(pass)).sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(LoginButton)).click();
    }

    // Method to change the user's password.
    public void passwordchange(String oldpass, String newpass) {
        wait.until(ExpectedConditions.elementToBeClickable(changePasswordLink)).click();
        wait.until(ExpectedConditions.elementToBeClickable(Oldpassword)).sendKeys(oldpass);
        wait.until(ExpectedConditions.elementToBeClickable(newpassword)).sendKeys(newpass);
        wait.until(ExpectedConditions.elementToBeClickable(confirmnewpassword)).sendKeys(newpass);
        wait.until(ExpectedConditions.elementToBeClickable(submitbutton)).click();
    }

    // Method to verify if the password change was successful.
    public boolean passwordverify() {
        return wait.until(ExpectedConditions.elementToBeClickable(passwordchangeverify)).isDisplayed();
    }
}