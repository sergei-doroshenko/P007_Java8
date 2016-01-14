package org.sergei;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by sergei on 1/13/16.
 */
public class ShareMutable {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        final Wrapper w = new Wrapper(10);

        for (int i = 0; i < 10; i++) {
            final int index = i;
            executorService.submit(new Runnable() {
                @Override
                public void run() {

                    System.out.println("Running task: " + index);
                    System.out.println(w);
                }
            });

        }

        w.setVal(20);
        System.out.println("Task started....");
        executorService.shutdown();
    }
}

class Wrapper {
    private int val;

    public Wrapper(int val) {
        this.val = val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "Wrapper{" +
                "val=" + val +
                '}';
    }
}
