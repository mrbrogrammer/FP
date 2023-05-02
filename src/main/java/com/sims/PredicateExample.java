package com.sims;

import java.util.List;
import java.util.function.Predicate;

public class PredicateExample {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    
        List<Person> people = List.of(
                new Person("John", Gender.MALE),
                new Person("Alex", Gender.MALE),
                new Person("Ellie", Gender.FEMALE)
        );
        
        Females<Person> isFemale = new Females<>();
        
        people.stream().filter(isFemale).toList().forEach(System.out::println);
        
        
    
    }
    
    
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