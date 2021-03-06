package org.sergei.j7;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sergei on 1/14/16.
 */
public class Sample02 {
    public static boolean isPrime(int number) {
        // flag, we hate them
        boolean divisible = false;

        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                divisible = true;
                break;
            }
        }

        return number > 1 && !divisible;
    }

    public static void main(String[] args) {
        List<Double> sqrtOfFirst100Primes = new ArrayList<>();

        int index = 1;
        while (sqrtOfFirst100Primes.size() < 100) {
            if (isPrime(index)) {
                sqrtOfFirst100Primes.add(Math.sqrt(index));
            }

            index++;
        }

        System.out.println(
                String.format("Computer %d values, first is %g, last is %g",
                        sqrtOfFirst100Primes.size(),
                        sqrtOfFirst100Primes.get(0),
                        sqrtOfFirst100Primes.get(sqrtOfFirst100Primes.size() - 1))
        );
    }
}
