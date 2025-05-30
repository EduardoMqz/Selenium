package com.selenium;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.resources.JsonReader;

public class IX_PracticalProblems {
    private static final String JSON_PATH = "src\\test\\java\\com\\resources\\IX_PracticalProblems.json";

    @Test
    public void scrolling() throws IOException {
        Map<String, Object> config = JsonReader.readJsonAsMap(JSON_PATH);
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        driver.get(config.get("webPage").toString());
        driver.manage().window().maximize();
        jsExecutor.executeScript("window.scrollBy(0,500)");
        jsExecutor.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");

        // table grid
        List<WebElement> values = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
        int val = 0;
        for (WebElement webElement : values) {
            val += Integer.parseInt(webElement.getText());
        }
        String totalAmount = driver.findElement(By.cssSelector(".totalAmount")).getText().split(" ")[3];
        Assert.assertEquals(val, Integer.parseInt(totalAmount));
        driver.quit();
    }

}
