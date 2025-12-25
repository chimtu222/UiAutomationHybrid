package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import uistore.SecureTradingServicesPageUi;
import uistore.TopRankingProductsUi;
import utils.CaptureScreenshot;
import utils.DriverHelper;
import utils.LoggerGeneretor;
import utils.ReporterMaker;

public class SecureTradingServicesPage {
	ExtentTest test;
    WebDriver driver;
    DriverHelper helper;
    HomePage home;
    TopRankingProductsPage product;
public SecureTradingServicesPage(WebDriver driver){
    this.driver=driver;
    helper=new DriverHelper(driver); 
    home=new HomePage(driver);
    product=new TopRankingProductsPage(driver);
}

/*------------------Wrapper Method---------------*/
/* Method Name:   validatingSecureTradingPage
 * Author Name:   10820894
 * Short Description:  Verifying Secure Trading Services Page
 * Return type: void
 * Parameter List: test
*/

	public void validatingSecureTradingPage(ExtentTest test) {
		
		/*------------------Calling clickingOnSecureTradingServices From Home Page---------------*/
				home.clickingOnSecureTradingServices(test);
				clickingOnBuyersGuide(test);
				clickingOnSecureTradingServicesImage(test);
				scrollingToRefundAndReturn(test);
				clickingOnRefundAndReturnLinkAndVerifying(test);
				
	}	
	
	/* Method Name:   validatingDisplayAndAccessoriesPage
	 * Author Name:   10820894
	 * Short Description:  Verifying Display And Accessories Product Page
	 * Return type: void
	 * Parameter List: test
	*/

		public void validatingDisplayAndAccessoriesPage(ExtentTest test) {
			
			/*------------------Calling clickingOnSecureTradingServices From Home Page---------------*/
					home.clickingOnSecureTradingServices(test);
					scrollingToDisplayAndAccessories(test);
					clickingOnDisplayAndAccessories(test);
					clickingOnFirstDisplayAndAccessoriesProduct(test);
					validatingProductPage(test);
					
		}
		/* Method Name:   orderingFromSecureTradingServices
		 * Author Name:   10820894
		 * Short Description:  Verifying Secure Trading Services Product Page
		 * Return type: void
		 * Parameter List: test
		*/

			public void orderingFromSecureTradingServices(ExtentTest test) {
				
				/*------------------Calling clickingOnSecureTradingServices From Home Page---------------*/
						home.clickingOnSecureTradingServices(test);
						scrollingToDisplayAndAccessories(test);
						clickingOnFirstDisplayAndAccessoriesProduct(test);
						product.clickingOnStartOrderRequest(test);
						verifyingProductResultPage(test);
						
			}
	
	
	
	
	
