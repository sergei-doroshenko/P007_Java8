package org.sergei.j8.dao;

/**
 * Created by sergei on 1/28/16.
 */
@FunctionalInterface
interface DaoFunction<A, B, R> {
    R apply(A a, B b);
}
