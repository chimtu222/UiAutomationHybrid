package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import uistore.HomePageUi;
import uistore.BuyerServicesPageUi;
import utils.LoggerGeneretor;
import utils.ReporterMaker;
import utils.CaptureScreenshot;
import utils.DriverHelper;

public class BuyerServicesPage {
	ExtentTest test;
    WebDriver driver;
    DriverHelper helper;
    HomePage home;
public BuyerServicesPage(WebDriver driver){
    this.driver=driver;
    helper=new DriverHelper(driver);
    home=new HomePage(driver);
}

/*---------------------------Wrapper Methods------------------------------------*/
	/* Method Name: userManualFornewUser
	 * Author Name: 10820894
	 * Short Description:  Validating User Manual guide for new user
	 * Return type: void
	 * Parameter List: test
	*/

	public void userManualFornewUser(ExtentTest test) {
		String expectedURL=driver.getCurrentUrl();
		home.hoveringOnBuyer(test);
		clickingOnNewUserGuide(test);
		clickingOnStartNow(test);
		verifyingUrl(test,expectedURL);
	}
	
	/* Method Name:   moreInformation
	 * Author Name:   10820894
	 * Short Description:  Validating There is MOre info about Buyer or not
	 * Return type: void
	 * Parameter List: test
	*/
	public void moreInformation(ExtentTest test) {
			
		/*------------------Calling hoveringOnBuyer From Home Page---------------*/
			home.hoveringOnBuyer(test);
			clickingOnNewUserGuide(test);
			clickingOnLearnMore(test);
			verifyingPageHeaderOfLearnMorePage(test);
	}
	
	/* Method Name:   validatingContactUs
	 * Author Name:   10820894
	 * Short Description:  Validating Contact Us FAQ
	 * Return type: void
	 * Parameter List: test
	*/
	public void validatingContactUs(ExtentTest test) {
		home.clickingOnLogo(test);
		/*------------------Calling hoveringOnBuyer From Home Page---------------*/
		home.hoveringOnBuyer(test);
		clickingOnContactUs(test);
		clickingOnFrequentlyAskedQuestion(test);
		verifyingPageHeaderOfFaq(test);
	}
	
	/* Method Name:   validatingBrowsingHistory
	 * Author Name:   10820894
	 * Short Description:  Validating Browsing History of the User
	 * Return type: void
	 * Parameter List: test
	*/
	public void validatingBrowsingHistory(ExtentTest test) {
		
		/*------------------Calling hoveringOnBuyer From Home Page---------------*/
			home.hoveringOnBuyer(test);
			clickingOnBrowsingHistory(test);
			clickingOnCategoriesKeyword(test);
			clickingOnAuditedSuppliers(test);
			clickingOnProductHistoryButton(test);
			verifyingHistoryPage(test);
	}
	/* Method Name:   validatingMeetSupplierPage
	 * Author Name:   10820894
	 * Short Description:  Validating Meet Supplier Page
	 * Return type: void
	 * Parameter List: test
	*/
	public void validatingMeetSupplierPage(ExtentTest test) {
		
		/*------------------Calling hoveringOnBuyer From Home Page---------------*/
			home.hoveringOnBuyer(test);
			clickingOnMeetSupplierLink(test);
			clickingOnApplyToMeetSupplierBtn(test);
			verifyingApplyToMeetSupplierPage(test);
	}
	/* Method Name:   validatingMeetSupplierPage
	 * Author Name:   10820894
	 * Short Description:  Validating Meet Supplier Page
	 * Return type: void
	 * Parameter List: test
	*/
	public void validatingAuditedSupplierPage(ExtentTest test) {
		
		/*------------------Calling hoveringOnBuyer From Home Page---------------*/
			home.hoveringOnBuyer(test);
			home.clickingOnAuditedSupplier(test);
			scrollingToAuditedSupplierPageFooter(test);
			clickingBackToTopButton(test);
			verifyingAuditedSupplierPage(test);
	}
	
	
	
	
	
/*------------------------------------Methods-----------------------------------------*/
	
