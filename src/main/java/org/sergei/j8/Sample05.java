package org.sergei.j8;

import org.sergei.commons.Person;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by sergei on 1/14/16.
 *
 * Non-intrusive Comparisons:
 * - Comparable vs. Comparator
 * - Composition of comparators
 */
public class Sample05 {
    public static void printSorted(List<Person> people, Comparator<Person> comparator) {
        people.stream()
                .sorted(comparator)
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Sara", 12),
                new Person("Mark", 43),
                new Person("Bob", 12),
                new Person("Jill", 24)
        );

//        Collections.sort(people);

//        Comparator<Person> comparator = (o1, o2) -> o1.getName().compareTo(o2.getName());
        /*
        comparing(Person::getName) is a function that get 1 parameter and return you another function.
         */
//        printSorted(people, Comparator.comparing(Person::getName));
        printSorted(people,
                Comparator.comparing(Person::getAge).thenComparing(Person::getName));

        // we don't touch the collection, don't change it.
        System.out.println(people);
    }
}
