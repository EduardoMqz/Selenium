package com.computer;

import org.testng.annotations.Test;
import com.pom.base.Base;
import com.pom.base.GlobalVariables;
import com.pom.poc.ComputerSearch;
import org.testng.annotations.BeforeTest;

import java.io.FileNotFoundException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class ComputerTest {
  
	//Capa 3 del POM src/main/java->com.pom.base->Base.java
	//Capa 2 DEL POM src/main/java->com.pom.poc->ComputerSearch
	//Capa 1 del POM (Equivalencia con src/test/java->Tareas->Computer.java)
	
	WebDriver driver;
	Base base;
	ComputerSearch computer;
	
	//Instancia
	String name, introduced, discontinued, company, search,company2;
	
	@BeforeTest
	  public void beforeTest() throws FileNotFoundException {
		System.out.println("BeforeTest");
		
		base = new Base(driver);
		driver = base.SetupChromeDriver();
		computer = new ComputerSearch(driver);
		
		//Setup data
		this.name = base.getJSONValue("data", "name");
		this.introduced = base.getJSONValue("data", "introduced");
		this.discontinued = base.getJSONValue("data", "discontinued");
		this.company = base.getJSONValue("data", "company");
		
	  }
	
	@Test
	public void tc001() {
		System.out.println("tc001");
		base.launchBrowser(GlobalVariables.URL);
		computer.NewComputer(name, introduced, discontinued, company);
		
  }
	
	
	
  @AfterTest
  public void afterTest() {
	  System.out.println("AfterTest");
	  driver.close();
  }

}
