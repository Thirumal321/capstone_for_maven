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
	@FindBy(id="ctl00_lblUser") private WebElement Accountclick;
	@FindBy(css=".themecolor.d-block.w-100.mb-3.font-weight-bold.signuplink") private WebElement signup;
	@FindBy(id="ctl00_phBody_SignIn_txtEmail") private WebElement userid;
	@FindBy(id="ctl00_phBody_SignIn_txtPassword")private WebElement pass;
	@FindBy(id="ctl00_phBody_SignIn_btnLogin")private WebElement LoginButton;

	//passwordchaange_locators
	@FindBy(xpath="//*[@id=\"site-wrapper\"]/div/div/div/div/div/div[6]/div/a") private WebElement changePasswordLink; 

	@FindBy(id="ctl00_phBody_ChangePassword_txtCurPwd") private WebElement Oldpassword;
	@FindBy(id="ctl00_phBody_ChangePassword_txtNewPassword") private WebElement newpassword;
	@FindBy(id="ctl00_phBody_ChangePassword_txtConfirmPwd") private WebElement confirmnewpassword;
	@FindBy(id="ctl00_phBody_ChangePassword_imgSubmit") private WebElement submitbutton;
	@FindBy(id="ctl00_phBody_ChangePassword_lblmsg") private WebElement passwordchangeverify;




	public UserRegistrationPage(WebDriver driver) {
		this.wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		PageFactory.initElements(driver, this);
	}
	public void registration() {
		wait.until(ExpectedConditions.elementToBeClickable(Accountclick)).click();
		wait.until(ExpectedConditions.elementToBeClickable(signup)).click();

	}
	public void user_login(String username,String password) {
		wait.until(ExpectedConditions.elementToBeClickable(Accountclick)).click();
		wait.until(ExpectedConditions.elementToBeClickable(userid)).sendKeys(username);
		wait.until(ExpectedConditions.elementToBeClickable(pass)).sendKeys(password);
		wait.until(ExpectedConditions.elementToBeClickable(LoginButton)).click();

	}
	public void passwordchange(String oldpass,String newpass) {
		wait.until(ExpectedConditions.elementToBeClickable(changePasswordLink)).click();
		wait.until(ExpectedConditions.elementToBeClickable(Oldpassword)).sendKeys(oldpass);
		wait.until(ExpectedConditions.elementToBeClickable(newpassword)).sendKeys(newpass);
		wait.until(ExpectedConditions.elementToBeClickable(confirmnewpassword)).sendKeys(newpass);
		wait.until(ExpectedConditions.elementToBeClickable(submitbutton)).click();

	}
	public boolean passwordverify() {

		return wait.until(ExpectedConditions.elementToBeClickable(passwordchangeverify)).isDisplayed();


	}

}