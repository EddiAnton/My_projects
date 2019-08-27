package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        phoneBook.addRecord(new Person("Eddi", "Anton", 9133703302L));
        phoneBook.addRecord(new Person("Julia", "Anton", 9831340594L));
        phoneBook.addRecord(new Person("Igor", "Vaizert", 9139110044L));
        phoneBook.addRecord(new Person("Marina", "Vaizert", 9133980000L));

        System.out.println(phoneBook.search("Anton"));
    }
}