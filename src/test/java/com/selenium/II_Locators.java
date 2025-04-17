package com.selenium;

import java.io.IOException;
import java.time.Duration;
import java.util.Map;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.resources.JsonReader;

public class II_Locators {

    @Test
    public void logInTest() throws IOException {
        Map<String, Object> config = JsonReader.readJsonAsMap("src/test/java/com/resources/II_locators.json");
        System.setProperty("webdriver.chrome.driver", "src/main/java/com/selenium/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.get((String) config.get("webpage"));
        driver.findElement(By.id("inputUsername")).sendKeys((String) config.get("username"));
        driver.findElement(By.name("inputPassword")).sendKeys("helloWorld");
        driver.findElement(By.className("signInBtn")).click();
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.className("error")));
        driver.quit();
    }
}