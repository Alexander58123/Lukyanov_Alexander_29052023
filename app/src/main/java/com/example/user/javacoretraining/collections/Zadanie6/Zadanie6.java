package com.example.user.javacoretraining.collections.Zadanie6;

import java.util.*;
import java.util.stream.Collectors;

public class Zadanie6 {

    public static void main(String[] args) {

        // заполнили объекты Student
        Student student1 = new Student("Михеев", "Александр", "Васильевич", 1989, 5, "20ВП1");
        student1.setPredmetu(3, 4, 5, 4, 3);
        Student student2 = new Student("Печкина", "Мария", "Юрьевна", 1949, 3, "20ВП1");
        student2.setPredmetu(4, 3, 3, 4, 4);
        Student student3 = new Student("Аладушкин", "Петр", "Гаврилович", 1994, 4, "20ВП1");
        student3.setPredmetu(5, 4, 4, 3, 4);
        Student student4 = new Student("Форлаков", "Михаил", "Игоревич", 1985, 2, "21ВП3");
        student4.setPredmetu(3, 4, 3, 3, 3);
        Student student5 = new Student("Яковлев", "Лев", "Абрамович", 1997, 1, "21ВП3");
        student5.setPredmetu(3, 4, 3, 3, 5);
        Student student6 = new Student("Озерова", "Юлия", "Владимировна", 1990, 2, "25ВП3");
        student6.setPredmetu(4, 4, 3, 4, 3);
        Student student7 = new Student("Соколова", "Екатерина", "Андреевна", 1985, 3, "19ВП3");
        student7.setPredmetu(5, 5, 5, 5, 5);
        Student student8 = new Student("Балалайкин", "Дмитрий", "Сергеевич", 1982, 4, "19ВП3");
        student8.setPredmetu(3, 4, 5, 5, 3);

        // лобавление в лист всех студентов
        List<Student> list = new ArrayList<>();
        Collections.addAll(list, student1, student2, student3, student4, student5, student6, student7, student8); // добавили элементы

        System.out.println("Студенты, исходный список");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        // здесь двойной используем компаратор под (условие групп и алфавита)
        System.out.println("\nСтуденты, сортировка по курсу и алфавитному порядку");
        Comparator<Student> kursAndAlphabet = new KursComparator().thenComparing(new AlphabetComparator());
        Collections.sort(list, kursAndAlphabet);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        // Вывод самых младших студенов
        System.out.println("\nМладший(ие) студенты");
        Student.mladStudent(list);


        // вывод самых старших студентов
        System.out.println("\nСтарший(ие) студенты");
        Student.starStudent(list);


        // средние оценки группы
        System.out.println("\nСредний балл каждой группы по каждому предмету");
        Student.sredBallGruppu(list);


        // лучший(ие) студент в группе
        System.out.println("\nЛучший(ие) студент(ы) в группе");
        Student.luchStudentGruppu(list);


    }
}



class Student {
    private String familiya;
    private String imya;
    private String otchestvo;
    private int godRozhdeniya;
    private int kurs;
    private String nomerGruppu;
    private int[] predmetu;

    public Student() { // default constructor
    }

    public  Student(String familiya, String imya, String otchestvo, int godRozhdeniya, int kurs, String nomerGruppu) {
        this.familiya = familiya;
        this.imya = imya;
        this.otchestvo = otchestvo;
        this.godRozhdeniya = godRozhdeniya;
        this.kurs = kurs;
        this.nomerGruppu = nomerGruppu;
    }

    public int[] getPredmetu() {
        return predmetu;
    }

    public int getKurs() {
        return kurs;
    }

    public String getFamiliya() {
        return familiya;
    }

    public int getGodRozhdeniya() {
        return godRozhdeniya;
    }

    public String getNomerGruppu() {
        return nomerGruppu;
    }

    // переопределенный вывод наших студентов
    @Override
    public String toString() {
        return "Student [Familiya=" + familiya
                + ", Imya=" + imya
                + ", Otchestvo=" + otchestvo
                + ", GodRozhdeniya=" + godRozhdeniya
                + ", Kurs=" + kurs
                + ", NomerGruppu=" + nomerGruppu
                + ", Predmetu=" + Arrays.toString(predmetu) + "]";
    }

    /**
     * Пошли отсюда основные методы
     */


    // добавление оценок студенту
    public void setPredmetu(int ocenka1, int ocenka2, int ocenka3, int ocenka4, int ocenka5) {
        predmetu = new int[5];
        predmetu[0] = ocenka1;
        predmetu[1] = ocenka2;
        predmetu[2] = ocenka3;
        predmetu[3] = ocenka4;
        predmetu[4] = ocenka5;
    }

    // поиск младших студентов
    public static void mladStudent(List<Student> list) {
        Comparator<Student> minimVozComparator = new DenRozhdeniyaComparator();
        Collections.sort(list, minimVozComparator);
        int minYears = list.get(list.size()-1).getGodRozhdeniya();
        for (int i = list.size() - 1; i >=  0; i--) {
            if (list.get(i).getGodRozhdeniya() == minYears) {
                System.out.println(list.get(i));
            } else {
                break;
            }
        }
    }


