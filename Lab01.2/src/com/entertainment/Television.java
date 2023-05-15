package com.entertainment;

public class Television {

    //instance variables
    private String brand;
    private int volume;

    //Television has a tuner
    private Tuner tuner = new Tuner();

    //constructors
    public Television() {
    }

    public Television(String brand, int volume) {
    }

    //business methods
    public int getCurrentChannel() {
        return tuner.getChannel(); //delegate to contained tuner object
    }

    public void changeChannel(int channel) {
        tuner.setChannel(channel); //delegate to contained Tuner object
    }

    //accessor methods
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    //toString method

    @Override
    public String toString() {
        return String.format("%s: Brand = %S, " + "Volume = %S, Channel = %S",
                getClass().getSimpleName(), getBrand(), getVolume(), getCurrentChannel());
    }

}