package com.dexter.test.config;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.dexter.utils.DataHandlers;

public class TestConfiguration {
	public static WebDriver getInstance() throws Exception
	{
		WebDriver driver=null;
		String browserType=DataHandlers.getDataFromPropertyFile("configuration","browser");
		String url = DataHandlers.getDataFromPropertyFile("configuration","URL");
		if ( browserType.equalsIgnoreCase("Firefox"))
		{
			System.setProperty("webdriver.firefox.marionette","F:/Softwares/Selenium Drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if ( browserType.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","F:/Softwares/Selenium Drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if ( browserType.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver","F:/Softwares/Selenium Drivers/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		return driver;
	}

}
