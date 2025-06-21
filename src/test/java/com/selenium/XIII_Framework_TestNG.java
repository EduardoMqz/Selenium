package com.selenium;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class XIII_Framework_TestNG {

    @Test
    public void testNG(){
        System.out.println("Hello world");

    }

    @Test
    public void secondTest(){
        System.out.println("second Test");
    }

    @Test
    public void thirdTest(){
        System.out.println("Third test");
    }

    @Test
    public void thirdTestPartII(){
        System.out.println("A sequel!!! unbelievable");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("I will execute first");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("I will execute last");
    }


}
