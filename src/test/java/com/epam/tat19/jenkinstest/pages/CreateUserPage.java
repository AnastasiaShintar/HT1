package com.epam.tat19.jenkinstest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class CreateUserPage extends AbstractPage {
	
	private final String INPUT_TYPE_TEXT = "text";
	private final String INPUT_TYPE_PASSWORD = "PASSWORD";

	public CreateUserPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "username")
	private WebElement userName;

	@FindBy(name = "password1")
	private WebElement password;

	@FindBy(name = "password2")
	private WebElement confirmPasword;

	@FindBy(name = "fullname")
	private WebElement fullName;

	@FindBy(name = "email")
	private WebElement emailAddress;

	@FindBy(id = "yui-gen3-button")
	private WebElement createUserButton;

	public String getCreateUserButtonСolor() {
		String color = createUserButton.getCssValue("background-color");
		String[] hexValue = color.replace("rgba(", "").replace(")", "").split(",");
		int hexValue1 = Integer.parseInt(hexValue[0]);
		hexValue[1] = hexValue[1].trim();
		int hexValue2 = Integer.parseInt(hexValue[1]);
		hexValue[2] = hexValue[2].trim();
		int hexValue3 = Integer.parseInt(hexValue[2]);
		String actualColor = String.format("#%02x%02x%02x", hexValue1, hexValue2, hexValue3);
		return actualColor;
	}

	public void createNewUser(String userName, String password, String confirmPasword, String fullName, String emailAddress) {
		this.userName.sendKeys(userName);
		this.password.sendKeys(password);
		this.confirmPasword.sendKeys(confirmPasword);
		this.fullName.sendKeys(fullName);
		this.emailAddress.sendKeys(emailAddress);
	}
	
	public void checkUsernameInput() {
		userName.getTagName().equals(INPUT_TYPE_TEXT);
		Assert.assertTrue(userName.getText().isEmpty());
	}
	public void checkPasswordInput() {
		password.getTagName().equals(INPUT_TYPE_PASSWORD);
		Assert.assertTrue(userName.getText().isEmpty());
	}
	public void checkConfirmPaswordInput() {
		confirmPasword.getTagName().equals(INPUT_TYPE_PASSWORD);
		Assert.assertTrue(userName.getText().isEmpty());
	}
	public void checkFullNameInput() {
		fullName.getTagName().equals(INPUT_TYPE_TEXT);
		Assert.assertTrue(userName.getText().isEmpty());
	}
	public void checkEmailAddressInput() {
		emailAddress.getTagName().equals(INPUT_TYPE_TEXT);
		Assert.assertTrue(userName.getText().isEmpty());
	}
	
	
	
	public void createUserButtonClick() {
		createUserButton.click();
	}

	@Override
	public void openPage() {
	}

}
