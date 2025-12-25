package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import uistore.BuyerServicesPageUi;
import uistore.HomePageUi;
import uistore.SearchResultPageUi;
import uistore.SecureTradingServicesPageUi;
import uistore.SignInPageUi;
import utils.CaptureScreenshot;
import utils.DriverHelper;
import utils.LoggerGeneretor;
import utils.ReporterMaker;

public class HomePage {
	ExtentTest test;
    WebDriver driver;
    DriverHelper helper;
public HomePage(WebDriver driver){
    this.driver=driver;
    helper=new DriverHelper(driver); 
}

/*----------------------------------Wrapper Methods---------------------------------*/
/* Method Name:  validatingLogoUrl
 * Author Name:   10820894
 * Short Description:  Validating URL after Clicking On Logo
 * Return type: void
 * Parameter List: test
*/
public void validatingLogoUrl(ExtentTest test) {
	String expectedUrl=driver.getCurrentUrl();
	try {
	clickingOnLogo(test);
	String actualUrl1=driver.getCurrentUrl();
	Assert.assertEquals(actualUrl1, expectedUrl);
	LoggerGeneretor.info("URL is same as Main URL");
    test.log(Status.PASS,"URL is same as Main URL");
    clickingOnLogo(test);
	String actualUrl2=driver.getCurrentUrl();
	Assert.assertEquals(actualUrl2, expectedUrl);
	LoggerGeneretor.info("Second Click URL is same as Main URL");
    test.log(Status.PASS,"Second Click URL is same as Main URL");
    clickingOnLogo(test);
	String actualUrl3=driver.getCurrentUrl();
	Assert.assertEquals(actualUrl3, expectedUrl);
	clickingOnLogo(test);
	String actualUrl4=driver.getCurrentUrl();
	Assert.assertEquals(actualUrl4, expectedUrl);
	LoggerGeneretor.info("Third Click URL is same as Main URL");
    test.log(Status.PASS,"Third Click URL is same as Main URL");
	}catch(Exception e) {
	LoggerGeneretor.error("Failed URL is Not same as Main URL...");
    test.log(Status.FAIL,"Failed URL is Not same as Main URL...");	
	}
	
}



/*----------------------------------Methods-------------------------------------*/
	/* Method Name:  hoveringOnSignInAndClickingOnIt
	 * Author Name:   10820894
	 * Short Description:  
	 * Return type: void
	 * Parameter List: test
	*/
public void hoveringOnSignInAndClickingOnIt(ExtentTest test) {
	try{
	     helper.hoverOverElement(HomePageUi.SigninJoin);
	     WebElement Text=driver.findElement(HomePageUi.Signin);
	     String actualText=Text.getText();
	     String expectedText="Sign in";
	     helper.softAsserting(actualText, expectedText);
	     LoggerGeneretor.info("Hovered On Sign in/Join");
	     test.log(Status.PASS,"Hovered On Sign in/Join");
	     }catch(Exception e){
	    	 	String Path=ReporterMaker.captureScreenShot("FailedHoveringSigninJoin");
	    	 	test.addScreenCaptureFromPath(Path, "FailedHoveringSigninJoin");
	    	 	 CaptureScreenshot.captureScreenShot("FailedHoveringSigninJoin");
	             LoggerGeneretor.error("Failed to Hover On Sign in/Join...");
	             test.log(Status.FAIL,"Failed to Hover On Sign in/Join...");
	     }

	     try{
	     helper.clickOnElement(HomePageUi.Signin);
	     WebElement Text=driver.findElement(SignInPageUi.forgotPassword);
	     String actualText=Text.getText();
	     String expectedText="Forgot password? ";
	     helper.softAsserting(actualText, expectedText);
	     LoggerGeneretor.info("Clicked On Sign in");
	     test.log(Status.PASS,"Clicked On Sign in");
	     }catch(Exception e){
	    	 	String Path=ReporterMaker.captureScreenShot("FailedSignin");
	    	 	test.addScreenCaptureFromPath(Path, "FailedSignin");
	             CaptureScreenshot.captureScreenShot("FailedSignin");
	             LoggerGeneretor.error("Failed to  click on Sign in...");
	             test.log(Status.FAIL,"Failed to click On Sign in...");
	     }
	
}
	/* Method Name: hoveringOnBuyer
	 * Author Name: 10820894
	 * Short Description: Hovering On Buyer
	 * Return type: void
	 * Parameter List: test
	*/	

	
public void hoveringOnBuyer(ExtentTest test) {
		try{
		     helper.hoverOverElement(HomePageUi.buyer);
		     WebElement Text=driver.findElement(HomePageUi.newUserGuide);
		     String actualText=Text.getText();
		     String expectedText="New User Guide";
		     helper.softAsserting(actualText, expectedText);
		     LoggerGeneretor.info("Hovered On Buyer");
		     test.log(Status.PASS,"Hovered On Buyer");
		     }catch(Exception e){
		    	 	String Path=ReporterMaker.captureScreenShot("FailedHoveringBuyer");
		    	 	test.addScreenCaptureFromPath(Path, "FailedHoveringBuyer");
		    	 	 CaptureScreenshot.captureScreenShot("FailedHoveringBuyer");
		             LoggerGeneretor.error("Failed to Hover On Buyer...");
		             test.log(Status.FAIL,"Failed to Hover On Buyer...");
		     }
	}
/* Method Name: clickingOnAuditedSupplier
 * Author Name: 10820894
 * Short Description: Clicking On Audited Supplier
 * Return type: void
 * Parameter List: test
*/	


public void clickingOnAuditedSupplier(ExtentTest test) {
	try{
	     helper.clickOnElement(HomePageUi.auditedSuppliersReports);
	     helper.switchToNewWindow();
	     WebElement Text=driver.findElement(BuyerServicesPageUi.verifyAuditedSupplierPage);
	     String actualText=Text.getText();
	     String expectedText="Audited Suppliers";
	     helper.softAsserting(actualText, expectedText);
	     LoggerGeneretor.info("Clicked On Audited Suppliers' Reports");
	     test.log(Status.PASS,"Clicked On Audited Suppliers' Reports");
	     }catch(Exception e){
	    	 	 String Path=ReporterMaker.captureScreenShot("FailedClickAuditedSupplier");
	    	 	 test.addScreenCaptureFromPath(Path, "FailedClickAuditedSupplier");
	    	 	 CaptureScreenshot.captureScreenShot("FailedClickAuditedSupplier");
	             LoggerGeneretor.error("Failed to Click On Audited Suppliers' Reports...");
	             test.log(Status.FAIL,"Failed to Click On Audited Suppliers' Reports...");
	     }
}
	
