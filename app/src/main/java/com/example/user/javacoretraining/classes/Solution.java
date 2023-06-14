package com.example.user.javacoretraining.classes;

public class Solution {

    public static void main(String[] args) {


        // под первую задача I
        ZadanieOne zadanieOne = new ZadanieOne();
        zadanieOne.setPeremOne(5);
        zadanieOne.setPeremTwo(10);

        System.out.println(zadanieOne.summaZnachenii());

        System.out.println(zadanieOne.naibolZnachenie());

        zadanieOne.vuvodNaEkran();

    }

}


class ZadanieOne {
    private int peremOne;
    private int peremTwo;

    public void setPeremOne(int peremOne) {
        this.peremOne = peremOne;
    }

    public void setPeremTwo(int peremTwo) {
        this.peremTwo = peremTwo;
    }

    // сумма
    public int summaZnachenii() {
        return peremOne + peremTwo;
    }

    // наибольшее значение
    public int naibolZnachenie() {
        return (peremOne > peremTwo) ? peremOne : peremTwo;
    }

    // вывод
    public void vuvodNaEkran() {
        System.out.println("Переменная один: " + peremOne);
        System.out.println("Переменная два: " + peremTwo);
    }


}
