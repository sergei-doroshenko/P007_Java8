package org.sergei.j8;

import java.util.function.Consumer;
import java.util.function.Function;

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

    public String op3() {
        return "Some operation 3...";
    }

    public String op4() {
        return "Some operation 4...";
    }

    public static String cat(Function<Resource, String> block) {
        Resource resource = new Resource();
        try {
            return block.apply(resource);
        } finally {
            resource.close();
        }
    }

    public Function<Resource, String> fun1 = resource -> "Some function 1...";

    public Function<String, Integer> fun2 = str -> str.length();


    public static String compute(Function<Resource, Integer> block) {
        Resource resource = new Resource();
        try {
            return block.apply(resource).toString();
        } finally {
            resource.close();
        }
    }


}
