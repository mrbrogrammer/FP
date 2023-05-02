package com.sims.functionalinterfaces;

import java.util.function.Supplier;

public class _Supplier {
    public static void main(String[] args) {
        System.out.println("Imperative approach: " + getId());
    
        System.out.println("Supplier: " + getId.get());
        
        GetId id = () -> 12345678910L;
        System.out.println("Using the @FunctionalInterface Annotation: " + id.getId());
    }
    
    static Supplier<Long> getId = () -> 12345678910L;
    
    @FunctionalInterface
    interface GetId {
        long getId();
    }
    
    static long getId() {
        return 12345678910L;
    }
}
