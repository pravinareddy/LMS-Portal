
package com.lmsapp.lms.webDriverManager;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.lmsapp.lms.utilities.ConfigReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {

	public WebDriver driver;
	
	
	public WebDriver getDriverManager() throws IOException {
		if (driver == null) {

			 String browserType = ConfigReader.getProperty("browser");
	            String url = ConfigReader.getProperty("Url");
		            if (browserType == null || url == null) {
		                throw new IllegalArgumentException("Browser type or URL not found in configuration");
		            }

               switch (browserType.toLowerCase()) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions chromeoption = new ChromeOptions();
                    chromeoption.addArguments("--headless");
                    driver = new ChromeDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    EdgeOptions edgeoption = new EdgeOptions();
                    edgeoption.addArguments("--headless");
                    driver = new EdgeDriver(edgeoption);
                    break;
                case "firefox":
                	 WebDriverManager.firefoxdriver().setup();
                	 FirefoxOptions firefoxoption = new FirefoxOptions();
                     firefoxoption.addArguments("--headless");
                     driver = new FirefoxDriver(firefoxoption);
                   break;         	
                 default:
                    throw new IllegalArgumentException("Unsupported browser: " + browserType);
            }

            driver.manage().deleteAllCookies();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
            driver.manage().window().maximize();
            driver.get(url);
        }
        return driver;
    }
		


}
