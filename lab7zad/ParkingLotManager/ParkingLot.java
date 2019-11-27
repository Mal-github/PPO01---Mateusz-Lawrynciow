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
            Log.info("sprzedano bilet ca³odzienny");
            kasa = (float) (kasa+5.00);
            }
        	if (los>=70&&los<=95) {
            Log.info("sprzedano bilet miesiêczny");
            kasa = (float) (kasa+20.00);
            }
        	if (los>=95&&los<=100) {
            Log.info("ten pojaz ju¿ posiada bilet");
            }
            samochody++;    
    	}
        
        if(entity instanceof TeacherCar&&samochody<maks_samochodow) {
        	Log.info(entity.identify() + " wpuœæ go");
        	Log.info("Profesor nie p³aci za miejsce parkingowe");
            samochody++;    
    	}
        if(entity instanceof Car&&maks_samochodow==samochody) {
    		Log.info(entity.identify() + " zakaz dostêpu parking jest pe³yny.");
    	}
        if(entity instanceof Bicycle&&rowery<maksrowerow) {
    		Log.info(entity.identify() + " wpuœæ go");
    		rowery++;
    	}
    	
    	if(entity instanceof Bicycle&&rowery==maksrowerow) {
    		Log.info(entity.identify() + " zakaz dostêpu stojak na rowery jest pe³ny .");
    	}
        
        if(entity instanceof Poj_uprzy) {
        	Log.info(entity.identify() + " wpuœæ go.");
        	Log.info("pojazd uprzywilejowany nie p³aci za wstêp i nie zabiera miejsca na parkingu");
  
        }
        
        if(entity instanceof Kurier) {
        	Log.info(entity.identify() + " wpuœæ go.");
        	Log.info("kurier nie p³aci za wstêp i nie zabiera miejsca na parkingu");
        }
        
    	if(entity instanceof Pedestrian) {
    		Log.info(entity.identify() + " wpuœæ go");
    	}
    	
    	if(entity instanceof czolg) {
    		Log.info(entity.identify() + " zakaz dostêpu jest zbyt szeroki");
    	}
    	
    }

    public int licznik() {
        return samochody;
    }
    public float skarbonka() {
    	return kasa;
    }

}


