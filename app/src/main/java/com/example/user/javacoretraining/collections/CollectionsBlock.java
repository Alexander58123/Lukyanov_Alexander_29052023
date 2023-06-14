package com.example.user.javacoretraining.collections;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Набор тренингов по работе со строками в java.
 * <p>
 * Задания определены в комментариях методов.
 * <p>
 * Проверка может быть осуществлена запуском тестов.
 * <p>
 * Доступна проверка тестированием @see CollectionsBlockTest.
 */
public class CollectionsBlock<T extends Comparable> {

    /**
     * Даны два упорядоченных по убыванию списка.
     * Объедините их в новый упорядоченный по убыванию список.
     * Исходные данные не проверяются на упорядоченность в рамках данного задания
     *
     * @param firstList  первый упорядоченный по убыванию список
     * @param secondList второй упорядоченный по убыванию список
     * @return объединенный упорядоченный список
     * @throws NullPointerException если один из параметров null
     */

    public List<T> collectionTask0(@NonNull List<T> firstList, @NonNull List<T> secondList) throws NullPointerException {
        List<T> mergeSpiski = null;

        if (firstList == null || secondList == null) {
            throw new NullPointerException();
        } else {
            mergeSpiski = new ArrayList<>(firstList.size() + secondList.size());
            mergeSpiski.addAll(firstList);
            mergeSpiski.addAll(secondList);
            Collections.sort(mergeSpiski, Collections.reverseOrder()); // со вторым параметром обратная сортировка
        }

        return mergeSpiski;
    }

    /**
     * Дан список. После каждого элемента добавьте предшествующую ему часть списка.
     *
     * @param inputList с исходными данными
     * @return измененный список
     * @throws NullPointerException если один из параметров null
     */
    public List<T> collectionTask1(@NonNull List<T> inputList) throws NullPointerException {
        List<T> result = new ArrayList<>();

        if (inputList == null ) {
            throw new NullPointerException();
        } else {
            result.add(inputList.get(0));
            for (int i = 1; i < inputList.size(); i++) {
                result.add(inputList.get(i));
                for (int j = 0; j < i; j++) {
                    result.add(inputList.get(j));
                }
            }
        }

        return result;
    }

    /**
     * Даны два списка. Определите, совпадают ли множества их элементов.
     *
     * @param firstList  первый список элементов
     * @param secondList второй список элементов
     * @return <tt>true</tt> если множества списков совпадают
     * @throws NullPointerException если один из параметров null
     */
    public boolean collectionTask2(@NonNull List<T> firstList, @NonNull List<T> secondList) throws NullPointerException {
        boolean result = false;

        if (firstList == null || secondList == null) {
            throw new NullPointerException();
        } else {
            if (firstList.size() == secondList.size()) { // равны, проверям
                Collections.sort(firstList);
                Collections.sort(secondList);
                if (firstList.equals(secondList)) {
                    result = true;
                }
            } else {
                result = false;
            }
        }

        return result;
    }

    /**
     * Создать список из заданного количества элементов.
     * Выполнить циклический сдвиг этого списка на N элементов вправо или влево.
     * Если N > 0 циклический сдвиг вправо.
     * Если N < 0 циклический сдвиг влево.
     *
     * @param inputList список, для которого выполняется циклический сдвиг влево
     * @param n         количество шагов циклического сдвига N
     * @return список inputList после циклического сдвига
     * @throws NullPointerException если один из параметров null
     */
    public List<T> collectionTask3(@NonNull List<T> inputList, int n) throws NullPointerException {
        if (inputList == null) {
            throw new NullPointerException();
        }

        if (n > 0) {
            for (int i = 0; i < n; i++) {
                List<T> temp = new ArrayList<>();
                temp.add(inputList.get(inputList.size() - 1));

                for (int j = inputList.size() - 1; j > 0; j--) {
                    inputList.set(j, inputList.get(j - 1));
                }
                inputList.set(0, temp.get(0));
            }
        } else {
            for (int i = 0; i > n; i--) {
                List<T> temp = new ArrayList<>();
                temp.add(inputList.get(0));

                for (int j = 1; j < inputList.size(); j++) {
                    inputList.set(j - 1, inputList.get(j));
                }

                inputList.set(inputList.size() -1, temp.get(0));
            }
        }

        return inputList;
    }

    /**
     * Элементы списка хранят слова предложения.
     * Замените каждое вхождение слова A на B.
     *
     * @param inputList список со словами предложения и пробелами для разделения слов
     * @param a         слово, которое нужно заменить
     * @param b         слово, на которое нужно заменить
     * @return список после замены каждого вхождения слова A на слово В
     * @throws NullPointerException если один из параметров null
     */
    public List<String> collectionTask4(@NonNull List<String> inputList, @NonNull String a,
                                        @NonNull String b) throws NullPointerException{
        String temp = "";

        if (inputList != null|| a != null|| b != null) {
            for (int i = 0; i < inputList.size(); i++) {
                temp = inputList.get(i).replace(a, b);
                inputList.set(i, temp);
            }
        } else {
            throw new NullPointerException();
        }

        return inputList;
    }

    /*
      Задание подразумевает создание класса(ов) для выполнения задачи.

      Дан список студентов. Элемент списка содержит фамилию, имя, отчество, год рождения,
      курс, номер группы, оценки по пяти предметам.
      Заполните список и выполните задание.
      Упорядочите студентов по курсу, причем студенты одного курса располагались
      в алфавитном порядке.
      Найдите средний балл каждой группы по каждому предмету.
      Определите самого старшего студента и самого младшего студентов.
      Для каждой группы найдите лучшего с точки зрения успеваемости студента.
     */


    /**
     *  Решение задачи в пакете
     *  Zadanie6
     */
}
