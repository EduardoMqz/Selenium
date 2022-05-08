package com.pom.poc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.pom.base.Base;

public class ComputerSearch extends Base {
	//Capa 3 del POM src/main/java->com.pom.base->Base.java
	//Capa 2 DEL POM (Equivalencia con src/test/java->Tareas->Computer.java)
	//Capa 1 del POM src/test/java->com.computer->ComputerTest.java
	
	public ComputerSearch(WebDriver driver) {
		super(driver);

	}
	
	//Object
	By btnAdd = By.xpath("//a[@id='add']");
	By txtName = By.xpath("//input[@id='name']");
	By txtIntroduces = By.xpath("//input[@id='introduced']");
	By txtdiscontinued = By.xpath("//input[@id='discontinued']");
	By ddCompany = By.id("company");
	By btnSubmit = By.xpath("//input[@type='submit']");
	
	By txtSearchBox = By.xpath("//input[@id='searchbox']");
	By btnSubmitSearch = By.xpath("//input[@id='searchsubmit']");
	By tblComputer = By.xpath("//tbody/tr[1]/td[1]/a");
	
	//Customize methods
	public void NewComputer(String name, String introduced , String discontinued, String company) {
		click(btnAdd);
		type(txtName, name);
		type(txtIntroduces, introduced);
		type(txtdiscontinued, discontinued);
		select(ddCompany, company);
		click(btnSubmit);
	}
	
	public void UpdateComputer(String search, String company) {
		type(txtSearchBox, search);
		click(btnSubmitSearch);
		click(tblComputer);
		
		select(ddCompany, company);
		click(btnSubmit);
	}
	
	
	
	
	
	

}
