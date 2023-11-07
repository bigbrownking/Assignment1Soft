package com.alisher.entity.people;

import java.util.ArrayList;
import java.util.List;

public class NotificationManager {
    private List<Observer> observers = new ArrayList<>();

    public List<Observer> getObservers() {
        return observers;
    }

    public void setObservers(List<Observer> observers) {
        this.observers = observers;
    }
}
