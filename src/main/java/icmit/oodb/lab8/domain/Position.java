package icmit.oodb.lab8.domain;

import icmit.oodb.lab8.annotation.*;
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

  public List<Personnel> getPersonnel() {
    return personnel;
  }

  public void setPersonnel(List<Personnel> personnel) {
    this.personnel = personnel;
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
