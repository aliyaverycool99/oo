package icmit.oodb.Lab3.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "Uchet")
public class Uchet {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private List<Applicants> applicants;
    @XmlElementWrapper(name = "applicants")
    @XmlElement(name = "applicant")
    public List<Applicants> getApplicants() {
        return applicants;
    }
    public void setApplicants(List<Applicants> applicants) {
        this.applicants = applicants;
    }

    private List<Personnel> personnels;
    @XmlElementWrapper(name = "personnels")
    @XmlElement(name = "personnel")
    public List<Personnel> getPersonnels() {
        return personnels;
    }
    public void setPersonnels(List<Personnel> personnels) {
        this.personnels = personnels;
    }

    @Override
    public String toString(){
        return "Uchet: " +
                "name ='" + name + '\n' +
                ", applicants =" + applicants + '\n' +
                ", personnels=" + personnels;
    }
}
