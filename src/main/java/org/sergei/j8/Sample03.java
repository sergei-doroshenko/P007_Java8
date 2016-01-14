package org.sergei.j8;

import org.sergei.commons.TimeSlot;

import java.util.Arrays;
import java.util.List;

/**
 * Created by sergei on 1/14/16.
 */
public class Sample03 {
    public static void main(String[] args) {
        List<TimeSlot> timeSlots = Arrays.asList(
            new TimeSlot("1"), new TimeSlot("2"), new TimeSlot("3"), new TimeSlot("4"), new TimeSlot("5"), new TimeSlot("6")
        );

        TimeSlot firstAvailableTimeSlot = null; // null is smell

        for (TimeSlot timeSlot : timeSlots) {
            if (timeSlot.isAvailable()) {
                timeSlot.schedule();
                firstAvailableTimeSlot = timeSlot;
                break;
            }
        }

        TimeSlot firstTimeSlot =
            timeSlots.stream()
                .filter(TimeSlot::isAvailable)
                .findFirst()
                .orElse(new TimeSlot("default"));

        System.out.println("TimeSlot is: " + firstAvailableTimeSlot);
        System.out.println("TimeSlot is: " + firstTimeSlot);
    }
}