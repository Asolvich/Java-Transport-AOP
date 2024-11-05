package org.example;

import java.util.Objects;

/**
 * Класс Plane представляет собой сущность самолета, которая наследуется от класса Transport.
 * Помимо полей базового класса (числовое и текстовое поля), содержит поле с типом самолета.
 */
public class Plane extends Transport {
    /**
     * Passenger
     * Personal
     * Military
     */
    private String planeType;

    /**
     * Пустой конструктор по умолчанию.
     * Создает объект Plane без начальных значений.
     */

    public Plane() {}

    /**
     * Конструктор, который инициализирует объект Plane с переданными значениями для числового поля,
     * текстового поля и типа самолета.
     *
     * @param numField числовое поле.
     * @param textField текстовое поле.
     * @param planeType строка, представляющая тип самолета.
     */
    public Plane(int numField, String textField, String planeType) {
        super(numField, textField);
        this.planeType = planeType;
    }
    /**
     * Возвращает тип самолета.
     *
     * @return строка, представляющая тип самолета.
     */
    public String getPlaneType() {
        return planeType;
    }

    /**
     * Устанавливает тип самолета.
     *
     * @param planeType строка, представляющая тип самолета.
     */
    public void setPlaneType(String planeType) {
        this.planeType = planeType;
    }

    /**
     * Переопределяет метод equals() для сравнения объектов Plane.
     * Сравнение происходит на основе полей базового класса и типа самолета.
     *
     * @param o объект для сравнения.
     * @return true, если объекты равны, иначе false.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Plane plane = (Plane) o;
        return Objects.equals(planeType, plane.planeType);
    }

    /**
     * Переопределяет метод hashCode() для генерации уникального хэш-кода объекта.
     * Учитывает поля базового класса и тип самолета.
     *
     * @return хэш-код объекта.
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), planeType);
    }

    /**
     * Переопределяет метод toString() для представления объекта Plane в виде строки.
     * В строковом представлении включены числовое и текстовое поля из базового класса,
     * а также тип самолета.
     *
     * @return строковое представление объекта Plane.
     */
    @Override
    public String toString() {
        return "Plane{" +
                "numberField=" + getNumField() +
                ", textField='" + getTextField() + '\'' +
                ", planeType='" + planeType + '\'' +
                '}';
    }
}
