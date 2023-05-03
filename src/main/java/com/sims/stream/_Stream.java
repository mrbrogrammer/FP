package com.sims.stream;

import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.LongStream;

import static com.sims.stream._Stream.Gender.FEMALE;
import static com.sims.stream._Stream.Gender.MALE;

public class _Stream {
    
    public static void main(String[] args) {
    
        List<Person> people = List.of(
                new Person("John", MALE),
                new Person("Bella", FEMALE),
                new Person("George", MALE)
        );
        
        LongStream longStream = people.stream().filter(x -> x.name == "Bella").mapToLong(x -> x.name.length());
    
        System.out.println("longStream.sum() = " + longStream.sum());
    
        // filter
        Predicate<Person> isPeter = x -> Objects.equals(x.name, "John");
        Consumer<Person> changeName = person -> person.name = "Peter";
        people.stream()
                .filter(isPeter)
                .toList().forEach(changeName);
        
        people.forEach(System.out::println);
        
        // map
        Function<Person, String> personStringFunction = person -> person.name;
        ToIntFunction<String> stringToIntFunction = String::length;
    
        System.out.println(people.stream()
                .map(personStringFunction)
                .mapToInt(stringToIntFunction).max().orElse(0));
        
        // findFirst
        people.stream().findFirst().get().name = people.stream().filter(x -> x == people.get(people.size() -1)).findFirst().get().name;

        // peek
        Consumer<Person> changeGender = x -> x.gender = MALE;
        people.stream()
                .peek(changeGender)
                .peek(System.out::println)
                .toList();
        
    }
    
    static class Person {
        String name;
        
        Gender gender;
        
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
    
}
