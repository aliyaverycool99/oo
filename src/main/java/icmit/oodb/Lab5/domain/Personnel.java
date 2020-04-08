package icmit.oodb.Lab5.domain;

import org.postgresql.util.PGobject;
import org.postgresql.util.PGtokenizer;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Personnel extends PGobject {
    private Person person;
    private Extra_salary extra_salary;
    private Date date_empl;

    public Personnel() {
        setType("personnel_");
    }

    public void setValue(String value) throws SQLException {
        String s = value.substring(1, value.length() - 1);
        PGtokenizer t = new PGtokenizer(s, ',');
        if (t.getSize() != 2) throw new SQLException("Не удалось преобразовать в тип Person");
//        person = t.getToken(0);
//        extra_salary = t.getToken(1);
        try {
            date_empl = new SimpleDateFormat("yyyy-MM-dd").parse(t.getToken(2));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Personnel{" +
                "person=" + person +
                ", extra_salary=" + extra_salary +
                ", date_empl=" + date_empl +
                '}';
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Extra_salary getExtra_salary() {
        return extra_salary;
    }

    public void setExtra_salary(Extra_salary extra_salary) {
        this.extra_salary = extra_salary;
    }

    public Date getDate_empl() {
        return date_empl;
    }

    public void setDate_empl(Date date_empl) {
        this.date_empl = date_empl;
    }
}
