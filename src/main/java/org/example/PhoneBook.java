package org.example;

import java.util.*;

public class PhoneBook {
    public static void main(String[] args) {
        // Создаем HashMap для хранения телефонной книги
        HashMap<String, List<String>> phoneBook = new HashMap<>();

        // Добавляем записи в телефонную книгу
        addContact(phoneBook, "Иван Бубнов", "1234567890");
        addContact(phoneBook, "Жанна Червовая", "9876543210");
        addContact(phoneBook, "Иван Бубнов", "5555555555");
        addContact(phoneBook, "Алиса Туз", "1111111111");
        addContact(phoneBook, "Карен Крестов", "9999999999");
        addContact(phoneBook, "Жанна Червовая", "4444444444");

        // Выводим телефонную книгу отсортированную по убыванию числа телефонов
        List<Map.Entry<String, List<String>>> sortedEntries = sortPhoneBook(phoneBook);
        for (Map.Entry<String, List<String>> entry : sortedEntries) {
            String name = entry.getKey();
            List<String> phoneNumbers = entry.getValue();
            System.out.println(name + ": " + phoneNumbers);
        }
    }

    // Метод для добавления контакта в телефонную книгу
    public static void addContact(HashMap<String, List<String>> phoneBook, String name, String phoneNumber) {
        // Если контакт уже существует, добавляем телефонный номер в список
        if (phoneBook.containsKey(name)) {
            List<String> phoneNumbers = phoneBook.get(name);
            phoneNumbers.add(phoneNumber);
        } else {
            // Создаем новый список для телефонных номеров и добавляем его в телефонную книгу
            List<String> phoneNumbers = new ArrayList<>();
            phoneNumbers.add(phoneNumber);
            phoneBook.put(name, phoneNumbers);
        }
    }

    // Метод для сортировки телефонной книги по убыванию числа телефонов
    public static List<Map.Entry<String, List<String>>> sortPhoneBook(HashMap<String, List<String>> phoneBook) {
        List<Map.Entry<String, List<String>>> sortedEntries = new ArrayList<>(phoneBook.entrySet());

        // Используем компаратор для сортировки записей по убыванию числа телефонов
        sortedEntries.sort((entry1, entry2) -> {
            int size1 = entry1.getValue().size();
            int size2 = entry2.getValue().size();
            return Integer.compare(size2, size1);
        });

        return sortedEntries;
    }
}
