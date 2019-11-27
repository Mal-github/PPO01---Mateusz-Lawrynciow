package ParkingLotManager;

import ParkingLotManager.Entities.Bicycle;
import ParkingLotManager.Entities.Car;
import ParkingLotManager.Entities.Pedestrian;
import ParkingLotManager.Entities.TeacherCar;
import ParkingLotManager.Interfaces.EntityInterface;
import ParkingLotManager.Entities.Kurier;
import ParkingLotManager.Entities.czolg;
import ParkingLotManager.Entities.Poj_uprzy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class QueueGenerator {
	static Random random = new Random();

    private static final int ANONYMOUS_PEDESTRIANS_COUNT = random.nextInt(101)+1;
    private static final int PEDESTRIANS_COUNT = random.nextInt(21)+1;
    private static final int CARS_COUNT = random.nextInt(16)+1;
    private static final int TEACHER_CARS_COUNT = random.nextInt(16)+1;
    private static final int BICYCLES_COUNT = random.nextInt(3)+1;
    private static final int POJ_UPRZY_COUNT = random.nextInt(2)+1;
    private static final int KURIER_COUNT = random.nextInt(5)+1;
    private static final int CZOLG_COUNT = random.nextInt(1)+1;

    public static ArrayList<EntityInterface> generate() {
        ArrayList<EntityInterface> queue = new ArrayList<>();

        for (int i = 0; i <= ANONYMOUS_PEDESTRIANS_COUNT; i++) {
            queue.add(new Pedestrian());
        }

        for (int i = 0; i <= PEDESTRIANS_COUNT; i++) {
            queue.add(new Pedestrian(getRandomName()));
        }

        for (int i = 0; i <= CARS_COUNT; i++) {
            queue.add(new Car(getRandomPlateNumber()));
        }

        for (int i = 0; i <= TEACHER_CARS_COUNT; i++) {
            queue.add(new TeacherCar(getRandomPlateNumber()));
        }

        for (int i = 0; i <= BICYCLES_COUNT; i++) {
            queue.add(new Bicycle());
        }
        for (int i = 0; i <= POJ_UPRZY_COUNT; i++) {
            queue.add(new Poj_uprzy(getRandomPlateNumber()));
        }
        
        for (int i = 0; i <= KURIER_COUNT; i++) {
            queue.add(new Kurier(getRandomPlateNumber()));
        }
        
        for (int i = 0; i <= CZOLG_COUNT; i++) {
            queue.add(new czolg());
        }

        Collections.shuffle(queue);

        return queue;
    }

    private static String getRandomPlateNumber() {
        Random generator = new Random();
        return "DLX " + (generator.nextInt(89999) + 10000);
    }

    private static String getRandomName() {
        String[] names = {"John", "Jack", "James", "George", "Joe", "Jim"};
        return names[(int) (Math.random() * names.length)];
    }

}
