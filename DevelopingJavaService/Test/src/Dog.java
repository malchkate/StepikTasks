import java.util.ArrayList;
import java.util.List;

class Animal {}



public class Dog extends Animal {

    public static void main(String[] args) {

        List<Dog> dogs = new ArrayList<>();

        List<Animal> animals = dogs;

    }

}