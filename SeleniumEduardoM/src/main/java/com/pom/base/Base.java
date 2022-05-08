package com.pom.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	//Capa 3 del POM (Equivalencia con src/test/java->Tareas->Computer.java)
	//Capa 2 DEL POM src/main/java->com.pom.poc->ComputerSearch
	//Capa 1 del POM src/test/java->com.computer->ComputerTest
	
	private WebDriver driver;
	
	/*
	 * Constructor Selenium
	 * @Author Eduardo Marquez
	 * @param driver
	 * @return
	 * @return N/A
	 * @throws N/A
	 */
	public Base(WebDriver driver) {
		this.driver = driver;
	}
	
	/*
	 * Chrome connection
	 * @Author Eduardo Marquez
	 * @param 
	 * @return
	 * @throws
	 * @date 05/08/2022
	 */
	public WebDriver SetupChromeDriver() {
		 ChromeOptions chromeOpt = new ChromeOptions();
		 WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver(chromeOpt);
		 return driver;
		 
	}
	
	/*
	 * Launch browser
	 * @Author Eduardo Marquez
	 * @param url
	 * @return
	 * @throws
	 * @date 05/08/2022
	 */
	public void launchBrowser(String url) {
		 driver.get(url);
		  driver.manage().window().maximize();
	}
	
	
	/*
	 * Type text into box
	 * @Author Eduardo Marquez
	 * @param locator, inputText
	 * @return
	 * @throws
	 * @date 05/08/2022
	 */
	public void type(By locator, String inputText) {
		driver.findElement(locator).sendKeys(inputText);	
	}
	
	/*
	 * Click object
	 * @Author Eduardo Marquez
	 * @param locator
	 * @return
	 * @throws
	 * @date 05/08/2022
	 */
	public void click(By locator) {
		driver.findElement(locator).click();
	}
	
	/*
	 * Select from dropdown
	 * @Author Eduardo Marquez
	 * @param locator, text
	 * @return
	 * @throws
	 * @date 05/08/2022
	 */
	public void select(By locator, String text) {
		Select drop = new Select(driver.findElement(locator));
		  drop.selectByVisibleText(text);
	}
	
	/*
	 * Driver close
	 * @Author Eduardo Marquez
	 * @param
	 * @return
	 * @throws
	 * @date 05/08/2022
	 */
	public void closeBrowser() {
		driver.close();
	}

}


