package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import uistore.SignInPageUi;
import utils.LoggerGeneretor;
import utils.ReporterMaker;
import utils.CaptureScreenshot;
import utils.DriverHelper;

public class SigninPage {
	ExtentTest test;
    WebDriver driver;
    DriverHelper helper;
    HomePage home;
public SigninPage(WebDriver driver){
    this.driver=driver;
    helper=new DriverHelper(driver); 
    home=new HomePage(driver);
}
		

/*----------------------------Wrapper Methods-----------------------------------*/
	/* Method Name:   SignInFacebook
	 * Author Name:   10820894
	 * Short Description:  Testing Sign in With FaceBook
	 * Return type: void
	 * Parameter List: test
	*/
	public void signInFacebook(ExtentTest test){
		
		/*------------------Calling hoveringOnSignInAndClickingOnIt From Home Page---------------*/
		home.hoveringOnSignInAndClickingOnIt(test);
		clickingOnSignInButton(test);
		verifyingEmailWarnText(test);
		VerifyingPasswordWarnText(test);
		clickingOnFaceBookIcon(test);
		verifyingFaceBookPage(test);
	     
	}
	
	/* Method Name:   SignInForgotPass
	 * Author Name:   10820894
	 * Short Description:  Trying to use Forgot Password feature
	 * Return type: void
	 * Parameter List: test
	*/
		public void signInForgotPass(ExtentTest test) {
			
			
			/*------------------Calling hoveringOnSignInAndClickingOnIt From Home Page---------------*/
				home.hoveringOnSignInAndClickingOnIt(test);
				clickingOnSignInButton(test);
				verifyingEmailWarnText(test);
				VerifyingPasswordWarnText(test);
				clickingOnForgotPassword(test);
				verifyingForgotPasswordPage(test);
		}
		
		
		
		
		
/*------------------------Methods---------------------------------------------------*/
		
		/*--------------------Clicking On Sign in Button---------------------------*/
		public void clickingOnSignInButton(ExtentTest test){
		     try{
		     helper.clickOnElement(SignInPageUi.SigninSubmit);
		     WebElement Text=driver.findElement(SignInPageUi.SigninSubmit);
		     String actualText=Text.getText();
		     String expectedText="Sign In";
		     helper.softAsserting(actualText, expectedText);
		     test.log(Status.PASS,"Clicked Sign in Button");
		     LoggerGeneretor.info("Clicked Sign in Button");
		     }catch(Exception e){
		    	     String Path=ReporterMaker.captureScreenShot("FailedSignin Button");
		 	 	     test.addScreenCaptureFromPath(Path, "FailedSignin Button");
		    	     CaptureScreenshot.captureScreenShot("FailedSignin Button");
		             LoggerGeneretor.error("Failed to Click Sign in Button...");
		             test.log(Status.FAIL,"Failed to Click Sign in Button...");
		     }
		
		}
		/*------------------Verifying Email warning Message---------------------------*/
		public void verifyingEmailWarnText(ExtentTest test){
		     try{
		     WebElement emailWarnMsg=driver.findElement(SignInPageUi.emailWarnText);
		     String actualWarningText=emailWarnMsg.getText();
		     String expectedWarningText="Please enter your Email Address or Member ID.";
		     Assert.assertEquals(actualWarningText, expectedWarningText);
		     test.log(Status.PASS,"Email Warning Present");
		     LoggerGeneretor.info("Email Warning Present");
		     }catch(Exception e){
		    	     String Path=ReporterMaker.captureScreenShot("FailedEmailWarning");
		 	 	     test.addScreenCaptureFromPath(Path, "FailedEmailWarning");
		             CaptureScreenshot.captureScreenShot("FailedEmailWarning");
		             LoggerGeneretor.error("Email Warning Not Present...");
		             test.log(Status.FAIL,"Email Warning Not Present...");
		      }
		}
		
