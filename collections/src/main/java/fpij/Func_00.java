package fpij;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import static java.util.stream.Collectors.joining;

/**
 * Created by Sergei on 02.10.2015.
 */
public class Func_00 {
    public static void main(String[] args) {
        final Function<String, Function<String, String>> func = str -> {
            if (str.length() < 5) {
                return arg -> arg.toLowerCase();
            } else {
                return arg -> arg.toUpperCase();
            }
        };

        List<String> samples = Arrays.asList("Mouse", "Implementation", "Lol", "Sword");

        samples.stream()
                .map(sample -> func.apply(sample).apply(sample))
                .forEach(System.out::println);

        String result = samples.stream()
                .map(sample -> func.apply(sample).apply(sample))
                .collect(joining(", "));
        System.out.println(result); // MOUSE, IMPLEMENTATION, lol, SWORD
    }
}
