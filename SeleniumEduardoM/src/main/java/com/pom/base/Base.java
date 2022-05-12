package com.pom.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

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
	
	
	/**
	 * Get Data from JSON file (Directly)
	 * 
	 * @author Ricardo Avalos
	 * @param jsonFile, jsonKey
	 * @return jsonValue
	 * @throws FileNotFoundException
	 */
	public String getJSONValue(String jsonFileObj, String jsonKey) throws FileNotFoundException {
		try {

			// JSON Data
			InputStream inputStream = new FileInputStream(GlobalVariables.PATH_JSON_DATA + jsonFileObj + ".json");
			JSONObject jsonObject = new JSONObject(new JSONTokener(inputStream));

			// Get Data
			String jsonValue = (String) jsonObject.get(jsonKey);
			return jsonValue;

		} catch (FileNotFoundException e) {
			Assert.fail("JSON file is not found");
			return null;
		}
	}
	
	
	/**
	 * Implicity Wait
	 * 
	 * @author ricardo.avalos
	 */
	public void implicitlyWait(int seconds) {
		try {
			driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
		} catch(TimeoutException e) {
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * Wait For Element Present (Explicit wait)
	 * 
	 * @author Ricardo Avalos
	 * @param locator
	 * @return
	 * @throws TimeoutException
	 */
	public void waitForElementPresent(By locator) throws TimeoutException {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
	}
	
	
	/*
	 * Take screenshot
	 * 
	 * @author Ricardo Avalos
	 * @throws IOException
	 */
	public String takeScreenshot(String fileName){
		try {
			String pathFileName= GlobalVariables.PATH_SCREENSHOTS + fileName + ".png";
			Screenshot screenshot = new AShot().takeScreenshot(driver);
			ImageIO.write(screenshot.getImage(), "PNG", new File(pathFileName));
			return pathFileName;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}

	}

}


