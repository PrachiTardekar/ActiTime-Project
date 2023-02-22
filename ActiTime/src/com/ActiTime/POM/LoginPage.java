package com.ActiTime.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

//Declaration
	@FindBy(id = "username")
	private WebElement un;
	
	@FindBy(name = "pwd")
	private WebElement pw;

	@FindBy(xpath = "//div[.='Login ']")
	private WebElement lg;
	
//initialization
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getUn() {
		return un;
	}

	public WebElement getPw() {
		return pw;
	}

	public WebElement getLg() {
		return lg;
	}
//business logic
	public void login(String username, String password) {
		un.sendKeys(username);
		pw.sendKeys(password);
		lg.click();
	}
	
}
