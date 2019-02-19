package com.minions.spacechallenge.spacecraft;

public class U2 extends Rocket {
    public U2() {
        super(120000000, 18000, 29000);
    }

    @Override
    public boolean launch() {
        return Math.random() > 0.04 * (weight / maxWeight);
    }

    @Override
    public boolean land() {
        return Math.random() > 0.08 * (weight / maxWeight);
    }
}
