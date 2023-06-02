package com.example.user.javacoretraining.training;

/**
 * Набор тренингов по работе с примитивными типами java.
 * <p>
 * Задания определены в комментариях методов.
 * <p>
 * Проверка может быть осуществлена запуском тестов.
 * <p>
 * Доступна проверка тестированием @see ElementaryTrainingTest.
 */
public class ElementaryTraining {

    /**
     * Метод должен возвращать среднее значение
     * для введенных параметров
     *
     * @param firstValue  первый элемент
     * @param secondValue второй элемент
     * @return среднее значение для введенных чисел
     */
    public double averageValue(int firstValue, int secondValue) {
        double result = ((firstValue + secondValue) / 2) + ((double)(firstValue + secondValue) % 2) / 2;
        return result;
    }

    /**
     * Пользователь вводит три числа.
     * Произвести манипуляции и вернуть сумму новых чисел
     *
     * @param firstValue  увеличить в два раза
     * @param secondValue уменьшить на три
     * @param thirdValue  возвести в квадрат
     * @return сумма новых трех чисел
     */
    public double complicatedAmount(int firstValue, int secondValue, int thirdValue) {
        firstValue = firstValue * 2;
        secondValue = secondValue - 3;
        thirdValue = thirdValue * 2;
        return firstValue + secondValue + thirdValue;
    }

    /**
     * Метод должен поменять значение в соответствии с условием.
     * Если значение больше 3, то увеличить
     * на 10, иначе уменьшить на 10.
     *
     * @param value число для изменения
     * @return новое значение
     */
    public int changeValue(int value) {
        int result;
        if (value > 3) {
            result = value + 10;
        } else {
            result = value - 10;
        }
        return result;
    }

    /**
     * Метод должен менять местами первую
     * и последнюю цифру числа.
     * Обрабатывать максимум пятизначное число.
     * Если число < 10, вернуть
     * то же число
     *
     * @param value число для перестановки
     * @return новое число
     */
    public int swapNumbers(int value) throws Exception {
        int result;
        String temp = "";

        if (value < 10) {
            result = value;
        } else if (String.valueOf(value).length() > 5) {
            throw new Exception(); // кидаем исключение, если больше 5
        } else {
            temp = String.valueOf(value);
            char odin = temp.charAt(0);
            char dva = temp.charAt(temp.length()-1);

            temp = dva + temp.substring(1, temp.length() - 1) + odin;
            result = Integer.parseInt(temp);
        }
        return result;
    }

    /**
     * Изменить значение четных цифр числа на ноль.
     * Счет начинать с единицы.
     * Обрабатывать максимум пятизначное число.
     * Если число < 10 вернуть
     * то же число.
     *
     * @param value число для изменения
     * @return новое число
     */
    public int zeroEvenNumber(int value) throws Exception {
        String temp = String.valueOf(value);
        String result = "";
        char charTemp = 0;
        int itog;

        if (value < 10) {
            itog = value;
        } else if (String.valueOf(value).length() > 5) {
            throw new Exception(); // кидаем исключение, если больше 5
        } else {
            for (int i = 0; i < temp.length(); i++) {
                charTemp = temp.charAt(i);

                if ((int) charTemp % 2 == 0) {
                    charTemp = '0';
                    result = result + charTemp;
                } else {
                    result = result + charTemp;
                }
            }

            itog = Integer.parseInt(result);
        }
        return itog;
    }
}
