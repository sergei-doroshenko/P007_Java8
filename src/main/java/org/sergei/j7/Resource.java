package org.sergei.j7;

/**
 * Created by sergei on 1/14/16.
 */
public class Resource implements AutoCloseable {
    public Resource() {
        System.out.println("Created...");
    }

    public void op1() {
        System.out.println("Some operation 1...");
    }

    public void op2() {
        System.out.println("Some operation 2...");
    }

    public void close() {
        System.out.println("External resources clean up.");
    }
}
