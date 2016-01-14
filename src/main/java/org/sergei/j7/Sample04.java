package org.sergei.j7;

import java.io.File;

/**
 * Created by sergei on 1/14/16.
 */
public class Sample04 {
    public static void main(String[] args) {
        File dir = new File(".");

        // names in uppercase, comma separated
        File[] children = dir.listFiles();
        if (children != null) {
            for (int i = 0; i < children.length; i++) {
                System.out.print(children[i].getName().toUpperCase());
                if (i < children.length -1) {
                    System.out.print(", ");
                }
            }
        }
        System.out.println(dir);
    }
}
