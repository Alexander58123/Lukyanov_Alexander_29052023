package com.example.user.javacoretraining.training;

/**
 * Набор тренингов по работе с массивами в java.
 * <p>
 * Задания определены в комментариях методов.
 * <p>
 * Проверка может быть осуществлена запуском тестов.
 * <p>
 * Доступна проверка тестированием @see ArraysTrainingTest.
 */
public class ArraysTraining {

    /**
     * Метод должен сортировать входящий массив
     * по возрастранию пузырьковым методом
     *
     * @param valuesArray массив для сортировки
     * @return отсортированный массив
     */
    public int[] sort(int[] valuesArray) {
        for (int i = valuesArray.length - 1; i > 1; i--) {
            for (int j = 0; j < i; j++) {
                if (valuesArray[j] > valuesArray[j + 1]) {
                    int temp = valuesArray[j];
                    valuesArray[j] = valuesArray[j + 1];
                    valuesArray[j + 1] = temp;
                }
            }
        }

        return valuesArray;
    }

    /**
     * Метод должен возвращать максимальное
     * значение из введенных. Если входящие числа
     * отсутствуют - вернуть 0
     *
     * @param values входящие числа
     * @return максимальное число или 0
     */
    public int maxValue(int... values) {
        int maximum;

        if (values.length == 0) {
            maximum = 0;
        } else {
            maximum = values[0];
            for (int i = 1; i < values.length; i++) {
                if (values[i] > maximum) {
                    maximum = values[i];
                }
            }
        }

        return maximum;
    }

    /**
     * Переставить элементы массива
     * в обратном порядке
     *
     * @param array массив для преобразования
     * @return входящий массив в обратном порядке
     */
    public int[] reverse(int[] array) {
        int[] itogMassive = new int[array.length];

        for (int i = 0, j = array.length - 1; i < itogMassive.length; i++, j--) {
            itogMassive[i] = array[j];
        }

        return itogMassive;
    }

    /**
     * Метод должен вернуть массив,
     * состоящий из чисел Фибоначчи
     *
     * @param numbersCount количество чисел Фибоначчи,
     *                     требуемое в исходящем массиве.
     *                     Если numbersCount < 1, исходный
     *                     массив должен быть пуст.
     * @return массив из чисел Фибоначчи
     */
    public int[] fibonacciNumbers(int numbersCount) {
        int[] masResult;

        if (numbersCount < 1) {
            masResult = new int[]{};
        } else if (numbersCount == 1) {
            masResult = new int[numbersCount];
            masResult[0] = 0;
        } else {
            masResult = new int[numbersCount];
            masResult[0] = 0;
            masResult[1] = 1;
            for (int i = 2; i < masResult.length; i++) {
                masResult[i] = masResult[i - 1] + masResult[i - 2];
            }
        }

        return masResult;
    }

    /**
     * В данном массиве найти максимальное
     * количество одинаковых элементов.
     *
     * @param array массив для выборки
     * @return количество максимально встречающихся
     * элементов
     */
    public int maxCountSymbol(int[] array) {
        int maxCount = 1;
        int tekushiiMaxCount = 1;

        // отсортировали через пузырек
        for (int i = array.length - 1; i > 1; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

        // теперь находим самую высокую частотность
        for (int i = 0; i < array.length - 1; i++) {

            if (array[i] == array[i + 1]) {
                tekushiiMaxCount = tekushiiMaxCount + 1;
            } else {
                tekushiiMaxCount = 1;
                continue;
            }

            if (maxCount < tekushiiMaxCount) {
                maxCount = tekushiiMaxCount;
            }

        }

        return maxCount;
    }
}
