package com.mao.strategy;

public class Dog implements Comparable<Dog>{
    int food;

    public Dog(int food) {
        this.food = food;
    }

    @Override
    public int CompareTo(Dog dog) {
        if (this.food < dog.food) {
            return -1;
        } else if (this.food > dog.food) {
            return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "food=" + food +
                '}';
    }

}
