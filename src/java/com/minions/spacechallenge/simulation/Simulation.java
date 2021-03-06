package com.minions.spacechallenge.simulation;

import com.minions.spacechallenge.item.Item;
import com.minions.spacechallenge.spacecraft.Rocket;
import com.minions.spacechallenge.spacecraft.U1;
import com.minions.spacechallenge.spacecraft.U2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {

    public ArrayList<Item> loadItems(String itemsFile) {
        String itemsFilePath = String.format("%s%sresources%s%s",
                                            System.getProperty("user.dir"), File.separator, File.separator, itemsFile);
        ArrayList<Item> itemsList = new ArrayList<>();
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

    public ArrayList<Rocket> loadU1(ArrayList<Item> itemsList) {
        ArrayList<Rocket> rocketsList = new ArrayList<>();
        rocketsList.add(new U1());
        itemsList.forEach(item -> {
            if (rocketsList.get(rocketsList.size() - 1).canCarry(item)) {
                rocketsList.get(rocketsList.size() - 1).carry(item);
            } else {
                rocketsList.add(new U1());
            }
        });

        return rocketsList;
    }

    public ArrayList<Rocket> loadU2(ArrayList<Item> itemsList) {
        ArrayList<Rocket> rocketsList = new ArrayList<>();
        rocketsList.add(new U2());
        itemsList.forEach(item -> {
            if (rocketsList.get(rocketsList.size() - 1).canCarry(item)) {
                rocketsList.get(rocketsList.size() - 1).carry(item);
            } else {
                rocketsList.add(new U2());
            }
        });

        return rocketsList;
    }

    public double runSimulation(ArrayList<Rocket> rockets) {
        double budget = 0;
        for (Rocket rocket : rockets) {
            while (!rocket.land() || !rocket.launch()) {
                budget += rocket.getCost();
            }
            budget += rocket.getCost();
        }
        return budget;
    }
}
