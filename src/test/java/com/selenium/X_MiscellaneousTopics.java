package com.selenium;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.TakesScreenshot;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import com.resources.JsonReader;
import org.apache.commons.io.FileUtils;

public class X_MiscellaneousTopics {
    private static final String JSON_PATH = "src\\test\\java\\com\\resources\\X_MiscellaneousTopics.json";


    @Test
    public void test() throws IOException {
        ChromeOptions options = new ChromeOptions();
        Proxy proxy = new Proxy();
        proxy.setHttpProxy("ipaddress:4444");
        options.setCapability("proxy", proxy);
        options.setAcceptInsecureCerts(true);
        options.addEncodedExtensions("");
        Map<String, Object> config = JsonReader.readJsonAsMap(JSON_PATH);
        WebDriver driver = new ChromeDriver(options);

        driver.get(config.get("webPage").toString());
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        driver.quit();
    }

    @Test
    public void deleteCookies() throws IOException {
        WebDriver driver = new ChromeDriver();

        driver.manage().deleteAllCookies();
        // driver.manage().deleteCookieNamed(null);
        // driver.manage().addCookie(null);
        driver.get("http://google.com");
        driver.manage().window().maximize();
        driver.quit();
    }

    @Test
    public void takeScreenshot() throws IOException {
        WebDriver driver = new ChromeDriver();

        driver.get("http://google.com");
        driver.manage().window().maximize();
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("src\\test\\java\\screenshot\\Screenshot.png"));
        driver.quit();
    }

    @Test
    public void deleteScreenshot() {
        File screenshot = new File("src\\test\\java\\screenshot\\Screenshot.png");
        if (screenshot.delete()) {
            System.out.println("Deleted the file: " + screenshot.getName());
        } else {
            System.out.println("Failed to delete the file.");
        }
    }

    @Test
    public void brokenLinks() throws IOException, URISyntaxException{
        Map<String, Object> config = JsonReader.readJsonAsMap(JSON_PATH);
        WebDriver driver = new ChromeDriver();

        driver.get(config.get("webPage2").toString());
        driver.manage().window().maximize();
        String url = driver.findElement(By.cssSelector("a[href*='brokenlink']")).getDomAttribute("href");
        HttpURLConnection conn = (HttpURLConnection) new URI(url).toURL().openConnection();
        conn.setRequestMethod("HEAD");
        conn.connect();
        int responseCode = conn.getResponseCode();
        Assert.assertEquals(404, responseCode);
        driver.quit();
    }

}
