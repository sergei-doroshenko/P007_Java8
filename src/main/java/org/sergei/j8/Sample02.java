package org.sergei.j8;

import java.lang.reflect.Method;
import java.util.*;
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


        testDates();
    }

    public static void testDates () {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("UTC"));
        calendar.set(2016, Calendar.JANUARY, 5, 12, 30, 0);

        Date d0 = calendar.getTime();
        calendar.add(Calendar.DAY_OF_YEAR, -20);
        Date d1 = calendar.getTime();
        calendar.add(Calendar.DAY_OF_YEAR, 63);
        Date d2 = calendar.getTime();


        List<Date> dates = Arrays.asList(new Date[]{
                d0, d1, d2
        });

//        Optional<Date> min = dates.stream().min((o1, o2) -> o1.compareTo(o2));
        Optional<Date> min = dates.stream().min(Comparator.naturalOrder());
        System.out.println(min.get());

        Optional<Date> max = dates.stream().max((o1, o2) -> o1.compareTo(o2));
        System.out.println(max.get());
//        dates.stream().sorted().forEach(d -> System.out.println(d));
    }
}
