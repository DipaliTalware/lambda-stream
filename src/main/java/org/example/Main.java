package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        Stream.of("Anton", "Berta", "Cäsar").peek(System.out::println).toList();

        List<Integer> numbers = Arrays.asList(18, 24, 35, 43, 54, 65, 7, 80, 9, 10, 11, 12, 13, 14, 15, 17);
        List<Integer> evenNumbers = numbers.stream().filter(number -> number % 2 == 0).toList();
        List<Integer> doubledNumbers = numbers.stream().map(number -> number * 2).toList();
        List<Integer> sortedList = numbers.stream().sorted().toList();
        int sumOfAllNumbers = numbers.stream().reduce(0, (i1, i2) -> i1 + i2);
        List<Integer> collect = numbers.stream().collect(Collectors.toList());


//        System.out.println("Filtered Even Numbers: " + evenNumbers);
//        System.out.println("The Doubled Numbers: " + doubledNumbers);
//        System.out.println("The Sorted List: " + sortedList);
//        System.out.println("The Sum Of all Numbers: " + sumOfAllNumbers);
//        System.out.println("Collected numbers into a new list: "+ collect);
//        numbers.stream().forEach(e -> System.out.println(e));

        
        List<Student> students = new ArrayList<>();
        Files.lines(Path.of("students.csv")).skip(1).forEach(line -> {
            System.out.println(line);
            String[] splitedLined = line.split(",");
            if (splitedLined.length > 3) {
                Student student = new Student(Integer.parseInt(splitedLined[0]),splitedLined[1], splitedLined[2], Integer.parseInt(splitedLined[3]));
                students.add(student);
            }
        });

        System.out.println(students);
    }


}