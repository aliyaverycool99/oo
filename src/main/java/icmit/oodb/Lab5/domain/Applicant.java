package icmit.oodb.Lab5.domain;

import org.postgresql.geometric.PGpoint;
import org.postgresql.util.PGobject;
import org.postgresql.util.PGtokenizer;

import java.sql.SQLException;

public class Applicant extends PGobject {
    private Person person;
    private Position position;

    public Applicant(){
        setType("applicant_");
    }

    public void setValue(String value) throws SQLException {
        String s = value.substring(1, value.length()-1);
        PGtokenizer t = new PGtokenizer(s, ',');
        if(t.getSize() != 2) throw new SQLException("Не удалось преобразовать в тип Applicant");
//        PGpoint point1 = new PGpoint(t.getToken(0));
//        person = unQuoteString(t.getToken(0));
//        position = Position.class(t.getToken(1));
    }

    @Override
    public String toString() {
        return "Applicant{" +
                "person=" + person +
                ", position=" + position +
                '}';
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
}
