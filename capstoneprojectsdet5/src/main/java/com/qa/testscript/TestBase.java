package com.qa.testscript;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


public class TestBase {
	WebDriver driver;
	Properties prop=new Properties();
	FileInputStream file;

	
	@Parameters("Browser")
	@BeforeClass
	public void startBrowser(String Browser) throws IOException {
		
		if(Browser.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(Browser.equalsIgnoreCase("Edge"))
		{
			System.setProperty("webdriver.edge.driver","C:\\Users\\KONDIB\\Desktop\\bhuvana\\capstoneprojectsdet5\\edgedriver\\msedgedriver.exe");
			driver=new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		file=new FileInputStream("C:\\Users\\KONDIB\\Desktop\\bhuvana\\capstoneprojectsdet5\\src\\main\\java\\com\\qa\\utilities\\properties");
		prop.load(file);
		driver.get(prop.getProperty("url"));
	}
	
	@AfterClass
	public void close() {
		driver.close();
	}
	
}



