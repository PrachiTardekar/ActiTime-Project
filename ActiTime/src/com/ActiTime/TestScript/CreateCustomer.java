package com.ActiTime.TestScript;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.ActiTime.GenericLibrary.BaseClass;
import com.ActiTime.GenericLibrary.FileLibrary;
import com.ActiTime.POM.HomePage;
import com.ActiTime.POM.TaskPage;

public class CreateCustomer extends BaseClass {
	FileLibrary fl=new FileLibrary();

	@Test
	public void CreateCustomer() throws EncryptedDocumentException, IOException, InterruptedException {
		HomePage hp=new HomePage(driver);
		hp.getTasklnk().click();
		
		
		TaskPage tp=new TaskPage(driver);
		String custname = fl.readDataFromExcelfile("Sheet1", 1, 2);
		String description= fl.readDataFromExcelfile("Sheet1", 2, 1);
		tp.completetask(custname, description);
		
		String expected = custname;
		System.out.println(expected);
		 String actualdata = driver.findElement(By.xpath("//div[@title='"+custname+"']")).getText();
		 SoftAssert s=new SoftAssert(); //soft assert
		 s.assertEquals(expected, actualdata);
		 Reporter.log("assertion pass", true);
		 s.assertAll();
		
	}

		
}
