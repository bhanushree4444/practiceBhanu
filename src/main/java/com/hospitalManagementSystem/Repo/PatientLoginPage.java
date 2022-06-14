package com.hospitalManagementSystem.Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PatientLoginPage {
	@FindBy(name ="username" )
	private WebElement userNameTxt;
	
	@FindBy(name ="password")
	private WebElement passwordTxt;
	
	@FindBy(name ="submit")
	private WebElement submitBtn;
	
	
	public  PatientLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void patientLoginAction(String username,String password) {
		userNameTxt.sendKeys(username);
		passwordTxt.sendKeys(password);
		submitBtn.click();
	}
	
	


}
