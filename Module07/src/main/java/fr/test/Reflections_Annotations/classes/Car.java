package fr.test.Reflections_Annotations.classes;

public class Car {
    private String brand;
    private String model;
    private int year;

    public Car() {
        this.brand = "BMW";
        this.model = "rs3";
        this.year = 2021;
    }


    public Car(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    public void start() {
        System.out.println("Starting the car.");
    }

    public void drive() {
        System.out.println("Driving the car.");
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                '}';
    }
}