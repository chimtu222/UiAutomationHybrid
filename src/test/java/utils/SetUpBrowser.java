package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SetUpBrowser {
    public static WebDriver driver;
    public static FileInputStream file;
    public static Properties prop;

    public void loadProperties() throws IOException {
        String propertiesPath = System.getProperty("user.dir") + "/config/browser.properties";
        try {
            file = new FileInputStream(propertiesPath);
            prop = new Properties();
            prop.load(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void openBrowser() {
        try {
            loadProperties();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String executionType = prop.getProperty("executiontype");
        String browserName = prop.getProperty("browser");
        boolean headless = Boolean.parseBoolean(prop.getProperty("headless", "false"));

        if ("remote".equalsIgnoreCase(executionType)) {
            URL gridUrl;
            try {
                gridUrl = new URL(prop.getProperty("gridurl"));
                driver = new RemoteWebDriver(gridUrl, new ChromeOptions());
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        } else if ("local".equalsIgnoreCase(executionType)) {
            switch (browserName.toLowerCase()) {
                case "chrome":
                    ChromeOptions chromeOptions = new ChromeOptions();
                    if (headless) {
                        chromeOptions.addArguments("--headless");
                        chromeOptions.addArguments("--disable-gpu");
                        chromeOptions.addArguments("--window-size=1920,1080");
                    }
                    driver = new ChromeDriver(chromeOptions);
                    break;

                case "edge":
                    driver = new EdgeDriver();
                    break;

                case "firefox":
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    if (headless) {
                        firefoxOptions.addArguments("--headless");
                    }
                    driver = new FirefoxDriver(firefoxOptions);
                    break;

                default:
                    System.err.println("Unsupported browser: " + browserName);
                    break;
            }
        } else {
            System.err.println("Invalid execution type: " + executionType);
        }

        if (driver != null) {
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get(prop.getProperty("url"));
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(18));
        }
    }
}
