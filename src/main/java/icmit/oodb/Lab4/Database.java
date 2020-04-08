package icmit.oodb.Lab4;

import com.google.gson.Gson;
import icmit.oodb.Lab4.domain.Position;
import icmit.oodb.Lab4.domain.Uchet;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//import static com.sun.activation.registries.LogSupport.log;

public class Database {

    Auth auth = new Auth();
    Gson gson = new Gson();

    class Auth {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String password = "1234";
    }

    public int saveToDB(Uchet uchet) {
        log("Сохранение в БД");
        String sql_1 = "insert into jtest (content) values('" + gson.toJson(uchet) + "') returning id";
        String sql_2 = "insert into jtest (contentb) values (cast(? as json)) returning id";
//        String SQL_SELECT1 = "insert into jtest (content) values ('" + gson.toJson(uchet) + "') returning id";
//        String SQL_SELECT = "insert into jtest (content, contentb) values (cast(? as json), cast(? as json)) returning id";
        try (Connection conn = DriverManager.getConnection(auth.url, auth.user, auth.password);
             PreparedStatement preparedStatement = conn.prepareStatement(sql_1)) {

            String object = gson.toJson(uchet);

            long start;
            long finish;

//            preparedStatement.setString(1, object);

            start = System.nanoTime();
            ResultSet resultSet = preparedStatement.executeQuery();
            finish = System.nanoTime();
            System.out.println("Время сохранения - content:  " + (finish - start) + " нс.");
            while (resultSet.next()) {
                int i = resultSet.getInt("id");
                //return i;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try (Connection conn = DriverManager.getConnection(auth.url, auth.user, auth.password);
             PreparedStatement preparedStatement = conn.prepareStatement(sql_2)) {

            String object = gson.toJson(uchet);

            long start;
            long finish;

            preparedStatement.setString(1, object);

            start = System.nanoTime();
            ResultSet resultSet = preparedStatement.executeQuery();
            finish = System.nanoTime();
            System.out.println("Время сохранения - contentb:  " + (finish - start) + " нс.");
            while (resultSet.next()) {
                int i = resultSet.getInt("id");
                //return i;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void loadFromDB() {
        long start;
        long finish;
        log("Считывание из БД");
        String sql = "select content from jtest";
        String sqlb = "select contentb from jtest";
        try (Connection conn = DriverManager.getConnection(auth.url, auth.user, auth.password);
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

            String example = "";
            Uchet uchet = null;

            start = System.nanoTime();
            ResultSet resultSet = preparedStatement.executeQuery();
            finish = System.nanoTime();
            System.out.println("Время считывания - content:  " + (finish - start) + " нс.");

            while (resultSet.next()) {
                example = resultSet.getString("content");
            }
            uchet = gson.fromJson(example, Uchet.class);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        try (Connection conn = DriverManager.getConnection(auth.url, auth.user, auth.password);
             PreparedStatement preparedStatement = conn.prepareStatement(sqlb)) {

            String example = "";
            Uchet uchet = null;

            start = System.nanoTime();
            ResultSet resultSet = preparedStatement.executeQuery();
            finish = System.nanoTime();
            System.out.println("Время считывания - contentb: " + (finish - start) + " нс.");

            while (resultSet.next()) {
                example = resultSet.getString("contentb");
            }
            uchet = gson.fromJson(example, Uchet.class);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void searchInBD() {
        long start;
        long finish;
        log("Поиск в БД");
        String sql = "SELECT content -> 'name' as content FROM jtest";
        String sqlb = "SELECT contentb -> 'name' as contentb FROM jtest";
        try (Connection conn = DriverManager.getConnection(auth.url, auth.user, auth.password);
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

            String example = "";
            Uchet uchet = null;

            start = System.nanoTime();
            ResultSet resultSet = preparedStatement.executeQuery();
            finish = System.nanoTime();
            System.out.println("Время поиска - content:  " + (finish - start) + " нс.");

            while (resultSet.next()) {
                example = resultSet.getString("content");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        try (Connection conn = DriverManager.getConnection(auth.url, auth.user, auth.password);
             PreparedStatement preparedStatement = conn.prepareStatement(sqlb)) {

            String example = "";
            Uchet uchet = null;

            start = System.nanoTime();
            ResultSet resultSet = preparedStatement.executeQuery();
            finish = System.nanoTime();
            System.out.println("Время поиска - contentb: " + (finish - start) + " нс.");

            while (resultSet.next()) {
                example = resultSet.getString("contentb");
            }
            System.out.println("Поле 'name' содержит: " + example);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void sortByASC() {
        List<String> content = new ArrayList<>();
        List<String> contentb = new ArrayList<>();
        long start;
        long finish;
        log("Сортировка по ASC");
        String sql = "SELECT (content -> 'name') as content FROM jtest ORDER by contentb ASC;";
        String sqlb = "SELECT (contentb -> 'name') as contentb FROM jtest ORDER by contentb ASC;";
        try (Connection conn = DriverManager.getConnection(auth.url, auth.user, auth.password);
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

            String example = "";
            Uchet uchet = null;

            start = System.nanoTime();
            ResultSet resultSet = preparedStatement.executeQuery();
            finish = System.nanoTime();
            System.out.println("Время сортировки - content:  " + (finish - start) + " нс.");

            while (resultSet.next()) {
                example = resultSet.getString("content");
                content.add(example);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        try (Connection conn = DriverManager.getConnection(auth.url, auth.user, auth.password);
             PreparedStatement preparedStatement = conn.prepareStatement(sqlb)) {

            String example = "";
            Uchet uchet = null;

            start = System.nanoTime();
            ResultSet resultSet = preparedStatement.executeQuery();
            finish = System.nanoTime();
            System.out.println("Время сортировки - contentn: " + (finish - start) + " нс.");

            while (resultSet.next()) {
                example = resultSet.getString("contentb");
                contentb.add(example);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("\ncontent:");
        for (int i = 0; i < content.size(); i++) {
            System.out.println(content.get(i));
        }
        System.out.println("\ncontentb:");
        for (int i = 0; i < contentb.size(); i++) {
            System.out.println(contentb.get(i));
        }
    }

        public void log (String str) {
        System.out.println("\n[ " + new Date().toString() + " ] " + str + "\n");
    }
}
