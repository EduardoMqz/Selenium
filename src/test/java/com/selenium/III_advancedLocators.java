package com.selenium;

import java.io.IOException;
import java.time.Duration;
import java.util.Map;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.resources.JsonReader;

public class III_advancedLocators {

    @Test
    public void advancedLocators() throws IOException {
        Map<String, Object> config = JsonReader.readJsonAsMap("src/test/java/com/resources/III_advancedLocators.json");
        System.setProperty("webdriver.chrome.driver", "src/main/java/com/selenium/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.get((String) config.get("webpage"));
        driver.findElement(By.cssSelector("#inputUsername")).sendKeys((String) config.get("username"));
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys((String) config.get("password"));
        driver.findElement(By.id("chkboxOne")).click();
        driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='login-container']/p")));
        Assert.assertEquals("You are successfully logged in.", driver.findElement(By.tagName("p")).getText());
        Assert.assertEquals("Hello " +(String) config.get("username")+",", driver.findElement(By.tagName("h2")).getText());
        driver.findElement(By.xpath("//button[text()='Log Out']")).click();
        wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Sign in']")));
        driver.quit();
    }
}
