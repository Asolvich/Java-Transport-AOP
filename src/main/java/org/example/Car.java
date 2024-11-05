package org.example;

import java.util.Objects;

/**
 * Класс Car представляет собой сущность машины, которая наследуется от класса Transport.
 * Помимо полей базового класса (числовое и текстовое поля), содержит поле с типом машины.
 */
public class Car extends Transport {
    /**
     * Sedan
     * Sport
     * Universal
     * SUV
     */
    private String carType;

    /**
     * Пустой конструктор по умолчанию.
     * Создает объект Car без начальных значений.
     */

    public Car() {}

    /**
     * Конструктор, который инициализирует объект Car с переданными значениями для числового поля,
     * текстового поля и типа машины.
     *
     * @param numField числовое поле.
     */
    public Car(int numField, String textField, String carType) {
        super(numField, textField);
        this.carType = carType;
    }
    /**
     * Возвращает тип машины.
     *
     * @return строка, представляющая тип машины.
     */
    public String getСarType() {
        return carType;
    }

    /**
     * Устанавливает тип теста.
     *
     * @param carType строка, представляющая тип машины.
     */
    public void setСarType(String carType) {
        this.carType = carType;
    }

    /**
     * Переопределяет метод equals() для сравнения объектов Car.
     * Сравнение происходит на основе полей базового класса и типа машины.
     *
     * @param o объект для сравнения.
     * @return true, если объекты равны, иначе false.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Car car = (Car) o;
        return Objects.equals(carType, car.carType);
    }

    /**
     * Переопределяет метод hashCode() для генерации уникального хэш-кода объекта.
     * Учитывает поля базового класса и тип машины.
     *
     * @return хэш-код объекта.
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), carType);
    }

    /**
     * Переопределяет метод toString() для представления объекта Car в виде строки.
     * В строковом представлении включены числовое и текстовое поля из базового класса,
     * а также тип машины.
     *
     * @return строковое представление объекта Car.
     */
    @Override
    public String toString() {
        return "Car{" +
                "numberField=" + getNumField() +
                ", textField='" + getTextField() + '\'' +
                ", carType='" + carType + '\'' +
                '}';
    }
}
