package com.epam.tat19.jenkinstest.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {
	private final Logger logger = LogManager.getRootLogger();
	private static final String BASE_URL = "http://localhost:8080/login?from=%2F";

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "j_username")
	private WebElement userName;

	@FindBy(name = "j_password")
	private WebElement userPassword;

	@FindBy(id = "yui-gen1-button")
	private WebElement logInButton;

	@Override
	public void openPage() {// проверка отображения необходимой BASE_URL
		driver.navigate().to(BASE_URL);
		if ((!driver.getTitle().equals("Jenkins")) || (!driver.getCurrentUrl().equals(BASE_URL))) {
			throw new IllegalStateException("Wrong site page!");
		}
		logger.info("Login page opened");
	}

	public String getLogInButtonСolor() {//цвет кнопки "Log In"
		String color = logInButton.getCssValue("background-color");
		String[] hexValue = color.replace("rgba(", "").replace(")", "").split(",");
		int hexValue1 = Integer.parseInt(hexValue[0]);
		hexValue[1] = hexValue[1].trim();
		int hexValue2 = Integer.parseInt(hexValue[1]);
		hexValue[2] = hexValue[2].trim();
		int hexValue3 = Integer.parseInt(hexValue[2]);
		String actualColor = String.format("#%02x%02x%02x", hexValue1, hexValue2, hexValue3);
		return actualColor;
	}

	public void jenkinsAuthorization(String userName, String password) {//авторизация в Jenkins
		this.userName.sendKeys(userName);
		this.userPassword.sendKeys(password);
		logInButton.click();
	}

	

}
