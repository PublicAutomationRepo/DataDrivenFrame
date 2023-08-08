package main;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Main implements ITestListener {

	public static String testCaseName;
	public static WebDriver driver;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	@Override
	public void onTestStart(ITestResult result) {

		 testCaseName = result.getName();
		 //System.out.println(testCaseName);

	}

	@BeforeSuite
	public void setUp() {
		extent = new ExtentReports();
		ExtentSparkReporter Reporter = new ExtentSparkReporter("ExtentReport.html");
		extent.attachReporter(Reporter);
		
	
	}

	@BeforeMethod
	public void before() {
		System.out.println("Before Method");
		launchBrowser(BrowserType.CHROME);
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");

	}

	@AfterMethod
	public void after() {

		System.out.println("After Method");
		driver.quit();
	}

	@AfterSuite
	public void setDown() {
		extent.flush();
	}

	public WebDriver launchBrowser(BrowserType browserType) {

		switch (browserType) {
		case CHROME:

			// String path = System.getProperty("user.dir")+"\\Drivers\\chrome.exe";
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			break;

		case FIREFOX:
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\Drivers\\geckodriver");
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			driver = new FirefoxDriver(firefoxOptions);
			break;

		default:
			throw new IllegalArgumentException("Unsupported browser type: " + browserType);
		}

		return driver;

	}

}
