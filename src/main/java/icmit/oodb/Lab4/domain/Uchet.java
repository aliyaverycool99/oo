package icmit.oodb.Lab4.domain;

import java.util.ArrayList;
import java.util.List;

public class Uchet {

    public String name = "001";

    List<Applicants> applicants = new ArrayList<>();
    List<Personnel> personnels = new ArrayList<>();

    public List<Applicants> getApplicants() {
        return applicants;
    }

    public void setApplicants(List<Applicants> applicants) {
        this.applicants = applicants;
    }

    public List<Personnel> getPersonnels() {
        return personnels;
    }

    public void setPersonnels(List<Personnel> personnels) {
        this.personnels = personnels;
    }

//    public void addApp (Long l, Person person, Position position){
//        applicants.add(new Applicants(l, person, position));
//    }

    public void addApp (Applicants app){
        applicants.add(app);
    }

    public void addPerl (Long l, Applicants applicants, Extra_salary extra_salary){
        personnels.add(new Personnel(l, applicants, extra_salary));
    }
}
