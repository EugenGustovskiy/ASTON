package Lecture_8;

public class MyArraySizeException extends Exception {
    public MyArraySizeException() {
        super("Массив должен иметь размер 4х4");
    }
}