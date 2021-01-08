/*
  Author: Marcus Linné, Linnéa Mörk
  Id: ai8851, al2804
  Study program: DT
*/

package model;

/**
 * Ship class clarifies the different ships should contain and whether they are dead or not
 */
public abstract class Ship {
    private final ShipType shipType;
    private final int length;
    private int hits = 0;

    public Ship(ShipType shipType, int length){
        this.shipType = shipType;
        this.length = length;
    }

    public ShipType getShipType() {
        return shipType;
    }

    public int getLength() {
        return length;
    }

    public int getHits() {
        return hits;
    }

    public void incHits() {
        hits++;
    }

    public boolean isDead() {
        if (length-hits <= 0) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return shipType.name();
    }
}