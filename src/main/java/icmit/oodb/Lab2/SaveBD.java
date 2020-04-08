package icmit.oodb.Lab2;

import com.google.gson.Gson;

import icmit.oodb.Lab2.domain.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public class SaveBD {

    //сохраняем личные данные человека
    public static void savePersonList(List<Person> persons) throws IOException {

        if (persons != null) {
            Gson gson = new Gson();

            String personsAsJson = gson.toJson(persons);

//            System.out.println(personsAsJson);

            try (OutputStream os = new FileOutputStream(new File("JSON/person.json"))) {
                os.write(personsAsJson.getBytes("UTF-8"));
                os.flush();
            }
        }
    }


    //сохранение информации о дополнительной плате сотрудникам
    public static void saveExtra_salaryList(List<Extra_salary> extra_salaries) throws IOException {

        if (extra_salaries != null) {
            Gson gson = new Gson();

            String extra_salaryAsJson = gson.toJson(extra_salaries);

            System.out.println(extra_salaryAsJson);

            try (OutputStream os = new FileOutputStream(new File("JSON/extra_salary.json"))) {
                os.write(extra_salaryAsJson.getBytes("UTF-8"));
                os.flush();
            }
        }
    }


    //сохранение информации о должностях
    public static void savePositionList(List<Position> positions) throws IOException {

        if (positions != null) {
            Gson gson = new Gson();

            String positionAsJson = gson.toJson(positions);

            System.out.println(positionAsJson);

            try (OutputStream os = new FileOutputStream(new File("JSON/position.json"))) {
                os.write(positionAsJson.getBytes("UTF-8"));
                os.flush();
            }
        }
    }

    //сохранение информации о претендентах на кадры
    //изменить вывод информации
    public static void saveApplicantsList(List<Applicants> applicants) throws IOException {

        if (applicants != null) {
            Gson gson = new Gson();

            String applicantsAsJson = gson.toJson(applicants);

            System.out.println(applicantsAsJson);

            try (OutputStream os = new FileOutputStream(new File("JSON/applicants.json"))) {
                os.write(applicantsAsJson.getBytes("UTF-8"));
                os.flush();
            }
        }
    }

    //сохранение информации о кадрах
    //изменить вывод информации
    public static void savePersonnelList(List<Personnel> personnels) throws IOException {

        if (personnels != null) {
            Gson gson = new Gson();

            String personnelsAsJson = gson.toJson(personnels);

            System.out.println(personnelsAsJson);

            try (OutputStream os = new FileOutputStream(new File("JSON/personnel.json"))) {
                os.write(personnelsAsJson.getBytes("UTF-8"));
                os.flush();
            }
        }
    }
}