		/*-------------------Scrolling To Footer----------------------------*/
		public void scrollingToAuditedSupplierPageFooter(ExtentTest test) {
		 try{
		     helper.javascriptScroll(BuyerServicesPageUi.auditedSuppliersReportsFooter);
		     WebElement Text=driver.findElement(BuyerServicesPageUi.verifyFooter);
		     String actualText=Text.getText();
		     String expectedText="Contact Us:";
		     helper.softAsserting(actualText, expectedText);
		     LoggerGeneretor.info("Footer Verified");
		     test.log(Status.PASS,"Footer Verified");
		     }catch(Exception e){
		    	 	 String Path=ReporterMaker.captureScreenShot("FailedToScrollToFooter");
		    	 	 test.addScreenCaptureFromPath(Path, "FailedToScrollToFooter");
		             CaptureScreenshot.captureScreenShot("FailedToScrollToFooter");
		             LoggerGeneretor.error("Failed to Scroll to Footer...");
		             test.log(Status.FAIL,"Failed to Scroll to Footer...");
		     }
		}
		/*-------------------Back to top----------------------------*/
		public void clickingBackToTopButton(ExtentTest test) {
		 try{
		     helper.clickOnElement(BuyerServicesPageUi.backToTop);
		     WebElement Text=driver.findElement(BuyerServicesPageUi.verifyAuditedSupplierPage);
		     String actualText=Text.getText();
		     String expectedText="Audited Suppliers";
		     helper.softAsserting(actualText, expectedText);
		     LoggerGeneretor.info("Clicked back To top");
		     test.log(Status.PASS,"Clicked back To top");
		     }catch(Exception e){
		    	 	 String Path=ReporterMaker.captureScreenShot("FailedClickBackToTop");
		    	 	 test.addScreenCaptureFromPath(Path, "FailedClickBackToTop");
		    	 	 CaptureScreenshot.captureScreenShot("FailedClickBackToTop");
		             LoggerGeneretor.error("Failed to click back to Top...");
		             test.log(Status.FAIL,"Failed to click back to Top...");
		     }
		}
		/*-------------------Back to top----------------------------*/
		public void verifyingAuditedSupplierPage(ExtentTest test) {
		 try{
		     WebElement Text=driver.findElement(BuyerServicesPageUi.verifyAuditedSupplierPage);
		     String actualText=Text.getText();
		     String expectedText="Audited Suppliers";
		     helper.softAsserting(actualText, expectedText);
		     LoggerGeneretor.info("Audited Suppliers' Reports Page Found");
		     test.log(Status.PASS,"Audited Suppliers' Reports Page Found");
		     String Path=ReporterMaker.captureScreenShot("SuccessAuditedSupplierPage");
    	 	 test.addScreenCaptureFromPath(Path, "SuccessAuditedSupplierPage");
    	 	 CaptureScreenshot.captureScreenShot("SuccessAuditedSupplierPage");
		     }catch(Exception e){
		    	 	 String Path=ReporterMaker.captureScreenShot("FailedAuditedSupplierPage");
		    	 	 test.addScreenCaptureFromPath(Path, "FailedAuditedSupplierPage");
		    	 	 CaptureScreenshot.captureScreenShot("FailedAuditedSupplierPage");
		             LoggerGeneretor.error("Failed to Load Audited Suppliers' Reports...");
		             test.log(Status.FAIL,"Failed to Load Audited Suppliers' Reports...");
		     }
		}
	
