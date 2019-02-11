package com.minions.spacechallenge.spacecraft;

public class U1 extends Rocket {
    public U1() {
        super(100000000, 10000, 18000);
    }

    @Override
    public boolean launch() {
        return Math.random() < 0.05 * (weight / maxWeight);
    }

    @Override
    public boolean land() {
        return Math.random() < 0.01 * (weight / maxWeight);
    }
}
