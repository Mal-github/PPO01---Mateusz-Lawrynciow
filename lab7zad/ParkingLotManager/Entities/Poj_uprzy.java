package ParkingLotManager.Entities;


import ParkingLotManager.Interfaces.EntityInterface;

public class Poj_uprzy implements EntityInterface {

    private String plate;

    public Poj_uprzy(String plate) {
        this.plate = plate;
    }

    public String identify() {
        return "Pojazd Uprzywiywilejowny z nr tablicy: " + plate;
    }

    public boolean canEnter() {
        return true;
    }

}
