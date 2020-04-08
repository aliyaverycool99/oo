package icmit.oodb.Lab5;

import com.google.gson.Gson;
import icmit.oodb.Lab5.domain.*;

import java.math.BigInteger;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DB {
    Auth auth = new Auth();

    class Auth {
        String url = "jdbc:postgresql://localhost:5433/uchet";
        String user = "postgres";
        String password = "1234";
    }

    public void insertApp(String surname, String namePer, String phone, String gender, Date date_birth, String namePos, int size) throws SQLException {
        Connection conn = DriverManager.getConnection(auth.url, auth.user, auth.password);
        String sql = "insert into applicant (_applicant.person.surname_, _applicant.person.name_, _applicant.person.phone_, _applicant.person.gender_, _applicant.person.date_birth_, _applicant.positon.name_, _applicant.positon.size_) values ('"+surname+"', '"+namePer+"','"+phone+"', '"+gender+"', '"+date_birth+"', '"+namePos+"', '"+size+"')";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void insertPerl(String surname, String namePer, String phone, String gender, Date date_birth, String namePos, int sizePos, String nameSal, int sizeSal, Date date_empl) throws SQLException {
        Connection conn = DriverManager.getConnection(auth.url, auth.user, auth.password);
        String sql = "insert into personnel (_personnel.person.person.surname_, _personnel.person.person.name_, _personnel.person.person.phone_, _personnel.person.person.gender_, _personnel.person.person.date_birth_, _personnel.person.positon.name_, _personnel.person.positon.size_, " +
                "_personnel.salary.name_, _personnel.salary.size_, " +
                "_personnel.date_empl) " +
                "values ('"+surname+"', '"+namePer+"','"+phone+"', '"+gender+"', '"+date_birth+"'," +
                " '"+namePos+"', '"+sizePos+"'," +
                "'"+nameSal+"', '"+sizeSal+
                "','"+date_empl+"')";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void findByIDApp(int i) throws SQLException {
        String example = "";
        Connection conn = DriverManager.getConnection(auth.url, auth.user, auth.password);
        String sql = " select _applicant from applicant where applicant.id = "+i+"";
        try (
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                example = resultSet.getString("_applicant");
                System.out.println("Претендент на должность под номером ID: "+ i + " = "+example);
            }
        }
    }

    public void findByIDPerl(int i) throws SQLException {
        String example = "";
        Connection conn = DriverManager.getConnection(auth.url, auth.user, auth.password);
        String sql = " select _personnel from personnel where personnel.id = " + i + "";
        try (
                PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                example = resultSet.getString("_personnel");
                System.out.println("Сотрудник на должность под номером ID: " + i + " = " + example);
            }
        }
    }

    public void updataPerl(int i, String surname, String namePer, String gender) throws SQLException {
        Connection conn = DriverManager.getConnection(auth.url, auth.user, auth.password);
        String sql = "update personnel set _personnel.person.person.surname_ = '"+surname+"', _personnel.person.person.name_ = '"+namePer+"', _personnel.person.person.gender_ = '"+gender+"' where personnel.id = "+i+"";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void updataApp(int i, String namePos, int sizePos) throws SQLException {
        Connection conn = DriverManager.getConnection(auth.url, auth.user, auth.password);
        String sql = "update applicant set _applicant.positon.name_ = '"+namePos+"', _applicant.positon.size_ = '"+sizePos+"' where applicant.id = "+i+"";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

//    SELECT (client).firstname from library_person;

    public void selectApp() throws SQLException {
        String example = "";
        Connection conn = DriverManager.getConnection(auth.url, auth.user, auth.password);
        String sql = "select (_applicant).person.surname_ from applicant";
        try (
                PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                example = resultSet.getString("surname_");
                System.out.println(example);
            }
        }
    }

    public void selectPerl() throws SQLException {
        String id = "";
        String name = "";
        Connection conn = DriverManager.getConnection(auth.url, auth.user, auth.password);
        String sql = "select (_personnel).person.person.name_, personnel.id from personnel";
        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                id = resultSet.getString("id");
                name = resultSet.getString("name_");
                System.out.println(id +" "+name);
            }
        }
    }
}

