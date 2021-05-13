package com.mao.abstractfactory;

public class MagicFactory extends AbstractFactory {

    @Override
    Vehicle createVehicle() {
        return new Broom();
    }

    @Override
    Food createFood() {
        return new Mushroom();
    }

    @Override
    Weapon createWeapon() {
        return new MagicStick();
    }
}
