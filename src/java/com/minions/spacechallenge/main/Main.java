package com.minions.spacechallenge.main;

import com.minions.spacechallenge.simulation.Simulation;
import com.minions.spacechallenge.spacecraft.Rocket;

import java.util.Stack;

public class Main {

    public static void main(String[] Args) {
        Simulation simulation = new Simulation();
        simulation.loadItems("phase-1.txt");
        simulation.loadItems("phase-2.txt");
        Stack<Rocket> rocketsU1 = simulation.loadU1(simulation.getItemsList());
        System.out.print("The total budget required is: ");
        System.out.println(simulation.runSimulation(rocketsU1));

        Simulation simulation2 = new Simulation();
        simulation2.loadItems("phase-1.txt");
        simulation2.loadItems("phase-2.txt");
        Stack<Rocket> rocketsU2 = simulation2.loadU2(simulation.getItemsList());
        System.out.print("The total budget required is: ");
        System.out.println(simulation2.runSimulation(rocketsU2));
    }
}
