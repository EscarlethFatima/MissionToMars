package com.minions.spacechallenge.simulation;

import com.minions.spacechallenge.item.Item;
import com.minions.spacechallenge.spacecraft.Rocket;
import com.minions.spacechallenge.spacecraft.U1;
import com.minions.spacechallenge.spacecraft.U2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Simulation {
    private ArrayList<Item> itemsList;

    public Simulation() {
        itemsList = new ArrayList<>();
    }

    public ArrayList<Item> getItemsList() {
        return itemsList;
    }

    public ArrayList<Item> loadItems(String itemsFilePath) {
        try {
            File file = new File(itemsFilePath);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String[] line = scanner.nextLine().split("=");
                itemsList.add(new Item(line[0], Integer.parseInt(line[1])));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return itemsList;
    }

    public Stack<Rocket> loadU1(ArrayList<Item> itemsList) {
        Stack<Rocket> rocketsList = new Stack<>();
        rocketsList.push(new U1());
        itemsList.forEach(item -> {
            if (rocketsList.peek().canCarry(item)) {
                rocketsList.peek().carry(item);
            } else {
                rocketsList.push(new U1());
            }
        });

        return rocketsList;
    }

    public Stack<Rocket> loadU2(ArrayList<Item> itemsList) {
        Stack<Rocket> rocketsList = new Stack<>();
        rocketsList.push(new U2());
        itemsList.forEach(item -> {
            if (rocketsList.peek().canCarry(item)) {
                rocketsList.peek().carry(item);
            } else {
                rocketsList.push(new U2());
            }
        });

        return rocketsList;
    }

    public int runSimulation(Stack<Rocket> rockets) {
        int budget = 0;

        //Loop through all rockets in the array
        for (Rocket rocket : rockets) {
            while (!rocket.land() || !rocket.launch()) {
                budget = budget + rocket.getCost();
            }
            budget = budget + rocket.getCost();
        }
        return budget;
    }
}
