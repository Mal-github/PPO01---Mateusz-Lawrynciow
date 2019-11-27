package ParkingLotManager;

import ParkingLotManager.Entities.Bicycle;
import ParkingLotManager.Entities.Car;
import ParkingLotManager.Entities.Poj_uprzy;
import ParkingLotManager.Entities.Pedestrian;
import ParkingLotManager.Entities.Kurier;
import ParkingLotManager.Entities.czolg;
import ParkingLotManager.Entities.TeacherCar;
import ParkingLotManager.Interfaces.EntityInterface;

import java.util.ArrayList;
import java.util.Random;

final public class ParkingLot {
	Random random = new Random();

    private ArrayList<EntityInterface> entitiesOnProperty = new ArrayList<>();
    private int samochody = 0;
    private int maks_samochodow = 700;
    private int rowery = 0;
    private int maksrowerow = 5;
    private float kasa = 0;


    public boolean checkIfCanEnter(EntityInterface entity) {
        return entity.canEnter();
    }

    public void letIn(EntityInterface entity) {
        entitiesOnProperty.add(entity);
        
        if(entity instanceof Car&&samochody<maks_samochodow) {
        	int los = random.nextInt(101);
        	Log.info(entity.identify() + " let in.");
        	if (los>=0&&los<=40) {
        	Log.info("sprzedano bilet");
        	kasa = (float) (kasa+1.50);
        	}
        	if (los>=40&&los<=70) {
            Log.info("sprzedano bilet ca�odzienny");
            kasa = (float) (kasa+5.00);
            }
        	if (los>=70&&los<=95) {
            Log.info("sprzedano bilet miesi�czny");
            kasa = (float) (kasa+20.00);
            }
        	if (los>=95&&los<=100) {
            Log.info("ten pojaz ju� posiada bilet");
            }
            samochody++;    
    	}
        
        if(entity instanceof TeacherCar&&samochody<maks_samochodow) {
        	Log.info(entity.identify() + " wpu�� go");
        	Log.info("Profesor nie p�aci za miejsce parkingowe");
            samochody++;    
    	}
        if(entity instanceof Car&&maks_samochodow==samochody) {
    		Log.info(entity.identify() + " zakaz dost�pu parking jest pe�yny.");
    	}
        if(entity instanceof Bicycle&&rowery<maksrowerow) {
    		Log.info(entity.identify() + " wpu�� go");
    		rowery++;
    	}
    	
    	if(entity instanceof Bicycle&&rowery==maksrowerow) {
    		Log.info(entity.identify() + " zakaz dost�pu stojak na rowery jest pe�ny .");
    	}
        
        if(entity instanceof Poj_uprzy) {
        	Log.info(entity.identify() + " wpu�� go.");
        	Log.info("pojazd uprzywilejowany nie p�aci za wst�p i nie zabiera miejsca na parkingu");
  
        }
        
        if(entity instanceof Kurier) {
        	Log.info(entity.identify() + " wpu�� go.");
        	Log.info("kurier nie p�aci za wst�p i nie zabiera miejsca na parkingu");
        }
        
    	if(entity instanceof Pedestrian) {
    		Log.info(entity.identify() + " wpu�� go");
    	}
    	
    	if(entity instanceof czolg) {
    		Log.info(entity.identify() + " zakaz dost�pu jest zbyt szeroki");
    	}
    	
    }

    public int licznik() {
        return samochody;
    }
    public float skarbonka() {
    	return kasa;
    }

}


