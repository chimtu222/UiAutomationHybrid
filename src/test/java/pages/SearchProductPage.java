package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import uistore.HomePageUi;
import uistore.SearchResultPageUi;
import utils.ReadFromExcel;
import utils.ReporterMaker;
import utils.LoggerGeneretor;
import utils.CaptureScreenshot;
import utils.DriverHelper;

public class SearchProductPage {
	ExtentTest test;
    WebDriver driver;
    DriverHelper helper;
    HomePage home;
public SearchProductPage(WebDriver driver){
    this.driver=driver;
    helper=new DriverHelper(driver); 
    home=new HomePage(driver);
}

/*------------------------------Wrapper Methods---------------------------*/


	/* Method Name:   SearchInvalidProduct
	 * Author Name:   10820894
	 * Short Description:  Testing The Search Bar By searching Invalid Product
	 * Return type: void
	 * Parameter List: test
	*/

	public void searchInvalidProduct(ExtentTest test) {
		
		 /*---------Calling clickingOnSearchBar From Home Page-----------*/
	     home.clickingOnSearchBar(test);
	     
	     passingInValidInput(test);
	     /*----------Calling clickingOnSearch Button From Home Page----------*/
	     home.clickingTheSearchButton(test);
	     
	     verifyingResultPage(test);
	}
	
	
	/* Method Name:   SearchFromDropDown
	 * Author Name:   10820894
	 * Short Description:  Searching Product From Suggestion Drop Down Menu
	 * Return type: void
	 * Parameter List: test
	*/
	
		     
	public void searchFromDropDown(ExtentTest test) {
		
		    /*------------------Calling clickingOnSearchBar From Home Page---------------*/
			home.clickingOnSearchBar(test);
			
			passingSubStringValue(test);
			/*-------------Calling doubleClickOnSuggestion From Home Page-------*/
		     home.doubleClickOnSuggestion(test);
		     
		     clickingOnSmartPhone(test);
		     clickingOnFirstProductCard(test);
		     clickingOnContactSupplier(test);
		     verifyingResultPageAfterClicking(test);
	}
	
	
	/* Method Name:   SearchValidProduct
	 * Author Name:   10820894
	 * Short Description:  Testing The Search Bar By searching Valid Product
	 * Return type: void
	 * Parameter List: test
	*/
	     
	public void searchValidProduct(ExtentTest test) {

			/*------------------Calling clickingOnSearchBar From Home Page---------------*/
			home.clickingOnSearchBar(test);
		
			passingValidInputToSearchBar(test);
			/*------------------Calling clickingTheSearchButton From Home Page---------------*/
			home.clickingTheSearchButton(test);
	      
			clickingOnFirstProduct(test);
			validatingProductPage(test);
	}
	
	
	

    /*-----------------------------------Methods---------------------------------------*/
	
	      /*------------------Passing invalid Input to Search Bar---------------*/
	     public void passingInValidInput(ExtentTest test) {
	     try{
	     String  searchString=ReadFromExcel.readdata(0, 0);
	     helper.sendKeys(HomePageUi.searchBar, searchString);
	     WebElement Text=driver.findElement(HomePageUi.searchBar);
	     String actualText=Text.getText();
	     String expectedText="hgggivs";
	     helper.softAsserting(actualText, expectedText);
	     LoggerGeneretor.info("Search Element Passed to search Bar");
	     test.log(Status.PASS,"Search Element Passed to search Bar");
	     }catch(Exception e){
	    	 	String Path=ReporterMaker.captureScreenShot("FailedValuePass");
	    		test.addScreenCaptureFromPath(Path, "FailedValuePass");
	             CaptureScreenshot.captureScreenShot("FailedValuePass");
	             LoggerGeneretor.error("Failed to  click on Sign in...");
	             test.log(Status.FAIL,"Failed to click On Sign in...");
	     }
	}

