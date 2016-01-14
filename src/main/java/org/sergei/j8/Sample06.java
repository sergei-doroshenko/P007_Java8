package org.sergei.j8;

import java.util.function.Consumer;
import java.util.function.Function;

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

        /*String result = Resource.compute(new Function<Resource, String>() {
            @Override
            public String apply(Resource resource) {
                return resource.op3();
            }
        });*/
        /*String result = Resource.compute(Resource::op3);*/
        String result1 = Resource.cat(resource -> resource.op3() + resource.op4());
        System.out.println(result1);

        String result2 = Resource.compute(resource ->
                        resource.fun1.andThen(resource.fun2).apply(resource)
        );
        System.out.println(result2);
    }
}
