package com.minions.spacechallenge.spacecraft;

import com.minions.spacechallenge.item.Item;

public interface SpaceShip {
    boolean launch();

    boolean land();

    boolean canCarry(Item item);

    void carry(Item item);
}
