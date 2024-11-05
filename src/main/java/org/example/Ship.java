package org.example;

import java.util.Objects;

/**
 * Класс Ship представляет собой сущность Корабля, которая наследуется от класса Transport.
 * Помимо полей базового класса (числовое и текстовое поля), содержит поле с типом корабля.
 */
public class Ship extends Transport {
    /**
     * Cruise
     * Personal
     * Military
     */
    private String shipType;

    /**
     * Пустой конструктор по умолчанию.
     * Создает объект Ship без начальных значений.
     */

    public Ship() {}

    /**
     * Конструктор, который инициализирует объект Ship с переданными значениями для числового поля,
     * текстового поля и типа корабля.
     *
     * @param numField числовое поле.
     * @param textField текстовое поле.
     * @param shipType строка, представляющая тип корабля.
     */
    public Ship(int numField, String textField, String shipType) {
        super(numField, textField);
        this.shipType = shipType;
    }
    /**
     * Возвращает тип корабля.
     *
     * @return строка, представляющая тип корабля.
     */
    public String getShipType() {
        return shipType;
    }

    /**
     * Устанавливает тип корабля.
     *
     * @param shipType строка, представляющая тип корабля.
     */
    public void setShipType(String shipType) {
        this.shipType = shipType;
    }

    /**
     * Переопределяет метод equals() для сравнения объектов Ship.
     * Сравнение происходит на основе полей базового класса и типа корабля.
     *
     * @param o объект для сравнения.
     * @return true, если объекты равны, иначе false.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Ship ship = (Ship) o;
        return Objects.equals(shipType, ship.shipType);
    }

    /**
     * Переопределяет метод hashCode() для генерации уникального хэш-кода объекта.
     * Учитывает поля базового класса и тип корабля.
     *
     * @return хэш-код объекта.
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), shipType);
    }

    /**
     * Переопределяет метод toString() для представления объекта Ship в виде строки.
     * В строковом представлении включены числовое и текстовое поля из базового класса,
     * а также тип корабля.
     *
     * @return строковое представление объекта Ship.
     */
    @Override
    public String toString() {
        return "Ship{" +
                "numberField=" + getNumField() +
                ", textField='" + getTextField() + '\'' +
                ", shipType='" + shipType + '\'' +
                '}';
    }
}
