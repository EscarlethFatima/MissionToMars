package com.minions.spacechallenge.simulation;

import com.minions.spacechallenge.item.Item;
import com.minions.spacechallenge.spacecraft.Rocket;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {
    private ArrayList<Rocket> rocketList;

    public Simulation() {
        rocketList = new ArrayList<>();
    }

    public ArrayList<Item> loadItems(String itemsFilePath) {
        ArrayList<Item> itemList = new ArrayList<>();
        try {
            File file = new File(itemsFilePath);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String[] line = scanner.nextLine().split("=");
                itemList.add(new Item(line[0], Integer.parseInt(line[1])));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return itemList;
    }
}
