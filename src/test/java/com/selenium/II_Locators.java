package com.selenium;


public class II_Locators {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "path to chromedriver");
        Webdriver driver = new ChromeDriver();
        driver.get("webpage");

        driver.findElement(By.id("elementsId")).sendKeys("text2Type");
        driver.findElement(By.name("elementName")).sendKeys("text");
        driver.findElement(By.className("className")).click();
    }

}
