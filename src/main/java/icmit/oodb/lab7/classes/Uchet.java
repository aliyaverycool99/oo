package icmit.oodb.lab7.classes;


import icmit.oodb.lab7.annotation.*;

import java.util.Collection;
import java.util.TreeSet;

@Entity
public class Uchet {
  @Id
  Long id;
  @Column
  String name;

  @OneToOne
  Collection<Personnel> personnel = new TreeSet<>();

  public Uchet() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

}
