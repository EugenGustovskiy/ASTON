package Lecture_7;

public class Cat extends Animal {
    public boolean satiety = false;

    public Cat(String name) {
        super(name);
    }

    public void run(int distance){
        if (distance <= 200) {
            System.out.printf("%s пробежал(а): %d.\n", name, distance);
        } else {
            System.out.printf("%s пробежал(а): %d. Осталось пробежать: %d.\n", name, 200,
                    distance - 200);
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println(name + " не умеет плавать!");
    }

    //Кормим кота (для сытости коту необходимо покушать на 5)
    public int feedCats(int bowlOfFood, Cat[] cats) {
        for (Cat cat : cats) {
            if (!cat.satiety && bowlOfFood >= 5) {
                cat.satiety = true;
                bowlOfFood -= 5;
            }
        }
        return bowlOfFood;
    }

    //Выводим в консоль сытость котов
    public void findOutIsCatFull(Cat[] cats) {
        for (Cat cat : cats) {
            if (cat.satiety) {
                System.out.println(cat.name + " сыт(а)");
            } else {
                System.out.println(cat.name + " хочет кушать!");
            }
        }
    }
}