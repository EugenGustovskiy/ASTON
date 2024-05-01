package org.example;

public class Homework {
    public static void main(String[] args) {
        //1
        //printThreeWords();
        //2
        //checkSumSign();
        //3
        //printColor();
        //4
        //compareNumbers();
        //5
        //boolean res = checkSumInRange(10,7);
        //6
        //checkPositiveOrNegativeInt(4);
        //7
        //checkIntIsNegative(2);
        //8
        //printStringMultipleTimes("ASTON", 4);
        //9
        //boolean res = checkYearIsLeap(1244);
        //10
        //int[] array = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        //invertArray(array);
        //11
        //int[] array = new int[100];
        //fillArray(array);
        //12
        //increaseMoreSixByTwo();
        //13
        //createSquareArray();
        //14
        //int[] res = fillAndReturnArray(5, 2);
    }

    //1
    public static void printThreeWords() {
        System.out.print("Orange\nBanana\nApple\n");
    }

    //2
    public static void checkSumSign() {
        int a = -1;
        int b = 2;

        if (0 <= a + b) {
            System.out.println("Сумма положительная");
        } else System.out.println("Сумма отрицательная");
    }

    //3
    public static void printColor() {
        int value = 13;

        if (value <= 0) {
            System.out.println("Красный");
        } else if (value <= 100) {
            System.out.println("Желтый");
        } else System.out.println("Зеленый");
    }

    //4
    public static void compareNumbers() {
        int a = 10;
        int b = 11;

        if (a >= b) {
            System.out.println("a >= b");
        } else System.out.println("a < b");
    }

    //5
    public static boolean checkSumInRange(int a, int b) {
        return a + b > 10 && a + b <= 20;
    }

    //6
    public static void checkPositiveOrNegativeInt(int a) {
        if (a < 0) {
            System.out.printf("%d - отрицательное число\n", a);
        } else System.out.printf("%d - положительное число\n", a);
    }

    //7
    public static boolean checkIntIsNegative(int a) {
        return a < 0;
    }

    //8
    public static void printStringMultipleTimes(String str, int count) {
        for (int i = 0; i < count; i++) {
            System.out.println(str);
        }
    }

    //9
    public static boolean checkYearIsLeap(int year) {
        return year % 100 == 0 ? year % 400 == 0 : year % 4 == 0;
    }

    //10
    public static void invertArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                array[i] = 1;
            } else array[i] = 0;
        }
    }

    //11
    public static void fillArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
    }

    //12
    public static void increaseMoreSixByTwo() {
        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] *= 2;
            }
        }
    }

    //13
    public static void createSquareArray() {
        int size = 4;
        int[][] array = new int[size][size];

        for (int i = 0; i < size; i++) {
            array[i][i] = 1;
            array[i][size - 1 - i] = 1;
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    //14
    public static int[] fillAndReturnArray(int len, int initialValue) {
        int[] array = new int[len];

        for (int i = 0; i < array.length; i++) {
            array[i] = initialValue;
        }

        return array;
    }
}