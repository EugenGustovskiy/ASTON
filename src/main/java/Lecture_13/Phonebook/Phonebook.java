package Lecture_13.Phonebook;

import java.util.ArrayList;
import java.util.List;

public class Phonebook {
    private List<Contact> contacts;

    public Phonebook() {
        this.contacts = new ArrayList<>();
    }

    //Добавить контакт в телефонный справочник
    public void add(String fullName, String phoneNumber) {
        contacts.add(new Contact(fullName, phoneNumber));
    }

    //Получить ФИО и номер телефона
    public List<Contact> get(String lastName) {
        List<Contact> result = new ArrayList<>();
        for (Contact contact : contacts) {
            if (contact.getLastName().equalsIgnoreCase(lastName)) {
                result.add(contact);
            }
        }
        return result;
    }

    //Вывести в консоль
    public void printContacts(String lastName) {
        List<Contact> foundContacts = get(lastName);
        if (foundContacts.isEmpty()) {
            System.out.println("Контакты не найдены.");
        } else {
            System.out.println("Найдены следующие контакты:");
            int count = 1;
            for (Contact contact : foundContacts) {
                System.out.println(count + ". " + contact);
                count++;
            }
        }
    }
}