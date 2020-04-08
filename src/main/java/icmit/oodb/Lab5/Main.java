package icmit.oodb.Lab5;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) throws ParseException, SQLException {
        DB db = new DB();
        db.insertApp("surname", "namePer", "89123456789", "f", new SimpleDateFormat("yyyy-MM-dd").parse("1989-09-12"), "namePos", 12000);
        db.insertPerl("surname", "namePer", "89123456789", "f", new SimpleDateFormat("yyyy-MM-dd").parse("1989-09-12"), "namePos", 12000, "nameSal", 1000, new SimpleDateFormat("yyyy-MM-dd").parse("2017-09-12"));
        db.updataPerl(1,"SURNAME", "NAME", "M");
        db.findByIDApp(4);
        db.updataApp(4,"NAMESEZPOSITION", 1233);
        db.findByIDApp(4);
        db.findByIDPerl(9);
        db.selectApp();
        db.selectPerl();
    }
}
