package ParkingLotManager.Entities;

import ParkingLotManager.Interfaces.EntityInterface;

public class czolg implements EntityInterface {

    public String identify() {
        return "czo³g ";
    }

    public boolean canEnter() {
        return true;
    }

}