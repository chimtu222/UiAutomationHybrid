package runner;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pages.ComputerProductsPage;
import pages.ElectricalAndElectronicsPage;
import pages.HelpMenuPage;
import pages.HomePage;
import pages.SearchProductPage;
import pages.SecureTradingServicesPage;
import pages.SigninPage;
import pages.TopRankingProductsPage;
import pages.BuyerServicesPage;
import utils.SetUpBrowser;
import utils.JProgressBar;
import utils.ReporterMaker;
import utils.SendEmail;


public class TestMadeInChina extends SetUpBrowser {
	ExtentReports reports;
	ExtentTest test;
	private static JProgressBar progress;
	@BeforeTest
	public void setUp() {
		reports=ReporterMaker.generateExtentReport("MadeinChinaReport");
		progress=new JProgressBar();
	}
	@BeforeMethod
	public void openingBrowser() {
		openBrowser();
	}
	
//	/*--------------------------Login with FaceBook----------------------------*/
//	@Test(description ="login via FaceBook" ,priority = 1)
//	public void loginWithFaceBook(){
//			System.out.println("Running TestCase- 1");
//			test=reports.createTest("Log in With FaceBook","Validating FaceBook Log in URL");
//	        SigninPage signin=new SigninPage(driver);
//	        signin.signInFacebook(test);
//	        
//	}
//	
//	/*--------------------------Login with ForgotPassword----------------------------*/
//	@Test(description ="Validating ForgotPassword" ,priority = 2)
//	public void forgotPasswordValidation() {
//		System.out.println("Running TestCase- 2");
//		test=reports.createTest("Reset Using Forgot Password","Validating ForgotPassword Page");
//        SigninPage forgotpass=new SigninPage(driver);
//        forgotpass.signInForgotPass(test); 
//	}
	
	/*--------------------------Searching Valid Product----------------------------*/
	@Test(description ="Searching Valid Product" ,priority = 3)
	public void searchingValidProducts() {
		System.out.println("Running TestCase- 3");
		test=reports.createTest("Searching Valid Products ","Validating Product Page");
		SearchProductPage search=new SearchProductPage(driver);
		search.searchValidProduct(test);
				
	}
	
	/*--------------------------Searching Some Non Existing Products ----------------------------*/
	@Test(description ="Searching Some Non Existing" ,priority = 4)
	public void searchingInValidProducts() {
		System.out.println("Running TestCase- 4");
		test=reports.createTest("Searching Invalid Products","Validating Result Page");
		SearchProductPage search=new SearchProductPage(driver);
		search.searchInvalidProduct(test);
	}
	
