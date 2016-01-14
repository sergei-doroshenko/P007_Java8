package org.sergei.j8;

import java.io.File;
import static java.util.stream.Collectors.*;
import java.util.stream.*;

/**
 * Created by sergei on 1/14/16.
 */
public class Sample04 {
    public static void main(String[] args) {
        File dir = new File(".");

        // names in uppercase, comma separated
        File[] children = dir.listFiles();
        if (children != null) {
            System.out.println(
                Stream.of(children)
                    .map(File::getName)
                    .map(String::toUpperCase)
                    .collect(joining(", "))
            );
        }
    }
}
