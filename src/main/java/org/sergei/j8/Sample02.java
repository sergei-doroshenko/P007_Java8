package org.sergei.j8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Created by sergei on 1/14/16.
 *
 * Streamlining iterations:
 * - Specialized functions
 * - Function composition
 * - Infinite streams
 * - Lazy evaluation
 */
public class Sample02 {
    public static boolean isPrime(int number) {
        // flag, we hate them
        /*boolean divisible = false;

        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                divisible = true;
                break;
            }
        }
*/
//        System.out.println("Called....");
        return number > 1 &&
                IntStream.range(2, number)
                .noneMatch(i -> number % i == 0);
    }

    public static void main(String[] args) {
        /*List<Double> sqrtOfFirst100Primes = new ArrayList<>();

        int index = 1;
        while (sqrtOfFirst100Primes.size() < 100) {
            if (isPrime(index)) {
                sqrtOfFirst100Primes.add(Math.sqrt(index));
            }

            index++;
        }*/

        // A good code is like a story not like a puzzle.

        List<Double> sqrtOfFirst100Primes =
            Stream.iterate(1, e -> e + 1) // lazy evolution
                    /*.parallel()*/
                    .filter(Sample02::isPrime)
                    .map(Math::sqrt)
                    .limit(100)
                    .collect(toList());

        System.out.println(
                String.format("Computer %d values, first is %g, last is %g",
                        sqrtOfFirst100Primes.size(),
                        sqrtOfFirst100Primes.get(0),
                        sqrtOfFirst100Primes.get(sqrtOfFirst100Primes.size() - 1))
        );

    }
}
