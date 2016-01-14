package org.sergei.j8;

import java.util.function.Consumer;

/**
 * Created by sergei on 1/14/16.
 */
public class Sample06 {
    public static void main(String[] args) {

        // 1. forgot ++
        // 2. exception : ok
        // 3. verbose : ok
        // Around method pattern

        /*Resource.use(new Consumer<Resource>() {
            @Override
            public void accept(Resource resource) {
                resource.op1();
                resource.op2();
            }
        });*/

        Resource.use(resource -> {
            resource.op1();
            resource.op2();
        });
    }
}