		/*----------------------------Verifying Password Warn Text-----------------------*/
		public void VerifyingPasswordWarnText(ExtentTest test){
		     
		try{
		    WebElement passwordWarnMsg=driver.findElement(SignInPageUi.passwordWarnText);
		    String actualWarningText=passwordWarnMsg.getText();
		    String expectedWarningText="Please enter your Password.";
		    Assert.assertEquals(actualWarningText, expectedWarningText);
		    CaptureScreenshot.captureScreenShot("SuccessPass&EmailWarningText");
		    test.log(Status.PASS,"Password Warning Present");
		    LoggerGeneretor.info("Password Warning Present");
		    }catch(Exception e){
		    	String Path=ReporterMaker.captureScreenShot("FailedPasswordWarning");
			 	test.addScreenCaptureFromPath(Path, "FailedPasswordWarning");
		            CaptureScreenshot.captureScreenShot("FailedPasswordWarning");
		            LoggerGeneretor.error("Password Warning Not Present...");
		            test.log(Status.FAIL,"Password Warning Not Present...");
		     }
		}
		/*----------------------------Clicking On FaceBook icon-----------------------*/
		public void clickingOnFaceBookIcon(ExtentTest test){
		try{
		    helper.clickOnElement(SignInPageUi.facebookIcon);
		    helper.switchToNewWindow();
		    test.log(Status.PASS,"Clicked FaceBook icon");
		    LoggerGeneretor.info("Clicked FaceBook icon");
		    }catch(Exception e){
		    		String Path=ReporterMaker.captureScreenShot("FailedFacebookIcon");
		    		test.addScreenCaptureFromPath(Path, "FailedFacebookIcon");
		    	    CaptureScreenshot.captureScreenShot("FailedFacebookIcon");
		            LoggerGeneretor.error("Failed to Click FaceBook icon...");
		            test.log(Status.FAIL,"Failed to Click FaceBook icon...");
		    }
		}
		/*----------------------------Verifying FaceBook Page-----------------------*/
		public void verifyingFaceBookPage(ExtentTest test){
		
		try{
		    String actualUrl=driver.getCurrentUrl();
		    String expectedUrl="https://www.facebook.com/login";
		    Assert.assertTrue(actualUrl.contains(expectedUrl));
		    test.log(Status.PASS,"FaceBook Log in Page Verified");
		    LoggerGeneretor.info("FaceBook Log in Page Verified");
		    CaptureScreenshot.captureScreenShot("SuccessFacebookLoginPage");
		    String Path=ReporterMaker.captureScreenShot("SuccessFacebookLoginPage");
			test.addScreenCaptureFromPath(Path, "SuccessFacebookLoginPage");
		    }catch(Exception e){
		    		String Path=ReporterMaker.captureScreenShot("FailedFaceBookLogin");
		    		test.addScreenCaptureFromPath(Path, "FailedFaceBookLogin");
		            CaptureScreenshot.captureScreenShot("FailedFaceBookLogin");
		            LoggerGeneretor.error("FaceBook Log in Page Not Found...");
		            test.log(Status.FAIL,"FaceBook Log in Page Not Found...");
		     }
	
	    }
		/*----------------------------Clicking On ForgotPassword-----------------------*/		
		public void clickingOnForgotPassword(ExtentTest test) {
		try {
		helper.clickOnElement(SignInPageUi.forgotPassword);
		WebElement forgotPasswordPage=driver.findElement(SignInPageUi.forgotPasswordVerification);
	    String actualWarningText=forgotPasswordPage.getText();
	    String expectedWarningText="Reset Your Password";
	    helper.softAsserting(actualWarningText, expectedWarningText);
		test.log(Status.PASS,"Clicked Forgot Password");
	    LoggerGeneretor.info("Clicked Forgot Password");
		
		}catch(Exception e) {
		String Path=ReporterMaker.captureScreenShot("FailedForgotPassword");
	 	test.addScreenCaptureFromPath(Path, "FailedForgotPassword");
		CaptureScreenshot.captureScreenShot("FailedForgotPassword");
        LoggerGeneretor.error("Failed to Click Forgot Password...");
        test.log(Status.FAIL,"Failed to Click Forgot Password...");
		}
	}
		
		/*----------------------------Verifying Forgot Password Page-----------------------*/
		public void verifyingForgotPasswordPage(ExtentTest test) {
		try{
	    WebElement forgotPasswordPage=driver.findElement(SignInPageUi.forgotPasswordVerification);
	    String actualWarningText=forgotPasswordPage.getText();
	    String expectedWarningText="Reset Your Password";
	    Assert.assertEquals(actualWarningText, expectedWarningText);
	    test.log(Status.PASS,"Forgot Password Page Verified");
	    LoggerGeneretor.info("Forgot Password Page Verified");
	    CaptureScreenshot.captureScreenShot("SuccessForgotPasswordPage");
	    String Path=ReporterMaker.captureScreenShot("SuccessForgotPasswordPage");
		test.addScreenCaptureFromPath(Path, "SuccessForgotPasswordPage");
	    }catch(Exception e){
	    		String Path=ReporterMaker.captureScreenShot("FailedForgotPasswordPage");
	    		test.addScreenCaptureFromPath(Path, "FailedForgotPasswordPage");
	            CaptureScreenshot.captureScreenShot("FailedForgotPasswordPage");
	            LoggerGeneretor.error("Forgot Password Page Not Found...");
	            test.log(Status.FAIL,"Forgot Password Page Not Found...");
	     }
	}
}
