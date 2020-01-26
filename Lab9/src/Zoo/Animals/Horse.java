package Zoo.Animals;

public class Horse extends Animal {

    public Horse(String name) {
        super(name);
    }

    @Override
    String[] getDiet() {
        return new String[]{"water", "fruits", "vegetables"};
    }

}
