package com.selenium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class I_JavaConcepts {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void Variables(){
        int myNum = 5;
        String webSite = "Academy";
        char charac = 'D';
        double deci = 5.99;

        System.out.printf("""
            String:     %s
            int:        %d
            double:     %f
            character:  %c%n""", webSite, myNum, deci, charac);

        ArrayList<Integer> arrInt = new ArrayList<>(
            List.of(5,10,15,20,25));

        for (int i = 0; i < arrInt.size(); i++) {
            System.out.printf("Element %d:   %d%n",i ,arrInt.get(i));
        }
        


        
    }
} 