		/*-------------------Clicking On Meet Supplier Link----------------------------*/
		public void clickingOnMeetSupplierLink(ExtentTest test) {
			 try{
			     helper.clickOnElement(HomePageUi.meetSupplierLink);
			     helper.switchToNewWindow();
			     WebElement Text=driver.findElement(BuyerServicesPageUi.meetSupplierLinkValid);
			     String actualText=Text.getText();
			     String expectedText="Buyer Service";
			     helper.softAsserting(actualText, expectedText);
			     LoggerGeneretor.info("Clicked On Meet Supplier Link");
			     test.log(Status.PASS,"Clicked On Meet Supplier Link");
			     }catch(Exception e){
			    	 	String Path=ReporterMaker.captureScreenShot("FailedMeetSupplierLink");
			    	 	test.addScreenCaptureFromPath(Path, "FailedMeetSupplierLink");
			             CaptureScreenshot.captureScreenShot("FailedMeetSupplierLink");
			             LoggerGeneretor.error("Failed to  click on Meet Supplier Link...");
			             test.log(Status.FAIL,"Failed to click On Meet Supplier Link...");
			     }
		}
		
		
		/*-----------------Clicking On Apply to Meet Supplier Button----------------*/
		public void clickingOnApplyToMeetSupplierBtn(ExtentTest test) {
			 try{
			     helper.clickOnElement(BuyerServicesPageUi.applyToMeetSupplierBtn);
			     WebElement Text=driver.findElement(BuyerServicesPageUi.headerBrowsingHsrtyValid);
			     String actualText=Text.getText();
			     String expectedText="Apply to Meet Suppliers";
			     helper.softAsserting(actualText, expectedText);
			     LoggerGeneretor.info("Clicked On Apply to Meet Supplier Button");
			     test.log(Status.PASS,"Clicked On Apply to Meet Supplier Button");
			     }catch(Exception e){
			    	 	 String Path=ReporterMaker.captureScreenShot("FailedApplyToMeetSupplierBtn");
			    	 	 test.addScreenCaptureFromPath(Path, "FailedApplyToMeetSupplierBtn");
			             CaptureScreenshot.captureScreenShot("FailedApplyToMeetSupplierBtn");
			             LoggerGeneretor.error("Failed to  click on Apply to Meet Supplier Button...");
			             test.log(Status.FAIL,"Failed to click On Apply to Meet Supplier Button...");
			     }
		}
	
		/*-----------------Verify Apply to Meet Supplier Result Page----------------*/
		public void verifyingApplyToMeetSupplierPage(ExtentTest test) {
			 try{
			     WebElement Text=driver.findElement(BuyerServicesPageUi.headerBrowsingHsrtyValid);
			     String actualText=Text.getText();
			     String expectedText="Apply to Meet Suppliers";
			     helper.softAsserting(actualText, expectedText);
			     LoggerGeneretor.info("Clicked On Apply to Meet Supplier Button");
			     test.log(Status.PASS,"Clicked On Apply to Meet Supplier Button");
			     String Path=ReporterMaker.captureScreenShot("SuccessApplyToMeetSupplierBtn");
	    	 	 test.addScreenCaptureFromPath(Path, "SuccessApplyToMeetSupplierBtn");
	             CaptureScreenshot.captureScreenShot("SuccessApplyToMeetSupplierBtn");
			     }catch(Exception e){
			    	 	 String Path=ReporterMaker.captureScreenShot("FailedApplyToMeetSupplierBtn");
			    	 	 test.addScreenCaptureFromPath(Path, "FailedApplyToMeetSupplierBtn");
			             CaptureScreenshot.captureScreenShot("FailedApplyToMeetSupplierBtn");
			             LoggerGeneretor.error("Failed to  click on Apply to Meet Supplier Button...");
			             test.log(Status.FAIL,"Failed to click On Apply to Meet Supplier Button...");
			     }
		}
		
  /*-------------------------------------------------------------------------------------*/
		/*-------------------Clicking On New User Guide----------------------------*/
		public void clickingOnNewUserGuide(ExtentTest test) {
		     try{
		     helper.clickOnElement(HomePageUi.newUserGuide);
		     helper.switchToNewWindow();
		     WebElement Text=driver.findElement(BuyerServicesPageUi.startNow);
		     String actualText=Text.getText();
		     String expectedText="Start Now";
		     helper.softAsserting(actualText, expectedText);
		     LoggerGeneretor.info("Clicked On New User Guide");
		     test.log(Status.PASS,"Clicked On New User Guide");
		     }catch(Exception e){
		    	 	String Path=ReporterMaker.captureScreenShot("FailedNewUserGuide");
		    	 	test.addScreenCaptureFromPath(Path, "FailedNewUserGuide");
		             CaptureScreenshot.captureScreenShot("FailedNewUserGuide");
		             LoggerGeneretor.error("Failed to  click on New User Guide...");
		             test.log(Status.FAIL,"Failed to click On New User Guide...");
		     }
		}
		
