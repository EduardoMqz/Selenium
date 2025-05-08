package com.selenium;

import java.io.IOException;
import java.time.Duration;
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
        System.out.println(products.size());
        for (WebElement webElement : products) {
            System.out.println(webElement.findElement(By.className("product-name")).getText());
            if (webElement.findElement(By.className("product-name")).getText().contains("Cucumber")) {
                System.out.println("encontre cucumbers");
                webElement.findElement(By.className("stepper-input")).findElement(By.className("increment")). click();
                webElement.findElement(By.className("stepper-input")).findElement(By.className("increment")). click();
                webElement.findElement(By.className("stepper-input")).findElement(By.className("increment")). click();
                webElement.findElement(By.className("stepper-input")).findElement(By.className("increment")). click();
                break;
                
            }
            
        }


        //driver.findElement(By.xpath("//a[@class='increment'][2]")).click();

        
    }

}
