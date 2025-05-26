package com.selenium;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import com.resources.JsonReader;

public class VIII_RealTimeExercises {

    private static final String JSON_PATH = "src\\test\\java\\com\\resources\\VIII_RealTimeExercises.json";

    @Test
    public void linksOnPage() throws IOException{
        Map<String, Object> config = JsonReader.readJsonAsMap(JSON_PATH);
        WebDriver driver = new ChromeDriver();

        driver.get((String) config.get("webPage"));
        driver.manage().window().maximize();
        List<WebElement> listOfLinks = driver.findElements(By.xpath("//a"));
        System.out.println(listOfLinks.size());
        WebElement footerDriver = driver.findElement(By.id("gf-BIG"));
        List<WebElement> listOfFooterLInks = footerDriver.findElements(By.tagName("a"));
        System.out.println(listOfFooterLInks.size());
        driver.quit();
    }

}
