package Lecture_7;

public class Cat extends Animal {
    public boolean satiety = false;

    public Cat(String name) {
        super(name, 200, 0);
    }

    @Override
    public void displayHowManySwim(int distance) {
        System.out.println(name + " не умеет плавать!");
    }

    //Кормим кота (для сытости коту необходимо покушать на 5)
    public static int feedCats(int bowlOfFood, Cat[] cats) {
        for (Cat cat : cats) {
            if (!cat.satiety && bowlOfFood >= 5) {
                cat.satiety = true;
                bowlOfFood -= 5;
            }
        }
        return bowlOfFood;
    }

    //Выводим в консоль сытость котов
    public static void findOutIsCatFull(Cat[] cats) {
        for (Cat cat : cats) {
            if (cat.satiety) {
                System.out.println(cat.name + " сыт(а)");
            } else {
                System.out.println(cat.name + " хочет кушать!");
            }
        }
    }
}