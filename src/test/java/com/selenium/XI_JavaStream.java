package com.selenium;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.collect.Streams;
import com.resources.JsonReader;

public class XI_JavaStream {

    private static final String JSON_PATH = "src\\test\\java\\com\\resources\\XI_JavaStream.json";

    @Test
    public void javaStreams() {
        List<String> names = new ArrayList<String>();
        names.add("David");
        names.add("Allen");
        names.add("George");
        names.add("Adam");
        names.add("Emma");
        names.add("Mary");

        /****************** Regular way **********************/
        int count = 0;
        for (int i = 0; i < names.size(); i++) {
            String name = names.get(i);
            if (name.startsWith("A")) {
                count++;

            }
        }
        System.out.println("using regular java: " + count);
        /************************************************** */

        /******************* using stream ********************/
        long countStream = names.stream().filter(name -> name.startsWith("A")).count();
        System.out.println("using stream: " + countStream);

        countStream = Stream.of("David", "Allen", "George", "Adam", "Emma", "Mary").filter(name -> name.startsWith("A"))
            .count();
        System.out.println("using stream directly: " + countStream);

        names.stream().filter(name -> name.length() > 4)
            .forEach(name -> System.out.println(name + " is greater than 4"));

        names.stream().filter(name -> name.length() > 4).limit(1)
            .forEach(name -> System.out.println(name + " is alone"));

        Stream.of("sophia", "liam", "olivia", "noah", "ava", "ethan").filter(name -> name.endsWith("a"))
            .map(name -> name.toUpperCase()).forEach(name -> System.out.println(name + " ends with a"));

        List<String> nom = Arrays.asList("oliva", "sophia", "owen", "ethan", "oliver");
        nom.stream().filter(name -> name.startsWith("o"))
            .map(name -> name.toUpperCase()).sorted()
            .forEach(name -> System.out.println(name + " starts with an O"));

        Stream<String> newStream = Streams.concat(names.stream(), nom.stream());
        boolean flag = newStream.anyMatch(name -> name.equalsIgnoreCase("Adam"));
        System.out.println(flag);
        Assert.assertTrue(flag);

        List<String> namesCollect = Stream.of("sophia", "liam", "olivia", "noah", "ava", "ethan").filter(name -> name.endsWith("a"))
            .map(name -> name.toUpperCase()).collect(Collectors.toList());
        System.out.println("Collectors name: " + namesCollect.get(0));

        List<Integer> numbers = Arrays.asList(4,5,6,8,7,1,3,6,9,4,7);
        //print unique numbers, sort array
        numbers.stream().distinct().sorted().forEach(number -> System.out.println(number));
        List<Integer> numb = numbers.stream().distinct().sorted().collect(Collectors.toList());
        System.out.println("number in index 2: " + numb.get(2));
        /****************************************************/
    }

    @Test
    public void webTableSorting() throws IOException{
        Map<String,Object> config = JsonReader.readJsonAsMap(JSON_PATH);
        WebDriver driver = new ChromeDriver();

        driver.get(config.get("webPage").toString());
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//th[1]")).click();
        List<WebElement> elementsList = driver.findElements(By.xpath("//tbody/tr/td[1]"));
        List<String> productsList = elementsList.stream().map(product -> product.getText()).collect(Collectors.toList());
        List<String> sortedList = productsList.stream().sorted().collect(Collectors.toList());
        Assert.assertEquals(productsList, sortedList);
        driver.quit();
    }
}
