package com.selenium;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import com.resources.JsonReader;

public class VIII_RealTimeExercises {

    private static final String JSON_PATH = "src\\test\\java\\com\\resources\\VIII_RealTimeExercises.json";

    @Test
    public void linksOnPage() throws IOException {
        Map<String, Object> config = JsonReader.readJsonAsMap(JSON_PATH);
        WebDriver driver = new ChromeDriver();

        driver.get((String) config.get("webPage"));
        driver.manage().window().maximize();
        List<WebElement> listOfLinks = driver.findElements(By.xpath("//a"));
        System.out.println(listOfLinks.size());
        WebElement footerDriver = driver.findElement(By.id("gf-BIG")); // limiting webdriver scope
        List<WebElement> listOfFooterLInks = footerDriver.findElements(By.tagName("a"));
        System.out.println(listOfFooterLInks.size());
        // count of only first column
        WebElement columnOneDriver = footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
        List<WebElement> listOfLinksColumnOne = columnOneDriver.findElements(By.tagName("a"));
        System.out.println(listOfLinksColumnOne.size());
        // click on each link and check page if the page are opening
        listOfLinksColumnOne.stream()
                .skip(1) // Skip the first element (equivalent to starting at i=1)
                .forEach(link -> {
                    String cclickOnLink = Keys.chord(Keys.CONTROL, Keys.ENTER);
                    link.sendKeys(cclickOnLink);
        });
        driver.quit();
    }

}
