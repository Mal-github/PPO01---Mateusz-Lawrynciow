package ParkingLotManager.Entities;

import ParkingLotManager.Interfaces.EntityInterface;

public class czolg implements EntityInterface {

    public String identify() {
        return "czo�g ";
    }

    public boolean canEnter() {
        return true;
    }

}