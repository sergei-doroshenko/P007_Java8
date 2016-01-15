package org.sergei.j8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by sergei on 1/15/16.
 *
 * Lazy evaluation
 */
public class Sample07 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        int[] factor = new int[] {2};
        Stream<Integer> strm = numbers.stream()
                .map(e -> e * factor[0]);

        factor[0] = 44;

        strm.forEach(System.out::println);
        /*
        the output:
        44
        88
        132
        176
        220
        264
        308
        352
        396
        440
         */
    }
}