    // поиск старших студентов
    public static void starStudent(List<Student> list) {
        Comparator<Student> minimVozComparator = new DenRozhdeniyaComparator();
        Collections.sort(list, minimVozComparator);
        int maxYears = list.get(0).getGodRozhdeniya();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getGodRozhdeniya() == maxYears) {
                System.out.println(list.get(i));
            } else {
                break;
            }
        }
    }


    // средний балл группы по каждому предмету
    public static void sredBallGruppu(List<Student> list) {

        // группировка в карту
        Map<String, List<Student>> studListGrouped =
                list.stream().collect(Collectors.groupingBy(w -> w.nomerGruppu));


        Set<String> kluchiGruppu = studListGrouped.keySet(); // все ключиГруппы в Set
        Iterator<String> iterator = kluchiGruppu.iterator(); // итератор для перебора


        while (iterator.hasNext()) {
            int[] obshiMassive = new int[5]; // этот для подсчета для одного набора List<Student>
            double[] sredOcenkiGruppu = new double[5]; // итоговое значение

            String tekGruppa = iterator.next(); // получили ключ-названиеГруппы
            int kolvoStudentov = studListGrouped.get(tekGruppa).size();

            // собираем в единый массив значения из List<Student>
            for (int i = 0; i < kolvoStudentov; i++) {
                int[] tekMasStudenta = studListGrouped.get(tekGruppa).get(i).getPredmetu();
                for (int j = 0; j < obshiMassive.length; j++) {
                    obshiMassive[j] = tekMasStudenta[j] + obshiMassive[j];
                }
            }

            // вычисляем среднюю оценку группы
            for (int i = 0; i < sredOcenkiGruppu.length; i++) {
                sredOcenkiGruppu[i] = Math.round(((obshiMassive[i] / kolvoStudentov)
                        + ((double) (obshiMassive[i] % kolvoStudentov) / kolvoStudentov)) * 10.0) / 10.0;
            }

            // здесь специально оставил все выводы, чтобы было нагляднее
            // видеть все значения
            System.out.println(tekGruppa);
            System.out.println(studListGrouped.get(tekGruppa));
            System.out.println("Количество студентов " + kolvoStudentov);
            for (int elem:obshiMassive) {
                System.out.print(elem + " ");
            }
            System.out.println();
            for (double elem:sredOcenkiGruppu) {
                System.out.print(elem + " ");
            }
            System.out.println();
            System.out.println();
        }


    }


    // лучший студент для каждой группы
    public static void luchStudentGruppu(List<Student> list) {

        // группировка в карту по номеру группы
        Map<String, List<Student>> studListGrouped =
                list.stream().collect(Collectors.groupingBy(w -> w.nomerGruppu));


        Set<String> kluchiGruppu = studListGrouped.keySet(); // все ключиГруппы в Set
        Iterator<String> iterator = kluchiGruppu.iterator(); // итератор для перебора


        while (iterator.hasNext()) {

            String tekGruppa = iterator.next(); // получили ключ-названиеГруппы
            int kolvoStudentov = studListGrouped.get(tekGruppa).size(); // кол-во студентов по ключу

            // собираем в единый массив значения из List<Student>
            int maxOcenka = 0;
            List<Student> luchStudentuList = new ArrayList<>();

            // здесь определили максимальное значение, если сложить все оценки
            for (int i = 0; i < kolvoStudentov; i++) {

                int[] tekMasStudenta = studListGrouped.get(tekGruppa).get(i).getPredmetu();
                int countOcenki = 0;

                for (int j = 0; j < tekMasStudenta.length; j++) { // собрали в одно число все оценки 1 студента
                    countOcenki = countOcenki + tekMasStudenta[j];
                }

                if (countOcenki > maxOcenka) {
                    maxOcenka = countOcenki;
                }
            }

            // здесь уже сравниваем тех у кого есть максим. значение maxOcenka
            // и добавляем в отдельный лист для вывода
            for (int i = 0; i < kolvoStudentov; i++) {

                int[] tekMasStudenta = studListGrouped.get(tekGruppa).get(i).getPredmetu();
                int countOcenki = 0;

                for (int j = 0; j < tekMasStudenta.length; j++) { // собрали в одно число все оценки 1 студента
                    countOcenki = countOcenki + tekMasStudenta[j];
                }

                if (countOcenki == maxOcenka) {
                    luchStudentuList.add(studListGrouped.get(tekGruppa).get(i));
                }

            }

            for (Student luchStedent: luchStudentuList) {
                System.out.println(luchStedent);
            }

        }  // end while


    }


}

// отдельный класс
// Comparator для сортировки по алфавиту
class AlphabetComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return o1.getFamiliya().compareToIgnoreCase(o2.getFamiliya());
    }

}


// отдельный класс
// Comparator для сортировки по курсу
class KursComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return o1.getKurs() - o2.getKurs();
    }

}


// отдельный класс
// Comparator для сортировки по дню рождения
class DenRozhdeniyaComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return o1.getGodRozhdeniya() - o2.getGodRozhdeniya();
    }

}


// отдельный класс
// Comparator для сортировки по группе
class GruppaComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return o1.getNomerGruppu().compareToIgnoreCase(o2.getNomerGruppu());
    }

}












