package com.minions.spacechallenge.main;

import com.minions.spacechallenge.item.Item;
import com.minions.spacechallenge.simulation.Simulation;
import com.minions.spacechallenge.spacecraft.Rocket;

import java.util.ArrayList;

public class Main {

    public static void main(String[] Args) {
        Simulation simulation = new Simulation();
        ArrayList<Item> loadItemsPhase1 = simulation.loadItems(System.getProperty("user.dir") + "/resources/phase-1.txt");
        ArrayList<Item> loadItemsPhase2 = simulation.loadItems(System.getProperty("user.dir") + "/resources/phase-2.txt");

        ArrayList<Rocket> rocketsU1Phase1 = simulation.loadU1(loadItemsPhase1);
        ArrayList<Rocket> rocketsU1Phase2 = simulation.loadU1(loadItemsPhase2);
        System.out.print("The total budget required is: ");
        System.out.println(simulation.runSimulation(rocketsU1Phase1));
        System.out.println(simulation.runSimulation(rocketsU1Phase2));

        Simulation simulation2 = new Simulation();
        ArrayList<Rocket> rocketsU2Phase1 = simulation2.loadU2(loadItemsPhase1);
        ArrayList<Rocket> rocketsU2Phase2 = simulation2.loadU2(loadItemsPhase2);
        System.out.print("The total budget required is: ");
        System.out.println(simulation2.runSimulation(rocketsU2Phase1));
        System.out.println(simulation2.runSimulation(rocketsU2Phase2));
    }
}
