package org.example;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Основной класс консольного приложения для управления списком сущностей
 * (Plane, Car, Ship). Предоставляет меню для добавления, удаления,
 * вывода и сравнения сущностей.
 */

public class Main {
    /**
     * Главный метод программы, отвечает за вывод меню, обробатывание ввода пользователя,
     * завершение программы.
     */

    static ArrayList<Transport> entityList = new ArrayList<>();
    public static void main(String[] args) {

        while (true){
            Scanner scanner = new Scanner(System.in);
            System.out.println("------------------------------------------------------------");
            System.out.println("Выберите действие:");
            System.out.println("1) Добавление нового элемента");
            System.out.println("2) Удаление элемента по индексу");
            System.out.println("3) Вывод всех элементов");
            System.out.println("4) Сравнение двух элементов на сходство");
            System.out.println("5) Завершение работы");
            System.out.println("Введите значение: ");
            String userInput = scanner.nextLine();
            if (!isInt(userInput)){
                System.out.println("------------------------------------------------------------");
                System.out.println("Введено некоректное значение, пожалуйста введите число");
                continue;
            }
            
            int intInput = Integer.parseInt(userInput);
            switch (intInput) {
                case 1:
                    System.out.println("------------------------------------------------------------");
                    addNewEntity();
                    break;
                case 2:
                    System.out.println("------------------------------------------------------------");
                    deleteEntityByIndex();
                    break;
                case 3:
                    System.out.println("------------------------------------------------------------");
                    showAllEntities();
                    break;
                case 4:
                    System.out.println("------------------------------------------------------------");
                    compareEntities();
                    break;
                case 5:
                    System.out.println("------------------------------------------------------------");
                    System.out.println("Завершение работы.");
                    return;
                default:
                    System.out.println("------------------------------------------------------------");
                    System.out.println("Неверное значение, выберите от 1 до 5");
            }
        }
    }

    /**
     * Метод для добавления новой сущности в список. Пользователь выбирает тип
     * сущности, вводит числовое и текстовое поля, и сущность добавляется в общий
     * список.
     */
    private static void addNewEntity() {
        int intVariant;
        while (true){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите тип транспорта (1 - Машина, 2 - Самолет, 3 - Корабль):");
            String variant = scanner.nextLine();
            if(isInt(variant)){
                intVariant = Integer.parseInt(variant);
                if(intVariant == 1 || intVariant == 2 || intVariant == 3){
                    break;
                }else {
                    System.out.println("Неверный ввод, пожалуйтса введите число от 1 до 3");
                }
            }else {
                System.out.println("Неверный ввод, пожалуйтса введите число от 1 до 3");
            }
        }

        int numField;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите числовое поле:");
        String numberField = scanner.nextLine();
        while(!isInt(numberField)){
            System.out.println("Введите пожалуйста число");
            System.out.println("Введите числовое поле:");
            numberField = scanner.nextLine();
        }
        numField = Integer.parseInt((numberField));

        System.out.println("Введите строку:");
        String textField = scanner.nextLine();
        while (textField.isEmpty()){
         System.out.println("Введите пожалуйста строку");
         System.out.println("Введите строку:");
         textField = scanner.nextLine();
        }

        Transport entity = null;
        switch (intVariant){
            case 1:
                System.out.println("Введите тип машины:");
                String carType = scanner.nextLine();

                while (carType.isEmpty()){
                    System.out.println("Введите тип машины:");
                    carType = scanner.nextLine();
                }

                entity = new Car(numField, textField, carType);
                break;

            case 2:
                System.out.println("Введите тип самолета:");
                String planeType = scanner.nextLine();

                while (planeType.isEmpty()){
                    System.out.println("Введите тип самолета:");
                    planeType = scanner.nextLine();
                }

                entity = new Plane(numField, textField, planeType);
                break;

            case 3:
                System.out.println("Введите тип корабля:");
                String shipType = scanner.nextLine();

                while (shipType.isEmpty()){
                    System.out.println("Введите тип корабля:");
                    shipType = scanner.nextLine();
                }

                entity = new Ship(numField, textField, shipType);
                break;
        }
        entityList.add(entity);
    }

    /**
     * Метод для удаления сущности по индексу. Пользователь вводит индекс элемента,
     * и если индекс верен, элемент удаляется из списка.
     */
    private static void deleteEntityByIndex() {
        int index;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите индекс элемента для удаления:");
        String numberField = scanner.nextLine();

        while(!isInt(numberField)){
            System.out.println("Введите пожалуйста число");
            System.out.println("Введите индекс элемента для удаления:");
            numberField = scanner.nextLine();
        }

        index = Integer.parseInt((numberField));

        if (index >= 0 && index < entityList.size()) {
            entityList.remove(index);
            System.out.println("Элемент удален.");
        } else {
            System.out.println("Неверный индекс.");
        }
    }

    /**
     * Метод для вывода всех сущностей в списке. Если список пуст, выводится
     * сообщение об этом.
     */
    private static void showAllEntities() {
        if (entityList.isEmpty()) {
            System.out.println("Список пуст.");
        } else {
            for (int i = 0; i < entityList.size(); i++) {
                System.out.println("Индекс " + i + ": " + entityList.get(i));
            }
        }
    }

    /**
     * Метод для сравнения двух сущностей на равенство. Пользователь вводит индексы
     * двух элементов, и если оба индекса верны, сравниваются объекты. Выводится
     * сообщение, равны ли они или нет.
     */
    private static void compareEntities() {
        int index1;
        int index2;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите индекс первого элемента: ");
        String numberField = scanner.nextLine();
        while(!isInt(numberField)){
            System.out.println("Введите пожалуйста число");
            System.out.println("Введите индекс первого элемента: ");
            numberField = scanner.nextLine();
        }

        index1 = Integer.parseInt((numberField));
        System.out.println("Введите индекс первого элемента: ");
        numberField = scanner.nextLine();
        while(!isInt(numberField)){
            System.out.println("Введите пожалуйста число");
            System.out.println("Введите индекс первого элемента: ");
            numberField = scanner.nextLine();
        }

        index2 = Integer.parseInt((numberField));

        if (index1 >= 0 && index1 < entityList.size() && index2 >= 0 && index2 < entityList.size()) {
            Transport entity1 = entityList.get(index1);
            Transport entity2 = entityList.get(index2);

            if (entity1.equals(entity2)) {
                System.out.println("Элементы равны.");
            } else {
                System.out.println("Элементы не равны.");
            }
        } else {
            System.out.println("Один или оба индекса неверны.");
        }
    }

    /**
     *Метод для определения, является ли строка числом используя регулярные выражения,
     * выводит true если строка число, false иначе.
     *
     * @param userInput строка от пользователя
     * @return true или false
     */
    public static boolean isInt(String userInput) {
        return userInput.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
    }

}

