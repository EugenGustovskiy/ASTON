package Lecture_13;

import java.util.*;

public class Lecture_13 {
    public static void main(String[] args) {
        String[] collectionOfWords = {"молоко", "хлеб", "молоко", "йогурт", "Молоко", "Сыр", "Сметана", "мясо", "КОНФЕТЫ",
                "кетчуп", "сыр", "творог", "Хлеб", "конфеты", "зефир", "рыба", "вода", "хрен", "помидор"};

        //Lecture_13 lecture = new Lecture_13();
        //Задание 1.1
        //lecture.printCollectionUniqueWords(collectionOfWords);
        //Задание 1.2
        //lecture.printWordCount(collectionOfWords);

        //Задание 2
        //Phonebook phonebook = new Phonebook();
        //phonebook.add("Смирнов Сергей Александрович", "+375336549874");
        //phonebook.add("Кукушкин Игорь Вадимович", "+375446874211");
        //phonebook.add("Смирнов Денис Иванович", "+375296874126");
        //phonebook.add("Петров Петр Витальевич", "+375294759862");

        //phonebook.printContacts("Смирнов");
    }

    //Получаем список уникальных слов (Регистр учитываем)
    public Set<String> getCollectionUniqueWords(String[] collectionOfWords) {
        Set<String> collectionUniqueWords = new HashSet<>();
        Collections.addAll(collectionUniqueWords, collectionOfWords);
        return collectionUniqueWords;
    }

    //Выводим список уникальных слов
    public void printCollectionUniqueWords(String[] collectionUniqueWords) {
        Set<String> uniqueWords = getCollectionUniqueWords(collectionUniqueWords);
        System.out.println("Уникальные слова: " + uniqueWords);
    }

    //Получаем количество вхождений каждого слова (Регистр не учитываем)
    public Map<String, Integer> getWordCount(String[] collectionOfWords) {
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : collectionOfWords) {
            String wordLower = word.toLowerCase();
            wordCount.put(wordLower, wordCount.getOrDefault(wordLower, 0) + 1);
        }
        return wordCount;
    }

    //Выводим слово и количество вхождений
    public void printWordCount(String[] collectionOfWords) {
        Map<String, Integer> wordCount = getWordCount(collectionOfWords);
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}