package Lecture_7;

import Lecture_7.Figures.Circle;
import Lecture_7.Figures.Rectangle;
import Lecture_7.Figures.Triangle;

public class Lecture_7 {
    public static void main(String[] args) {
        //Задание 1
        Cat[] cats = new Cat[5];
        cats[0] = new Cat("Феня");
        cats[1] = new Cat("Барсик");
        cats[2] = new Cat("Тимошка");
        cats[3] = new Cat("Гарфилд");
        cats[4] = new Cat("Альф");

        Dog[] dogs = new Dog[5];
        dogs[0] = new Dog("Мухтар");
        dogs[1] = new Dog("Оскар");
        dogs[2] = new Dog("Баллу");
        dogs[3] = new Dog("Рокки");
        dogs[4] = new Dog("Агбар");

        //Сколько пробежали
        //cats[1].run(210);
        //dogs[1].run(540);

        //Сколько проплыли
        //cats[2].swim(20);
        //dogs[2].swim(10);

        //Сколько котов
        //int countCats = Animal.getCountCertainAnimals(cats);
        //System.out.println("Всего котов: " + countCats);

        //Сколько собак
        //int countDogs = Animal.getCountCertainAnimals(dogs);
        //System.out.println("Всего собак: " + countDogs);

        //Сколько общее количество животных
        //int allCountAnimals = Animal.getCountAllAnimals(countCats, countDogs);
        //System.out.println("Всего животных: " + allCountAnimals);

        //Процесс по кормлению котов и выводу в консоль их сытости + процесс пополнения миски
        //int bowlOfFood = 12;
        //bowlOfFood = Cat.feedCats(bowlOfFood, cats);
        //Cat.findOutIsCatFull(cats);
        //bowlOfFood = replenishFoodBowl(bowlOfFood, 10);
        //bowlOfFood = Cat.feedCats(bowlOfFood, cats);
        //Cat.findOutIsCatFull(cats);

        //Задание 2
        //Circle circle1 = new Circle(2.0, "Зеленый", "Черный");
        //Rectangle rectangle1 = new Rectangle(1.0, 2.0, "Оранжевый", "Синий");
        //Triangle triangle1 = new Triangle(2.0, 2.0, 3.0, "Красный", "Белый");

        //circle1.getCircleInfo();
        //rectangle1.getRectangleInfo();
        //triangle1.getTriangleInfo();
    }
    //Задание 1
    //Пополняем миску с едой
    public int replenishFoodBowl(int bowlOfFood, int amountOfFood) {
        return bowlOfFood + amountOfFood;
    }
}