		/*-------------------Clicking On Start Now----------------------------*/
		public void clickingOnStartNow(ExtentTest test) {
		     try{
		     helper.clickOnElement(BuyerServicesPageUi.startNow);
		     test.log(Status.PASS,"Clicked Start Now");
		     LoggerGeneretor.info("Clicked Start Now");
		     helper.switchToNewWindow();
		     }catch(Exception e){
		    	 	String Path=ReporterMaker.captureScreenShot("FailedStart Now");
		    	 	test.addScreenCaptureFromPath(Path, "FailedStart Now");
		    	     CaptureScreenshot.captureScreenShot("FailedStart Now");
		             LoggerGeneretor.error("Failed to Click Start Now...");
		             test.log(Status.FAIL,"Failed to Click Start Now...");
		     }
		}
		/*-------------------Verifying URL----------------------------*/
		public void verifyingUrl(ExtentTest test,String expectedURL) {
		     try{
			     String currentURL=driver.getCurrentUrl();
			     Assert.assertEquals(currentURL, expectedURL);
			     test.log(Status.PASS,"Same As Main URL");
			     LoggerGeneretor.info("Same As Main URL");
			     CaptureScreenshot.captureScreenShot("SuccessURL");
			     String Path=ReporterMaker.captureScreenShot("SuccessURL");
	 	 	     test.addScreenCaptureFromPath(Path, "SuccessURL");
			     }catch(Exception e){
			    	 	String Path=ReporterMaker.captureScreenShot("FailedURL");
			    	 	test.addScreenCaptureFromPath(Path, "FailedURL");
			             CaptureScreenshot.captureScreenShot("FailedURL");
			             LoggerGeneretor.error("Page Not Found...");
			             test.log(Status.FAIL,"Page Not Found...");
			      }
		}
	
		
		/*------------------Clicking On Learn More---------------*/
		public void clickingOnLearnMore(ExtentTest test) {
		     try{
		     helper.waitForElementToBeVisible(BuyerServicesPageUi.learnMore, 10);
		     helper.clickOnElement(BuyerServicesPageUi.learnMore);
		     test.log(Status.PASS,"Clicked Learn More");
		     LoggerGeneretor.info("Clicked Learn More");
		     helper.switchToNewWindow();
		     }catch(Exception e){
		    	 	String Path=ReporterMaker.captureScreenShot("FailedLearn More");
		    	 	test.addScreenCaptureFromPath(Path, "FailedLearn More");
		    	     CaptureScreenshot.captureScreenShot("FailedLearn More");
		             LoggerGeneretor.error("Failed to Click Learn More...");
		             test.log(Status.FAIL,"Failed to Click Learn More...");
		     }
		}
		/*------------------Verifying Page Header Of Learn More Page---------------*/
		public void verifyingPageHeaderOfLearnMorePage(ExtentTest test) {
		     try{
			     WebElement pageHeader=driver.findElement(BuyerServicesPageUi.learnMoreValid);
			     String actualHeader=pageHeader.getText();
			     String expectedHeader="How to Avoid Fraud";
			     Assert.assertEquals(actualHeader,expectedHeader);
			     test.log(Status.PASS,"Learn More Page Found");
			     LoggerGeneretor.info("Learn More Page Found");
			     CaptureScreenshot.captureScreenShot("SuccessTabletPC");
			     String Path=ReporterMaker.captureScreenShot("SuccessTabletPC");
	 	 	     test.addScreenCaptureFromPath(Path, "SuccessTabletPC");
			     }catch(Exception e){
			    	 String Path=ReporterMaker.captureScreenShot("FailedLearnMorePage");
		 	 	     test.addScreenCaptureFromPath(Path, "FailedLearnMorePage");
			             CaptureScreenshot.captureScreenShot("FailedLearnMorePage");
			             LoggerGeneretor.error("Learn More Page Not Found...");
			             test.log(Status.FAIL,"Learn More Page Not Found...");
			      }	
		}
	
		
		
		
		/*------------------Clicking On Contact Us---------------*/	
		public void clickingOnContactUs(ExtentTest test) {
		     try{
		     helper.clickOnElement(HomePageUi.contactUS);
		     helper.switchToNewWindow();
		     WebElement Text=driver.findElement(BuyerServicesPageUi.frequentlyAskedQuestion);
		     String actualText=Text.getText();
		     String expectedText="Frequently Asked Questions";
		     helper.softAsserting(actualText, expectedText);
		     LoggerGeneretor.info("Clicked On Contact Us");
		     test.log(Status.PASS,"Clicked On Contact Us");
		     }catch(Exception e){
		    	 	String Path=ReporterMaker.captureScreenShot("FailedContactUs");
		    	 	test.addScreenCaptureFromPath(Path, "FailedContactUs");
		             CaptureScreenshot.captureScreenShot("FailedContactUs");
		             LoggerGeneretor.error("Failed to  click on Contact Us...");
		             test.log(Status.FAIL,"Failed to click On Contact Us...");
		     }
		}
		/*------------------Clicking On FAQ---------------*/
		public void clickingOnFrequentlyAskedQuestion(ExtentTest test) {
		     try{
			     helper.clickOnElement(BuyerServicesPageUi.frequentlyAskedQuestion);
			     LoggerGeneretor.info("Clicked On Frequently Asked Question");
			     test.log(Status.PASS,"Clicked On Frequently Asked Question");
			     }catch(Exception e){
			    	 	String Path=ReporterMaker.captureScreenShot("FailedFAQClick");
			    	 	test.addScreenCaptureFromPath(Path, "FailedFAQClick");
			             CaptureScreenshot.captureScreenShot("FailedFAQClick");
			             LoggerGeneretor.error("Failed to  click on Frequently Asked Question...");
			             test.log(Status.FAIL,"Failed to click On Frequently Asked Question...");
			     }
		}
		/*------------------Verifying Page Header of FAQ Result Page---------------*/
		public void verifyingPageHeaderOfFaq(ExtentTest test) {
		     try{
			     WebElement pageHeader=driver.findElement(BuyerServicesPageUi.frequentlyAQValid);
			     String actualHeader=pageHeader.getText();
			     String expectedHeader="Frequently Asked Questions";
			     Assert.assertEquals(actualHeader,expectedHeader);
			     test.log(Status.PASS,"Frequently Asked Question Page Found");
			     LoggerGeneretor.info("Frequently Asked Question Page Found");
			     CaptureScreenshot.captureScreenShot("SuccessFAQ");
			     String Path=ReporterMaker.captureScreenShot("SuccessFAQ");
	 	 	     test.addScreenCaptureFromPath(Path, "SuccessFAQ");
			     }catch(Exception e){
			    	 String Path=ReporterMaker.captureScreenShot("FailedFAQPage");
		 	 	     test.addScreenCaptureFromPath(Path, "FailedFAQPage");
			             CaptureScreenshot.captureScreenShot("FailedFAQPage");
			             LoggerGeneretor.error("Frequently Asked Question Page Not Found...");
			             test.log(Status.FAIL,"Frequently Asked Question Page Not Found...");
			      }
		     
	}
	
		
		/*------------------Clicking On Browsing History---------------*/
		public void clickingOnBrowsingHistory(ExtentTest test) {
		     try{
		     helper.clickOnElement(HomePageUi.browsingHistory);
		     WebElement Text=driver.findElement(BuyerServicesPageUi.categoriesKeywords);
		     String actualText=Text.getText();
		     String expectedText="Categories & keywords";
		     helper.softAsserting(actualText, expectedText);
		     LoggerGeneretor.info("Clicked On Browsing History");
		     test.log(Status.PASS,"Clicked On Browsing History");
		     }catch(Exception e){
		    	 String Path=ReporterMaker.captureScreenShot("FailedBrowsingHistoryClick");
	 	 	     test.addScreenCaptureFromPath(Path, "FailedBrowsingHistoryClick");
		             CaptureScreenshot.captureScreenShot("FailedBrowsingHistoryClick");
		             LoggerGeneretor.error("Failed to  click on Browsing History...");
		             test.log(Status.FAIL,"Failed to click On Browsing History...");
		     }
		}
		/*------------------Clicking On Categories Keyword---------------*/
		public void clickingOnCategoriesKeyword(ExtentTest test) {
		     try{
			     helper.clickOnElement(BuyerServicesPageUi.categoriesKeywords);
			     WebElement Text=driver.findElement(BuyerServicesPageUi.categoriesKeywords);
			     String actualText=Text.getText();
			     String expectedText="Categories & keywords";
			     helper.softAsserting(actualText, expectedText);
			     LoggerGeneretor.info("Clicked On Categories Keywords");
			     test.log(Status.PASS,"Clicked On Categories Keywords");
			     }catch(Exception e){
			    	 String Path=ReporterMaker.captureScreenShot("FailedCategoriesKeywords");
		 	 	     test.addScreenCaptureFromPath(Path, "FailedCategoriesKeywords");
			             CaptureScreenshot.captureScreenShot("FailedCategoriesKeywords");
			             LoggerGeneretor.error("Failed to  click on Categories Keywords...");
			             test.log(Status.FAIL,"Failed to  click on Categories Keywords...");
			     }
		}
		/*------------------Clicking On Audited Suppliers---------------*/
		public void clickingOnAuditedSuppliers(ExtentTest test) {
		     try{
			     helper.clickOnElement(BuyerServicesPageUi.auditedSuppliers);
			     WebElement Text=driver.findElement(BuyerServicesPageUi.auditedSuppliers);
			     String actualText=Text.getText();
			     String expectedText="Audited Suppliers";
			     helper.softAsserting(actualText, expectedText);
			     LoggerGeneretor.info("Clicked On Audited Suppliers");
			     test.log(Status.PASS,"Clicked On Audited Suppliers");
			     }catch(Exception e){
			    	 String Path=ReporterMaker.captureScreenShot("FailedAuditedSuppliers");
		 	 	     test.addScreenCaptureFromPath(Path, "FailedAuditedSuppliers");
			             CaptureScreenshot.captureScreenShot("FailedAuditedSuppliers");
			             LoggerGeneretor.error("Failed to  click on Audited Suppliers...");
			             test.log(Status.FAIL,"Failed to  click on Audited Suppliers...");
			     }
		}
		/*------------------Clicking On Product History Button---------------*/
		public void clickingOnProductHistoryButton(ExtentTest test) {
		     try{
			     helper.clickOnElement(BuyerServicesPageUi.productHistory);
			     WebElement Text=driver.findElement(BuyerServicesPageUi.productHistory);
			     String actualText=Text.getText();
			     String expectedText="Products";
			     helper.softAsserting(actualText, expectedText);
			     LoggerGeneretor.info("Clicked On Product History");
			     test.log(Status.PASS,"Clicked On Product History");
			     }catch(Exception e){
			    	 String Path=ReporterMaker.captureScreenShot("FailedProductHistoryClick");
		 	 	     test.addScreenCaptureFromPath(Path, "FailedProductHistoryClick");
			             CaptureScreenshot.captureScreenShot("FailedProductHistoryClick");
			             LoggerGeneretor.error("Failed to  click on Product History...");
			             test.log(Status.FAIL,"Failed to click On Product History...");
			     }
		}
		/*------------------Verifying Product History Result Result Page---------------*/
		public void verifyingHistoryPage(ExtentTest test) {
		     try{
			     WebElement pageHeader=driver.findElement(BuyerServicesPageUi.headerBrowsingHsrtyValid);
			     String actualHeader=pageHeader.getText();
			     String expectedHeader="Your Recent Visit History";
			     Assert.assertEquals(actualHeader,expectedHeader);
			     test.log(Status.PASS,"Product History Page Found");
			     LoggerGeneretor.info("Product History Page Found");
			     CaptureScreenshot.captureScreenShot("SuccessProductHistoryPage");
			     String Path=ReporterMaker.captureScreenShot("SuccessProductHistoryPage");
	 	 	     test.addScreenCaptureFromPath(Path, "SuccessProductHistoryPage");
			     }catch(Exception e){
			    	 String Path=ReporterMaker.captureScreenShot("FailedProductHistoryPage");
		 	 	     test.addScreenCaptureFromPath(Path, "FailedProductHistoryPage");
			             CaptureScreenshot.captureScreenShot("FailedProductHistoryPage");
			             LoggerGeneretor.error("Product History Page Not Found...");
			             test.log(Status.FAIL,"Product History Page Not Found...");
			      }
		     
	}
		
	
	
}

