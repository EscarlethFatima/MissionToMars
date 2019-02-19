package com.minions.spacechallenge;

import com.minions.spacechallenge.item.Item;
import com.minions.spacechallenge.simulation.Simulation;
import com.minions.spacechallenge.spacecraft.Rocket;

import java.util.ArrayList;

public class Main {

    public static void main(String[] Args) {
        System.out.println("------------------WELCOME TO MISSION TO MARS------------------");
        Simulation simulation = new Simulation();
        ArrayList<Item> loadItemsPhase1 = simulation.loadItems("Phase-1.txt");
        ArrayList<Item> loadItemsPhase2 = simulation.loadItems("Phase-2.txt");
        System.out.println("=====ROCKET U1====");

        ArrayList<Rocket> rocketsU1Phase1 = simulation.loadU1(loadItemsPhase1);
        ArrayList<Rocket> rocketsU1Phase2 = simulation.loadU1(loadItemsPhase2);
        System.out.println("The total budget required is:");
        System.out.println(String.format("Phase 1: %.0f" , simulation.runSimulation(rocketsU1Phase1)));
        System.out.println(String.format("Phase 2: %.0f" , simulation.runSimulation(rocketsU1Phase2)));

        System.out.println("=====ROCKET U2====");

        Simulation simulation2 = new Simulation();
        ArrayList<Rocket> rocketsU2Phase1 = simulation2.loadU2(loadItemsPhase1);
        ArrayList<Rocket> rocketsU2Phase2 = simulation2.loadU2(loadItemsPhase2);
        System.out.println("The total budget required is:");
        System.out.println(String.format("Phase 1: %.0f", simulation2.runSimulation(rocketsU2Phase1)));
        System.out.println(String.format("Phase 2: %.0f", simulation2.runSimulation(rocketsU2Phase2)));
    }
}
