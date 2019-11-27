package ParkingLotManager.Entities;

import ParkingLotManager.Interfaces.EntityInterface;

public class Bicycle implements EntityInterface {

    public String identify() {
        return "nieznany rower";
    }

    public boolean canEnter() {
        return true;
    }

}
