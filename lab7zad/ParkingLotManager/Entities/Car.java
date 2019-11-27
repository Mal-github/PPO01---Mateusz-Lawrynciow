package ParkingLotManager.Entities;

import java.util.Random;

import ParkingLotManager.Log;
import ParkingLotManager.Interfaces.EntityInterface;

public class Car implements EntityInterface {

    private String plate;

    public Car(String plate) {
        this.plate = plate;
    }

    public String identify() {
        return "samochod z nr tablicy " + plate;
    }

    public boolean canEnter() {
    	Random zakazana_tablica = new Random();
    	int ban_tab = zakazana_tablica.nextInt(101);
    	if(ban_tab>=0&&ban_tab<=90) {
    		return true;
    	}else{
    		Log.info("ten samochód" + plate +" jest na czarnej liœcie");
    		return false;
    	}
    }
}
