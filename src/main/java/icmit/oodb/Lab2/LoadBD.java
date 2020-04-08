package icmit.oodb.Lab2;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import icmit.oodb.Lab2.domain.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

public class LoadBD {
    //Загрузка личных данных людей
    public static List<Person> loadPersonList() throws IOException, JsonSyntaxException{
        String personStr = "";
        File file = new File("JSON/person.json");

        if (file.exists()) {
            personStr = new String(Files.readAllBytes(file.toPath()));
        } else {
            System.out.println("File person.json not found!");
        }

        Gson gson = new Gson();
        Person[] personlst = gson.fromJson(personStr, Person[].class);
        return Arrays.asList(personlst);
    }

    //загрузка информации о дополнительной плате сотрудникам
    public static List<Extra_salary> loadExtra_salaryList() throws IOException, JsonSyntaxException {
        String extra_salaryStr = "";
        File file = new File("JSON/extra_salary.json");

        if (file.exists()) {
            extra_salaryStr = new String(Files.readAllBytes(file.toPath()));
        } else {
            System.out.println("File extra_salary.json not found!");
        }

        Gson gson = new Gson();
        Extra_salary[] extra_salarielst = gson.fromJson(extra_salaryStr, Extra_salary[].class);
        return Arrays.asList(extra_salarielst);
    }

//    public static List load(String list, String file) throws IOException, ClassNotFoundException {
//        String Str = "";
//        File file0 = new File(file);
//
//        if (file0.exists()) {
//            Str = new String(Files.readAllBytes(file0.toPath()));
//        } else {
//            System.out.println("File .json not found!");
//        }
//        Gson gson = new Gson();
//
//        List<?> olist = List.forName(list);
//        Class<?> clas = Class.forName(list);
//    }



    //загрузка информации о должностях
    public static List<Position> loadPositionList() throws IOException, JsonSyntaxException {
        String positionStr = "";
        File file = new File("JSON/position.json");

        if (file.exists()) {
            positionStr = new String(Files.readAllBytes(file.toPath()));
        } else {
            System.out.println("File position.json not found!");
        }

        Gson gson = new Gson();
        Position[] positionlst = gson.fromJson(positionStr,Position[].class);
        return Arrays.asList(positionlst);
    }

    //загрузка информации о претендентах на кадры
    public static List<Applicants> loadApplicantsList() throws IOException, JsonSyntaxException {
        String applicantsStr = "";
        File file = new File("JSON/applicants.json");

        if (file.exists()) {
            applicantsStr = new String(Files.readAllBytes(file.toPath()));
        } else {
            System.out.println("File applicants.json not found!");
        }

        Gson gson = new Gson();
        Applicants[] applicantslst = gson.fromJson(applicantsStr, Applicants[].class);
        return Arrays.asList(applicantslst);
    }

    //загрузка информации о кадровиках
    public static List<Personnel> loadPersonnelList() throws IOException, JsonSyntaxException{
        String personnelStr = "";
        File file = new File("JSON/personnel.json");

        if (file.exists()) {
            personnelStr = new String(Files.readAllBytes(file.toPath()));
        } else {
            System.out.println("File personnel.json not found!");
        }

        Gson gson = new Gson();
        Personnel[] personnellst = gson.fromJson(personnelStr, Personnel[].class);
        return Arrays.asList(personnellst);
    }
}
