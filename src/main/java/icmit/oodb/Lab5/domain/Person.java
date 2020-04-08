package icmit.oodb.Lab5.domain;

import org.postgresql.util.PGobject;
import org.postgresql.util.PGtokenizer;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Person extends PGobject{
    private String surname;
    private String name;
    private String phone;
    private String gender;
    private Date date_birth;

    public Person() {
        setType("person_");
    }

    public Person(String surname, String name, String phone, String gender, Date date_birth) {
        this();
        this.surname = surname;
        this.name = name;
        this.phone = phone;
        this.gender = gender;
        this.date_birth = date_birth;
    }

    public void setValue(String value) throws SQLException{
        String s = value.substring(1, value.length()-1);
        PGtokenizer t = new PGtokenizer(s, ',');
        if(t.getSize() != 2) throw new SQLException("Не удалось преобразовать в тип Person");
        surname = t.getToken(0);
        name = t.getToken(1);
        phone = t.getToken(2);
        gender = t.getToken(3);
        try {
            date_birth = new SimpleDateFormat("yyyy-MM-dd").parse(t.getToken(4));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public boolean equals(Object obj) {
        if(obj instanceof Person) {
            Person p = (Person) obj;
            return p.getSurname().equals(surname) && p.getName().equals(name) &&
                    p.getPhone().equals(phone) &&p.getGender().equals(gender) &&p.getDate_birth().equals(date_birth);
        } else {
            return false;
        }
    }

    @Override
    public String getValue() {
        return "Person{" +
                "surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", gender='" + gender + '\'' +
                ", date_birth=" + new SimpleDateFormat("yyyy-MM-dd").format(date_birth) +
                '}';
    }

//    public String getValue() {
//        return "('" + firstname + "','" + lastname + "','" + middlename + "','" + gender
//                + "','" + new SimpleDateFormat("yyyy-MM-dd").format(birthdate) + "')";
//    }

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDate_birth() {
        return date_birth;
    }

    public void setDate_birth(Date date_birth) {
        this.date_birth = date_birth;
    }
}
