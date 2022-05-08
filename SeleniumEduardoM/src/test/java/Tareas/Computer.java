package Tareas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Computer {
  @Test
  public void setup() {
	  
	  ChromeOptions chromeOpt = new ChromeOptions();
	  WebDriverManager.chromedriver().setup();
	  WebDriver driver = new ChromeDriver(chromeOpt);
	  
	  driver.get("https://computer-database.gatling.io/computers");
	  driver.manage().window().maximize();
	  
	//realtive Xpath  -> input[@id='add']  
	  driver.findElement(By.xpath("//a[@id='add']")).click();
	  
	  driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Eduardo");
	  driver.findElement(By.xpath("//input[@id='introduced']")).sendKeys("1995-02-08");
	  driver.findElement(By.xpath("//input[@id='discontinued']")).sendKeys("2005-11-16");
	  Select drop = new Select(driver.findElement(By.id("company")));
	  drop.selectByVisibleText("RCA");
	  driver.findElement(By.xpath("//input[@type='submit']")).click();
	  
	  String text = driver.findElement(By.xpath("//div/strong")).getText();
	  Assert.assertEquals("Done !", text);
	  
	  
	  driver.findElement(By.xpath("//input[@id='searchbox']")).sendKeys("ASCI Thors Hammer");
	  driver.findElement(By.xpath("//input[@id='searchsubmit']")).click();
	  driver.findElement(By.xpath("//tbody/tr[1]/td[1]/a")).click();
	  drop = new Select(driver.findElement(By.id("company")));
	  drop.selectByVisibleText("Apple Inc.");
	  driver.findElement(By.xpath("//input[@type='submit']")).click();
	  text = driver.findElement(By.xpath("//div/strong")).getText();
	  Assert.assertEquals("Done !", text);
	  
	  
	  
	  
	  

	  
  }
}
