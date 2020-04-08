package icmit.oodb.Lab4.domain;

import java.util.List;

public class Applicants {

    //Класс претендентов на должность
    //В этом классе хранится личные данные человека и список должностей, на которые претендует этот человек
    //т.е. у одного претендента может быть несколько должностей
    private long ID;
    private Person person;
    private Position position;

    public Applicants(long ID, Person person, Position position) {
        this.ID = ID;
        this.person = person;
        this.position = position;
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

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Applicant {" +
                person + '\'' +
                ", Positions = '" + position + '\'' +
                '}';
    }



}

