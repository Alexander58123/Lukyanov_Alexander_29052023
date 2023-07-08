package com.example.user.javacoretraining.classes;

import java.util.*;

// задача "Вступительные экзамены"


public class Solution6 {

    public static void main(String[] args) {

        Abiturient abiturient1 = new Abiturient("Лукьянов", "Александр", "Сергеевич", 33, "Анапа");
        Abiturient abiturient2 = new Abiturient("Степанов", "Вячеслав", "Евгеньевич", 28, "Краснодар");
        Abiturient abiturient3 = new Abiturient("Алексеев", "Роман", "Андреевич", 25, "Москва");
        Abiturient abiturient4 = new Abiturient("Прохоров", "Владислав", "Борисович", 21, "Екатеринбург");
        Abiturient abiturient5 = new Abiturient("Лобань", "Валентин", "Николаевич", 24, "Казань");

        Prepodavatel prepodMatem = new Prepodavatel("Гаврилов", "А.", "Б.", "Математика");
        Prepodavatel prepodInform = new Prepodavatel("Алешин", "Н.", "С.", "Информатика");
        Prepodavatel prepodFizika = new Prepodavatel("Карнилов", "А.", "Е.", "Физика");


        // создали факультет FVT (фак. выч. техники)
        Facultet fvt = new Facultet("ФВТ", 4.3); // пройдут, у кого будет (5, 4, 4)|(5, 5, 3) и выше оценки

        // добавили абитуриентов, кто подал документы
        fvt.add(abiturient1);
        fvt.add(abiturient2);
        fvt.add(abiturient3);
        fvt.add(abiturient4);
        fvt.add(abiturient5);

        // добавили преподавателей на факультет FVT
        fvt.addPrepod(prepodMatem);
        fvt.addPrepod(prepodInform);
        fvt.addPrepod(prepodFizika);

        // создали экзамен (передали факультет)
        Ekzamenu ekzamenuFvt = new Ekzamenu(fvt);

        // вывели информацию что относится к экзаментам
        System.out.println(ekzamenuFvt.getPredmetu());
        System.out.println(ekzamenuFvt.getAbiturients());
        System.out.println(ekzamenuFvt.getPrepodavatel());
        System.out.println();

        // ключевой метод, показывает кого зачислили
        ekzamenuFvt.sdachaEkzamenov();
    }
}

// абитуриент
class Abiturient {
    private String familiya;
    private String imya;
    private String otchestvo;
    private int age;
    private String gorod;


    public Abiturient(String familiya, String imya, String otchestvo, int age, String gorod) {
        this.familiya = familiya;
        this.imya = imya;
        this.otchestvo = otchestvo;
        this.age = age;
        this.gorod = gorod;
    }

    public void show() {
        System.out.println(familiya + " " + imya + " " + otchestvo + ", " + "возраст " + age + ", " + "город " + gorod);
    }

    @Override
    public String toString() {
        return "Abiturient [Familiya=" + familiya
                + ", Imya=" + imya
                + ", Otchestvo=" + otchestvo
                + ", Age=" + age
                + ", Gorod=" + gorod + "]";
    }
}


// факультет
class Facultet {
    private String nazvanie;
    private List<String> spisokEkzamenov;
    private List<Abiturient> spisokAbiturientov;
    private List<Prepodavatel> spisokPrepodavatelei;
    private double propuskBall;


    public Facultet(String nazvanie, double propuskBall) {
        this.nazvanie = nazvanie;
        this.spisokEkzamenov = List.of("Математика", "Информатика", "Физика");
        this.propuskBall = propuskBall;
        this.spisokAbiturientov = new ArrayList<>();
        this.spisokPrepodavatelei = new ArrayList<>();
    }

    public List<Abiturient> getSpisokAbiturientov() {
        return spisokAbiturientov;
    }

    public List<Prepodavatel> getPrepodavatel() {
        return spisokPrepodavatelei;
    }

    // список названий экзаменов
    public List<String> getSpisokEkzamenov() {
        return spisokEkzamenov;
    }

    public String getNazvanie() {
        return nazvanie;
    }

    public double getPropuskBall() {
        return propuskBall;
    }


    // добавляем абитуриента в список факультета (подал документы)
    public void add(Abiturient abiturient) {
        spisokAbiturientov.add(abiturient);
        abiturient.show();
        System.out.println(" - Подал документы на факультет " + nazvanie);
    }

    // добавляем преподавателей на факультет
    public void addPrepod(Prepodavatel prepodavatel) {
        spisokPrepodavatelei.add(prepodavatel);
    }

}


