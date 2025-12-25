package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import uistore.HelpMenuPageUi;
import uistore.HomePageUi;
import utils.CaptureScreenshot;
import utils.DriverHelper;
import utils.LoggerGeneretor;
import utils.ReporterMaker;

public class HelpMenuPage {
	ExtentTest test;
    WebDriver driver;
    DriverHelper helper;
    HomePage home;
public HelpMenuPage(WebDriver driver){
    this.driver=driver;
    helper=new DriverHelper(driver); 
    home=new HomePage(driver);
}

/*------------------------------Wrapper Methods---------------------------*/


	/* Method Name:   validatingSupplierEmail
	 * Author Name:   10820894
	 * Short Description:  Validating Supplier Email Page
	 * Return type: void
	 * Parameter List: test
	*/
	
	public void validatingSupplierEmail(ExtentTest test) {
		home.hoveringOnHelpMenu(test);
		clickingOnSubmitAComplaint(test);
		clickingOnLearnMoreTips(test);
		clickingSupplierEmailLink(test);
		verifyingSupplierEmailPage(test);
	}
	
	
	/* Method Name:   validatingWebSiteHistory
	 * Author Name:   10820894
	 * Short Description:  Validating Made in China History Page
	 * Return type: void
	 * Parameter List: test
	*/
	
	public void validatingWebSiteHistory(ExtentTest test) {
		home.hoveringOnHelpMenu(test);
		clickingOnWhyMadeInChina(test);
		scrollingToContactUsPage(test);
		verifyingContactUsPage(test);
	}
	
	
	
/*-----------------------------------Methods--------------------------------------*/
	
		/*---------------------Clicking On Submit A Complaint----------------*/
		public void clickingOnSubmitAComplaint(ExtentTest test) {
			try{
			     helper.clickOnElement(HomePageUi.submitAComplaint);
			     WebElement Text=driver.findElement(HelpMenuPageUi.supplierEmailValidate);
			     String actualText=Text.getText();
			     String expectedText="Submit a Complaint";
			     helper.softAsserting(actualText, expectedText);
			     LoggerGeneretor.info("Clicked on Submit A Complaint");
			     test.log(Status.PASS,"Clicked on Submit A Complaint");
			     }catch(Exception e){
			    	 	String Path=ReporterMaker.captureScreenShot("FailedClickingSubmitAComplaint");
			    	 	test.addScreenCaptureFromPath(Path, "FailedClickingSubmitAComplaint");
			    	 	 CaptureScreenshot.captureScreenShot("FailedClickingSubmitAComplaint");
			             LoggerGeneretor.error("Failed to Click on Submit A Complaint...");
			             test.log(Status.FAIL,"Failed to Click on Submit A Complaint...");
			     }
		}
		
		/*---------------------Clicking On Learn More Tips Link----------------*/
		public void clickingOnLearnMoreTips(ExtentTest test) {
			try{
			     helper.clickOnElement(HelpMenuPageUi.learnMoreTips);
			     helper.switchToNewWindow();
			     WebElement Text=driver.findElement(HelpMenuPageUi.supplierEmailValidate);
			     String actualText=Text.getText();
			     String expectedText="How to Avoid Fraud";
			     helper.softAsserting(actualText, expectedText);
			     LoggerGeneretor.info("Clicked On Learn More Tips Link");
			     test.log(Status.PASS,"Clicked On Learn More Tips Link");
			     }catch(Exception e){
			    	 	String Path=ReporterMaker.captureScreenShot("FailedClickingLearnMoreTips");
			    	 	test.addScreenCaptureFromPath(Path, "FailedClickingLearnMoreTips");
			    	 	 CaptureScreenshot.captureScreenShot("FailedClickingLearnMoreTips");
			             LoggerGeneretor.error("Failed to Click On Learn More Tips Link...");
			             test.log(Status.FAIL,"Failed to Click On Learn More Tips Link...");
			     }	
		}
		/*---------------------Clicking On Check Supplier Email Link----------------*/
		public void clickingSupplierEmailLink(ExtentTest test) {
			try{
			     helper.clickOnElement(HelpMenuPageUi.supplierEmail);
			     LoggerGeneretor.info("Clicked On Check Supplier Email Link");
			     test.log(Status.PASS,"Clicked On Check Supplier Email Link");
			     }catch(Exception e){
			    	 	String Path=ReporterMaker.captureScreenShot("FailedSupplierEmailLink");
			    	 	test.addScreenCaptureFromPath(Path, "FailedSupplierEmailLink");
			    	 	 CaptureScreenshot.captureScreenShot("FailedSupplierEmailLink");
			             LoggerGeneretor.error("Failed to Click On Check Supplier Email Link...");
			             test.log(Status.FAIL,"Failed to Click On Check Supplier Email Link...");
			     }
		}
		
