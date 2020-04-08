package icmit.oodb.Lab2.domain;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.List;

public class Applicants {

    //Класс претендентов на должность
    //В этом классе хранится личные данные человека и список должностей, на которые претендует этот человек
    //т.е. у одного претендента может быть несколько должностей
    private long ID;
    private Person person;
    private List<Position> positionList;

    public Applicants(long ID, Person person, List<Position> positionList) {
        this.ID = ID;
        this.person = person;
        this.positionList = positionList;
    }

    public long getID() {
        return ID;
    }
    public void setID(long ID) {
        this.ID = ID;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public List<Position> getPositionList() {
        return positionList;
    }

    public void setPositionList(List<Position> positionList) {
        this.positionList = positionList;
    }

    @Override
    public String toString() {
        return "Applicant {" +
                person + '\'' +
                ", Positions = '" + positionList + '\'' +
                '}';
    }



}