	/* Method Name: hoveringOnAllCategories
	 * Author Name: 10820894
	 * Short Description: Hovering On All Categories
	 * Return type: void
	 * Parameter List: test
	*/	

	
public void hoveringOnAllCategories(ExtentTest test) {
		try{
		     helper.hoverOverElement(HomePageUi.allCategories);
		     WebElement Text=driver.findElement(HomePageUi.electricalElectrncs);
		     String actualText=Text.getText();
		     String expectedText="Electrical & Electronics";
		     helper.softAsserting(actualText, expectedText);
		     LoggerGeneretor.info("Hovered On All Categories");
		     test.log(Status.PASS,"Hovered On All Categories");
		     }catch(Exception e){
		    	 	String Path=ReporterMaker.captureScreenShot("FailedHoveringAllCategories");
		    	 	test.addScreenCaptureFromPath(Path, "FailedHoveringAllCategories");
		    	 	 CaptureScreenshot.captureScreenShot("FailedHoveringAllCategories");
		             LoggerGeneretor.error("Failed to Hover On All Categories...");
		             test.log(Status.FAIL,"Failed to Hover On All Categories...");
		     }
	}
	

	/* Method Name: clickingOnSearchBar
	 * Author Name: 10820894
	 * Short Description: Clicking the search Button
	 * Return type: void
	 * Parameter List: test
	*/	

public void clickingOnSearchBar(ExtentTest test) {
		try{
		     helper.clickOnElement(HomePageUi.searchBar);
		     WebElement Text=driver.findElement(HomePageUi.searchBar);
		     String actualText=Text.getText();
		     String expectedText="Enter a keyword to search products";
		     helper.softAsserting(actualText, expectedText);
		     LoggerGeneretor.info("Clicked Search Bar");
		     test.log(Status.PASS,"Clicked Search Bar");
		     }catch(Exception e){
		    	 	String Path=ReporterMaker.captureScreenShot("FailedClickSearchBar");
		    	 	test.addScreenCaptureFromPath(Path, "FailedClickSearchBar");
		    	 	 CaptureScreenshot.captureScreenShot("FailedClickSearchBar");
		             LoggerGeneretor.error("Failed to Click On Search Bar...");
		             test.log(Status.FAIL,"Failed to Click On Search Bar...");
		     }
	}
	
	
	
