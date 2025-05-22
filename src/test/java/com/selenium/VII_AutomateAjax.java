package com.selenium;

import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.resources.JsonReader;

public class VII_AutomateAjax {

    private static final String JSON_PATH = "src\\test\\java\\com\\resources\\VII_AutomateAjax.json";

    @Test
    public void handlingAjax() throws IOException {
        Map<String, Object> config = JsonReader.readJsonAsMap(JSON_PATH);
        WebDriver driver = new ChromeDriver();

        try {
            driver.manage().window().maximize();
            driver.get((String) config.get("webPage"));
            Actions actions = new Actions(driver);
            WebElement moveProfile = driver.findElement(By.id("nav-link-accountList"));
            // move to specific element
            actions.moveToElement(moveProfile).build().perform();
            actions.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT)
                    .sendKeys((String) config.get("itemToSearch"))
                    .doubleClick().build().perform();
            actions.moveToElement(moveProfile).contextClick().build().perform();
            actions.moveToElement(moveProfile).clickAndHold().build().perform();
        } finally {
            driver.quit();
        }
    }

    @Test
    public void handlingWindow() throws IOException {
        Map<String, Object> config = JsonReader.readJsonAsMap(JSON_PATH);
        WebDriver driver = new ChromeDriver();

        try {
            driver.manage().window().maximize();
            driver.get((String) config.get("webPageWindow"));
            driver.findElement(By.xpath("//a[@class='blinkingText'][1]")).click();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            Set<String> windows = driver.getWindowHandles();
            Iterator<String> ite = windows.iterator();
            String parentID = ite.next();
            String childID = ite.next();
            driver.switchTo().window(childID);
            wait.until(
                    ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//p[@class='im-para red']"))));
            String user = driver.findElement(By.xpath("//p[@class='im-para red']")).getText().split(" ")[4];
            System.out.println(user);
            driver.switchTo().window(parentID);
            driver.findElement(By.id("username")).sendKeys(user);

        } finally {
            driver.quit();
        }

    }
}
