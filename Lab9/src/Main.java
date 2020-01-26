import Zoo.Animals.Elephant;
import Zoo.Animals.Giraffe;
import Zoo.Animals.Lion;
import Zoo.Animals.Penguin;
import Zoo.Animals.*;
import Zoo.Zoo;

public class Main {

    public static void main(String[] args) {
        Zoo zoo = new Zoo("Zoo Legnica");
        int time = 6;
        zoo.addAnimal(new Lion("Simba"))
            .addAnimal(new Lion("Mufasa"))
            .addAnimal(new Elephant("Dumbo"));
        zoo.addAnimal(new Giraffe("Pasek"));
        zoo.addAnimal(new Penguin("Kowalski"));
        zoo.addAnimal(new Tiger("Rambo"));
        zoo.addAnimal(new Horse("P³otka"));
    
        if(time==6) {
        	System.out.println("Time:"+time+" o'clock");
        zoo.feedAnimals("meat");
        time+=1;
        }
        if(time==7) {
        	System.out.println("Time:"+time+"o'clock");
        zoo.feedAnimals("fish");
        time+=1;
        }
        if(time==8) {
        	System.out.println("Time:"+time+"o'clock");
        zoo.feedAnimals("milk");
        time+=1;
        }
        if(time==9) {
        	System.out.println("Time:"+time+"o'clock");
        zoo.feedAnimals("fruits");
        time+=1;
        }
}
}