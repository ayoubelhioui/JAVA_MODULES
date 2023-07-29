package fr.test.Reflections_Annotations.Reflection;

import fr.test.Reflections_Annotations.classes.Car;
import fr.test.Reflections_Annotations.classes.User;

import java.util.Scanner;

public class Reflection {
    private User user;
    private Car car;
    Scanner scanner;

    public Reflection() {
        this.user = new User();
        this.car = new Car();
        this.scanner = new Scanner(System.in);
    }


}
