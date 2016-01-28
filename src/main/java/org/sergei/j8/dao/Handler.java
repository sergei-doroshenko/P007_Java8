package org.sergei.j8.dao;

/**
 * Created by sergei on 1/28/16.
 */
public class Handler {

    public String handleError(Exception e) {
        System.out.println("Handler: " + e.getMessage());
        return "Handler: Error";
    }
}
