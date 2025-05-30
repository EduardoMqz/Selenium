package com.selenium;

import java.io.IOException;
import java.util.Map;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.resources.JsonReader;

public class IX_PracticalProblems {
    private static final String JSON_PATH = "src\\test\\java\\com\\resources\\IX_PracticalProblems.json";


    @Test
    public void scrolling() throws IOException{
        Map<String,Object> config = JsonReader.readJsonAsMap(JSON_PATH);
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        driver.get(config.get("webPage").toString());
        driver.manage().window().maximize();
        jsExecutor.executeScript("window.scrollBy(0,500)");
        jsExecutor.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
        

        //driver.quit();


    }

}
