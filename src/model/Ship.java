/*
  Author: Marcus Linné, Linnéa Mörk
  Id: ai8851, al2804
  Study program: DT
*/

package model;

// This abstract class clarifies what the different shiptypes should or could contain
public abstract class Ship {
    private final ShipType shipType;
    private boolean shot = false;
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

    public boolean isShot() {
        return shot;
    }
    public void setShot(boolean shot) {
        this.shot = shot;
    }
}
