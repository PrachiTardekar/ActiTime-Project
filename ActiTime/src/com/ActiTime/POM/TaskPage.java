package com.ActiTime.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TaskPage {

	@FindBy(xpath ="//div[.='Add New']")
	private WebElement addnewbtn;
	
	@FindBy(xpath ="//div[.='+ New Customer']")
	private WebElement newcust;
	
	@FindBy(xpath ="(//input[@placeholder='Enter Customer Name'])[2]")
	private WebElement custname;
	
	@FindBy(xpath ="//textarea[@placeholder='Enter Customer Description']")
	private WebElement custdesp;
	
	@FindBy(xpath ="(//div[@class='dropdownButton'])[15]")
	private WebElement dropdwn;
	
	@FindBy(xpath="(//div[.='Our company'])[10]")
	private WebElement ourcomp;
	
	@FindBy(xpath ="//div[.='Create Customer']")
	private WebElement createbtn;
	
	public TaskPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getAddnewbtn() {
		return addnewbtn;
	}
	
	

	public WebElement getNewcust() {
		return newcust;
	}

	public WebElement getCustname() {
		return custname;
	}

	public WebElement getCustdesp() {
		return custdesp;
	}

	public WebElement getDropdwn() {
		return dropdwn;
	}

	public WebElement getOurcomp() {
		return ourcomp;
	}

	public WebElement getCreatebtn() {
		return createbtn;
	}
	
//business logic or generic method
	
	public void completetask(String Custname, String Discription) throws InterruptedException {
		addnewbtn.click();
		newcust.click();
		custname.sendKeys(Custname);
		custdesp.sendKeys(Discription);
		dropdwn.click();
		Thread.sleep(3000);
		ourcomp.click();// its locator is keep on changing 
		createbtn.click();
	}
	
}
