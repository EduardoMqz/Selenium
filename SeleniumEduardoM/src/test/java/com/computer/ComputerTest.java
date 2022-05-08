package com.computer;

import org.testng.annotations.Test;
import com.pom.base.Base;
import com.pom.poc.ComputerSearch;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class ComputerTest {
  
	//Capa 3 del POM src/main/java->com.pom.base->Base.java
	//Capa 2 DEL POM src/main/java->com.pom.poc->ComputerSearch
	//Capa 1 del POM (Equivalencia con src/test/java->Tareas->Computer.java)
	
	WebDriver driver;
	Base base;
	ComputerSearch computer;
	
	@BeforeTest
	  public void beforeTest() {
		System.out.println("BeforeTest");
		
		base = new Base(driver);
		driver = base.SetupChromeDriver();
		computer = new ComputerSearch(driver);
		
	  }
	
	@Test
	public void tc001() {
		System.out.println("tc001");
		
		base.launchBrowser(null);
		computer.NewComputer(null, null, null, null);
		
		
  }
	
	@Test
	public void tc002() {
		System.out.println("tc002");
	  }
	
	
	@Test
	public void tc003() {
		System.out.println("tc003");
	  }
	
	
  

  @AfterTest
  public void afterTest() {
	  System.out.println("AfterTest");
  }

}
