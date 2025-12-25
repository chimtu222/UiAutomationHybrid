package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import uistore.ComputerProductsPageUi;
import uistore.HomePageUi;
import utils.LoggerGeneretor;
import utils.ReporterMaker;
import utils.CaptureScreenshot;
import utils.DriverHelper;

public class ComputerProductsPage {
	ExtentTest test;
    WebDriver driver;
    DriverHelper helper;
    HomePage home;
public ComputerProductsPage(WebDriver driver){
    this.driver=driver;
    helper=new DriverHelper(driver); 
    home=new HomePage(driver);
}

/*------------------Wrapper Method---------------*/
/* Method Name:   computerTabletPc
 * Author Name:   10820894
 * Short Description:  Checking Computer Products
 * Return type: void
 * Parameter List: test
*/

	public void validatingComputerTabletPc(ExtentTest test) {
		
		/*------------------Calling hoveringOnAllCategories From Home Page---------------*/
				home.hoveringOnAllCategories(test);
				
				clickingOnComputerProducts(test);
				hoveringOnComputerSection(test);
				clickingOnTabletPc(test);
				verifyTabletPcPage(test);
				
	}		
	
	
	
	
	
	/*------------------------------Methods------------------------------------*/
	
		/*------------------Clicking On Computer Products---------------*/
		public void clickingOnComputerProducts(ExtentTest test){
			 try{ 
			     helper.clickOnElement(HomePageUi.computerProducts);
			     WebElement Text=driver.findElement(By.tagName("h1"));
			     String actualText=Text.getText();
			     String expectedText="Computer Products ";
			     helper.softAsserting(actualText, expectedText);
			     LoggerGeneretor.info("Clicked On Computer Products");
			     test.log(Status.PASS,"Clicked On Computer Products");
			     }catch(Exception e){
			             CaptureScreenshot.captureScreenShot("FailedComputerProducts");
			    	 	 String Path=ReporterMaker.captureScreenShot("FailedComputerProducts");
			    	 	 test.addScreenCaptureFromPath(Path, "FailedComputerProducts");
			             LoggerGeneretor.error("Failed to  click on Computer Products...");
			             test.log(Status.FAIL,"Failed to click On Computer Products...");
			     }
		}
		
		/*------------------Hovering On Computer Section---------------*/
		public void hoveringOnComputerSection(ExtentTest test){
		
			     try{
				     helper.hoverOverElement(ComputerProductsPageUi.computerSection);
				     WebElement Text=driver.findElement(ComputerProductsPageUi.TabletPc);
				     String actualText=Text.getText();
				     String expectedText="Tablet PC";
				     helper.softAsserting(actualText, expectedText);
				     LoggerGeneretor.info("Hovered On Computer Section");
				     test.log(Status.PASS,"Hovered On Computer Section");
				     }catch(Exception e){
				    	 	 CaptureScreenshot.captureScreenShot("FailedHoveringComputer Section");
				    	 	 String Path=ReporterMaker.captureScreenShot("FailedHoveringComputer Section");
				             test.addScreenCaptureFromPath(Path, "FailedHoveringComputer Section");
				             LoggerGeneretor.error("Failed to Hover On Computer Section...");
				             test.log(Status.FAIL,"Failed to Hover On Computer Section...");
				     }
		}
		
		/*------------------Clicking On Tablet PC---------------*/
		public void clickingOnTabletPc(ExtentTest test){
			     try{
			     helper.clickOnElement(ComputerProductsPageUi.TabletPc);
			     WebElement productTitle=driver.findElement(ComputerProductsPageUi.TabletPCValid);
			     String actualTitle=productTitle.getText();
			     String expectedTitle="Tablet PC";
			     helper.softAsserting(actualTitle, expectedTitle);
			     test.log(Status.PASS,"Clicked Tablet PC");
			     LoggerGeneretor.info("Clicked Tablet PC");
			     }catch(Exception e){
			    	     CaptureScreenshot.captureScreenShot("FailedTabletPC");
			    	     String Path=ReporterMaker.captureScreenShot("FailedTabletPC");
			             test.addScreenCaptureFromPath(Path, "FailedTabletPC");
			             LoggerGeneretor.error("Failed to Click Tablet PC...");
			             test.log(Status.FAIL,"Failed to Click Tablet PC...");
			     }
		}
			   
		/*------------------Verifying Tablet PC Page---------------*/
		public void verifyTabletPcPage(ExtentTest test){
			     try{
				     WebElement productTitle=driver.findElement(ComputerProductsPageUi.TabletPCValid);
				     String actualTitle=productTitle.getText();
				     String expectedTitle="Tablet PC";
				     Assert.assertTrue(actualTitle.contains(expectedTitle));
				     test.log(Status.PASS,"Tablet PC Page Found");
				     LoggerGeneretor.info("Tablet PC Page Found");
				     CaptureScreenshot.captureScreenShot("SuccessTabletPC");
				     String Path=ReporterMaker.captureScreenShot("SuccessTabletPC");
		             test.addScreenCaptureFromPath(Path, "SuccessTabletPC");
				     }catch(Exception e){
				             CaptureScreenshot.captureScreenShot("FailedTabletPCPage");
				             String Path=ReporterMaker.captureScreenShot("FailedTabletPCPage");
				             test.addScreenCaptureFromPath(Path, "FailedTabletPCPage");
				             LoggerGeneretor.error("Tablet PC Page Not Found...");
				             test.log(Status.FAIL,"Tablet PC Page Not Found...");
				      }
			     
	}
}
