package com.mao.strategy;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Cat[] arr = {new Cat(3, 3), new Cat(5, 5), new Cat(1, 1)};
//        Dog[] arr = {new Dog(3), new Dog(5), new Dog(1)};
        Sorter<Cat> sorter = new Sorter<>();
        sorter.sort(arr, new CatHeightComparator());
        System.out.println(Arrays.toString(arr));
    }
}
