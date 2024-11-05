package org.example;

import java.util.Objects;

/**
 * Абстрактный класс, представляющий базовую сущность с двумя полями:
 * числовым (numField) и текстовым (textField). Предоставляет
 * методы для управления этими полями, а также переопределяет методы
 * equals, hashCode и toString.
 */

public abstract class Transport {
    private int numField;
    private String textField;

    /**
     * Конструктор по умолчанию. Инициализирует объект без задания полей.
     */
    public Transport() {}

    /**
     * Конструктор с параметрами. Инициализирует объект значениями для
     * числового и текстового полей.
     *
     * @param numField числовое поле, которое должно быть неотрицательным.
     * @param textField   текстовое поле, которое не должно быть пустым или null.
     * @throws IllegalArgumentException если значение numberField меньше 0 или
     * textField пустое или null.
     */
    public Transport(int numField, String textField) {
        setNumField(numField);
        setTextField(textField);
    }

    /**
     * Возвращает значение числового поля.
     *
     * @return текущее значение поля numField.
     */
    public int getNumField() {
        return numField;
    }

    /**
     * Устанавливает значение числового поля.
     * Если значение меньше 0, выбрасывается исключение IllegalArgumentException.
     *
     * @param numField новое значение для числового поля.
     * @throws IllegalArgumentException если значение numField меньше 0.
     */
    public void setNumField(int numField) {
        if (numField < 0) {
            throw new IllegalArgumentException("Число должно быть неотрицательным.");
        }
        this.numField = numField;
    }

    /**
     * Возвращает значение текстового поля.
     *
     * @return текущее значение поля textField.
     */
    public String getTextField() {
        return textField;
    }

    /**
     * Устанавливает значение текстового поля.
     * Если строка пустая или null, выбрасывается исключение IllegalArgumentException.
     *
     * @param textField новое значение для текстового поля.
     * @throws IllegalArgumentException если строка textField пуста или null.
     */
    public void setTextField(String textField) {
        if (textField == null || textField.trim().isEmpty()) {
            throw new IllegalArgumentException("Текстовое поле не может быть пустым или null.");
        }
        this.textField = textField;
    }

    /**
     * Переопределенный метод equals. Сравнивает текущий объект с другим объектом на
     * основе значений полей numField и textField.
     *
     * @param obj объект для сравнения.
     * @return true, если объекты равны, иначе false.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Transport transport = (Transport) obj;
        return numField == transport.numField && Objects.equals(textField, transport.textField);
    }

    /**
     * Переопределенный метод hashCode. Возвращает хеш-код на основе
     * полей textField и numField.
     *
     * @return хеш-код объекта.
     */
    @Override
    public int hashCode() {
        return Objects.hash(textField, numField);
    }

    /**
     * Переопределенный метод toString. Возвращает строковое представление объекта,
     * включая значения полей textField и numField.
     *
     * @return строковое представление объекта.
     */
    @Override
    public String toString() {
        return "TestBase{" +
                "textField='" + textField + '\'' +
                ", numberField=" + numField +
                '}';
    }
}
