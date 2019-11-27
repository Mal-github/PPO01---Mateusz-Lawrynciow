package ParkingLotManager.Entities;

import ParkingLotManager.Interfaces.EntityInterface;

public class Kurier implements EntityInterface {

    private String plate;

    public Kurier(String plate) {
        this.plate = plate;
    }

    public String identify() {
        return "Kurier z nr tabliczy " + plate;
    }

    public boolean canEnter() {
        return true;
    }

}
