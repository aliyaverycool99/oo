package icmit.oodb.lab9.domain;

import javax.persistence.*;
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

  public Collection<Personnel> getPersonnel() {
    return personnel;
  }

  public void setPersonnel(Collection<Personnel> personnel) {
    this.personnel = personnel;
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
