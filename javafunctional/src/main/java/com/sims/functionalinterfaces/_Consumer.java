package com.sims.functionalinterfaces;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {
    public static void main(String[] args) {
        initialize();
        System.out.println("Imperative approach: " + _Consumer.name);
        
        
        initializeName.accept("Ben");
        System.out.println("Consumer: " + _Consumer.name);
    
    
        initializeNameAndAge.accept("Sims", 23);
        System.out.println("BiConsumer: " + _Consumer.name + ", " + _Consumer.age);
        
        Initialize initialize = (x) -> _Consumer.name = x;
        initialize.initialize("Luke");
    
        System.out.println("Using the @FunctionalInterface Annotation: " + _Consumer.name);
    
    }
    
    static String name;
    static int age;
    
    static BiConsumer<String, Integer> initializeNameAndAge = _Consumer::initialize;
    static Consumer<String> initializeName = (x) -> _Consumer.name = x;
    
    @FunctionalInterface
    interface Initialize {
        void initialize(String name);
    }
    
    static void initialize() {
        _Consumer.name = "Sam";
    }
    static void initialize(String name, Integer age) {
        _Consumer.name = name;
        _Consumer.age = age;
        
    }
}
