package com.example.user.javacoretraining.threeblock;

public class Zadanie1 {

    public static void main(String[] args) {

        Printable myClosure;
        myClosure = s -> System.out.println(s);
        myClosure.print("I love Java");

        //--------------------------------

        Zadanie1 zadanie1 = new Zadanie1();
        Runnable task = () -> {
            System.out.println("I love Java");
        };

        zadanie1.repeatTask(5, task);


    }

    public void repeatTask(int times, Runnable task) {
        for (int i = 0; i < times; i++) {
            new Thread(task).start();
        }
    }
}

interface Printable {
    void print(String s);
}