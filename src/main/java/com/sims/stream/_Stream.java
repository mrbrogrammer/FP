package com.sims.stream;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static com.sims.stream._Stream.Gender.FEMALE;
import static com.sims.stream._Stream.Gender.MALE;

public class _Stream {
    

    
    public static void main(String[] args) {
    
        List<Person> people = List.of(
                new Person("John", MALE),
                new Person("Bella", FEMALE),
                new Person("George", MALE)
        );
    
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
        Predicate<Person> personPredicate = x -> x == people.get(people.size() - 1);
        people.stream().findFirst().get().name = people.stream().filter(personPredicate).findFirst().get().name;

        // peek
        Consumer<Person> changeGender = x -> x.gender = MALE;
        people.stream()
                .peek(changeGender)
                .peek(System.out::println)
                .toList();
        
    
        // infinite streams
        UnaryOperator<Integer> integerUnaryOperator = i -> i * 2;
        Stream<Integer> infiniteStream = Stream.iterate(1, integerUnaryOperator);
        List<Integer> collect = infiniteStream
                .limit(5)
                .toList();
        
        collect.forEach(System.out::println);
    
        // sorted
        Comparator<Person> personComparator = (t, u) -> t.name.compareTo(u.name); // We can also avoid defining the comparison logic by using Comparator.comparing()
        System.out.println("Sorted: " + people.stream()
                .sorted(personComparator)
                .toList());
        
        // distinct
        System.out.println("Distinct: " + people.stream().distinct().toList());
        
        // allMatch
        Predicate<Person> allMatchPredicate = x -> "George".equals(x.name);
        boolean allMatch = people.stream()
                .allMatch(allMatchPredicate);
        System.out.println("allMatch: " + allMatch);
    
        // anyMatch
        Predicate<Person> anyMatchPredicate = x -> "George".equals(x.name);
        boolean anyMatch = people.stream()
                .anyMatch(anyMatchPredicate);
        System.out.println("anyMatch: " + anyMatch);
        
        // noneMatch
        Predicate<Person> noneMatchPredicate = x -> "George".equals(x.name);
        boolean noneMatch = people.stream()
                .noneMatch(noneMatchPredicate);
        System.out.println("noneMatch: " + noneMatch);
        
        // sum
        LongStream longStream = people.stream()
                .filter(x -> "Bella".equals(x.name))
                .mapToLong(x -> x.name.length());
        System.out.println("Sum: " + longStream.sum());
        
        // range
        IntStream intStream = IntStream.range(1, 11); // infinite stream
        System.out.print("Range: ");
        intStream.forEach(System.out::print);
    
        // average
        System.out.println();
        IntStream averageIntStream = IntStream.range(1, 11);
        System.out.println("Average: " + averageIntStream.average().orElse(0));
        
        // reduce
        ToIntFunction<Person> personToIntFunction = x -> x.name.length();
        IntBinaryOperator intBinaryOperator = Integer::sum; // Can also be: (x, y) -> x + y
        int reduce = people.stream()
                .mapToInt(personToIntFunction)
                .reduce(0, intBinaryOperator);
        System.out.println("Reduce: " + reduce);
        
        //
    
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
