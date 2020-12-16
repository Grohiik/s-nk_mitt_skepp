package model;

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
}
