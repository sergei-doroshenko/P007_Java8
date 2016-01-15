package org.sergei.j8;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.*;

/**
 * Created by Sergei on 13.01.2016.
 *
 * Deodorizing Inner-Classes
 * - Single Abstract Method Interfaces
 * - Functional Interfaces
 */
public class Sample01 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        IntStream.range(0,10)
                .forEach(i ->
                        executorService.submit(() ->
                                System.out.println("Running task: " + i)));

        System.out.println("Task started....");
        executorService.shutdown();
    }
}
