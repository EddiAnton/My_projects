package com.javarush.task.task21.task2113;

public class Horse {
    String name;
    double speed;
    double distance;

    public Horse(String name, double speed, double distance) {
        this.name = name;
        this.speed = speed;
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    // В методе move() значение поля distance увеличивается на расстояние пройденное
    // лошадью за один "ход"(значение поля speed) умноженное на случайное число
    // от нуля до единицы полученное с помощью вызова метода Math.random().
    public void move() {
        distance += speed * Math.random();
    }

    // Метод print() выводит на экран строку состоящую из точек и имени лошади.
    // Количество точек равно целой части distance.
    public void print() {
        for (int i = 0; i < (int) distance; i++) {
            System.out.print(".");
        }
        System.out.println(getName());
    }
}
