package com.alisher.entity.people;


import java.util.HashSet;
import java.util.Set;

public class NotificationManager {
    private Set<Observer> observers = new HashSet<>();

    public Set<Observer> getObservers() {
        return observers;
    }
}
