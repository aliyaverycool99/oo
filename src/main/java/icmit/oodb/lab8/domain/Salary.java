package icmit.oodb.lab8.domain;

import icmit.oodb.lab8.annotation.*;
import java.util.List;

@Entity
public class Salary {
  @Id
  Long id;
  @Column
  String name;
  @Column
  String size;

  @OneToMany
   List<Personnel> personnel;

  public Salary() {
  }

  public List<Personnel> getPersonnel() {
    return personnel;
  }

  public void setPersonnel(List<Personnel> personnel) {
    this.personnel = personnel;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSize() {
    return size;
  }

  public void setSize(String size) {
    this.size = size;
  }

  @Override
  public String toString() {
    return "Salary{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", size='" + size + '\'' +
            ", personnels=" + personnel +
            '}';
  }


}
