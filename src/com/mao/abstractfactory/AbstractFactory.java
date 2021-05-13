package com.mao.abstractfactory;

public abstract class AbstractFactory {
    abstract Vehicle createVehicle();

    abstract Food createFood();

    abstract Weapon createWeapon();
}
