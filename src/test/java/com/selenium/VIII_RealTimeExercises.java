package com.selenium;

import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.resources.JsonReader;

public class VIII_RealTimeExercises {

    private static final String JSON_PATH = "src\\test\\java\\com\\resources\\VIII_RealTimeExercises.json";

    @Test
    public void linksOnPage() throws IOException {
        Map<String, Object> config = JsonReader.readJsonAsMap(JSON_PATH);
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        driver.get((String) config.get("webPage"));
        driver.manage().window().maximize();
        List<String> pageTitles = (List<String>) config.get("webPageTitles");
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
        Set<String> tabSet = driver.getWindowHandles();
        for (String handle : tabSet) {
            String currentTitle = wait.until(title -> {
                driver.switchTo().window(handle);
                return driver.getTitle();
            });
            System.out.println(currentTitle);
            if (!pageTitles.contains(currentTitle)) {
                Assert.fail("Unexpected page title found: " + currentTitle);
            }
        }
        driver.quit();
    }

    @Test
    public void handlingCalendar() throws IOException{
        Map<String, Object> config = JsonReader.readJsonAsMap(JSON_PATH);
        WebDriver driver = new ChromeDriver();

        driver.get((String) config.get("webPage2"));
        driver.manage().window().maximize();
        driver.findElement(By.className("react-date-picker__inputGroup")).click();
        driver.findElement(By.className("react-calendar__navigation__label")).click();
        driver.findElement(By.className("react-calendar__navigation__label")).click();
        driver.findElement(By.xpath("//button[text()='"+config.get("date").toString().split("/")[2]+"']")).click();
        driver.findElements(By.cssSelector(".react-calendar__year-view__months__month")).get(Integer.parseInt(config.get("date").toString().split("/")[0])-1).click();
        driver.findElement(By.xpath("//abbr[text()='"+config.get("date").toString().split("/")[1]+"']")).click();

        driver.quit();

    }
}
