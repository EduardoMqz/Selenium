package com.selenium;

import java.io.IOException;
import java.time.Duration;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.resources.JsonReader;

public class IV_WebElements {

    @Test
    public void webElementDropDown() throws IOException {
        Map<String, Object> config = JsonReader.readJsonAsMap("src/test/java/com/resources/IV_WebElements.json");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        
        driver.get((String) config.get("webPage"));
        WebElement ddlCurrency = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        Select selectCurrency = new Select(ddlCurrency);
        selectCurrency.selectByIndex(3);
        System.out.println(selectCurrency.getFirstSelectedOption().getText()); 
        selectCurrency.selectByContainsVisibleText("AED");
        System.out.println(selectCurrency.getFirstSelectedOption().getText());
        
        //passengers
        driver.findElement(By.id("divpaxinfo")).click();
        wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.id("hrefIncAdt")));
        for (int i = 1; i < 4; i++) {
            driver.findElement(By.id("hrefIncAdt")).click();
        }
        driver.findElement(By.id("btnclosepaxoption")).click();
        String passangers = driver.findElement(By.id("divpaxinfo")).getText();
        Assert.assertEquals("4 Adult", passangers);
        driver.quit();


    }

}
