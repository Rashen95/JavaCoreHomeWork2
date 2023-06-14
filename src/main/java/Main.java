/*
ЗАДАНИЕ
Написать метод, возвращающий количество чётных элементов массива. countEvens([2, 1, 2, 3, 4]) → 3 countEvens([2, 2, 0]) → 3 countEvens([1, 3, 5]) → 0
Написать функцию, возвращающую разницу между самым большим и самым маленьким элементами переданного не пустого массива.
Написать функцию, возвращающую истину, если в переданном массиве есть два соседних элемента, с нулевым значением.
*/

import java.util.Arrays;

/**
 * Точка входа
 */
public class Main {
    public static void main(String[] args) {
        int[] a = {2, 1, 3, 5, 9, 8, 4, 5};
        int[] b = {15, 5, 1, 5, 0, 0, 1, 5, 6, 5, 0};
        int[] c = {15, 0, 1, 5, 3, 1, 5, 0, 1, 2, 3};
        System.out.println(allCalculation(a));
        System.out.println(allCalculation(b));
        System.out.println(allCalculation(c));
    }

    /**
     * Метод, возвращающий количество чётных элементов массива.
     *
     * @param arr переданный массив
     * @return количество четных элементов
     */
    public static int evenCounter(int[] arr) {
        int count = 0;
        for (int a : arr) {
            if (a % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    /**
     * Функция, возвращающая разницу между самым большим и самым маленьким элементами переданного не пустого массива.
     *
     * @param arr переданный массив
     * @return разницу между самым большим и самым маленьким элементами массива
     */
    public static int diffMaxMin(int[] arr) {
        int max = arr[0];
        int min = arr[0];
        for (int a : arr) {
            if (a > max) max = a;
            else if (a < min) min = a;
        }
        return max - min;
    }

    /**
     * Функция, возвращающая истину, если в переданном массиве есть два соседних элемента, с нулевым значением.
     *
     * @param arr переданный массив
     * @return результат проверки
     */
    public static boolean double0(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1] && arr[i] == 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * Создание строки с полученными результатами
     *
     * @param arr        переданный массив
     * @param count      количество четных чисел в массиве
     * @param diffMaxMin разница между максимальным и минимальным
     * @param double0    результат проверки на соседство двух нулевых элементов
     * @return итоговая строка для вывода
     */
    public static String decorator(int[] arr, int count, int diffMaxMin, boolean double0) {
        if (double0) {
            return String.format("""
                    Вы передали массив: %s
                    в нем %d четных чисел
                    разница между самым большим и самым маленьким по значению элементом равна %d
                    в этом массиве есть два соседних элемента, с нулевым значением
                    """, Arrays.toString(arr), count, diffMaxMin);
        } else {
            return String.format("""
                    Вы передали массив: %s
                    в нем %d четных чисел
                    разница между самым большим и самым маленьким по значению элементом равна %d
                    в этом массиве нет двух соседних элементов, с нулевым значением
                    """, Arrays.toString(arr), count, diffMaxMin);
        }
    }

    /**
     * Проведение всех вычислений по заданию
     *
     * @param arr переданный массив
     * @return строка с полученной информацией
     */
    public static String allCalculation(int[] arr) {
        return decorator(arr, evenCounter(arr), diffMaxMin(arr), double0(arr));
    }
}