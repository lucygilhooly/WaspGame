package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static ArrayList<Wasp> wasps = new ArrayList<>();
    public static int index = (int) (Math.random() * wasps.size());
    public static boolean gameActive = true;

    public static void waspNest() {
        for (int i = 0; i < 5; i++) {
            Worker worker = new Worker(i);
            wasps.add(worker);
        }
        for (int i = 0; i < 8; i++) {
            Drone drone = new Drone(i);
            wasps.add(drone);
        }

        Queen queen = new Queen();
        wasps.add(queen);

        System.out.println("you have 1 queen, 5 worker wasps and 8 drone wasps in the nest");

    }
    public static void losePoints(){
        wasps.get(index).hitPoints -= wasps.get(index).losePoints;
        System.out.println("the " + wasps.get(index).type + " has " + wasps.get(index).hitPoints + " remaining");
        if (wasps.get(index).hitPoints<= 0){
            wasps.remove(wasps.get(index));
            System.out.println(wasps.get(index).type + " wasp down, the remaining nest is " + wasps);
        }
    }

    public static void shootWasp() {
        while(gameActive) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("hit the enter key to take a shot at a wasp!");
            scanner.nextLine();

            System.out.println("you shot down a " + wasps.get(index).toString());

            if (wasps.get(index).type.equals("Queen")){
                wasps.get(index).hitPoints -= wasps.get(index).losePoints;
                System.out.println("the queen has " + wasps.get(index).hitPoints + " remaining");
                if (wasps.get(index).hitPoints == 0){
                    gameActive = false;
                    System.out.println("The Nest has been defeated!!");
                }
            }
            if (wasps.get(index).type.equals("Worker") || wasps.get(index).type.equals("Drone")){
               losePoints();
            }
        }

    }

    public static void waspGame(){

        System.out.println("Welcome to my wasp game");
        waspNest();
        shootWasp();
    }


    public static void main(String[] args) {
            waspGame();
    }
}