package com.sims.functionalinterfaces;



import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {
    public static void main(String[] args) {
        System.out.println("Imperative approach: " + increment());
        System.out.println("Function: " +  increment.apply(2));
        System.out.println("BiFunction: " + integerConsumer.apply(1,3));
        
        Increment usingAnnotation = number -> number + 1;
        System.out.println("Using the @FunctionalInterface Annotation: " + usingAnnotation.increment(3));
    }
    
    
    static BiFunction<Integer, Integer, Boolean> integerConsumer =
            Integer::equals;
    static Function<Integer, Integer> increment = number -> number + 1;
    
    @FunctionalInterface
    interface Increment {
        int increment(Integer number);
    }
    static Integer increment() {
        return 2 + 1;
    }
}
