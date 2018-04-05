package com.epam.tat19.jenkinstest.factory;

import org.openqa.selenium.WebDriver;

public abstract class WebDriverCreator {
	
    protected WebDriver driver;

    public abstract WebDriver factoryMethod();

}
