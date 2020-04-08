package icmit.oodb.lab8;

import icmit.oodb.lab8.domain.*;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;


public class Test {


  public static void main(String[] args) {
    Properties props = new Properties();
    props.setProperty("url", "jdbc:postgresql://localhost:5433/uchet");
    props.setProperty("username", "postgres");
    props.setProperty("password", "1234");
    props.setProperty("driverName", "org.postgresql.Driver");
    String classPath = "oodb.lab7.classes";
//    EntityManagerImpl entityManager = new EntityManagerImpl();
    EntityManagerFactory entityManagerFactory = new EntityManagerFactory(props, classPath);
    EntityManager entityManager = entityManagerFactory.create();


    Position position = new Position();
    position.setName("программист");
    entityManager.persist(position);

    Position position1 = new Position();
    position.setName("менеджер");
    entityManager.persist(position1);

    List<Position> positionList = Arrays.asList(position, position1);

    Salary salary = new Salary();
    salary.setName("работа в выходные");
    salary.setSize("1500");
    entityManager.persist(salary);

    List<Salary> salaryList = Arrays.asList(salary);

    Uchet uchet = new Uchet();
    uchet.setName("Документ_1");
    entityManager.persist(uchet);

    List<Uchet> uchetList = Arrays.asList(uchet);

    Person personnel = new Personnel();
    personnel.setName("Иван");
    personnel.setSurname("Иванович");
    personnel.setPhone("00-00-000");
    personnel.setGender(0);
    ((Personnel) personnel).setDate("--");
    ((Personnel) personnel).setPosition(position1);
    ((Personnel) personnel).setSalary(salary);
    ((Personnel) personnel).setUchet(uchetList);
    entityManager.persist(personnel);


    Person personnel1 = new Personnel();
    personnel1.setName("Алина");
    personnel1.setSurname("Хаметшина");
    personnel1.setPhone("89742836404");
    personnel1.setGender(1);
    ((Personnel) personnel1).setDate("04.10.2017");
    ((Personnel) personnel1).setPosition(position);
    ((Personnel) personnel1).setSalary(salary);
    ((Personnel) personnel1).setUchet(uchetList);
    entityManager.persist(personnel1);


    System.out.println("\n");
    System.out.println("Объект класса position до обновления - " + position);
    position.setName("охранник");
    entityManager.merge(position);
    System.out.println("Объект класса position после обновления - " + position);


    System.out.println("\n");
    System.out.println("Объект класса Personnel до обновления - " + personnel1);
    personnel1.setPhone("89742216704");
    ((Personnel) personnel1).setPosition(position1);
    entityManager.merge(personnel1);
    System.out.println("Объект класса Personnel после обновления - " + personnel1);
    System.out.println("\n");


    entityManager.remove(personnel);


    System.out.println("\n");
    Object object = entityManager.find(Salary.class, 1);
    System.out.println("Найденный объект класса Salary с id=10 - " + object);

    entityManagerFactory.close();


  }
}

