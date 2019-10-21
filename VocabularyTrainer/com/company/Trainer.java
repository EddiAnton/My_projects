package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Trainer {
    private int wordCount = 0;
    private int positiveAnswerCount = 0;
    private int negativeAnswerCount = 0;

    public String printRecordsAmount() throws FileNotFoundException {
        Scanner scan = new Scanner(new File("/home/eduard/IdeaProjects/VocabularyTrainer/src/com/company/words.txt"));
        while (scan.hasNextLine()) {
            scan.nextLine();
            wordCount++;
        }
        scan.close();

        return "Тренажер содержит " + wordCount + " слов.";
    }

    private String[] record;
    private String[] translate;


    // метод возвращающий из тестового файла в рандомном порядке
    // слово на иностранном языке без перевода
    public String trainerStart(String text) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("/home/eduard/IdeaProjects/VocabularyTrainer/src/com/company/words.txt"));
        int pick = (int) (Math.random() * wordCount + 1);
        for (int i = 0; i < pick - 1; i++) {
            scan.nextLine();
        }
        record = scan.nextLine().split("-");
        return "Перевод слова " + record[0] + "?";
    }

    // метод проверяющий правильность введенного перевода слова
    public String getTranslate(String gues) {

        String guess = gues;
        boolean flag = false;
        translate = record[1].toLowerCase().split("[( {,|.}?)]+");
        String result = "";

        for (String s : translate) {
            if (guess.equals(s)) {
                flag = true;
            }
        }
        // при вводе "exit" показываем пользователю количество
        // правильных/неправильных ответов и обнуляем счетчики
        if (guess.equals("exit")) {
            result += "Ваш результат: \n";
            result += "правильных ответов - " + positiveAnswerCount + "\n";
            result += "неправильных ответов - " + negativeAnswerCount + "\n";
            positiveAnswerCount = 0;
            negativeAnswerCount = 0;

        } else {
            if (flag) {
                positiveAnswerCount++;
                result += "Верно\n\n";
            } else {
                negativeAnswerCount++;
                result += "Неверно, правильный ответ - " + record[1] + "\n";
            }
        }
        return result;
    }
}

