package icmit.oodb.Lab2.domain;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.function.Consumer;

public class Person {
    private long id;
    private String surname;
    private String name;
    private Calendar data_birth;
    private String education;
    private String phone;
    private String nationality;
    private String INN;
    private Gender gender;

    public Person() {

    }


    public enum Gender {
        male,
        female
    }

    public Person(long id, String surname, String name, Calendar data_birth, String education, String phone, String nationality, String inn, Gender gender) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.data_birth = data_birth;
        this.education = education;
        this.phone = phone;
        this.nationality = nationality;
        INN = inn;
        this.gender = gender;
    }


    public static void toWrPerson(Person prs) {
        String strdate = null;
        long id = prs.getId();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Calendar data_birth = prs.data_birth;
        String surname = prs.surname;
        String name = prs.name;
        String education = prs.education;
        String phone = prs.phone;
        String nationality = prs.nationality;
        String INN = prs.INN;
        Gender gender = prs.gender;
        if (data_birth != null) {
            strdate = sdf.format(data_birth.getTime());
        }
        String s = "Person" + id + " {" +
                "Surname = '" + surname + '\'' +
                ", Name = '" + name + '\'' +
                ", Birthday = '" + strdate + '\'' +
                ", Education = '" + education + '\'' +
                ", phone = '" + phone + '\'' +
                ", Nationality = '" + nationality + '\'' +
                ", INN = '" + INN + '\'' +
                ", Gender = '" + gender + '\'' +
                '}';
        System.out.println(s);
        return;
    }
    @Override
    public String toString() {
        String strdate = null;
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        if (data_birth != null) {
            strdate = sdf.format(data_birth.getTime());
        }
        return "Person{" +
                "Surname = '" + surname + '\'' +
                ", Name = '" + name + '\'' +
                ", Birthday = '" + strdate + '\'' +
                ", Education = '" + education + '\'' +
                ", phone = '" + phone + '\'' +
                ", Nationality = '" + nationality + '\'' +
                ", INN = '" + INN + '\'' +
                ", Gender = '" + gender + '\'' +
                '}';
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

    public Calendar getData_birth() {
        return data_birth;
    }

    public void setData_birth(Calendar data_birth) {
        this.data_birth = data_birth;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getINN() {
        return INN;
    }

    public void setINN(String INN) {
        this.INN = INN;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

}