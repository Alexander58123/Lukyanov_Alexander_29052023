package com.example.user.javacoretraining.training;

/**
 * Набор тренингов по работе со строками в java.
 * <p>
 * Задания определены в комментариях методов.
 * <p>
 * Проверка может быть осуществлена запуском тестов.
 * <p>
 * Доступна проверка тестированием @see StringsTrainingTest.
 */
public class StringsTraining {

    /**
     * Метод по созданию строки,
     * состоящей из нечетных символов
     * входной строки в том же порядке
     * (нумерация символов идет с нуля)
     *
     * @param text строка для выборки
     * @return новая строка из нечетных
     * элементов строки text
     */
    public String getOddCharacterString(String text) {
        String result = "";

        for (int i = 0; i < text.length(); i++) {
            if (i % 2 == 1) {
                result = result + text.charAt(i);
            }
        }
        return result;
    }

    /**
     * Метод для определения количества
     * символов, идентичных последнему
     * в данной строке
     *
     * @param text строка для выборки
     * @return массив с номерами символов,
     * идентичных последнему. Если таких нет,
     * вернуть пустой массив
     */
    public int[] getArrayLastSymbol(String text) {
        int[] result;
        int count = 0;
        boolean flag = false;

        Character simvolEnd = text.charAt(text.length() - 1);

        for (int i = 0; i < text.length() - 1; i++) {
            if (simvolEnd.equals(text.charAt(i))) {
                count = count + 1;
            }
        }

        if (count > 0) {
            result = new int[count];
            flag = true;
        } else {
            result = new int[]{};
        }

        if (flag) {
            int j = 0;
            for (int i = 0; i < text.length() - 1; i++) {
                if (simvolEnd.equals(text.charAt(i))) {
                    result[j] = i;
                    j++;
                }
            }
        }

        return result;
    }

    /**
     * Метод по получению количества
     * цифр в строке
     *
     * @param text строка для выборки
     * @return количество цифр в строке
     */
    public int getNumbersCount(String text) {
        int count = 0;
        Integer temp;

        for (int i = 0; i < text.length(); i++) {
            try {
                if ( (temp = Integer.parseInt(String.valueOf(text.charAt(i)))) instanceof Integer) {
                    count = count + 1;
                }
            } catch (NumberFormatException e) {
                continue;
            }

        }

        return count;
    }

    /**
     * Дан текст. Заменить все цифры
     * соответствующими словами.
     *
     * @param text текст для поиска и замены
     * @return текст, где цифры заменены словами
     */
    public String replaceAllNumbers(String text) {
        String result = "";
        Integer num = 0;
        String elem = "";

        for (int i = 0; i < text.length(); i++) {
            try {
                if ((num = Integer.parseInt(String.valueOf(text.charAt(i)))) instanceof Integer) {
                    result = result + text;
                }
            } catch (NumberFormatException exception) {
                elem = String.valueOf(text.charAt(i));
                result = result + elem;
            }
        }
        return result;
    }

    /**
     * Метод должен заменить заглавные буквы
     * на прописные, а прописные на заглавные
     *
     * @param text строка для изменения
     * @return измененная строка
     */
    public String capitalReverse(String text) {
        String result = "";
        char elem = 0;

        for (int i = 0; i < text.length(); i++) {
            elem = text.charAt(i);

            if (Character.isUpperCase(elem)) {
                elem = Character.toLowerCase(elem);
                result = result + elem;
            } else {
                elem = Character.toUpperCase(elem);
                result = result + elem;
            }

        }

        return result;
    }

}
