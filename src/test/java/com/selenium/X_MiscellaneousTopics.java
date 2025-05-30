package com.selenium;

import java.io.IOException;
import java.util.Map;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import com.resources.JsonReader;

public class X_MiscellaneousTopics {
    private static final String JSON_PATH = "src\\test\\java\\com\\resources\\X_MiscellaneousTopics.json";

    @Test
    public void test() throws IOException {
        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);
        Map<String, Object> config = JsonReader.readJsonAsMap(JSON_PATH);
        WebDriver driver = new ChromeDriver(options);

        driver.get(config.get("webPage").toString());
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        driver.quit();
    }

}
