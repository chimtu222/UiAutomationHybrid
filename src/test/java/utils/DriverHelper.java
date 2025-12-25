package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.Set;

public class DriverHelper {
    private WebDriver driver;

    public DriverHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForElementToBeVisible(By locator, int timeoutInSeconds) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (Exception e) {
        
            e.printStackTrace();
        }
    }

    public void clickOnElement(By locator) {
        try {
        	WebElement webElement = driver.findElement(locator);
        	JavascriptExecutor js = (JavascriptExecutor) driver;
        	js.executeScript("arguments[0].style.border='3px solid green'",webElement);
            webElement.click();
        } catch (Exception e) {
            
            e.printStackTrace();
        }
    }

    public void sendKeys(By locator, String data) {
        try {
        	WebElement webElement = driver.findElement(locator);
        	JavascriptExecutor js = (JavascriptExecutor) driver;
        	js.executeScript("arguments[0].style.border='3px solid green'",webElement);
            webElement.sendKeys(data);
        } catch (Exception e){
        	e.printStackTrace();
        }
    }
        
        public void softAsserting(String actual, String expected) {
            try {
            	 SoftAssert softAssert = new SoftAssert();
            	 softAssert.assertEquals(actual, expected);
            } catch (Exception e) {
            
                e.printStackTrace();
            }
    }

    public String getText(By locator) {
        try {
        	WebElement webElement = driver.findElement(locator);
        	JavascriptExecutor js = (JavascriptExecutor) driver;
        	js.executeScript("arguments[0].style.border='3px solid green'",webElement);
            return webElement.getText();
        } catch (Exception e) {
            
            e.printStackTrace();
            return null;
        }
    }

    public void jsClick(By locator) {
        try {
        	WebElement element = driver.findElement(locator);
        	JavascriptExecutor js = (JavascriptExecutor) driver;
        	js.executeScript("arguments[0].style.border='3px solid green'",element);
            js.executeScript("arguments[0].click();", element);
        } catch (Exception e) {
         
            e.printStackTrace();
        }
    }

    public void javascriptScroll(By locator) {
        try {
        	WebElement element = driver.findElement(locator);
        	JavascriptExecutor js = (JavascriptExecutor) driver;
        	js.executeScript("arguments[0].style.border='3px solid green'",element);
            js.executeScript("arguments[0].scrollIntoView();", element);
        } catch (Exception e) {
           
            e.printStackTrace();
        }
    }

    public void switchToNewWindow() {
        try {
            Set<String> windowHandles = driver.getWindowHandles();
            for (String windowHandle : windowHandles) {
                if (!windowHandle.isEmpty()) {
                    driver.switchTo().window(windowHandle);
                } else {
                    throw new Exception("New window could not be retrieved");
                }
            }
        } catch (Exception e) {
            
            e.printStackTrace();
        }
    }

    public void enterAction(By locator) {
        try {
        	WebElement webElement = driver.findElement(locator);
        	JavascriptExecutor js = (JavascriptExecutor) driver;
        	js.executeScript("arguments[0].style.border='3px solid green'",webElement);
            webElement.sendKeys(Keys.ENTER);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void hoverOverElement(By locator) {
        try {
        	WebElement webElement = driver.findElement(locator);
        	JavascriptExecutor js = (JavascriptExecutor) driver;
        	js.executeScript("arguments[0].style.border='3px solid green'",webElement);
            Actions actions = new Actions(driver);
            actions.moveToElement(webElement).perform();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void doubleClickOnElement(By locator) {
        try {
        	WebElement webElement = driver.findElement(locator);
        	JavascriptExecutor js = (JavascriptExecutor) driver;
        	js.executeScript("arguments[0].style.border='3px solid green'",webElement);
            Actions actions = new Actions(driver);
            actions.doubleClick(webElement).perform();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
