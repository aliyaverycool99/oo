package icmit.oodb.Lab4.domain;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Person {
    private long id;
    private String surname;
    private String name;
    private String phone;
    private Gender gender;

    public enum Gender {
        male,
        female
    }

    public Person(long id, String surname, String name, String phone, Gender gender) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.phone = phone;
        this.gender = gender;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", gender=" + gender +
                '}';
    }
}