	/* Method Name: clickingTheSearchButton
	 * Author Name: 10820894
	 * Short Description: Clicking on search button
	 * Return type: void
	 * Parameter List: test
	*/	
public void clickingTheSearchButton(ExtentTest test) {
		try{
		     helper.clickOnElement(HomePageUi.searchBtn);
		     test.log(Status.PASS,"Clicked Search Button");
		     LoggerGeneretor.info("Clicked Search Button");
		     }catch(Exception e){
		    	 	String Path=ReporterMaker.captureScreenShot("FailedSearchBtn");
		    	 	test.addScreenCaptureFromPath(Path, "FailedSearchBtn");
		    	     CaptureScreenshot.captureScreenShot("FailedSearchBtn");
		             LoggerGeneretor.error("Failed to Click Search Button...");
		             test.log(Status.FAIL,"Failed to Click Search Button...");
		     }
	}
	
	
	/* Method Name: doubleClickOnSuggestion
	 * Author Name: 10820894
	 * Short Description: double Clicking On Suggestion drop down menu
	 * Return type: void
	 * Parameter List: test
	*/
public void doubleClickOnSuggestion(ExtentTest test) {
		try{
		     helper.waitForElementToBeVisible(SearchResultPageUi.dropDownOpn, 5);
		     helper.doubleClickOnElement(SearchResultPageUi.dropDownOpn);
		     helper.switchToNewWindow();
		     driver.close();
		     helper.switchToNewWindow();
		     test.log(Status.PASS,"Clicked From Drop down Option");
		     LoggerGeneretor.info("Clicked From Drop down Option");
		     }catch(Exception e){
		    	 	String Path=ReporterMaker.captureScreenShot("FailedToClickDropDownOption");
		    	 	test.addScreenCaptureFromPath(Path, "FailedToClickDropDownOption");
		    	     CaptureScreenshot.captureScreenShot("FailedToClickDropDownOption");
		             LoggerGeneretor.error("Failed to Click Search Button...");
		             test.log(Status.FAIL,"Failed to Click Search Button...");
		     }
	}

	/* Method Name: clickingOnTopRankingProducts
	 * Author Name: 10820894
	 * Short Description: clicking On TopRanking Products in Header
	 * Return type: void
	 * Parameter List: test
	*/
public void clickingOnTopRankingProducts(ExtentTest test) {
		
		try{ 
		     helper.waitForElementToBeVisible(HomePageUi.topRankingProducts, 5);
		     helper.clickOnElement(HomePageUi.topRankingProducts);
		     WebElement Text=driver.findElement(By.xpath("//div[@class='liner-title top-title']"));
		     String actualText=Text.getText();
		     String expectedText="Top-ranking Products";
		     helper.softAsserting(actualText, expectedText);
		     helper.clickOnElement(HomePageUi.topRankingProducts);
		     test.log(Status.PASS,"Clicked Top Ranking Products");
		     LoggerGeneretor.info("Clicked Top Ranking Products");
		     }catch(Exception e){
		    	 	String Path=ReporterMaker.captureScreenShot("FailedTopRankingProducts");
		    	 	test.addScreenCaptureFromPath(Path, "FailedTopRankingProducts");
		    	     CaptureScreenshot.captureScreenShot("FailedTopRankingProducts");
		             LoggerGeneretor.error("Failed to Click on Top Ranking Products...");
		             test.log(Status.FAIL,"Failed to Click on Top Ranking Products...");
		     }
	}

