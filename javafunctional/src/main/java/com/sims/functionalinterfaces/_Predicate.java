package com.sims.functionalinterfaces;

import java.util.List;
import java.util.function.Predicate;


public class _Predicate {
    public static void main(String[] args) {
        
        List<Person> mypeople = List.of(
                new Person("John", Gender.MALE),
                new Person("Alex", Gender.MALE),
                new Person("Ellie", Gender.FEMALE)
        );
        
        Females<Person> isFemale = new Females<>();
        
        mypeople.stream().filter(isFemale).toList().forEach(System.out::println);
        
        Women women = x -> x.gender.equals(Gender.FEMALE);
    
        boolean female = women.isFemale(new Person("Sims", Gender.MALE));
    
        System.out.println("female = " + female);
    }
    
    
    
    
}

@FunctionalInterface
interface Women {
    boolean isFemale(Person V);
}

class Person {
    final String name;
    
    final Gender gender;
    
    public Person(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
    }
    
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                '}';
    }
    
}

enum Gender {
    MALE,
    FEMALE
}

class Females<E> implements Predicate<Person> {
    @Override
    public boolean test(Person V) {
        
        return V.gender.equals(Gender.FEMALE);
        
    }
}

