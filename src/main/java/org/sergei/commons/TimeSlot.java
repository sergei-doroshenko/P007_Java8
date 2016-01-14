package org.sergei.commons;

import java.util.Random;

/**
 * Created by sergei on 1/14/16.
 */
public class TimeSlot {
    private static Random random = new Random();
    private String name;

    public TimeSlot(String name) {
        this.name = name;
    }

    public void schedule() {

    }

    public boolean isAvailable() {
        return random.nextBoolean();
    }

    @Override
    public String toString() {
        return "TimeSlot{" +
                "name='" + name + '\'' +
                '}';
    }
}
