package icmit.oodb.Lab2;

import com.google.gson.Gson;
import icmit.oodb.Lab2.domain.*;
//import javafx.geometry.Pos;

import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {

//        Очищение файлов
        String filePathPerson = "JSON/person.json";
        String filePathPersonnel = "JSON/personnel.json";
        String filePathApp = "JSON/applicants.json";
        String filePathPosition = "JSON/position.json";
        String filePathEx_s = "JSON/extra_salary.json";
        String _ = "";
        FileWriter.appendUsingFileWriter(filePathPerson, _);
        FileWriter.appendUsingFileWriter(filePathPersonnel, _);
        FileWriter.appendUsingFileWriter(filePathApp, _);
        FileWriter.appendUsingFileWriter(filePathPosition, _);
        FileWriter.appendUsingFileWriter(filePathEx_s, _);


//запись личных данных
        List<Person> personList = new ArrayList();

        Person person = new Person();
        person.setId(0);
        person.setName("Alexander");
        person.setSurname("All");
        person.setNationality("Tatarstan");
        person.setEducation("VMK");
        person.setData_birth(new GregorianCalendar(1979, 8, 22));
        person.setGender(Person.Gender.male);
        person.setINN("0095459433");
        person.setPhone("+78932742209");

        Person person1 = new Person();
        person1.setId(1);
        person1.setName("Bob");
        person1.setSurname("Bill");
        person1.setNationality("Tatarstan");
        person1.setEducation("VMK");
        person1.setData_birth(new GregorianCalendar());
        person1.setGender(Person.Gender.male);
        person1.setINN("9905004353");
        person1.setPhone("+78921220954");

        personList.add(person);
        personList.add(person1);

        Gson gsonPerson   = new Gson();
        String strPerson = gsonPerson.toJson(personList);


        FileWriter.appendUsingFileWriter(filePathPerson,strPerson);
        SaveBD.savePersonList(personList);



        //Изменение личных данных о человеке
            List<Person> person_list = LoadBD.loadPersonList();
            System.out.println("Список: ");
            person_list.forEach(System.out::println);
            Person prs = Service.findPersonByID(person_list, 0);
            if (prs != null) {
                prs.setSurname("__");
                prs.setName("Alex");
                prs.setData_birth(new GregorianCalendar(0000, 0, 0));
                prs.setEducation("____");
                prs.setPhone("____");
                prs.setNationality("____");
                prs.setINN("___");
                prs.setGender(Person.Gender.male);

            }
            SaveBD.savePersonList(person_list);
            System.out.println("Измененный фрагмент: ");
            Person.toWrPerson(prs);
            System.out.println("Измененный список: ");
            person_list.forEach(System.out::println);


        //Вывод информации о мужчинах, сортировка
        System.out.println("Мужчины о алфавиту");
        List<Person> personn_List = LoadBD.loadPersonList();
        List<String> prsList = new ArrayList<>();
        int l = 0;
        for (int i = 0;i < personn_List.size(); i++){
            Person el = personn_List.get(l);
            if (el.getGender().equals(Person.Gender.male)) {
                prsList.add(el.getName());
            }
            l++;
        }
        Collections.sort(prsList);
        System.out.println(prsList);


//Найти человека по имени
        Scanner in = new Scanner(System.in);
        System.out.println("Введите имя искомого человека:");
        String name = in.next();
        List<Person> personn_list = LoadBD.loadPersonList();
        Person prs1 = Service.findPersonByName(personn_list, name);
        System.out.println("Вывод информации по имени " + name);
        Person.toWrPerson(prs1);


//Создание должностей
        List<Position> positionList = new ArrayList();
        Position position0 = new Position();
        position0.setId(0);
        position0.setName("___");
        position0.setSize(12000);
        Position position1 = new Position(1, "0909", 15000);
        Position position2 = new Position(2, "00000", 19);

        positionList.add(position0);
        positionList.add(position1);
        positionList.add(position2);

        Gson gsonPosition   = new Gson();
        String strPosition = gsonPosition.toJson(positionList);

        FileWriter.appendUsingFileWriter(filePathPosition,strPosition);
        SaveBD.savePositionList(positionList);

        ////////////////////////////////////////////////////////////////////////////////\
//Создание претендента на должность

//для начала вводим личные данные
        List<Person> newPersonList = new ArrayList(LoadBD.loadPersonList());
        Person prs2 = new Person(2, "", "", new GregorianCalendar(0000, 0, 0), "", "", "", "", Person.Gender.male);
        newPersonList.add(prs2);
        Gson gsonNewPerson = new Gson();
        String strNewPerson = gsonNewPerson.toJson(newPersonList);
        FileWriter.appendUsingFileWriter(filePathPerson,strNewPerson);
        SaveBD.savePersonList(newPersonList);
//из существующих должностей выбираем те, на которые претендует человек
        List<Position> positionListForApp0 = new ArrayList<>();
        positionListForApp0.add(position1);
        positionListForApp0.add(position2);
//создаем самого претендента
        List<Applicants> appList = new ArrayList<>();
        Applicants applicant0 = new Applicants(0, prs2, positionListForApp0);
        appList.add(applicant0);
        Gson gsonNewApp = new Gson();
        String strNewApp = gsonNewApp.toJson(appList);

        FileWriter.appendUsingFileWriter(filePathApp,strNewApp);
        SaveBD.saveApplicantsList(appList);
        System.out.println(applicant0);


//Создаем дополнительные платы
        List<Extra_salary> ex_sList = new ArrayList();
        Extra_salary extra_salary = new Extra_salary(0, "____", 2000);
        ex_sList.add(extra_salary);
        Gson gsonEx_s = new Gson();
        String strEx_s = gsonEx_s.toJson(ex_sList);

        FileWriter.appendUsingFileWriter(filePathEx_s, strEx_s);
        SaveBD.saveExtra_salaryList(ex_sList);



//Создаем кадровика

        //Ищем нужного человека из списка претендентов
        List<Applicants> _appList = LoadBD.loadApplicantsList();
        Applicants prss = Service.findApplicantsByID(_appList, 0);
        Person _prs = prss.getPerson();
        //Выбираем должность из его должностей, на которые он претендует
        List<Position> _posList = prss.getPositionList();
        Position _pos = Service.findPositionByID(_posList, 1);
        //Выбираем ему доп ЗП
        List<Extra_salary> _ex_sList = LoadBD.loadExtra_salaryList();
        Extra_salary _ex_s = Service.findExtra_salaryByID(_ex_sList, 0);

        List<Personnel> personnelList = new ArrayList(LoadBD.loadPersonnelList());
        Calendar date = new GregorianCalendar(2018, 8, 12);
        personnelList.add(new Personnel(_prs, _pos, date, _ex_s, 1000));
        Gson gsonNewPersonnel = new Gson();
        String strNewPersonnel = gsonNewPersonnel.toJson(personnelList);
        FileWriter.appendUsingFileWriter(filePathPersonnel,strNewPersonnel);
        SaveBD.savePersonnelList(personnelList);
    }}



