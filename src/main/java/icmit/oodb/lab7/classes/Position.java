package icmit.oodb.lab7.classes;


import icmit.oodb.lab7.annotation.*;

import java.util.List;

@Entity(name = "Position")
public class Position {
  @Id
  Long id;
  @Column
  String name;

  @OneToMany
  List<Personnel> personnel;

  public Position() {
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getId() {
    return id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    return "Position{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", personnel=" + personnel +
            '}';
  }
}
