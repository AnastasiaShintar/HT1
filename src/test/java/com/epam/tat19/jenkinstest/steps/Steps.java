package com.epam.tat19.jenkinstest.steps;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.epam.tat19.jenkinstest.factory.ChromeDriverCreator;
import com.epam.tat19.jenkinstest.factory.WebDriverCreator;
import com.epam.tat19.jenkinstest.pages.LoginPage;
import com.epam.tat19.jenkinstest.pages.MainPage;
import com.epam.tat19.jenkinstest.pages.ManagePage;
import com.epam.tat19.jenkinstest.pages.UsersPage;
import com.epam.tat19.jenkinstest.pages.CreateUserPage;
import com.epam.tat19.jenkinstest.pages.DeleteUserPage;

public class Steps {

	private WebDriver driver;

	WebDriverCreator chromeCreator = new ChromeDriverCreator();

	public void initChromeBrowser() {
		driver = chromeCreator.factoryMethod();
	}

	public void closeDriver() {
		ChromeDriverCreator.closeDriver();
	}

	public void openLoginPage(String userName, String password) {	//открыть страницу авторизации и авторизоваться
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.openPage();
		loginPage.jenkinsAuthorization(userName, password);
	}
	
	public void openManageJenkinsPage() {	//переход на страницу "Manage Jenkins"
		MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
		mainPage.clickManageJenkinsLink();
	}

	public String getLogInbuttonColor() {	//получение цвета кнопки "Log In"
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.openPage();
		String logInbuttonColor = loginPage.getLogInButtonСolor();
		return logInbuttonColor;
	}
	
	public String getCreateUserButtonСolor() {	//получение цвета кнопки "Create User"
		CreateUserPage createUserPage = PageFactory.initElements(driver, CreateUserPage.class);
		createUserPage.openPage();
		String createUserButtonСolor = createUserPage.getCreateUserButtonСolor();
		return createUserButtonСolor;
	}

	public void openManageUser() {	//переход на страницу "Users"
		ManagePage managePage = PageFactory.initElements(driver, ManagePage.class);
		managePage.clickManageUsersLink();

	}
	
	public void checkInput() {
		CreateUserPage createUserPage = PageFactory.initElements(driver, CreateUserPage.class);
		createUserPage.checkUsernameInput();
		createUserPage.checkPasswordInput();
		createUserPage.checkConfirmPaswordInput();
		createUserPage.checkFullNameInput();
		createUserPage.checkEmailAddressInput();
	}

	public void createUser(String userName, String password, String confirmPasword, String fullName, String emailAddress) {	//создание нового пользователя
		CreateUserPage createUserPage = PageFactory.initElements(driver, CreateUserPage.class);
		ManagePage managePage = PageFactory.initElements(driver, ManagePage.class);
		managePage.clickCreateUserLink();
		checkInput();
		createUserPage.createNewUser(userName,password, confirmPasword, fullName, emailAddress);
	}
	
	public void createUserButtonClick() {
		CreateUserPage createUserPage = PageFactory.initElements(driver, CreateUserPage.class);
		createUserPage.createUserButtonClick();
	}

	public void deleteUser() {	//удаление пользователя
		UsersPage usersPage = PageFactory.initElements(driver, UsersPage.class);
		usersPage.clickDeleteUserButton();
		DeleteUserPage deleteUserPage = PageFactory.initElements(driver, DeleteUserPage.class);
		deleteUserPage.getAcceptDeleteUserСolor();
	}
	
	public void acceptDeleteUserButtonClick() {
		DeleteUserPage deleteUserPage = PageFactory.initElements(driver, DeleteUserPage.class);
		deleteUserPage.acceptDeleteUser();
	}
	
	public String getacceptDeleteUserButtonColor() {
		DeleteUserPage deleteUserPage = PageFactory.initElements(driver, DeleteUserPage.class);
		String acceptDeleteUserButtonColor = deleteUserPage.getAcceptDeleteUserСolor();
		return acceptDeleteUserButtonColor;
	}
	
	public void checkDeletedUser() {
		UsersPage usersPage = PageFactory.initElements(driver, UsersPage.class);
		usersPage.checkDeletedUser();
		usersPage.checkDeleteHref();
	}

	public void deleteAdmin() {		//удаление администратора
		UsersPage usersPage = PageFactory.initElements(driver, UsersPage.class);
		usersPage.checkDeleteAdminHref();
	}

}
