package icmit.oodb.Lab4;

import com.google.gson.Gson;
import icmit.oodb.Lab4.domain.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class LoadDB {
    public static Extra_salary ex_sLoad() throws IOException {
        Extra_salary ex_s = null;
        String str = "";
        File file = new File("JSON/extra_salary.json");

        if (file.exists()) {
            str = new String(Files.readAllBytes(file.toPath()));
        }

        ex_s = new Gson().fromJson(str, Extra_salary.class);

        return ex_s;
    }

    public static List<Extra_salary> loadEx_sList(Connection connection) throws SQLException {
        String str = "";
        PreparedStatement statement =
                connection.prepareStatement("select contentb from jtest");
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            str = resultSet.getString("contentb");
            System.out.println(str);
        }

        statement.close();

        Gson gson = new Gson();

        Extra_salary[] es = gson.fromJson(str, Extra_salary[].class);

        statement =
                connection.prepareStatement("select contentb->0 as c from jtest ");

        resultSet = statement.executeQuery();

        while (resultSet.next()) {
            str = resultSet.getString("c");
            System.out.println(str);
        }

        return Arrays.asList(es);
    }
}
