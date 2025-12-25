package uistore;

import org.openqa.selenium.By;

public class TopRankingProductsUi {
	public static By bestSellingBtn=By.xpath("(//div[@class='trend-tab-item'])[1]");
	public static By titleValid=By.xpath("//span[@class='title']");
	public static By firstTopTrendingPrdct=By.xpath("//div[@class='prod-name']");
	public static By favIcon=By.xpath("//i[@class='J-fav-icon ob-icon icon-heart']");
	public static By startNowBtn=By.linkText("Start Order Request");
	public static By submitOrder=By.xpath("//button[text()='Submit Order']");
	public static By submitOrderValid=By.xpath("(//div[@class='section-title-text'])[1]");
	public static By signInValid=By.id("sign-in-submit");
	public static By newReleases=By.xpath("(//div[@class='trend-tab-item'])[3]");
	public static By scrollUptoAddInquiryBasket=By.xpath("(//div[@class='sr-proMainInfo-slide-page J-pic-dots-wrap'])[1]");
	public static By addInquiryBasket=By.xpath("//a[@title='Add Inquiry Basket to Compare']");
	public static By inquiryBasketIcon=By.xpath("//div[@class='nail-cart-wrap nail-action-item']");
	
	
}
