package com.ActiTime.GenericLibrary;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.ActiTime.POM.HomePage;
import com.ActiTime.POM.LoginPage;

public class BaseClass {
	
	FileLibrary f=new FileLibrary();
	
	public static WebDriver driver;
	@BeforeSuite
	
	
	public void databaseconnection()
	{
		//we can write logic here to connect to the database
		Reporter.log("Database connected",true);
	}
	@AfterSuite
	
	public void databasedisconnection()
	{
		Reporter.log("Database disconnected",true);
	}
	
	@BeforeClass
	public void launchBrowser() throws IOException
	{
		 driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String url = f.readDataFromePropertyFile("url");
		//driver.get("https://demo.actitime.com/login.do");
		driver.get(url);
		Reporter.log("browser launched successfully",true);
	}
	@AfterClass
	
	public void closeBrowser()
	{
		Reporter.log("Browser closed successfully ",true);
	}
	
	@BeforeMethod
	
	public void LoginToActitime() throws IOException
	{
		String UN = f.readDataFromePropertyFile("username");
		//driver.findElement(By.id("username")).sendKeys(UN);
		
		String PW = f.readDataFromePropertyFile("password");
		//driver.findElement(By.name("pwd")).sendKeys(PW);

//POM class used here
		LoginPage lp= new LoginPage(driver);
		lp.login(UN, PW);
		
		
		//driver.findElement(By.xpath("//div[.='Login ']")).click();
		Reporter.log("Logged in successfully",true);
	}
	@AfterMethod
	public void logoutFromActitime() throws InterruptedException
	{
		HomePage hp=new HomePage(driver);
		Thread.sleep(3000);
		hp.getLgoutlnk().click();
		
		//driver.findElement(By.id("logoutLink")).click();
		Reporter.log("Logged out successfully",true);
	}

}
