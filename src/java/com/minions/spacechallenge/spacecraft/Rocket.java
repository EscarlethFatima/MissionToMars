package com.minions.spacechallenge.spacecraft;

import com.minions.spacechallenge.item.Item;

public abstract class Rocket implements SpaceShip {
    protected int cost;
    protected int weight;
    protected int maxWeight;

    public Rocket(int cost, int weight, int maxWeight) {
        this.cost = cost;
        this.weight = weight;
        this.maxWeight = maxWeight;
    }

    @Override
    public boolean canCarry(Item item) {
        return item.getWeight() + weight <= maxWeight;
    }

    @Override
    public void carry(Item item) {
        weight += item.getWeight();
    }

    public int getWeight() {
        return weight;
    }
}