	/* Method Name: hoveringOnHelpMenu
	 * Author Name: 10820894
	 * Short Description: hovering On Help Menu
	 * Return type: void
	 * Parameter List: test
	*/
	public void hoveringOnHelpMenu(ExtentTest test) {
		try{
		     helper.waitForElementToBeVisible(HomePageUi.helpDropDown, 5);
		     helper.hoverOverElement(HomePageUi.helpDropDown);
		     WebElement Text=driver.findElement(HomePageUi.submitAComplaint);
		     String actualText=Text.getText();
		     String expectedText="Submit a Complaint";
		     helper.softAsserting(actualText, expectedText);
		     test.log(Status.PASS,"Hovered On Help Menu");
		     LoggerGeneretor.info("Hovered On Help Menu");
		     }catch(Exception e){
		    	 	String Path=ReporterMaker.captureScreenShot("FailedHelpMenu");
		    	 	test.addScreenCaptureFromPath(Path, "FailedHelpMenu");
		    	     CaptureScreenshot.captureScreenShot("FailedHelpMenu");
		             LoggerGeneretor.error("Failed to Hover On Help Menu...");
		             test.log(Status.FAIL,"Failed to Hover On Help Menu...");
		     }
	}
	/* Method Name: clickingOnLogo
	 * Author Name: 10820894
	 * Short Description: Clicking on Made in China Logo
	 * Return type: void
	 * Parameter List: test
	*/
	public void clickingOnLogo(ExtentTest test) {
		try{
	     helper.clickOnElement(HomePageUi.appLogo);
	     LoggerGeneretor.info("Clicked On Logo");
	     test.log(Status.PASS,"Clicked On Logo");
	     }catch(Exception e){
	    	 	String Path=ReporterMaker.captureScreenShot("FailedLogo");
	    	 	test.addScreenCaptureFromPath(Path, "FailedLogo");
	             CaptureScreenshot.captureScreenShot("FailedLogo");
	             LoggerGeneretor.error("Logo Not Clickable...");
	             test.log(Status.FAIL,"Logo Not Clickable...");
	     }
	}
	
	/* Method Name: clickingOnSecureTradingServices
	 * Author Name: 10820894
	 * Short Description: Clicking on Secure Trading Services
	 * Return type: void
	 * Parameter List: test
	*/
	public void clickingOnSecureTradingServices(ExtentTest test) {
		try{
		 helper.waitForElementToBeVisible(HomePageUi.secureTradingServices, 5);
	     helper.clickOnElement(HomePageUi.secureTradingServices);
	     WebElement Text=driver.findElement(SecureTradingServicesPageUi.validateSecureTradingPage);
	     String actualText=Text.getText();
	     String expectedText="Secured Trading";
	     helper.softAsserting(actualText, expectedText);
	     LoggerGeneretor.info("Clicked On Secure Trading Services");
	     test.log(Status.PASS,"Clicked On Secure Trading Services");
	     }catch(Exception e){
	    	 	String Path=ReporterMaker.captureScreenShot("FailedSecuredTrading");
	    	 	test.addScreenCaptureFromPath(Path, "FailedSecuredTrading");
	             CaptureScreenshot.captureScreenShot("FailedSecuredTrading");
	             LoggerGeneretor.error("Failed to Click on Secure Trading Services...");
	             test.log(Status.FAIL,"Failed to Click on Secure Trading Services...");
	     }
	}

	
}
