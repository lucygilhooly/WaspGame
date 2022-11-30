package org.example;

public class Wasp {

    int hitPoints;
    int losePoints;
    String type;


    public Wasp(int hitPoints, int losePoints, String type) {

        this.hitPoints = hitPoints;
        this.losePoints = losePoints;
        this.type = type;
    }


    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getLosePoints() {
        return losePoints;
    }

    public void setLosePoints(int losePoints) {
        this.losePoints = losePoints;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type + ", they lose "+ losePoints + " points";

    }
}
