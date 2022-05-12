package com.computer;

import org.testng.annotations.Test;

import com.pom.base.Base;
import com.pom.base.GlobalVariables;
import com.pom.poc.ComputerSearch;

import org.testng.annotations.BeforeTest;

import java.io.FileNotFoundException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class UpdateComputer {
	
	
	WebDriver driver;
	Base base;
	ComputerSearch computer;
	
	//Instancia
	String search,company;
	
	 @BeforeTest
	 public void beforeTest() throws FileNotFoundException {
		System.out.println("BeforeTest");
			
		base = new Base(driver);
		driver = base.SetupChromeDriver();
		computer = new ComputerSearch(driver);
			
		//Setup data
		this.search = base.getJSONValue("data", "search");
		this.company = base.getJSONValue("data", "company");
			
		  }

  @Test
  public void tc001() {
	  	System.out.println("tc002");
		base.launchBrowser(GlobalVariables.URL);
		computer.UpdateComputer(search, company);
  }
 
  @AfterTest
  public void afterTest() {  
	  System.out.println("AfterTest");
	  driver.close();
  }

}
