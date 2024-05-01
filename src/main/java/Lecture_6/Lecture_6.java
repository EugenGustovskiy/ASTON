package Lecture_6;

import java.math.BigDecimal;

public class Lecture_6 {
    public static void main(String[] args) {
        //Задание 1 и 2
        Employee[] employees = new Employee[5];
        employees[0] = new Employee("Кадуков Павел Леонидович", "Тестировщик",
                "kad.pavel@mail.com", "+375(33)853-24-13", new BigDecimal("1500.00"), 26);
        employees[1] = new Employee("Кузнецов Максим Витальевич", "Дизайнер",
                "kuznmaks@mail.com", "+375(33)753-11-45", new BigDecimal("700.00"), 22);
        employees[2] = new Employee("Вакульчик Иван Вадимович", "Разработчик",
                "vakulpower@mail.com", "+375(33)589-12-22", new BigDecimal("2000.00"), 25);
        employees[3] = new Employee("Грибкова Светлана Олеговна", "Тестировщик",
                "sv.gribkova@mail.com", "+375(44)468-54-54", new BigDecimal("1100.00"), 24);
        employees[4] = new Employee("Сенькевич Валентин Степанович", "Разработчик",
                "vt.senkevich@mail.com", "+375(29)641-66-78", new BigDecimal("900.00"), 21);

        //Вывод информации о конкретном сотруднике
        //employees[1].displayAllInformationAboutEmployee();

        //Вывод информации о всех сотрудниках
        //Employee.displayInformationAboutAllEmployees(employees);

        //Задание 3
        Park park = new Park("им. Максима Горького");

        Park.Attraction[] attractions = new Park.Attraction[3];
        attractions[0] = park.new Attraction("Колесо обозрения", "10.00 - 19.30",
                new BigDecimal("10.00"));
        attractions[1] = park.new Attraction("Комната смеха", "12.00 - 17.30",
                new BigDecimal("5.50"));
        attractions[2] = park.new Attraction("Американские горки", "10.00 - 18.00",
                new BigDecimal("15.00"));

        //Вывести информацию о конкретном аттракционе
        //attractions[0].displayAllInformationAboutAttraction();

        //Добавить аттракционы в парк
        park.addAttractionsToThePark(attractions);

        //Вывести название парка и всю информацию об аттракционах в нем
        park.displayInformationAboutAllAttractions();
    }
}