		/*---------------------Verify Supplier Email Result Page----------------*/
		public void verifyingSupplierEmailPage(ExtentTest test) {
			try{
			     WebElement Text=driver.findElement(HelpMenuPageUi.supplierEmailValidate);
			     String actualText=Text.getText();
			     String expectedText="Check Supplier's Email Address";
			     helper.softAsserting(actualText, expectedText);
			     LoggerGeneretor.info("Supplier Email Result Page Found");
			     test.log(Status.PASS,"Supplier Email Result Page Found");
			     String Path=ReporterMaker.captureScreenShot("SuccessSupplierEmailPage");
		    	 	test.addScreenCaptureFromPath(Path, "SuccessSupplierEmailPage");
		    	 	 CaptureScreenshot.captureScreenShot("SuccessSupplierEmailPage");
			     }catch(Exception e){
			    	 	String Path=ReporterMaker.captureScreenShot("FailedSupplierEmailPage");
			    	 	test.addScreenCaptureFromPath(Path, "FailedSupplierEmailPage");
			    	 	 CaptureScreenshot.captureScreenShot("FailedSupplierEmailPage");
			             LoggerGeneretor.error("Supplier Email Result Page Not Found...");
			             test.log(Status.FAIL,"Supplier Email Result Page Not Found...");
			     }
		}
		
		
		/*---------------------Clicking On Submit A Complaint----------------*/
		public void clickingOnWhyMadeInChina(ExtentTest test) {
			try{
			     helper.clickOnElement(HomePageUi.whyMadeInChina);
			     WebElement Text=driver.findElement(HelpMenuPageUi.whyMadeInChinaValidate);
			     String actualText=Text.getText();
			     String expectedText="About Us";
			     Assert.assertTrue(actualText.contains(expectedText));
			     LoggerGeneretor.info("Clicked on Why Made in China");
			     test.log(Status.PASS,"Clicked on Why Made in China");
			     }catch(Exception e){
			    	 	String Path=ReporterMaker.captureScreenShot("FailedClickingWhyMadeInChina");
			    	 	test.addScreenCaptureFromPath(Path, "FailedClickingWhyMadeInChina");
			    	 	 CaptureScreenshot.captureScreenShot("FailedClickingWhyMadeInChina");
			             LoggerGeneretor.error("Failed to Click on Why Made in China...");
			             test.log(Status.FAIL,"Failed to Click on Why Made in China...");
			     }
		}
		/*---------------------Scrolling To Contact Us Page----------------*/
		public void scrollingToContactUsPage(ExtentTest test) {
			try{
			     helper.javascriptScroll(HelpMenuPageUi.scrollDownToContactUs);
			     LoggerGeneretor.info("Scroll Down to Contact Us Page");
			     test.log(Status.PASS,"Scroll Down to Contact Us Page");
			     }catch(Exception e){
			    	 	String Path=ReporterMaker.captureScreenShot("FailedScrollingToContactUs");
			    	 	test.addScreenCaptureFromPath(Path, "FailedScrollingToContactUs");
			    	 	 CaptureScreenshot.captureScreenShot("FailedScrollingToContactUs");
			             LoggerGeneretor.error("Failed to Scroll Down to Contact Us Page...");
			             test.log(Status.FAIL,"Failed to Scroll Down to Contact Us Page...");
			     }
		}
		
		/*---------------------Verifying Contact Us Page----------------*/
		public void verifyingContactUsPage(ExtentTest test) {
			try{
			     WebElement Text=driver.findElement(HelpMenuPageUi.ContactUsValidate);
			     String actualText=Text.getText();
			     String expectedText="Contact Us";
			     Assert.assertTrue(actualText.contains(expectedText));
			     LoggerGeneretor.info("Contact US Section Found");
			     test.log(Status.PASS,"Contact US Section Found");
			     String Path=ReporterMaker.captureScreenShot("SuccessContactUsSection");
		    	 	test.addScreenCaptureFromPath(Path, "SuccessContactUsSection");
		    	 	 CaptureScreenshot.captureScreenShot("SuccessContactUsSection");
			     }catch(Exception e){
			    	 	String Path=ReporterMaker.captureScreenShot("FailedContactUsSection");
			    	 	test.addScreenCaptureFromPath(Path, "FailedContactUsSection");
			    	 	 CaptureScreenshot.captureScreenShot("FailedContactUsSection");
			             LoggerGeneretor.error("Failed to Contact US Section Found...");
			             test.log(Status.FAIL,"Failed to Contact US Section Found...");
			     }
		}
	
}
