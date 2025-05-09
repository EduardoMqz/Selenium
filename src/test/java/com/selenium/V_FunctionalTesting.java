package com.selenium;

import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.resources.JsonReader;

public class V_FunctionalTesting {

    @Test
    public void cart() throws IOException{
        Map<String, Object> config = JsonReader.readJsonAsMap("src/test/java/com/resources/V_FunctionalTesting.json");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().window().maximize();

        driver.get((String) config.get("webPage"));
        List<WebElement> products = driver.findElements(By.className("product"));
        String[] productList = {"Cucumber", "Brinjal", "Mushroom", "Corn"};
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).findElement(By.className("product-name")).getText().contains("Cucumber")) {
                while (!products.get(i).findElement(By.className("stepper-input")).findElement(By.className("quantity")).getDomAttribute("value").equalsIgnoreCase("5")) {
                    products.get(i).findElement(By.className("stepper-input")).findElement(By.className("increment")). click();
                }
                products.get(i).findElement(By.className("product-action")).click();
                break;  
            }
            
        }
       driver.quit();   
    }

}
