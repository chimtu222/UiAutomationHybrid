package uistore;

import org.openqa.selenium.By;

public class HelpMenuPageUi {

	public static By learnMoreTips=By.xpath("//a[text()='Learn more tips for online safe trading >']");
	public static By supplierEmail=By.cssSelector("a[href*='//membercenter.made-in-china.com/email-verify']");
	public static By supplierEmailValidate=By.tagName("h2");
	
	public static By whyMadeInChinaValidate=By.className("title");
	public static By scrollDownToContactUs=By.xpath("//div[@class='cont-block abt-storie']");
	public static By ContactUsValidate=By.xpath("//div[@class='cont-block abt-contact-us']/div/div[1]");
}
