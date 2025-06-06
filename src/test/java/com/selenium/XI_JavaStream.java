package com.selenium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Test;

public class XI_JavaStream {

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
            .map(name -> name.toUpperCase()).sorted().forEach(name -> System.out.println(name + " starts with an O"));
        /****************************************************/
    }
}
