import ParkingLotManager.Interfaces.EntityInterface;
import ParkingLotManager.Log;
import ParkingLotManager.ParkingLot;
import ParkingLotManager.QueueGenerator;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
    	int zegarek;
    	zegarek=6;
        ArrayList<EntityInterface> queue = QueueGenerator.generate();
        ParkingLot parkinglot = new ParkingLot();
        do{
        System.out.println("godzina:");
        System.out.println(zegarek);
        Log.info("samochodów na parkingu: " + parkinglot.licznik());
        Log.info();

        for (EntityInterface entity : queue) {
            if(parkinglot.checkIfCanEnter(entity)) {
                parkinglot.letIn(entity);
            }
        }

        Log.info();
        Log.info("samochodów na parkingu: " + parkinglot.licznik() );
        zegarek++;
    	}
    	while(zegarek>5&&zegarek<23);
        Log.info("skarbonka: " + parkinglot.skarbonka() + "z³");
    }
}
