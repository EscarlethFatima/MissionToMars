package com.minions.spacechallenge.spacecraft;

import com.minions.spacechallenge.item.Item;

public abstract class Rocket implements SpaceShip {
    protected double cost;
    protected double weight;
    protected double maxWeight;

    public Rocket(double cost, double weight, double maxWeight) {
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

    public double getCost() {
        return cost;
    }
}
