package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import uistore.SearchResultPageUi;
import uistore.TopRankingProductsUi;
import utils.CaptureScreenshot;
import utils.DriverHelper;
import utils.LoggerGeneretor;
import utils.ReporterMaker;

public class TopRankingProductsPage {
	ExtentTest test;
    WebDriver driver;
    DriverHelper helper;
    HomePage home;
public TopRankingProductsPage(WebDriver driver){
    this.driver=driver;
    helper=new DriverHelper(driver); 
    home=new HomePage(driver);
    
}
			
 /*------------------------------Wrapper Methods--------------------------------*/
	/* Method Name:  bestSellingTopRankingPrdcts
	 * Author Name:   10820894
	 * Short Description:  Ordering Best Selling Top Ranking Products
	 * Return type: void
	 * Parameter List: test
	*/
		
	public void bestSellingTopRankingPrdcts(ExtentTest test) throws InterruptedException{
		
	/*---------------calling clickingOnTopRankingProducts from HomePage-------------*/
		home.clickingOnTopRankingProducts(test);
		
		
		clickingOnBestSellingButton(test);
		clickingOnFirstTrendingPrdct(test);
		clickingOnFavIcon(test);
		clickingOnStartOrderRequest(test);
		clickingOnSubmitOrder(test);
	}
	
	
	/* Method Name:   newReleaseTopRankingProducts
	 * Author Name:   10820894
	 * Short Description:  Checking New Releases Products 
	 * Return type: void
	 * Parameter List: test
	*/
			
	public void newReleaseTopRankingProducts(ExtentTest test) throws InterruptedException{
		
		/*---------------calling clickingOnTopRankingProducts from HomePage-------------*/
		home.clickingOnTopRankingProducts(test);
		
		clickingOnNewRelease(test);
		clickingOnFirstTrendingPrdct(test);
		clickingOnAddInquiryBasket(test);
		clickingOnInquiryBasketIcon(test);
		
		
	}
	
	
	
	
 /*---------------------------Methods-------------------------------------*/
	
	/*---------------Clicking On  Best Selling-------------*/	
	public void clickingOnBestSellingButton(ExtentTest test) throws InterruptedException{
		try{
			 Thread.sleep(3000);
		     helper.clickOnElement(TopRankingProductsUi.bestSellingBtn);
		     Thread.sleep(2500);
		     WebElement Text=driver.findElement(TopRankingProductsUi.titleValid);
		     String actualText=Text.getText();
		     String expectedText="Best Selling";
		     Assert.assertTrue(actualText.contains(expectedText));
		     LoggerGeneretor.info("Clicked BestSelling");
		     test.log(Status.PASS,"Clicked BestSelling");
		     }catch(Exception e){
		    	 	String Path=ReporterMaker.captureScreenShot("FailedClickBestSelling");
		    	 	test.addScreenCaptureFromPath(Path, "FailedClickBestSelling");
		    	 	 CaptureScreenshot.captureScreenShot("FailedClickBestSelling");
		             LoggerGeneretor.error("Failed to Click On BestSelling...");
		             test.log(Status.FAIL,"Failed to Click On BestSelling...");
		     }
		}

