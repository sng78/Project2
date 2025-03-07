package io.github.sng78.models;

import javax.validation.constraints.*;

public class Person {

    private int id;

    @Pattern(regexp = "[А-Я][а-я]+\\s[А-Я][а-я]+\\s[А-Я][а-я]+",
            message = "Нужно ввести в формате: Фамилия Имя Отчество")
    private String fullName;

    @NotNull
    @Min(value = 1901, message = "Год рождения должен быть больше 1900")
    private int yearOfBirth;

    public Person() {
    }

    public Person(int id, String fullName, int yearOfBirth) {
        this.id = id;
        this.fullName = fullName;
        this.yearOfBirth = yearOfBirth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }
}
