package uistore;

import org.openqa.selenium.By;

public class SecureTradingServicesPageUi {
	public static By validateSecureTradingPage=By.xpath("//div[@class='m-channel-name']");
	public static By buyersGuide=By.xpath("//li[@class='info-item']");
	public static By validateBuyersGuide=By.xpath("//h1[@class='doc-title']");
	public static By secureTradingImg=By.xpath("//img[@class='lazyload']");
	public static By scrollDownUpToRefundAndReturn=By.xpath("//div[@class='J-pub-bock pub-wrap pub-faq-wrap']");
	public static By readReturnAndRefundRulesLink=By.xpath("//a[@class='sub-link link']");
	public static By validateReturnAndRefundPage=By.xpath("//div[@id='return']/div/h1");
	public static By scrollToDisplayAndAccessories=By.id("J-nav-wrap");
	public static By displayAndAccessories=By.xpath("//li[normalize-space()='Display & Accessories']");
	public static By firstDisplayAndAccessoriesPrdct=By.xpath("//div[@class='J-prod-list prod-list active']/ul/li");
	public static By firstDisplayAndAccessoriesPrdctValid=By.xpath("//div[@class='product-details-title pointer J-prod-detail']");
}
