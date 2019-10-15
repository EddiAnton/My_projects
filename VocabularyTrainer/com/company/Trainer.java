package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Trainer {
    private int records = 0;

    public void printRecordsAmount() throws FileNotFoundException {
        Scanner scan = new Scanner(new File("/home/eduard/IdeaProjects/VocabularyTrainer/src/com/company/words.txt"));
        while (scan.hasNextLine()){
            scan.nextLine();
            records++;
        }
        System.out.println("Тренажер содержит " + records + " слов");
        scan.close();
    }

    public void trainerStart() throws FileNotFoundException {
        while (true){
            Scanner scan = new Scanner(new File("/home/eduard/IdeaProjects/VocabularyTrainer/src/com/company/words.txt"));
            int pick = (int)(Math.random() * records + 1);
            for (int i = 0; i < pick - 1; i++){
                scan.nextLine();
            }
            String[] record = scan.nextLine().split("-");
            System.out.println("Перевод слова \"" + record[0] + "\"?");
            String[] translate = record[1].toLowerCase().split("[( {,|.}?)]+");
            Scanner scn = new Scanner(System.in);
            String guess = scn.nextLine();

            boolean flag = false;
            for (String s : translate) {
                if (guess.equals(s)) {
                    flag = true;
                }
            }

            if(guess.equals("exit")){
                break;
            }else{
                if (flag) {
                //if(guess.toLowerCase().equals(record[1].toLowerCase())){
                    System.out.println("Верно");
                    System.out.println();
                }else {
                    System.out.println("Неверно, правильный ответ - " + record[1]);
                    System.out.println();
                }
            }
        }
    }
}
