package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static Wasp queen = new Wasp(80, 7, "Queen");
    public static Wasp workerWasp = new Wasp(68, 10, "Worker Wasp");
    public static Wasp droneWasp = new Wasp(60, 12, "Drone Wasp");
    public static ArrayList<Wasp> wasps = new ArrayList<>();

    public static boolean gameActive = true;

    public static void waspNest() {
        System.out.println("1 " + queen.type + " with " + queen.hitPoints + " starting points");
        System.out.println("5 " + workerWasp.type + "s with " + workerWasp.hitPoints + " starting points");
        System.out.println("8 " + droneWasp.type + "s with " + droneWasp.hitPoints + " starting points");
        wasps.add(queen);
        wasps.add(workerWasp);
        wasps.add(workerWasp);
        wasps.add(workerWasp);
        wasps.add(workerWasp);
        wasps.add(workerWasp);
        wasps.add(droneWasp);
        wasps.add(droneWasp);
        wasps.add(droneWasp);
        wasps.add(droneWasp);
        wasps.add(droneWasp);
        wasps.add(droneWasp);
        wasps.add(droneWasp);
        wasps.add(droneWasp);
    }

    public static void shootWasp() {
        while(gameActive) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("hit the enter key to take a shot at a wasp!");
            scanner.nextLine();

            int index = (int) (Math.random() * wasps.size());
            System.out.println("you shot down a " + wasps.get(index).toString());

            if (wasps.get(index) == queen){
                queen.hitPoints -= queen.losePoints;
                System.out.println("the queen has " + queen.hitPoints + " remaining");
                if (queen.hitPoints == 0){
                    gameActive = false;
                    System.out.println("The Nest has been defeated!!");
                }
            }
            if (wasps.get(index) == workerWasp){
                workerWasp.hitPoints -= workerWasp.losePoints;
                System.out.println("the worker has " + workerWasp.hitPoints + " remaining");
                if (workerWasp.hitPoints <= 0){
                    wasps.remove(workerWasp);
                    System.out.println("worker wasp down, the remaining nest is " + wasps.toString());
                }
            }
            if (wasps.get(index) == droneWasp){
                droneWasp.hitPoints -= droneWasp.losePoints;
                System.out.println("the drone has " + droneWasp.hitPoints + " remaining");
                if (droneWasp.hitPoints <= 0){
                    wasps.remove(droneWasp);
                    System.out.println("drone wasp down, the remaining nest is " + wasps.toString());
                }
            }
        }

    }
    public static void waspGame(){

        System.out.println("Welcome to my wasp game");
        System.out.println("the starting team is: " );
        waspNest();
        shootWasp();
    }


    public static void main(String[] args) {
            waspGame();
    }
}