package com.mao.abstractfactory;

public class Main {
    public static void main(String[] args) {
        AbstractFactory factory = new ModernFactory();

        Vehicle car = factory.createVehicle();
        car.go();
        Weapon ak47 = factory.createWeapon();
        ak47.shoot();
        Food bread = factory.createFood();
        bread.printName();

    }
}
