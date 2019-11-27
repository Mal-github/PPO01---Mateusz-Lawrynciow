package ParkingLotManager.Entities;

import ParkingLotManager.Interfaces.EntityInterface;

public class TeacherCar implements EntityInterface {

    private String plate;

    public TeacherCar(String plate) {
        this.plate = plate;
    }

    public String identify() {
        return "samochod Profesora z nr tablicy: " + plate;
    }

    public boolean canEnter() {
        return true;
    }

}