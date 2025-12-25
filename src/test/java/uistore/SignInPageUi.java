package uistore;

import org.openqa.selenium.By;

public class SignInPageUi {
	public static By SigninSubmit=By.id("sign-in-submit");
	public static By forgotPassword=By.id("forgot_pwd_link");
	public static By emailWarnText=By.xpath("(//label[@class='error'])[1]");
	public static By passwordWarnText=By.xpath("(//label[@class='error'])[2]");
	public static By facebookIcon=By.xpath("//a[@title='Facebook']");
	public static By forgotPasswordVerification=By.xpath("//div[@class='hd']");
}
