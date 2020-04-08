package icmit.oodb.Lab4;

import com.google.gson.Gson;
import icmit.oodb.Lab4.domain.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

public class LoadFile {
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

    public static List<Extra_salary> loadEx_sList() throws IOException {
        String str = "";
        File file = new File("JSON/extra_salary.json");

        if (file.exists()) {
            str = new String(Files.readAllBytes(file.toPath()));
        } else {
            System.out.println("File persons.json not found!");
        }

        Gson gson = new Gson();

        Extra_salary[] es = gson.fromJson(str, Extra_salary[].class);

        return Arrays.asList(es);
    }
}
