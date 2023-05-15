package com.crisp;

/*
 * Natural order is given by size (double). this is called the sort key.
 */

class Radish implements Comparable<Radish> {
    private String color;
    private double size;
    private double tailLength;
    private int guysOnTop;

    //Constructors
    public Radish(String color, double size, double tailLength, int guysOnTop) {
        setColor(color);
        setSize(size);
        setTailLength(tailLength);
        setGuysOnTop(guysOnTop);
    }

    //accessor methods
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public double getTailLength() {
        return tailLength;
    }

    public void setTailLength(double tailLength) {
        this.tailLength = tailLength;
    }

    public int getGuysOnTop() {
        return guysOnTop;
    }

    public void setGuysOnTop(int guysOnTop) {
        this.guysOnTop = guysOnTop;
    }

    @Override   //interface comparable
    public int compareTo(Radish other) {
        return Double.compare(this.getSize(), other.getSize());
    }

    //Description
    @Override
    public String toString() {
        return String.format("%s: Color = %s, Size = %s, tailLength = %s, guysOnTop = %s",
                getClass().getSimpleName(), getColor(), getSize(), getTailLength(), getGuysOnTop());
    }
}