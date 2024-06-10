package Lecture_13.Phonebook;

public class Contact {
    private String fullName;
    private String phoneNumber;

    public Contact(String fullName, String phoneNumber) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
    }

    //Получить фамилию
    public String getLastName() {
        return fullName.split(" ")[0];
    }

    @Override
    public String toString() {
        return fullName + " " + phoneNumber;
    }
}