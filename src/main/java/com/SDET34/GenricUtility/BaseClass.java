package com.SDET34.GenricUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.hospitalManagementSystem.Repo.HomePage;
import com.hospitalManagementSystem.Repo.PatientLoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public  WebDriver driver;
	public JavaUtility jutil;

	public String url ;
	public  String AdminUsername;
	public String AdminPassword;
	public String PatienrUserName;
	public String PatientPassword;
	public String DoctorUserName;
	public String DoctorPassword;
	public String browser;
	public String ModuleName;
	public  long timeouts;
	
	public HomePage hp; 
	public   int Random;
	public MsExcelUtility msExcelUtility;
	public PropertyFileUtility propertyFileUtility;
	public WebDriverUtility webDriverUtility ;
	public static WebDriver staticdriver;
	/**
	 * This method use to open the excel,propertyfile,Getconnection with datbase.
	 * @throws Throwable
	 * 
	 */
	@BeforeSuite(groups="baseClass")
	public void beforeSuite() throws Throwable{



	}
	/**
	 * BeforeTest added to the  Basic configuration 
	 */
	@BeforeTest
	public void beforeTest() {
		
	}

	/**
	 * This method use to open the class,lanuch the browser navigate the application fetch the data from propertyfile  and browser Setting instance of common POM class
	 * @throws IOException
	 * dute nonstatic create object in the @beforeClass 
	 */

	//@Parameters(value="browser")
	@BeforeClass(groups="baseClass")
	public void beforClass() throws IOException {
		jutil=new JavaUtility();
		msExcelUtility= new MsExcelUtility();
		propertyFileUtility=new PropertyFileUtility();
		propertyFileUtility.openPropertyFile(IconstantPath.PROPERTYFILEPATH);
		
		browser=System.getProperty("BROWSER");
		url=System.getProperty("URL");
		//username=System.getProperty("USERNAME");
		//password=System.getProperty("PASSWORD");
		
		msExcelUtility.openExcel(IconstantPath.EXCELPATH);
		url = propertyFileUtility.getDataFromPropertFile("url");
		System.out.println(url);
		AdminUsername=propertyFileUtility.getDataFromPropertFile("AdminUsername");
		System.out.println(AdminUsername);
		AdminPassword =propertyFileUtility.getDataFromPropertFile("AdminPassword");
		browser = propertyFileUtility.getDataFromPropertFile("AdminPassword");
		
		PatienrUserName=propertyFileUtility.getDataFromPropertFile("PatienrUseName");
		System.out.println(PatienrUserName);
		PatientPassword =propertyFileUtility.getDataFromPropertFile("PatientPassword");
		browser = propertyFileUtility.getDataFromPropertFile("PatientPassword");
		
		DoctorUserName=propertyFileUtility.getDataFromPropertFile("DoctorUserName");
		System.out.println(DoctorUserName);
		DoctorPassword =propertyFileUtility.getDataFromPropertFile("DoctorPassword");
		browser = propertyFileUtility.getDataFromPropertFile("DoctorPassword");
		
		String timeout = propertyFileUtility.getDataFromPropertFile("timeout");
		timeouts = jutil.stringToLong(timeout);
		Random = jutil.getRandomNumber(1000);

		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case"firefox":
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			break;
			
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			break;

		default:
			System.out.println("please specify proper browser key");
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			break;

		}
		staticdriver=driver;
		webDriverUtility = new WebDriverUtility();
		webDriverUtility.navigateApp(url, driver);
		webDriverUtility.browserSetting(driver, timeouts);
		


	}

	/**
	 * This method use to login the application
	 */
	@BeforeMethod(groups="baseClass")
	public void beforMethod() {
		switch (ModuleName) {
		case "patient":
			hp = new HomePage(driver);
			hp.patientloginLink();
			PatientLoginPage patientLoginPage = new PatientLoginPage(driver);
			patientLoginPage.patientLoginAction(PatienrUserName, PatientPassword);
			break;
		case"doctor":
			
			break;
			
		case "admin":
			
			break;

		}
		




	}

	/**
	 * This method use to logout the application
	 */
	@AfterMethod(groups="baseClass")
	public void afterMethpd() {
		
	}

	/**
	 * This method use to quit the browser
	 */
	@AfterClass(groups="baseClass")
	public void afterClass() {
		webDriverUtility.quitBrowser(driver);
	}
	/**
	 * This method use to close the excel,close dataBase
	 * @throws IOException
	 */
	@AfterSuite(groups="baseClass")
	public void afterSuite() throws IOException {
		msExcelUtility.saveExcel(IconstantPath.EXCELPATH);
		msExcelUtility.closeExcel();


	}


}