// экзамены
class Ekzamenu {

    private List<String> predmetu;
    private List<Prepodavatel> prepodavatel;
    private List<Abiturient> abiturients;
    private double ballZachisleniya;
    private Map<Abiturient, Ocenka> poluchiliOcenki;


    // в конструктор передаем факультет
    // в зависимости от названия формируем экзамены (их перечень)
    public Ekzamenu(Facultet facultet) {
       if (facultet.getNazvanie().equalsIgnoreCase("ФВТ")) {
           predmetu = facultet.getSpisokEkzamenov();
           prepodavatel = facultet.getPrepodavatel();
           abiturients = facultet.getSpisokAbiturientov();
           ballZachisleniya = facultet.getPropuskBall();
       }
    }

    // от 2 до 5 случайные числа
    public static Integer generateOcenka() {
        Random random = new Random();
        Integer temp = random.nextInt(3 + 1) + 2;
        return temp;
    }

    // основной метод по сдаче экзаменов
    public void sdachaEkzamenov() {

        Map<Abiturient, Ocenka> poluchiliOcenki = new HashMap<>(); // карта для хранения всей структуры (абитуриенты, оценки)

        // сгенерировали оценки под каждого абитуриента
        for (int i = 0; i < getAbiturients().size(); i++) {
            Ocenka ocenka = new Ocenka();
            ocenka.setOcenkaPredmeta(new Integer[]{generateOcenka(), generateOcenka(), generateOcenka()});
            ocenka.setPredmetu(new String[]{predmetu.get(0), predmetu.get(1), predmetu.get(2)}); // предметы из факультета
            poluchiliOcenki.put(abiturients.get(i), ocenka); // положили в карту
        }

        Set<Abiturient> kluchiKartu = poluchiliOcenki.keySet(); // все ключиКарты в Set
        Iterator<Abiturient> iterator = kluchiKartu.iterator(); // итератор для перебора

        while (iterator.hasNext()) {
            Integer summaOcenok = 0;

            Abiturient tekushiiAbiturient = iterator.next(); // текущий ключ
            Integer[] tekushOcenkiAbiturienta = poluchiliOcenki.get(tekushiiAbiturient).getOcenkaPredmeta();
            System.out.println(Arrays.toString(tekushOcenkiAbiturienta));

            // собрали оценки от всех предметов
            for (int i = 0; i < tekushOcenkiAbiturienta.length; i++) {
                summaOcenok = tekushOcenkiAbiturienta[i] + summaOcenok;
            }

            // среднее арифметическое. Итоговая оценка
            double itogovaya = Math.round(((summaOcenok / tekushOcenkiAbiturienta.length)
                    + ((double) (summaOcenok % tekushOcenkiAbiturienta.length) / tekushOcenkiAbiturienta.length)) * 10.0) / 10.0;

            if (itogovaya >= ballZachisleniya) {

                tekushiiAbiturient.show();
                System.out.println("Зачислен с проходным баллом: " + itogovaya);
            }
        }
    }

    public List<String> getPredmetu() {
        return predmetu;
    }

    public List<Prepodavatel> getPrepodavatel() {
        return prepodavatel;
    }

    public List<Abiturient> getAbiturients() {
        return abiturients;
    }

    public Map<Abiturient, Ocenka> getPoluchiliOcenki() {
        return poluchiliOcenki;
    }
}

class Prepodavatel {
    private String familiya;
    private String imya;
    private String otchestvo;
    private String predmet;

    public Prepodavatel(String familiya, String imya, String otchestvo, String predmet) {
        this.familiya = familiya;
        this.imya = imya;
        this.otchestvo = otchestvo;
        this.predmet = predmet;
    }

    @Override
    public String toString() {
        return "Prepodavatel [Familiya=" + familiya
                + ", Imya=" + imya
                + ", Otchestvo=" + otchestvo
                + ", Предмет=" + predmet + "]";
    }
}

class Ocenka {

    private String[] predmetu;
    private Integer[] ocenkaPredmeta;


    public String[] getPredmetu() {
        return predmetu;
    }

    public void setPredmetu(String[] predmetu) {
        this.predmetu = predmetu;
    }

    public Integer[] getOcenkaPredmeta() {
        return ocenkaPredmeta;
    }

    public void setOcenkaPredmeta(Integer[] ocenkaPredmeta) {
        this.ocenkaPredmeta = ocenkaPredmeta;
    }





}
