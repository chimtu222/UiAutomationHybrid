package uistore;

import org.openqa.selenium.By;

public class BuyerServicesPageUi {
	public static By startNow=By.xpath("//a[@class='btn-large btn-main']");
	public static By learnMore=By.xpath("(//p[@class='r']/a)[7]");
	public static By learnMoreValid=By.xpath("//h2[text()='How to Avoid Fraud']");
	public static By frequentlyAskedQuestion=By.xpath("(//li[@class='menu-link']/a)[2]");
	public static By frequentlyAQValid=By.xpath("//div[@class='faq-head']");
	public static By categoriesKeywords=By.id("ca");
	public static By auditedSuppliers=By.id("ar");
	public static By productHistory=By.id("prod");
	public static By headerBrowsingHsrtyValid=By.tagName("h2");
	public static By meetSupplierLinkValid=By.xpath("//div[@class='m-channel-name']");
	public static By applyToMeetSupplierBtn=By.id("submit");
	public static By auditedSuppliersReportsFooter=By.className("m-footer");
	public static By verifyFooter=By.xpath("//span[text()='Contact Us:']");
	public static By backToTop=By.xpath("//a[@class='f-go-top']");
	public static By verifyAuditedSupplierPage=By.xpath("//div[@class='m-channel-name']");
	 
}