	      /*------------------Verify the Result Page---------------*/
	     public void verifyingResultPage(ExtentTest test) {
	     try{
	     WebElement productNotFound=driver.findElement(SearchResultPageUi.SearchElmntnotFound);
	     String actualWarning=productNotFound.getText();
	     String expectedWarning="No matches? Click to search for";
	     Assert.assertEquals(actualWarning,expectedWarning);
	     CaptureScreenshot.captureScreenShot("SuccessInvalidProductWarningText");
	     String Path=ReporterMaker.captureScreenShot("SuccessInvalidProductWarningText");
 		 test.addScreenCaptureFromPath(Path, "SuccessInvalidProductWarningText");
 		 test.log(Status.PASS,"Warning for Invalid Product Text Found");
	     LoggerGeneretor.info("Warning for Invalid Product Text Found");
	     }catch(Exception e){
	             CaptureScreenshot.captureScreenShot("FailedInvalidProductWarningText");
	             String Path=ReporterMaker.captureScreenShot("FailedInvalidProductWarningText");
		    	test.addScreenCaptureFromPath(Path, "FailedInvalidProductWarningText");
	             LoggerGeneretor.error("Warning text For Invalid Product Not Found...");
	             test.log(Status.FAIL,"Warning text For Invalid Product Not Found...");
	      }
	}
	
	     /*------------------Passing Valid input To SearchBar---------------*/
	     public void passingValidInputToSearchBar(ExtentTest test) {
		     try{
		     String  searchString=ReadFromExcel.readdata(1, 0);
		     helper.sendKeys(HomePageUi.searchBar, searchString);
		     WebElement Text=driver.findElement(HomePageUi.searchBar);
		     String actualText=Text.getText();
		     String expectedText="Shoes";
		     helper.softAsserting(actualText, expectedText);
		     LoggerGeneretor.info("Search Element Passed to search Bar");
		     test.log(Status.PASS,"Search Element Passed to search Bar");
		     }catch(Exception e){
		             CaptureScreenshot.captureScreenShot("FailedValuePass");
		             String Path=ReporterMaker.captureScreenShot("FailedValuePass");
			    		test.addScreenCaptureFromPath(Path, "FailedValuePass");
		             LoggerGeneretor.error("Failed to  click on Sign in...");
		             test.log(Status.FAIL,"Failed to click On Sign in...");
		     }
	}
	    
