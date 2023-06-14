package com.example.user.javacoretraining.classes;


import java.util.ArrayList;
import java.util.Random;

public class Solution2 {

    public static void main(String[] args) {

        ZadanieTwo superMassive = new ZadanieTwo(100);
        System.out.println(superMassive.kolvoElementov());

        superMassive.zapolRandom();

        superMassive.vuvodNaEkran();

        superMassive.shuffleElementu();
        System.out.println();
        superMassive.vuvodNaEkran();

        System.out.println();
        System.out.println(superMassive.countElementu(5));
    }
}

class ZadanieTwo {

    private ArrayList<Integer> massive;
    private int kolvo;

    public ZadanieTwo(int value) {
        massive = new ArrayList<>(value);
        kolvo = value;
    }

    public int kolvoElementov() {
        return kolvo;
    }

    // заполнение
    public void zapolRandom() {
        Random random = new Random();
        for (int i = 0; i < kolvo; i++) {
            massive.add(i, random.nextInt(100));
        }
    }

    // перемешать
    public void shuffleElementu() {
        Random rnd = new Random();
        for (int i = kolvo - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            Integer temp = massive.get(index);
            massive.set(index, massive.get(i));
            massive.set(i, temp);
        }
    }

    // поиск количества элементов
    public int countElementu(int value) {
        int count = 0;

        for (int i = 0; i < kolvo; i++) {
            if (massive.get(i) == value) {
                count = count + 1;
            }
        }
        return count;
    }

    // вывод
    public void vuvodNaEkran() {
        for (int i = 0; i < kolvo; i++) {
            System.out.print(massive.get(i) + " ");
        }
    }
}
