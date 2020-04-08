package icmit.oodb.Lab4;

import icmit.oodb.Lab4.domain.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
    Person person0 = new Person(0, "Dill", "Bob", "89126483649", Person.Gender.male);
    Person person1 = new Person(1, "Rey", "Alex", "89126483649", Person.Gender.male);
    Person person2 = new Person(2, "Wow", "Alisa", "89126483649", Person.Gender.female);

    Extra_salary extra_salary0 = new Extra_salary(0, "Extra work", 2000);
    Extra_salary extra_salary1 = new Extra_salary(1, "Night work", 1500);

    Position position0 = new Position(0, "Programmer", 20000);
    Position position1 = new Position(1, "Accountant", 17000);

    Applicants applicant0 = new Applicants(0, person0, position0);
    Applicants applicant1 = new Applicants(1, person1, position0);
    Applicants applicant2 = new Applicants(1, person2, position1);

    Uchet uchet = new Uchet();
    uchet.addApp(applicant0);
    uchet.addApp(applicant1);
    uchet.addApp(applicant2);
    uchet.addPerl((long) 0, applicant0, extra_salary0);
    uchet.addPerl((long) 1, applicant2, extra_salary1);

    Database database = new Database();
    int i = database.saveToDB(uchet);
    database.loadFromDB();
    database.searchInBD();
    database.sortByASC();

    }
}
