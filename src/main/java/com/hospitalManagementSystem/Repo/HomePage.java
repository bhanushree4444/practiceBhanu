package com.hospitalManagementSystem.Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	@FindBy(xpath ="//h3[.='Patients']/ancestor::div//span/a[@href='hms/user-login.php']")
	private WebElement patientloginLink;
	
	public  HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void patientloginLink() {
		patientloginLink.click();
	}
	

}
