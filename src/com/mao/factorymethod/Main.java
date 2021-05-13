package com.mao.factorymethod;

public class Main {
    public static void main(String[] args) {
        Moveable car1 = new Car();
        car1.go();

        Moveable car2 = new SimpleVehicleFactory().createCar();
        car2.go();

        Moveable car3 = new CarFactory().create();
        car3.go();
    }
}
