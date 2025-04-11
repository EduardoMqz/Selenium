package com.selenium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import org.junit.Test;

public class I_JavaConcepts {

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
            character:  %c""", webSite, myNum, deci, charac);
    }

    @Test
    public void arrayList(){
        ArrayList<Integer> arrInt = new ArrayList<>(
            List.of(5,10,15,20,25,2,4,6,8,3,9,12));
        for (int i = 0; i < arrInt.size(); i++) {
            System.out.printf("Element %d:   %d%n",i ,arrInt.get(i));
        }
        System.out.println("*".repeat(15));

        arrInt.sort(Comparator.naturalOrder());
        for(Integer numb : arrInt){
            if (numb % 3 == 0) {
                System.out.println("Element value: "+numb);
            }else{
                System.out.println(numb + " is not mutiple of three");
            }
        }
    }

}
 