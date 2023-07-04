package Programm;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    private final Database database;
    private final Scanner scanner;

    public Menu(Database database) {
        this.database = database;
        scanner = new Scanner(System.in);
    }

    public void mainMenu() {
        while (true) {
            try {
                System.out.print("\nМеню:\n" +
                        "--------------------------------------\n" +
                        "1. Добавить новое животное\n" +
                        "2. Показать список всех животных\n" +
                        "3. Просмотреть список команд животного\n" +
                        "4. Обучить животное новой команде\n" +
                        "0. Выход\n" +
                        "--------------------------------------\n" +
                        "Выберите пункт меню: ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1 -> addNewAnimal();
                    case 2 -> database.allAnimals();
                    case 3 -> animalCommands();
                    case 4 -> teachNewCommand();
                    case 0 -> {
                        System.out.println("Программа завершена.");
                        return;
                    }
                    default -> System.out.println("Ошибка: неверный ввод. Попробуйте снова.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Ошибка: неверный ввод. Попробуйте снова.");
                scanner.nextLine();
            }
        }
    }

    private void addNewAnimal() {
        System.out.print("Введите имя животного: ");
        String name = scanner.nextLine();
        System.out.print("Введите список команд через запятую: ");
        String skills = scanner.nextLine();

        System.out.println("Выберите класс животного:\n" +
                "1. Собака\n" +
                "2. Кошка\n" +
                "3. Хомяк\n" +
                "4. Осёл\n" +
                "5. Конь");
        int animalClass = scanner.nextInt();
        scanner.nextLine();

        Animal animal;
        switch (animalClass) {
            case 1 -> animal = new Dog(name, skills);
            case 2 -> animal = new Cat(name, skills);
            case 3 -> animal = new Hamster(name, skills);
            case 4 -> animal = new Donkey(name, skills);
            case 5 -> animal = new Horse(name, skills);
            default -> {
                System.out.println("Ошибка: неверный ввод. Попробуйте снова.");
                return;
            }
        }

        database.addAnimal(animal);
        System.out.println("Данные успешно добавлены в базу данных.");
    }

    private void animalCommands() {
        System.out.print("Введите имя животного: ");
        String name = scanner.nextLine();

        database.animalCommands(name);
    }

    private void teachNewCommand() {
        System.out.print("Введите имя животного: ");
        String name = scanner.nextLine();
        System.out.print("Введите новые команды через запятую: ");
        String command = scanner.nextLine();

        database.teachNewCommand(name, command);
        System.out.println("Данные успешно добавлены в базу данных.");
    }
}