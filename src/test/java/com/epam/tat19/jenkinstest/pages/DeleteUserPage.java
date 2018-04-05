package com.epam.tat19.jenkinstest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class DeleteUserPage extends AbstractPage{

	public DeleteUserPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "yui-gen3-button")
	private WebElement acceptDeleteUser;
	
	public void hexToRgbaConvertColor() {
		
	}
	
	public String getAcceptDeleteUserСolor() {
		
		String color = acceptDeleteUser.getCssValue("background-color");
		String[] hexValue = color.replace("rgba(", "").replace(")", "").split(",");
	 
		int hexValue1=Integer.parseInt(hexValue[0]);
		hexValue[1] = hexValue[1].trim();
		int hexValue2=Integer.parseInt(hexValue[1]);
		hexValue[2] = hexValue[2].trim();
		int hexValue3=Integer.parseInt(hexValue[2]);
		 
		String actualColor = String.format("#%02x%02x%02x", hexValue1, hexValue2, hexValue3);
		return actualColor;		
	}
	
	public void acceptDeleteUser() {
		acceptDeleteUser.click();
	}


	@Override
	public void openPage() {
	}

}
