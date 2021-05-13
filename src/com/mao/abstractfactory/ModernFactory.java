package com.mao.abstractfactory;

public class ModernFactory extends AbstractFactory {

    @Override
    Vehicle createVehicle() {
        return new Car();
    }

    @Override
    Food createFood() {
        return new Bread();
    }

    @Override
    Weapon createWeapon() {
        return new AK47();
    }
}
