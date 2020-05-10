package garage;

import cars.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Garage {

    private ArrayList<Car> cars;

    private ArrayList<GarageProduct> inventory;

    public Garage() {

        inventory = new ArrayList<>();

        cars = new ArrayList<>();
        //cars.add(getRandomCar());
    }

    public void addToInventory(GarageProduct product) {
        inventory.add(product);
    }

    public ArrayList<GarageProduct> getInventory() {
        return inventory;
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    /*public Car getRandomCar() {
        return new Car(
                "Carx",
                bodies.get(new Random().nextInt(bodies.size())),
                motors.get(new Random().nextInt(tires.size())),
                tires.get(new Random().nextInt(tires.size())),
                spoilers.get(new Random().nextInt(tires.size())),
                Color.RED);
    }*/
}
