package Lecture_6;

import java.math.BigDecimal;

public class Employee {
    String fullName;
    String jobTitle;
    String email;
    String phoneNumber;
    BigDecimal salary;
    int age;

    public Employee(String fullName, String jobTitle, String email, String phoneNumber,
                    BigDecimal salary, int age) {
        this.fullName = fullName;
        this.jobTitle = jobTitle;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    public void displayAllInformationAboutEmployee() {
        System.out.printf("ФИО: %s;\nДолжность: %s\nemail: %s\nТелефон: %s\nЗарплата: %s\nВозраст: %d\n",
                fullName, jobTitle, email, phoneNumber, salary.toString(), age);
    }

    public static void displayInformationAboutAllEmployees(Employee[] employees) {
        for (int i = 0; i < employees.length; i++) {
            employees[i].displayAllInformationAboutEmployee();
            if (i < employees.length - 1) {
                System.out.println("* * *");
            }
        }
    }
}