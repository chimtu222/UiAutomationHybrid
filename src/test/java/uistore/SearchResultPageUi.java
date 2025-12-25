package uistore;

import org.openqa.selenium.By;

public class SearchResultPageUi {
	public static By SearchElmntnotFound=By.xpath("//strong[text()='No matches? Click to search for ']");
	public static By searchRsltFstprdct=By.xpath("//h2[@class='product-name']");
	public static By dropDownOpn=By.xpath("//li[@val='mobile phone']");    
	public static By productDetailsValid=By.xpath("//div[@class='product-details-title pointer J-prod-detail']");
	public static By smartPhone=By.xpath("//a[@ads-data='Smart Phone']");
	public static By contactSplr=By.xpath("(//a[@class='btns button-link-contact'])[1]");
	public static By contactSplrValid=By.xpath("//span[@class='m-channel-name-content']");
}
