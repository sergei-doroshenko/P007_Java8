package org.sergei.j7;

import org.sergei.commons.Person;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by sergei on 1/14/16.
 */
public class Sample05 {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Sara", 12),
                new Person("Mark", 43),
                new Person("Bob", 17),
                new Person("Jill", 24)
        );

        Collections.sort(people);

        System.out.println(people);
    }
}