	     /*------------------clicking On First Product From Result Page---------------*/
		 public void clickingOnFirstProduct(ExtentTest test) {
		     try{
			     helper.clickOnElement(SearchResultPageUi.searchRsltFstprdct);
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
		      
		 /*------------------Verifying Result Page---------------*/  
		 public void validatingProductPage(ExtentTest test) {
		     try{
		     WebElement productPageFound=driver.findElement(SearchResultPageUi.productDetailsValid);
		     String actualText=productPageFound.getText();
		     String expectedText="Product Details";
		     Assert.assertEquals(actualText, expectedText);
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
	
		 /*------------------Passing Value To Search Bar---------------*/
		 public void passingSubStringValue(ExtentTest test) {
		     try{
		     String  searchString=ReadFromExcel.readdata(2, 0);
		     helper.sendKeys(HomePageUi.searchBar, searchString);
		     WebElement Text=driver.findElement(HomePageUi.searchBar);
		     String actualText=Text.getText();
		     String expectedText="Mob";
		     helper.softAsserting(actualText, expectedText);
		     LoggerGeneretor.info("Search Element Passed to search Bar");
		     test.log(Status.PASS,"Search Element Passed to search Bar");
		     }catch(Exception e){
		             CaptureScreenshot.captureScreenShot("FailedValuePass");
		             String Path=ReporterMaker.captureScreenShot("FailedValuePass");
			    		test.addScreenCaptureFromPath(Path, "FailedValuePass");
		             LoggerGeneretor.error("Failed to  click on Sign in...");
		             test.log(Status.FAIL,"Failed to click On Sign in...");
		     }
	}
		     
		 /*------------------Clicking On Smart Phone---------------*/
		 public void clickingOnSmartPhone(ExtentTest test) {
		     try{
		    	 helper.clickOnElement(SearchResultPageUi.smartPhone);
			     WebElement Text=driver.findElement(By.xpath("//span[@class='refine-selected']"));
			     String actualText=Text.getText();
			     String expectedText="Smart Phone";
			     helper.softAsserting(actualText, expectedText);
			     test.log(Status.PASS,"Clicked Smart Phone");
			     LoggerGeneretor.info("Clicked Smart Phone");
			     helper.switchToNewWindow();
			     }catch(Exception e){
			    	     CaptureScreenshot.captureScreenShot("FailedSmartPhone");
			    	     String Path=ReporterMaker.captureScreenShot("FailedSmartPhone");
				    		test.addScreenCaptureFromPath(Path, "FailedSmartPhone");
			             LoggerGeneretor.error("Failed to Click Smart Phone...");
			             test.log(Status.FAIL,"Failed to Click Smart Phone...");
			     }
		     }
		     
		 /*------------------Clicking On First Product Link---------------*/
		 public void clickingOnFirstProductCard(ExtentTest test) {
		     
		     try{
			     helper.clickOnElement(SearchResultPageUi.searchRsltFstprdct);
			     helper.switchToNewWindow();
			     WebElement Text=driver.findElement(By.xpath("//div[@class='product-details-title pointer J-prod-detail']"));
			     String actualText=Text.getText();
			     String expectedText="Product Details";
			     helper.softAsserting(actualText, expectedText);
			     test.log(Status.PASS,"Clicked First Product Card");
			     LoggerGeneretor.info("Clicked First Product Card");
			     }catch(Exception e){
			    	     CaptureScreenshot.captureScreenShot("FailedFirstPrdctClick");
			    	     String Path=ReporterMaker.captureScreenShot("FailedFirstPrdctClick");
				    	test.addScreenCaptureFromPath(Path, "FailedFirstPrdctClick");
			             LoggerGeneretor.error("Failed to Click First Product Card...");
			             test.log(Status.FAIL,"Failed to Click First Product Card...");
			     }
		     }
		 
		 /*-----------------Clicking On Supplier BUtton---------------*/
		 public void clickingOnContactSupplier(ExtentTest test) {
		     try{
			     helper.clickOnElement(SearchResultPageUi.contactSplr);
			     test.log(Status.PASS,"Clicked Contact Supplier");
			     LoggerGeneretor.info("Clicked Contact Supplier");
			     helper.switchToNewWindow();
			     }catch(Exception e){
			    	     CaptureScreenshot.captureScreenShot("FailedContactSupplierClick");
			    	     String Path=ReporterMaker.captureScreenShot("FailedContactSupplierClick");
				    	test.addScreenCaptureFromPath(Path, "FailedContactSupplierClick");
			             LoggerGeneretor.error("Failed to Click Contact Supplier...");
			             test.log(Status.FAIL,"Failed to Click Contact Supplier...");
			     }
		     }
		 
		 /*------------------Verifying Result Page---------------*/
		 public void verifyingResultPageAfterClicking(ExtentTest test) {
		     
		     try{
			     WebElement contactSplrPageFound=driver.findElement(SearchResultPageUi.contactSplrValid);
			     String actualText=contactSplrPageFound.getText();
			     String expectedText="Send Inquiry";
			     Assert.assertEquals(actualText, expectedText);
			     test.log(Status.PASS,"Send Inquiry Found in Contact Supplier Page");
			     LoggerGeneretor.info("Send Inquiry Found in Contact Supplier Page");
			     CaptureScreenshot.captureScreenShot("SuccessContactSplr");
			     String Path=ReporterMaker.captureScreenShot("SuccessContactSplr");
		    		test.addScreenCaptureFromPath(Path, "SuccessContactSplr");
			     }catch(Exception e){
			             CaptureScreenshot.captureScreenShot("FailedContactSupplierPage");
			             String Path=ReporterMaker.captureScreenShot("FailedContactSupplierPage");
				    		test.addScreenCaptureFromPath(Path, "FailedContactSupplierPage");
			             LoggerGeneretor.error("Contact Supplier Page Not Found...");
			             test.log(Status.FAIL,"Contact Supplier Page Not Found...");
			   }
	  }

}
