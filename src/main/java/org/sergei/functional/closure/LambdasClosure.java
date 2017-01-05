package org.sergei.functional.closure;

import java.util.function.Function;
import java.util.stream.IntStream;

/**
 * Created by Sergei_Doroshenko on 1/5/2017.
 */
public class LambdasClosure {
    public Function<Integer, Integer> getMultiplicator(){
        int a = 10;

        return arg -> {
            arg += 1;
            return a + arg;
        };
    };

    public static void main ( String[] args ) {
        LambdasClosure lambdasClosure = new LambdasClosure();
        Function<Integer, Integer> x = lambdasClosure.getMultiplicator();
        for(int i = 0; i < 5; i++) {
            System.out.println( x.apply( i ) );
        };
    }
}
