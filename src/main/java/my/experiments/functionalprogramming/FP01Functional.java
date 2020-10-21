package my.experiments.functionalprogramming;

import java.util.List;

public class FP01Functional {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 7, 8, 4, 12, 15);
        List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes");

//        printAllNumberInListFunctional(numbers);
//        printEvenNumberInListFunctional(numbers);

        exercise1(numbers);
        exercise2(courses);
        exercise3(courses);
        exercise4(courses);
    }

//    private static void print(int number) {
//        System.out.println(number);
//    }

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }

    private static void printAllNumberInListFunctional(List<Integer> numbers) {
        numbers.stream()
                .forEach(System.out::println);

    }

    private static void printEvenNumberInListFunctional(List<Integer> numbers) {
        numbers.stream()
                //.filter(FP01Functional::isEven)
                .filter(number -> number % 2 == 0)
                .forEach(System.out::println);

    }

    //
    // #### Exercise section
    //

    private static void exercise1(List<Integer> numbers) {
        //print odd numbers
        System.out.println("-- Exercise 1 --");
        numbers.stream()
                .filter(number -> number % 2 != 0)
                .forEach(System.out::println);
    }

    private static void exercise2(List<String> courses) {
        System.out.println("-- Exercise 2 --");
        courses.stream()
                .forEach(System.out::println);
    }

    private static void exercise3(List<String> courses) {
        System.out.println("-- Exercise 3 --");
        courses.stream()
                .filter(course -> course.contains("Spring"))
                .forEach(System.out::println);
    }

    private static void exercise4(List<String> courses) {
        System.out.println("-- Exercise 4 --");
        courses.stream()
                .filter(course -> course.length() >= 4)
                .forEach(System.out::println);
    }
}
