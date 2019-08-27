package com.company;

public class Person {
    private final String firstName;
    private final String lastName;
    private final long phoneNumber;

    public Person(String firstName, String lastName, long phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return "Имя = '" + firstName + '\'' +
                ", Фамилия = '" + lastName + '\'' +
                ", теелефон = " + phoneNumber;
    }
}
