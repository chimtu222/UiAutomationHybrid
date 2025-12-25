package uistore;

import org.openqa.selenium.By;

public class HomePageUi {
	  public static By appLogo=By.xpath("//div[@class='nail-logo']");
	  public static By SigninJoin=By.cssSelector("div.nl-refer");
	  public static By Signin=By.xpath("//a[@class='nail-btn main-btn']");
	  public static By searchBar=By.name("word");
	  public static By searchBtn=By.id("J-nail-search-submit");
	  public static By allCategories=By.xpath("(//a[@class='nail-link entr-link'])[2]");
	  public static By computerProducts=By.xpath("(//span[text()='Computer Products'])[2]");
	  public static By electricalElectrncs=By.xpath("(//span[text()='Electrical & Electronics'])[2]");
	  public static By buyer=By.xpath("//a[text()='Buyer']");
	  public static By newUserGuide=By.xpath("//a[text()='New User Guide']");
	  public static By contactUS=By.xpath("//a[text()='Contact Us']");
	  public static By browsingHistory=By.xpath("//a[text()='Browsing History']");
	  public static By topRankingProducts=By.xpath("//a[normalize-space()='Top-ranking Products']");
	  public static By helpDropDown=By.xpath("//a[text()='Help']");
	  public static By submitAComplaint=By.xpath("//a[text()='Submit a Complaint']");
	  public static By whyMadeInChina=By.xpath("//a[text()='Why Made-in-China.com']");
	  public static By secureTradingServices=By.xpath("//a[normalize-space()='Secured Trading Service']");
	  public static By meetSupplierLink=By.xpath("//a[text()='Meet Suppliers']");
	  public static By auditedSuppliersReports=By.cssSelector("a[href*='//www.made-in-china.com/audited-suppliers']");
	  
}
