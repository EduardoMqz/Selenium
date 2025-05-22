package com.selenium;

import java.io.IOException;
import java.util.Map;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.resources.JsonReader;

public class VII_AutomateAjax {

    private static final String JSON_PATH = "src\\test\\java\\com\\resources\\VII_AutomateAjax.json";

    @Test
    public void handlingAjax() throws IOException{
        Map<String, Object> config = JsonReader.readJsonAsMap(JSON_PATH);
        WebDriver driver = new ChromeDriver();

        try{
            driver.manage().window().maximize();
            driver.get((String) config.get("webPage"));
            Actions actions = new Actions(driver);
            actions.moveToElement(driver.findElement(By.id("nav-link-accountList")), 0, 0).build().perform();
            

        }finally{
            driver.quit();
        }



    }

}
