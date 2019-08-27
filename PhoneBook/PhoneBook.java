package com.company;

import java.util.ArrayList;

public class PhoneBook {
    private ArrayList<Person> people = new ArrayList<>();

    // метод добавления контакта в телефонную книгу
    public void addRecord(Person person) {
        people.add(person);
    }

    // метод поиска контакта из телефонной книги
    public ArrayList<Person> search(String searchTerm) {
        // search
        ArrayList<Person> person = new ArrayList<>();

        for(Person p : people) {
            if(searchTerm.equals(p.getFirstName())){
                person.add(p);
            }
            else if(searchTerm.equals(p.getLastName())){
                person.add(p);
            }
        }
        return person;
    }
}
