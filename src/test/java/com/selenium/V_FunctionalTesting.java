package com.selenium;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import com.resources.JsonReader;

public class V_FunctionalTesting {

    @Test
    public void cart() throws IOException{
        String[] productsToAdd = {"Cucumber", "Brinjal", "Mushroom", "Corn","Mango", "Pomegranate", "Almonds", "Walnuts"};
        Map<String, Object> config = JsonReader.readJsonAsMap("src/test/java/com/resources/V_FunctionalTesting.json");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get((String) config.get("webPage"));
        List<WebElement> products = driver.findElements(By.className("product"));
        for (int i = 0; i < products.size()-1; i++) {
           String productName = products.get(i).findElement(By.cssSelector("[class*='product-name']")).getText();
            if (Arrays.asList(productsToAdd).contains(productName.split(" ")[0])) {
                while (!products.get(i).findElement(By.className("stepper-input")).findElement(By.className("quantity")).getDomAttribute("value").equalsIgnoreCase("5")) {
                    products.get(i).findElement(By.className("stepper-input")).findElement(By.className("increment")). click();
                }
                products.get(i).findElement(By.className("product-action")).click(); 
            }
        }
       driver.quit();   
    }

}
