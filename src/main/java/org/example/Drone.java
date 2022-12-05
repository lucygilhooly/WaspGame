package org.example;

public class Drone extends Wasp{
    private int index;

    public Drone(int index) {
        super(60, 12, "Drone");
        this.index = index;
    }
}
