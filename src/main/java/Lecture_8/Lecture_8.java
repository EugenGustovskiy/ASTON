package Lecture_8;

public class Lecture_8 {
    public static void main(String[] args) {
        //Массив, который удовлетворяет условию
        String[][] array = {{"1", "2", "3", "4"}, {"5", "6", "7", "8"}, {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}};

        //Массивы, которые не соответствуют условиям
        //String[][] wrongArray = {{"1", "2", "3"}, {"5", "6", "7", "8"}, {"9", "10", "11", "12"},
        //        {"13", "14", "15", "16"}};
        //String[][] wrongArray = {{"1", "2", "D", "4"}, {"5", "6", "7", "8"}, {"9", "10", "11", "12"},
        //        {"13", "14", "15", "16"}};

        checkArraySize(array);
    }
    public static void checkArraySize(String[][] array) {
        try {
            if (array.length != 4 || array[0].length != 4) {
                throw new MyArraySizeException();
            } else {
                System.out.println("Массив соответствует условию.");
            }
        } catch (MyArraySizeException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}