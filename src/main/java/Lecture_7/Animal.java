package Lecture_7;

public class Animal {
    protected String name;
    protected int maxRunningDistance;
    protected int maxSwimmingDistance;

    public Animal(String name, int runDistance, int swimDistance) {
        this.name = name;
        this.maxRunningDistance = runDistance;
        this.maxSwimmingDistance = swimDistance;
    }

    public void displayHowManyRun(int distance) {
        if (distance <= maxRunningDistance) {
            System.out.printf("%s пробежал(а): %d.\n", name, distance);
        } else {
            System.out.printf("%s пробежал(а): %d. Осталось пробежать: %d.\n", name, maxRunningDistance,
                    distance - maxRunningDistance);
        }
    }

    public void displayHowManySwim(int distance) {
        if (distance <= maxSwimmingDistance) {
            System.out.printf("%s проплыл(а): %d.\n", name, distance);
        } else {
            System.out.printf("%s проплыл(а): %d. Осталось проплыть: %d.\n", name, maxSwimmingDistance,
                    distance - maxSwimmingDistance);
        }
    }

    //Определяем количество отдельных животных
    public static int returnCountCertainAnimals(Animal[] animals) {
        int countAnimals = 0;
        for (Animal animal : animals) {
            if (animal != null) {
                countAnimals++;
            }
        }
        return countAnimals;
    }

    //Определяем общее количество животных
    public static int returnCountAllAnimals(int... countAnimal) {
        int countAllAnimals = 0;
        for (int i : countAnimal) {
            countAllAnimals += i;
        }
        return countAllAnimals;
    }
}