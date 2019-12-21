package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {

    List<Integer> integers = Arrays.asList(3,9,7,0,10,20);
    integers.forEach(consumerWrapper(i -> System.out.println(50 / i), Exception.class));
    }
    private static <T, E extends Exception> Consumer<T> consumerWrapper(Consumer<T> consumer, Class<E> clazz) {
       return i->{
           try {
               consumer.accept(i);
           } catch (Exception e) {
               System.out.println("Exception has occured:"+e.getMessage());
           }
       };
    }
//    private static Consumer<Integer> lambdaWrapper(Consumer<Integer> cunsumer) {
//        return i->{
//            try {
//                cunsumer.accept(i);
//            } catch (ArithmeticException e) {
//                System.out.println("Arithmetic Exception occured:"+e.getMessage());
//            }
//        };
//    }
}
