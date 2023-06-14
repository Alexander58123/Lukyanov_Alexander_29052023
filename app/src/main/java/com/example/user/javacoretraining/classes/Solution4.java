package com.example.user.javacoretraining.classes;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Solution4 {

    public static void main(String[] args) {

        SimpleTime simpleTime = new SimpleTime();
        System.out.println(simpleTime.getTime());
        try {
            System.out.println(simpleTime.setTime(1, 34, 59));
        } catch (Exception e) {
            System.out.println("Скорректируйте правильную дату для изменения");
        }
    }
}

// установку времени можно сделать в конструкторе
// в задание говорится о методах, поэтому были добавлены и методы по изменению
// текущего времени

class SimpleTime {

    private LocalTime localTime;

    // default конструктор (текущая дата)
    public SimpleTime() {
        localTime = LocalTime.now().truncatedTo(ChronoUnit.SECONDS);
    }

    // конструктор (часы, минуты)
    public SimpleTime(int hour, int minute) {
        localTime = LocalTime.of(hour, minute).truncatedTo(ChronoUnit.SECONDS);
    }

    // конструктор (часы, минуты, секунды)
    public SimpleTime(int hour, int minute, int second) {
        localTime = LocalTime.of(hour, minute, second).truncatedTo(ChronoUnit.SECONDS);
    }

    // возврат времени
    public LocalTime getTime() {
        return localTime;
    }

    // пошел перегруженный метод по изменению времени

    // изменение часов
    public LocalTime setTime(int hour) throws Exception {
        LocalTime localTimeNew;

        int tekMinute = localTime.getMinute();
        int tekSecond = localTime.getSecond();

        if (hour >= 0 || hour <= 23) {
            localTimeNew = LocalTime.of(hour, tekMinute, tekSecond);
        } else {
            throw new Exception();
        }

        return localTimeNew;
    }

    // изменение часов и минут
    public LocalTime setTime(int hour, int minute) throws Exception {
        LocalTime localTimeNew;
        int tekSecond = localTime.getSecond();

        if ((hour >= 0 || hour <= 23) && (minute >= 0 || minute <= 59)) {
            localTimeNew = LocalTime.of(hour, minute, tekSecond);
        } else {
            throw new Exception();
        }

        return localTimeNew;
    }

    // изменение часов и минут и секунд
    public LocalTime setTime(int hour, int minute, int second) throws Exception {
        LocalTime localTimeNew;

        if ((hour >= 0 || hour <= 23) && (minute >= 0 || minute <= 59) && (second >=0 || second <= 59)) {
            localTimeNew = LocalTime.of(hour, minute, second);
        } else {
            throw new Exception();
        }

        return localTimeNew;
    }





}