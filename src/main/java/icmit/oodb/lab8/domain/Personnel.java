package icmit.oodb.lab8.domain;


import icmit.oodb.lab8.annotation.*;

import java.util.Collection;

@Entity
public class Personnel extends Person{
  @Id
  Long id;
  @Column
  String date;
  @Column
  @ManyToOne
  Position Position;
  @Column
  @ManyToOne
  Salary salary;

  @OneToOne
  Collection<Uchet> Uchet;

  public Personnel() {
  }

//  public Personnel(String surname, String name, String phone, double gender, Position Position, Salary salary, String date) {
//    super(surname, name, phone, gender);
//    this.Position = Position;
//    this.salary = salary;
//    this.date = date;
//  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public Position getPosition() {
    return Position;
  }

  public void setPosition(Position position) {
    Position = position;
  }

  public Salary getSalary() {
    return salary;
  }

  public void setSalary(Salary salary) {
    this.salary = salary;
  }

  public Collection<Uchet> getUchet() {
    return Uchet;
  }

  public void setUchet(Collection<Uchet> uchet) {
    Uchet = uchet;
  }

  @Override
  public String toString() {
    return "Personnel{" +
            "id=" + id +
            ", date='" + date + '\'' +
            ", Position=" + Position +
            ", salary=" + salary +
            ", person ='" + surname + ' ' + name + ' ' + phone + ' ' + gender +
            '}';
  }
}
