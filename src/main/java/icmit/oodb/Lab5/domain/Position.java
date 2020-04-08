package icmit.oodb.Lab5.domain;

import org.postgresql.util.PGobject;
import org.postgresql.util.PGtokenizer;

import java.sql.SQLException;

public class Position extends PGobject {
    private String name;
    private int size;

    public Position() {
        setType("extra_salary_");
    }

    public Position(String name, int size) {
        this();
        this.name = name;
        this.size = size;
    }

    public void setValue(String value) throws SQLException {
        String s = value.substring(1, value.length()-1);
        PGtokenizer t = new PGtokenizer(s, ',');
        if(t.getSize() != 2) throw new SQLException("Не удалось преобразовать в тип Person");
        name = t.getToken(0);
        size = Integer.parseInt(t.getToken(1));
    }

    public boolean equals(Object obj) {
        if(obj instanceof Position) {
            Position p = (Position) obj;
            return p.getName().equals(name) && p.getSize() == (size);
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Position {" +
                "name='" + name + '\'' +
                ", size=" + size +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
