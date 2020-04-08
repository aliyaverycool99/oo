package icmit.oodb.lab7.classes;

import icmit.oodb.lab7.annotation.*;

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
   List<Personnel> personnels;

  public Salary() {
  }

  public List<Personnel> getPersonnels() {
    return personnels;
  }

  public void setPersonnels(List<Personnel> personnels) {
    this.personnels = personnels;
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
            ", personnels=" + personnels +
            '}';
  }


}
