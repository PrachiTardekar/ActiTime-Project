package com.ActiTime.TestScript;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Assert1 {

	@Test
	public void demoassertion() {
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		String expectedtitle = "soogle";
		String actualtitle = driver.getTitle();
		Assert.assertEquals(expectedtitle, actualtitle);
		driver.quit();
	}
}
