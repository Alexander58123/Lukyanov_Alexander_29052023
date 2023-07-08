package com.example.user.javacoretraining.classes;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Solution5 {

    final static LocalTime limitMinutGorodskie = LocalTime.of(3, 20, 0); // лимит для гор. переговоров, 200 мин.

    public static void main(String[] args) {

        ArrayList<Abonent> list = new ArrayList<>();

        Abonent abonent1 = new Abonent("Спиридонов", "Александр", "Александрович", "г. Москва, ул. Тверская 154");
        Abonent abonent2 = new Abonent("Кондрашев", "Дмитрий", "Валерьевич", "г. Москва, ул. Моховая 17");
        Abonent abonent3 = new Abonent("Михальчук", "Максим", "Николаевич", "г. Москва, ул. Ленина 129");
        Abonent abonent4 = new Abonent("Слепова", "Светлана", "Юрьевна", "г. Москва, ул. Спортивная 63");
        Abonent abonent5 = new Abonent("Чугунова", "Елизавета", "Петровна", "г. Москва, ул. Калинина 270");
        Abonent abonent6 = new Abonent("Антонов", "Юрий", "Борисович", "г. Москва, ул. Евскина 12");

        list.add(abonent1);
        list.add(abonent2);
        list.add(abonent3);
        list.add(abonent4);
        list.add(abonent5);
        list.add(abonent6);

        System.out.println("Исходный список:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        System.out.println("\nCписок, у которых время городских переговоров превышает лимит");
        for (int i = 0; i < list.size(); i++) {
            int sravnenie = list.get(i).getTimeGorodskie().compareTo(limitMinutGorodskie);
            if (sravnenie > 0) {
                System.out.println(list.get(i));
            }
        }

        System.out.println("\nАбоненты, которые пользовались междугородней связью");
        for (int i = 0; i < list.size(); i++) {
            int sravnenie = list.get(i).getTimeGorodskie().compareTo(LocalTime.MIN);
            if (sravnenie > 0) {
                System.out.println(list.get(i));
            }
        }

        System.out.println("\nАбоненты по алфавиту");
        Collections.sort(list);
        for (Abonent elem:list) {
            System.out.println(elem);
        }

    }
}

// интерфейс Comparable нам для сравнения объектов класса
class Abonent implements Comparable<Abonent> {

    static int countIdentificator = 0;

    private int id;
    private String familiya;
    private String imya;
    private String otchestvo;
    private String adres;

    private double debet; // остаток на карте
    private double credit; // расходы по карте
    private LocalTime timeMezhdugorod;
    private LocalTime timeGorodskie;


    public Abonent() { // default constructor

    }

    public Abonent(String familiya, String imya, String otchestvo, String adres) {
        this.id = ++countIdentificator;
        this.familiya = familiya;
        this.imya = imya;
        this.otchestvo = otchestvo;
        this.adres = adres;
        this.debet = Math.ceil(Math.random() * 200);
        this.credit = Math.ceil(Math.random() * 100);
        this.timeGorodskie = LocalTime.of(generateHour(4), generateMinute(60));
        this.timeMezhdugorod = LocalTime.of(generateHour(1), generateMinute(20));
    }

    public LocalTime getTimeGorodskie() {
        return timeGorodskie;
    }

    public String getFamiliya() {
        return familiya;
    }

    public String getImya() {
        return imya;
    }

    public String getOtchestvo() {
        return otchestvo;
    }

    // random Hour
    public static int generateHour(int value) {
        Random random = new Random();
        int temp = random.nextInt(value); // от 0 до 3
        return temp;
    }

    // random Minute
    public static int generateMinute(int value) {
        Random random = new Random();
        int temp = random.nextInt(value); // от 0 до 2
        return temp;
    }

    // переопределенный вывод наших абонентов
    @Override
    public String toString() {
        return "Abonent [abonentId=" + id +
                ", abonentfamiliya=" + familiya
                + ", abonentimya=" + imya
                + ", abonentotchestvo=" + otchestvo
                + ", abonentAdres=" + adres
                + ", abonentDebet=" + debet
                + ", abonentCredit=" + credit
                + ", abonentTimeGorodskie=" + timeGorodskie
                + ", abonentTimeMezhdugorod=" + timeMezhdugorod + "]";
    }

    // для сортировки
    @Override
    public int compareTo(Abonent o) {
        String fio1 = familiya + imya + otchestvo;
        String fio2 = o.getFamiliya() + o.getImya() + o.getOtchestvo();
        return fio1.compareToIgnoreCase(fio2);
    }
}
