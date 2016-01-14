package org.sergei.j8;

import java.util.function.Consumer;

/**
 * Created by sergei on 1/14/16.
 */
public class Resource {
    private Resource() { System.out.println("Created by use..."); }

    public void op1() {
        System.out.println("Some operation 1...");
    }

    public void op2() {
        System.out.println("Some operation 2...");
    }

    private void close() {
        System.out.println("External resources clean up.");
    }

    public static void use(Consumer<Resource> block) {
        Resource resource = new Resource();
        try {
            block.accept(resource);
        } finally {
            resource.close();
        }
    }
}
