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

        Lecture_8 lecture = new Lecture_8();
        lecture.checkArray(array);
    }

    public void checkArray(String[][] array) {
        try {
            checkArraySize(array);
            int result = getArraySum(array);
            System.out.println("Сумма элементов массива: " + result);
        } catch (MyArraySizeException e) {
            System.out.println("Ошибка размера массива: " + e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println("Ошибка при обработке массива: " + e.getMessage());
        }
    }

    //Проверка размера массива
    public void checkArraySize(String[][] array) throws MyArraySizeException {
        if (array.length != 4 || array[0].length != 4) {
            throw new MyArraySizeException();
        }
    }

    //Преобразуем элементы массива в int и находим сумму всех элементов
    public int getArraySum(String[][] array) throws MyArrayDataException {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j, array[i][j]);
                }
            }
        }
        return sum;
    }
}