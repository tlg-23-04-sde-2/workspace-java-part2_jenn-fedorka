package com.duckrace;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

class DuckRacer implements Serializable {

    //instance variables
    private final int id;
    private String name;
    private final List<Reward> rewards = new ArrayList<>();

    //constructors
    public DuckRacer(int id, String name){
        this.id = id;
        setName(name);
    }

    //business methods
    public void win(Reward reward) {
        rewards.add(reward);
    }

    //accessory methods
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //derived property
    public int getWins() {
        return rewards.size();
    }

    //instead of returning a direct reference to our internal List<Reward>, we return
    // a read-only so the client cannot modify it
    public List<Reward> getRewards() {
        return Collections.unmodifiableList(rewards);
    }

    @Override
    public String toString() {
        return String.format( "%s: ID = %s, Name = %s, Wins = %s, Rewards = %s",
                getClass().getSimpleName(), getId(), getName(), getWins(), getRewards());
    }
}