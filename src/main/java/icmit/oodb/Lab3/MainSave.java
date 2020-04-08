package icmit.oodb.Lab3;

import icmit.oodb.Lab3.domain.*;

import javax.xml.bind.JAXBException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class MainSave {
    public static void main(String[] args) throws JAXBException {
        Uchet uchet = new Uchet();
        String name = "Name uchet";
        uchet.setName(name);

        //для начала вводим личные данные
        Person prs0 = new Person(0, "Thompson", "Diana", new GregorianCalendar(1999, 1, 1), "IVMiIT", "+79326577329", "RF", "009993332", Person.Gender.female);
        Person prs1 = new Person(1, "Tramp", "Alex", new GregorianCalendar(1839, 8, 14), "IMO", "+71884304787", "RF", "009993462", Person.Gender.male);
        Person prs2 = new Person(2, "Johnson", "Alex", new GregorianCalendar(1972, 11, 8), "IPO", "+79638954284", "RF", "009968731", Person.Gender.female);
        Person prs3 = new Person(3, "Smith", "Alina", new GregorianCalendar(1503, 5, 13), "IFMK", "+79643377578", "RF", "009985321", Person.Gender.male);
        //создаем должности
        Position position1 = new Position(0, "Programmer", 20000);
        Position position2 = new Position(1, "Accountant", 17000);
        Position position3 = new Position(2, "Economist", 15000);
        Position position4 = new Position(3, "Security Guard", 12000);
        List<Position> positionList = new ArrayList();
        positionList.add(position1);
        positionList.add(position2);

        //создаем самого претендента
        List<Applicants> app = new ArrayList();
        Applicants applicant0 = new Applicants(0, prs0, positionList);
        Applicants applicant1 = new Applicants(1, prs2, positionList);
        app.add(applicant0);
        app.add(applicant1);
        uchet.setApplicants(app);

        //Создаем доп ЗП
        Extra_salary ex_s0 = new Extra_salary(0, "Night shift", 2000);
        Extra_salary ex_s1 = new Extra_salary(1, "Extra work", 1000);

        //Создаем кадровиков
        List<Personnel> pers = new ArrayList();
        Personnel personnel0 = new Personnel(0, prs1, position3, new GregorianCalendar(1999, 1, 1),ex_s0, 100);
        Personnel personnel1 = new Personnel(1, prs3, position4, new GregorianCalendar(1999, 1, 1),ex_s1, 500);
        pers.add(personnel0);
        pers.add(personnel1);
        uchet.setPersonnels(pers);

        XMLService.saveUchetData(uchet);
        System.out.println("Файл заполнен");
}}
