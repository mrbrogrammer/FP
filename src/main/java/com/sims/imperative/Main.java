package com.sims.imperative;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("John", Gender.MALE),
                new Person("Alex", Gender.MALE),
                new Person("Ellie", Gender.FEMALE)
        );
        
        // imperative approach
        System.out.println("imperative approach");
    
        List<Person> females = new ArrayList<>();
        
        Person[] mypeople = new Person[5];
    
//        for (int i = 0; i < mypeople.length; i++) {
//            int count = i % 2 == 0 ? 1 : 0;
//
//            Gender[] Gender = Main.Gender.class.getEnumConstants();
//            Arrays.fill(mypeople, new Person("sims", Gender[count]));
//        }
//
//        for (Person person : mypeople) {
//            System.out.println(person);
//        }
        
        for (Person person: people) {
            if (Gender.FEMALE.equals(person.gender)) {
                females.add(person);
            }
        }
    
        for (Person person: people) {
            System.out.println(person);
        }
    
        // declarative approach
        System.out.println("declarative approach");
        Predicate<Person> personPredicate = person -> Gender.FEMALE.equals(person.gender);
    
        List<Person> list = people.stream()
                .filter(personPredicate)
                .collect(Collectors.toList());
        // option + command + V extract to variable
    
        System.out.println(list);
    
        Predicate<String> p = String::isEmpty;
    }
    
    static class Person {
        private final String name;
        
        private final Gender gender;
    
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
    
 
    public enum Gender {
        MALE,
        FEMALE
    }
    
    
}
