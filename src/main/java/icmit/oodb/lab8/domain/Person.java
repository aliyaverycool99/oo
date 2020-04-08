package icmit.oodb.lab8.domain;


import icmit.oodb.lab8.annotation.Column;

public abstract class Person {
    @Column
    String surname;
    @Column
    String name;
    @Column
    String phone;
    @Column
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
