package Lecture_8;

public class MyArrayDataException extends Exception {
    public int row;
    public int column;
    public String value;

    public MyArrayDataException(int row, int column, String value) {
        super("неверные данные в ячейке [" + row + "][" + column + "]: " + value);
        this.row = row;
        this.column = column;
        this.value = value;
    }
}