	/*--------------------------Searching Products from Suggestions----------------------------*/
	@Test(description ="Searching Products from Suggestions" ,priority = 5)
	public void searchingProductsFromSuggestions() {
		System.out.println("Running TestCase- 5");
		test=reports.createTest("Searching From Suggestions","Validating Result Page");
		SearchProductPage search=new SearchProductPage(driver);
		search.searchFromDropDown(test);
	}
	
//	/*--------------------------Computer Product Verifying----------------------------*/
//	@Test(description ="Computer Product" ,priority = 6)
//	public void checkingComputerProducts() {
//		System.out.println("Running TestCase- 6");
//		test=reports.createTest("Checking Computer Products","Validating Product Page");
//		ComputerProductsPage compter=new ComputerProductsPage(driver);
//		compter.validatingComputerTabletPc(test);
//	}
//	
//	/*--------------------------Electrical & Electronics Product Verifying----------------------------*/
//	@Test(description ="Electrical & Electronics Product" ,priority = 7)
//	public void checkingElectricalAndElectronicsProduct() {
//		System.out.println("Running TestCase- 7");
//		test=reports.createTest("Checking Electrical & Electronics Products","Validating Product Result Page");
//		ElectricalAndElectronicsPage electrical=new ElectricalAndElectronicsPage(driver);
//		electrical.validatingElectricalAndElectrncs(test);
//	}
//	
//	/*---------------------User Manual Redirection Button Validation-----------------*/
//	@Test(description ="User Manual Redirection Button" ,priority = 8)
//	public void userManualRedirecting() {
//		System.out.println("Running TestCase- 8");
//		test=reports.createTest("User Manual Redirecting","Validating URL");
//		BuyerServicesPage manual=new BuyerServicesPage(driver);
//		manual.userManualFornewUser(test);
//	}
//	
//	/*----------------------User Manual More information Validating-------------------*/
//	@Test(description ="User Manual More information" ,priority = 9)
//	public void userManualGivingMoreinfo() {
//		System.out.println("Running TestCase- 9");
//		test=reports.createTest("More info Validating","Validating Result Page");
//		BuyerServicesPage manual=new BuyerServicesPage(driver);
//		manual.moreInformation(test);
//	}
//	
//	/*--------------------------Contact US Page Validating----------------------------*/
//	@Test(description ="Contact Us FAQ" ,priority = 10)
//	public void contactUsFAQPage() {
//		System.out.println("Running TestCase- 10");
//		test=reports.createTest("Contact Us FAQ","Validating FAQ Page");
//		BuyerServicesPage faq=new BuyerServicesPage(driver);
//		faq.validatingContactUs(test);
//	}
//	
//	/*--------------------------Validating Browsing History----------------------------*/
//	@Test(description ="Validating Browsing History" ,priority = 11)
//	public void validatingBrowsingHistory() {
//		System.out.println("Running TestCase- 11");
//		test=reports.createTest("Browsing History","Validating Browsing History Page");
//		BuyerServicesPage history=new BuyerServicesPage(driver);
//		history.validatingBrowsingHistory(test);
//	}
//	
//	/*----------------Ordering TrendingProducts From Best Selling--------------*/
//	@Test(description ="Best Selling From TrendingProducts" ,priority = 12)
//	public void orderingAndAddingTrendingProductsToFav() throws InterruptedException{
//		System.out.println("Running TestCase- 12");
//		test=reports.createTest("Best Selling Trending Products","Validating Order Request Page");
//		TopRankingProductsPage topRank=new TopRankingProductsPage(driver);
//		topRank.bestSellingTopRankingPrdcts(test);
//	}
//	
	/*-----------------Inquiring Trending Products From New Releases------------*/
	@Test(description ="New Releases From Trending Products" ,priority = 13)
	public void inquringTrendingProducts() throws InterruptedException{
		System.out.println("Running TestCase- 13");
		test=reports.createTest("Newly Releases Trending Products","Validating Inquiry Page");
		TopRankingProductsPage topRank=new TopRankingProductsPage(driver);
		topRank.newReleaseTopRankingProducts(test);
	}
	
//	/*-----------------Validating Supplier Email Page------------*/
//	@Test(description ="Validating Supplier Email Page" ,priority = 14)
//	public void verifyingSupplierEmailPage(){
//		System.out.println("Running TestCase- 14");
//		test=reports.createTest("Supplier Email Page","Validating Supplier Email Result Page");
//		HelpMenuPage help=new HelpMenuPage(driver);
//		help.validatingSupplierEmail(test);
//	}
//	
//	/*-----------------Validating Web Site History Page------------*/
//	@Test(description ="Validating Made in China History" ,priority = 15)
//	public void verifyingWebSiteHistoryByContactUsPage(){
//		System.out.println("Running TestCase- 15");
//		test=reports.createTest("Made in China  Page History","Validating Web Site History Result Page");
//		HelpMenuPage help=new HelpMenuPage(driver);
//		help.validatingWebSiteHistory(test);
//	}
//	
//	/*-----------------Validating Secure Trading Services Page------------*/
//	@Test(description ="Validating Secure Trading Services Page" ,priority = 16)
//	public void verifyingSecureTradingServicesResultPage(){
//		System.out.println("Running TestCase- 16");
//		test=reports.createTest("Validating Secure Trading Services Page","Validating Web Site URL");
//		SecureTradingServicesPage trading=new SecureTradingServicesPage(driver);
//		trading.validatingSecureTradingPage(test);
//	}
//	
//	/*-----------------Validating Apply For Supplier Meet Page------------*/
//	@Test(description ="Validating Apply For Supplier Meet Page" ,priority = 17)
//	public void verifyingSupplierMeetApplyingPage(){
//		System.out.println("Running TestCase- 17");
//		test=reports.createTest("Validating Apply For Supplier Meet Page","Validating Applying Supplier Meet");
//		BuyerServicesPage meet=new BuyerServicesPage(driver);
//		meet.validatingMeetSupplierPage(test);
//	}
//	
//	/*-----------------Validating Display & Accessories Product Page------------*/
//	@Test(description ="Validating Display & Accessories Product Page" ,priority = 18)
//	public void verifyingDisplayAndAccessoriesProductPage(){
//		System.out.println("Running TestCase- 18");
//		test=reports.createTest("Validating Display & Accessories Product Page","Validating Display & Accessories Product");
//		SecureTradingServicesPage secureTrade=new SecureTradingServicesPage(driver);
//		secureTrade.validatingDisplayAndAccessoriesPage(test);
//	}
//	/*-----------------Validating Audited Suppliers' Report Page------------*/
//	@Test(description ="Validating Audited Suppliers' Report Page" ,priority = 19)
//	public void verifyingAuditedSuppliersReportPage(){
//		System.out.println("Running TestCase- 19");
//		test=reports.createTest("Validating Audited Suppliers' Page","Validating Result Page");
//		BuyerServicesPage buyer=new BuyerServicesPage(driver);
//		buyer.validatingAuditedSupplierPage(test);
//	}
//	/*-----------------Validating Secure Trading Service Product Page------------*/
//	@Test(description ="Validating Secure Trading Service Product Page" ,priority = 20)
//	public void verifyingSecureTradingServiceProductPage(){
//		System.out.println("Running TestCase- 20");
//		test=reports.createTest("Validating Secure Trading Service Page","Validating Result Page");
//		SecureTradingServicesPage trade=new SecureTradingServicesPage(driver);
//		trade.orderingFromSecureTradingServices(test);
//	}
//	
//	/*-----------------Validating Web Site URL after Clicking On Logo------------*/
//	@Test(description ="Validating Web Site URL" ,priority = 21,enabled = false)
//	public void verifyingWebApplicationUrlAfterClickingOnLogo(){
//		System.out.println("Running TestCase- 21");
//		test=reports.createTest("Validating Web Site URL","Validating Web Site URL");
//		HomePage home=new HomePage(driver);
//		home.validatingLogoUrl(test);
//	}
	
	
	/*---------------------------Closing All Opened Tabs------------------------------*/
	@AfterMethod
	public void closeBrwsr() {
		driver.quit();
		progress.updateProgress();
		
	}
	
	/*--------------Flushing Report and send it to Project Owner-----------------*/
	@AfterTest
	public void flushing()  {
		reports.flush();
//		System.out.println();
//		SendEmail email=new SendEmail();
//		System.out.println();
//		email.senEmail();
//		System.out.println();
//		System.out.println();
	}
}