	/*---------------Clicking On First Trending Product-------------*/
	public void clickingOnFirstTrendingPrdct(ExtentTest test) {
		try{
		     helper.clickOnElement(TopRankingProductsUi.firstTopTrendingPrdct);
		     WebElement productPageFound=driver.findElement(SearchResultPageUi.productDetailsValid);
		     String actualText=productPageFound.getText();
		     String expectedText="Product Details";
		     Assert.assertEquals(actualText, expectedText);
		     test.log(Status.PASS,"Clicked First Product Card");
		     LoggerGeneretor.info("Clicked First Product Card");
		     helper.switchToNewWindow();
		     }catch(Exception e){
		    	     CaptureScreenshot.captureScreenShot("FailedFirstPrdctClick");
		    	     String Path=ReporterMaker.captureScreenShot("FailedFirstPrdctClick");
			    		test.addScreenCaptureFromPath(Path, "FailedFirstPrdctClick");
		             LoggerGeneretor.error("Failed to Click First Product Card...");
		             test.log(Status.FAIL,"Failed to Click First Product Card...");
		     }
		
		}
/*----------------------------Handling Frames-----------------------------------*/
	/*---------------Clicking On  Wish List icon-------------*/
	public void clickingOnFavIcon(ExtentTest test) throws InterruptedException{
		try{
			 helper.waitForElementToBeVisible(TopRankingProductsUi.favIcon, 5);
		     helper.clickOnElement(TopRankingProductsUi.favIcon);
		     test.log(Status.PASS,"Clicked Fav icon");
		     LoggerGeneretor.info("Clicked Fav icon");
		     driver.switchTo().frame(driver.findElement(By.id("popupIframe")));
		     Thread.sleep(2000);
		     WebElement Text=driver.findElement(TopRankingProductsUi.signInValid);
		     System.out.println(Text);
		     String actualText=Text.getText();
		     String expectedText="Sign In";
		     helper.softAsserting(actualText, expectedText);
		     driver.switchTo().parentFrame();
		     driver.navigate().refresh();
		     }catch(Exception e){
		    	     CaptureScreenshot.captureScreenShot("FailedClickedFavicon");
		    	     String Path=ReporterMaker.captureScreenShot("FailedClickFavicon");
			    		test.addScreenCaptureFromPath(Path, "FailedClickFavicon");
		             LoggerGeneretor.error("Failed to Click Fav icon...");
		             test.log(Status.FAIL,"Failed to Click Fav icon...");
		     }
		}

	/*---------------Clicking On Start Order Request Button-------------*/
	public void clickingOnStartOrderRequest(ExtentTest test) {
		try{
		     helper.clickOnElement(TopRankingProductsUi.startNowBtn);
		     test.log(Status.PASS,"Clicked Start Order Request");
		     LoggerGeneretor.info("Clicked Start Order Request");
		     helper.switchToNewWindow();
		     WebElement Text=driver.findElement(TopRankingProductsUi.submitOrderValid);
		     String actualText=Text.getText();
		     String expectedText="Buyer Info.";
		     helper.softAsserting(actualText, expectedText);
		     }catch(Exception e){
		    	     CaptureScreenshot.captureScreenShot("FailedStartOrderRequest");
		    	     String Path=ReporterMaker.captureScreenShot("FailedStartOrderRequest");
			    		test.addScreenCaptureFromPath(Path, "FailedStartOrderRequest");
		             LoggerGeneretor.error("Failed to Click Start Order Request...");
		             test.log(Status.FAIL,"Failed to Click Start Order Request...");
		     }
		}

	/*---------------Clicking On Submit Order-------------*/
	public void clickingOnSubmitOrder(ExtentTest test) {
		try{
		     helper.clickOnElement(TopRankingProductsUi.submitOrder);
		     WebElement Text=driver.findElement(TopRankingProductsUi.submitOrderValid);
		     String actualText=Text.getText();
		     String expectedText="Buyer Info.";
		     helper.softAsserting(actualText, expectedText);
		     test.log(Status.PASS,"Clicked Submit Order");
		     LoggerGeneretor.info("Clicked Submit Order");
		     CaptureScreenshot.captureScreenShot("SuccessSubmitOrder");
    	     String Path=ReporterMaker.captureScreenShot("SuccessSubmitOrder");
	    	 test.addScreenCaptureFromPath(Path, "SuccessSubmitOrder");
		     }catch(Exception e){
		    	     CaptureScreenshot.captureScreenShot("FailedSubmitOrder");
		    	     String Path=ReporterMaker.captureScreenShot("FailedSubmitOrder");
			    	 test.addScreenCaptureFromPath(Path, "FailedSubmitOrder");
		             LoggerGeneretor.error("Failed to Click Submit Order...");
		             test.log(Status.FAIL,"Failed to Click Submit Order...");
		     }
	}

