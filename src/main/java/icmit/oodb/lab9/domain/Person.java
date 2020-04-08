package icmit.oodb.lab9.domain;

import javax.persistence.*;

public abstract class Person {

    @Column(length = 60,nullable = false)
    String surname;
    @Column(length = 60,nullable = false)
    String name;
    @Column(length = 60,nullable = false)
    String phone;
    @Column(nullable = false)
    double gender;


  public Person() {
  }


    public Person(String surname, String name, String phone, double gender) {
        this.surname = surname;
        this.name = name;
        this.phone = phone;
        this.gender = gender;
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

    public double getGender() {
        return gender;
    }

    public void setGender(double gender) {
        this.gender = gender;
    }
}
