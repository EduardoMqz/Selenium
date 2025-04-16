package com.selenium;

import java.io.InputStream;
import java.util.Properties;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class II_Locators {

    
    
  
    

    @Test
    public void logInTest() {
        System.setProperty("webdriver.chrome.driver", "path to chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("google.com");
        driver.findElement(By.id("elementsId")).sendKeys("text2Type");
        driver.findElement(By.name("elementName")).sendKeys("text");
        driver.findElement(By.className("className")).click();
    }

}