	/*------------------------------Methods------------------------------------*/
			/*---------------Verifying Result Page-------------*/
			public void verifyingProductResultPage(ExtentTest test) {
				try{
				     WebElement Text=driver.findElement(TopRankingProductsUi.submitOrderValid);
				     String actualText=Text.getText();
				     String expectedText="Buyer Info.";
				     helper.softAsserting(actualText, expectedText);
				     test.log(Status.PASS,"Secured Trading Service Order Page Found");
				     LoggerGeneretor.info("Secured Trading Service Order Page Found");
				     CaptureScreenshot.captureScreenShot("SuccessServiceOrderPageFound");
		    	     String Path=ReporterMaker.captureScreenShot("SuccessServiceOrderPageFound");
			    	 test.addScreenCaptureFromPath(Path, "SuccessServiceOrderPageFound");
				     }catch(Exception e){
				    	     CaptureScreenshot.captureScreenShot("FailedServiceOrderPageFound");
				    	     String Path=ReporterMaker.captureScreenShot("FailedServiceOrderPageFound");
					    	 test.addScreenCaptureFromPath(Path, "FailedServiceOrderPageFound");
				             LoggerGeneretor.error("Secured Trading Service Order Page Not Found...");
				             test.log(Status.FAIL,"Secured Trading Service Order Page Not Found...");
				     }
				}
		/*------------------Scrolling to Display & Accessories---------------*/
		public void scrollingToDisplayAndAccessories(ExtentTest test){
		try{
		     helper.javascriptScroll(SecureTradingServicesPageUi.scrollToDisplayAndAccessories);
		     WebElement Text=driver.findElement(SecureTradingServicesPageUi.displayAndAccessories);
		     String actualText=Text.getText();
		     String expectedText="Display & Accessories";
		     Assert.assertTrue(actualText.contains(expectedText));
		     LoggerGeneretor.info("Clicked on Display and Accessories");
		     test.log(Status.PASS,"Clicked on Display and Accessories");
		     }catch(Exception e){
		    	 	String Path=ReporterMaker.captureScreenShot("FailedClickingDisplayAndAccessories");
		    	 	test.addScreenCaptureFromPath(Path, "FailedClickingDisplayAndAccessories");
		    	 	 CaptureScreenshot.captureScreenShot("FailedClickingDisplayAndAccessories");
		             LoggerGeneretor.error("Failed to Click on Display and Accessories...");
		             test.log(Status.FAIL,"Failed to Click on Display and Accessories...");
		     }
	}
		/*------------------Verifying Product Result Page---------------*/  
		 public void validatingProductPage(ExtentTest test) {
		     try{
		     WebElement productPageFound=driver.findElement(SecureTradingServicesPageUi.firstDisplayAndAccessoriesPrdctValid);
		     String actualText=productPageFound.getText();
		     String expectedText="Product Details";
		     Assert.assertTrue(actualText.contains(expectedText));
		     test.log(Status.PASS,"Product Details Found in Result Page");
		     LoggerGeneretor.info("Product Details Found in Result Page");
		     CaptureScreenshot.captureScreenShot("SuccessProductResultPage");
		     String Path=ReporterMaker.captureScreenShot("SuccessProductResultPage");
	    		test.addScreenCaptureFromPath(Path, "SuccessProductResultPage");
		     }catch(Exception e){
		             CaptureScreenshot.captureScreenShot("FailedProductResultPage");
		             String Path=ReporterMaker.captureScreenShot("FailedProductResultPage");
			    		test.addScreenCaptureFromPath(Path, "FailedProductResultPage");
		             LoggerGeneretor.error("Product Result Page Not Found...");
		             test.log(Status.FAIL,"Product Result Page Not Found...");
		      }
	
	}
	  	/*------------------Clicking On Display & Accessories---------------*/
		public void clickingOnDisplayAndAccessories(ExtentTest test){
		try{
		     helper.clickOnElement(SecureTradingServicesPageUi.displayAndAccessories);
		     LoggerGeneretor.info("Clicked on Display and Accessories");
		     test.log(Status.PASS,"Clicked on Display and Accessories");
		     }catch(Exception e){
		    	 	String Path=ReporterMaker.captureScreenShot("FailedClickingDisplayAndAccessories");
		    	 	test.addScreenCaptureFromPath(Path, "FailedClickingDisplayAndAccessories");
		    	 	 CaptureScreenshot.captureScreenShot("FailedClickingDisplayAndAccessories");
		             LoggerGeneretor.error("Failed to Click on Display and Accessories...");
		             test.log(Status.FAIL,"Failed to Click on Display and Accessories...");
		     }
	}
		/*------------Clicking On First  Display & Accessories Product------------*/
		public void clickingOnFirstDisplayAndAccessoriesProduct(ExtentTest test){
		try{
		     helper.clickOnElement(SecureTradingServicesPageUi.firstDisplayAndAccessoriesPrdct);
		     helper.switchToNewWindow();
		     WebElement productPageFound=driver.findElement(SecureTradingServicesPageUi.firstDisplayAndAccessoriesPrdctValid);
		     String actualText=productPageFound.getText();
		     String expectedText="Product Details";
		     Assert.assertTrue(actualText.contains(expectedText));
		     LoggerGeneretor.info("Clicked on First Display and Accessories Product");
		     test.log(Status.PASS,"Clicked on First Display and Accessories Product");
		     }catch(Exception e){
		    	 	String Path=ReporterMaker.captureScreenShot("FailedClickingFirstDisplayAndAccessoriesPrdct");
		    	 	test.addScreenCaptureFromPath(Path, "FailedClickingFirstDisplayAndAccessoriesPrdct");
		    	 	 CaptureScreenshot.captureScreenShot("FailedClickingFirstDisplayAndAccessoriesPrdct");
		             LoggerGeneretor.error("Failed to Click on First Display and Accessories Product...");
		             test.log(Status.FAIL,"Failed to Click on First Display and Accessories Product...");
		     }
	}
		/*------------------Clicking On Buyers Guide---------------*/
		public void clickingOnBuyersGuide(ExtentTest test){
			try{
			     helper.clickOnElement(SecureTradingServicesPageUi.buyersGuide);
			     helper.switchToNewWindow();
			     WebElement Text=driver.findElement(SecureTradingServicesPageUi.validateBuyersGuide);
			     String actualText=Text.getText();
			     String expectedText="About Us";
			     helper.softAsserting(actualText, expectedText);
			     LoggerGeneretor.info("Clicked on Buyers Guide");
			     test.log(Status.PASS,"Clicked on Buyers Guide");
			     }catch(Exception e){
			    	 	String Path=ReporterMaker.captureScreenShot("FailedClickingBuyersGuide");
			    	 	test.addScreenCaptureFromPath(Path, "FailedClickingBuyersGuide");
			    	 	 CaptureScreenshot.captureScreenShot("FailedClickingBuyersGuide");
			             LoggerGeneretor.error("Failed to Click on Buyers Guide...");
			             test.log(Status.FAIL,"Failed to Click on Buyers Guide...");
			     }
		}
		/*------------------Clicking On Secure Trading Image---------------*/
		public void clickingOnSecureTradingServicesImage(ExtentTest test){
				try{
				     helper.clickOnElement(SecureTradingServicesPageUi.secureTradingImg);
				     WebElement Text=driver.findElement(By.xpath("//h1[@class='head-title']"));
				     String actualText=Text.getText();
				     String expectedText="Secured Trading Service";
				     helper.softAsserting(actualText, expectedText);
				     LoggerGeneretor.info("Clicked on Secure Trading Image");
				     test.log(Status.PASS,"Clicked on Secure Trading Image");
				     }catch(Exception e){
				    	 	String Path=ReporterMaker.captureScreenShot("FailedClickingSecureTradingImage");
				    	 	test.addScreenCaptureFromPath(Path, "FailedClickingSecureTradingImage");
				    	 	 CaptureScreenshot.captureScreenShot("FailedClickingSecureTradingImage");
				             LoggerGeneretor.error("Failed to Click on Secure Trading Image...");
				             test.log(Status.FAIL,"Failed to Click on Secure Trading Image...");
				     }
			
		}
		
