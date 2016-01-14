package org.sergei.j7;

/**
 * Created by sergei on 1/14/16.
 */
public class Sample06 {
    public static void main(String[] args) {

        // 1. forgot ++
        // 2. exception : ok
        // 3. verbose : ok

        // 1st solution:
        /*Resource resource = new Resource();
        try {
            resource.op1();
            resource.op2();
        } finally {
            resource.close();
        }*/

        // Java 7: ARM - Automatic Resource Management
        // try with resources
        // 2nd solution:
        try ( Resource resource = new Resource() ) {
            resource.op1();
            resource.op2();
        }


    }
}
