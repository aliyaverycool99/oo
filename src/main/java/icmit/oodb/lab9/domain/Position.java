package icmit.oodb.lab9.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Position {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  Long id;
  @Column(length = 60,nullable = false  )
  String name;

  @OneToMany(mappedBy = "position", cascade = CascadeType.REMOVE)
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
