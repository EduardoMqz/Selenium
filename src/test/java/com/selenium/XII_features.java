package com.selenium;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import com.resources.JsonReader;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class XII_features {
    private static final String JSON_PATH = "src\\test\\java\\com\\resources\\XI_JavaStream.json";

    @Test
    public void realtiveLocators() throws IOException{
        Map<String,Object> config = JsonReader.readJsonAsMap(JSON_PATH);
        WebDriver driver = new ChromeDriver();

        driver.get(config.get("webPage").toString());
        driver.manage().window().maximize();
        WebElement nameTxt = driver.findElement(By.cssSelector("[name='name']"));
        String labelTxt = driver.findElement(with(By.tagName("label")).above(nameTxt)).getText();
        Assert.assertTrue(labelTxt.equalsIgnoreCase("name"));
        driver.quit();
    }

    @Test
    public void multipleTabs() throws IOException{
        Map<String,Object> config = JsonReader.readJsonAsMap(JSON_PATH);
        WebDriver driver = new ChromeDriver();

        driver.get(config.get("webPage").toString());
        driver.manage().window().maximize();
        String parentWindow = driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get(config.get("webPageCourses").toString());
        String courseTtitle = driver.findElements(By.cssSelector("a[href*='/p/'] div[class='course-listing-title']")).get(1).getText();
        driver.switchTo().window(parentWindow);
        WebElement nameTxt = driver.findElement(By.cssSelector("[name='name']"));
        nameTxt.sendKeys(courseTtitle);

        //take webelement screenshot
        File nameFile = nameTxt.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(nameFile, new File("src\\test\\java\\screenshot\\nameTxt.png"));

        //get height and width
        Assert.assertEquals(nameTxt.getRect().getDimension().getWidth(), (Number) config.get("width"));
        Assert.assertEquals(nameTxt.getRect().getDimension().getHeight(), (Number) config.get("height"));
        driver.quit();
    }

}