		/*------------------Scrolling To Refund And Return---------------*/
		public void scrollingToRefundAndReturn(ExtentTest test){
				try{
				     helper.javascriptScroll(SecureTradingServicesPageUi.scrollDownUpToRefundAndReturn);
				     WebElement Text=driver.findElement(SecureTradingServicesPageUi.readReturnAndRefundRulesLink);
				     String actualText=Text.getText();
				     String expectedText="Read the full Return & Refund rules.";
				     helper.softAsserting(actualText, expectedText);
				     LoggerGeneretor.info("Scrolled To Refund And Return");
				     test.log(Status.PASS,"Scrolled To Refund And Return");
				     }catch(Exception e){
				    	 	String Path=ReporterMaker.captureScreenShot("FailedScrollToRefundAndReturn");
				    	 	test.addScreenCaptureFromPath(Path, "FailedScrollToRefundAndReturn");
				    	 	 CaptureScreenshot.captureScreenShot("FailedScrollToRefundAndReturn");
				             LoggerGeneretor.error("Failed to Scroll To Refund And Return...");
				             test.log(Status.FAIL,"Failed to Scroll To Refund And Return...");
				     }
			
		}
		
		/*------------------Scrolling To Refund And Return---------------*/
		public void clickingOnRefundAndReturnLinkAndVerifying(ExtentTest test){
				try{
					 helper.waitForElementToBeVisible(SecureTradingServicesPageUi.readReturnAndRefundRulesLink, 5);
				     helper.jsClick(SecureTradingServicesPageUi.readReturnAndRefundRulesLink);
				     helper.switchToNewWindow();
				     WebElement Text=driver.findElement(SecureTradingServicesPageUi.validateReturnAndRefundPage);
				     String actualText=Text.getText();
				     String expectedText="Return & Refund Rules";
				     helper.softAsserting(actualText, expectedText);
				     LoggerGeneretor.info("Refund And Return Rules Page Found");
				     test.log(Status.PASS,"Refund And Return Rules Page Found");
				     CaptureScreenshot.captureScreenShot("SuccessReturn&RulePage");
				     String Path=ReporterMaker.captureScreenShot("SuccessReturn&RulePage");
			    	 test.addScreenCaptureFromPath(Path, "SuccessReturn&RulePage");
				     }catch(Exception e){
				    	 	String Path=ReporterMaker.captureScreenShot("FailedReturn&RulePage");
				    	 	test.addScreenCaptureFromPath(Path, "FailedReturn&RulePage");
				    	 	 CaptureScreenshot.captureScreenShot("FailedReturn&RulePage");
				             LoggerGeneretor.error("Failed to Found Refund And Return Rules Page...");
				             test.log(Status.FAIL,"Failed to Found Refund And Return Rules Page...");
				     }
		}
		
		
}
