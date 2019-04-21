package com.javarush.task.task21.task2113;

import java.util.*;

public class Hippodrome {
    // объявляем приватный лист в котором будут храниться лошади
    private List<Horse> horses;
    // объявляем объект игры Ипподром
    static Hippodrome game;

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    // создаем геттер для доступа к приватному листу с лошадьми
    public List<Horse> getHorses() {
        return horses;
    }

    // В методе run запускаем цикл от 1 до 100. Это наш забег.
    // В теле цикла вызываем сначала move, затем print.
    // Чтобы игра работала наглядно добавляем в него Thread.sleep(500);
    public void run() throws InterruptedException {
        for (int i = 0; i < 100; i++ ) {
            move();
            print();
            Thread.sleep(500);
        }
    }

    // В цикле для каждой лошади вызываем ее метод print.
    // Выводим после цикла 10 пустых строк - чтобы было красивее.
    public void print() {
        for (Horse horse: horses) {
            horse.print();
        }
        for (int i = 0; i < 10; i++)
            System.out.println();
    }

    // В методе move класса Hippodrome в цикле у каждой лошади
    // мы вызываем метод move класса Horse.
    public void move() {
        for (Horse horse: horses) {
            horse.move();
        }
    }

    // Метод getWinner() возвращает лошадь пробежавшую наибольшую дистанцию.
    public Horse getWinner() {
        Horse horseWinner = null;
        for (Horse horse: horses) {
            if (horseWinner == null) {
                horseWinner = horse;
            }
            if (horseWinner.getDistance() < horse.getDistance()) {
                horseWinner = horse;
            }
        }
        return horseWinner;
    }

    // Метод printWinner() выводит на экран имя победителя.
    public void printWinner() {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }

    public static void main(String[] args) throws InterruptedException {
        game = new Hippodrome(new ArrayList<>());

        game.getHorses().add(new Horse("Zorka", 3, 0));
        game.getHorses().add(new Horse("Zvezda", 3, 0));
        game.getHorses().add(new Horse("Lucky", 3, 0));
        game.getHorses().add(new Horse("Slevin", 3, 0));

        game.run();
        game.printWinner();
    }
}