	/*---------------Clicking On New Release-------------*/
	public void clickingOnNewRelease(ExtentTest test) throws InterruptedException{
		try{
			Thread.sleep(3000);
		     helper.clickOnElement(TopRankingProductsUi.newReleases);
		     Thread.sleep(2500);
		     WebElement Text=driver.findElement(TopRankingProductsUi.titleValid);
		     String actualText=Text.getText();
		     String expectedText="New Releases";
		     Assert.assertTrue(actualText.contains(expectedText));
		     LoggerGeneretor.info("Clicked New Releases");
		     test.log(Status.PASS,"Clicked New Releases");
		     }catch(Exception e){
		    	 	String Path=ReporterMaker.captureScreenShot("FailedClickNewReleases");
		    	 	test.addScreenCaptureFromPath(Path, "FailedClickNewReleases");
		    	 	 CaptureScreenshot.captureScreenShot("FailedClickNewReleases");
		             LoggerGeneretor.error("Failed to Click On New Releases...");
		             test.log(Status.FAIL,"Failed to Click On New Releases...");
		     }
	}

	/*---------------Clicking On Add Inquiry Basket-------------*/
	public void clickingOnAddInquiryBasket(ExtentTest test) {
		try{
			 helper.javascriptScroll(TopRankingProductsUi.scrollUptoAddInquiryBasket);
		     helper.clickOnElement(TopRankingProductsUi.addInquiryBasket);
		     WebElement productPageFound=driver.findElement(SearchResultPageUi.productDetailsValid);
		     String actualText=productPageFound.getText();
		     String expectedText="Product Details";
		     Assert.assertEquals(actualText, expectedText);
		     test.log(Status.PASS,"Clicked Add Inquiry Basket");
		     LoggerGeneretor.info("Clicked Add Inquiry Basket");
		     }catch(Exception e){
		    	     CaptureScreenshot.captureScreenShot("FailedAddInquiryBasket");
		    	     String Path=ReporterMaker.captureScreenShot("FailedAddInquiryBasket");
			    	 test.addScreenCaptureFromPath(Path, "FailedAddInquiryBasket");
		             LoggerGeneretor.error("Failed to Click Add Inquiry Basket...");
		             test.log(Status.FAIL,"Failed to Click Add Inquiry Basket...");
		     }
	}
	
	/*---------------Clicking On Inquiry Basket icon-------------*/
	public void clickingOnInquiryBasketIcon(ExtentTest test) {
		try{
		     helper.clickOnElement(TopRankingProductsUi.inquiryBasketIcon);
		     helper.switchToNewWindow();
		     WebElement productPageFound=driver.findElement(By.xpath("//div[@class='m-channel-name']"));
		     String actualText=productPageFound.getText();
		     String expectedText="Inquiry Basket";
		     Assert.assertEquals(actualText, expectedText);
		     test.log(Status.PASS,"Clicked Add Inquiry Basket icon");
		     LoggerGeneretor.info("Clicked Add Inquiry Basket icon");
		     CaptureScreenshot.captureScreenShot("SuccessAddInquiryBasketIcon");
    	     String Path=ReporterMaker.captureScreenShot("SuccessAddInquiryBasketIcon");
	    	 test.addScreenCaptureFromPath(Path, "SuccessAddInquiryBasketIcon");
		     }catch(Exception e){
		    	     CaptureScreenshot.captureScreenShot("FailedAddInquiryBasketIcon");
		    	     String Path=ReporterMaker.captureScreenShot("FailedAddInquiryBasketIcon");
			    	 test.addScreenCaptureFromPath(Path, "FailedAddInquiryBasketIcon");
		             LoggerGeneretor.error("Failed to Click Add Inquiry Basket icon...");
		             test.log(Status.FAIL,"Failed to Click Add Inquiry Basket icon...");
		     }
		
	}
}
