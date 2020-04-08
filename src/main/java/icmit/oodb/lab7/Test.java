package icmit.oodb.lab7;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;

public class Test {

  public static void main(String[] args) {
    ScanDB scanDB = new ScanDB();
    ScanPackages scanPackages = new ScanPackages();

    LinkedHashMap<String, LinkedHashSet<String>> tablesDB = scanDB.getTablesInfo();
    System.out.println("Данные из БД \n" + tablesDB);

    LinkedHashMap<String, LinkedHashMap<String, String>> tablesPackage = ScanClasses.getInfoAboutClasses();
    System.out.println("Данные из классов \n" + tablesPackage);

    List<String> tablesPackageNames = new ArrayList<>(tablesPackage.keySet());

    LinkedHashMap<String, List<String>> tableAndFieldColumns = new LinkedHashMap<>();
    LinkedHashMap<String, List<String>> tableAndFieldId = new LinkedHashMap<>();
    LinkedHashMap<String, List<String>> tableAndFieldRelations = new LinkedHashMap<>();

    for (int i = 0; i < tablesPackageNames.size(); i++) {
      // поля первого класса
      LinkedHashMap<String, String> fields = tablesPackage.get(tablesPackageNames.get(i));

      List<String> fieldsType = new ArrayList<>(fields.values());
      List<String> fieldsName = new ArrayList<>(fields.keySet());

      List<String> columns = new ArrayList<>();
      List<String> ids = new ArrayList<>();
      List<String> relations = new ArrayList<>();


      for (int j = 0; j < fields.size(); j++) {
        if (fieldsType.get(j).equalsIgnoreCase("Column"))
          columns.add(fieldsName.get(j));
        if (fieldsType.get(j).equalsIgnoreCase("Id"))
          ids.add(fieldsName.get(j));
        if (fieldsType.get(j).contains("OneToOne"))
          relations.add(fieldsName.get(j) + "=" + fieldsType.get(j));
        if (fieldsType.get(j).contains("OneToMany"))
          relations.add(fieldsName.get(j) + "=" + fieldsType.get(j));
        if (fieldsType.get(j).contains("ManyToMany"))
          relations.add(fieldsName.get(j) + "=" + fieldsType.get(j));
        if (fieldsType.get(j).contains("ManyToOne"))
          relations.add(fieldsName.get(j) + "=" + fieldsType.get(j));

      }
      tableAndFieldColumns.put(tablesPackageNames.get(i), columns);
      tableAndFieldId.put(tablesPackageNames.get(i), ids);
      tableAndFieldRelations.put(tablesPackageNames.get(i), relations);
    }

    List<String> tablesDBNames = new ArrayList<>(tablesDB.keySet());

    for (int i = 0; i < tablesPackage.size(); i++) {

      for (int j = 0; j < tablesDB.size(); j++) {
        if (tablesPackageNames.get(i).equalsIgnoreCase(tablesDBNames.get(j))) {
          System.out.println("\n Класс " + tablesPackageNames.get(i));

          //поля классов
          List<String> ids = tableAndFieldId.get(tablesPackageNames.get(i));
          List<String> columns = tableAndFieldColumns.get(tablesPackageNames.get(i));
          List<String> relations = tableAndFieldRelations.get(tablesPackageNames.get(i));

          LinkedHashSet<String> tablesDBFields = tablesDB.get(tablesDBNames.get(j));
          for (int k = 0; k < ids.size(); k++) {
            if (tablesDBFields.contains(ids.get(k)))
              System.out.println("\t\tПоле " + ids.get(k) + " совпадает");
          }

          for (int k = 0; k < columns.size(); k++) {
            if (tablesDBFields.contains(columns.get(k)))
              System.out.println("\t\tПоле " + columns.get(k) + " совпадает");
          }

          for (int k = 0; k < relations.size(); k++) {


            String[] relationsArray = relations.get(k).split("=");
            if (relationsArray[relationsArray.length - 3].equalsIgnoreCase("OneToMany")) {
              LinkedHashMap<String, String> fieldsPackage = tablesPackage.get(tablesPackageNames.get(i));
              if (fieldsPackage.containsKey(relationsArray[0]) && fieldsPackage.get(relationsArray[0]).contains(relationsArray[2]) &&
                      fieldsPackage.get(relationsArray[0]).contains(relationsArray[relationsArray.length - 1])) {
                System.out.println("В классе " + tablesPackageNames.get(i) + " найдено поле " + relationsArray[2] + "<" + relationsArray[relationsArray.length - 1] + ">");

              } else {
                System.out.println("Ошибка!!!! Поле  "+relationsArray[2] + "<" + relationsArray[relationsArray.length - 1] + "> не найдено");
              }
//

            } else if (relationsArray[relationsArray.length - 3].equalsIgnoreCase("ManyToMany")) {
//
              String tableName1 = relationsArray[relationsArray.length - 1].toLowerCase() + "_" + tablesDBNames.get(j);
              String tableName2 = tablesDBNames.get(j) + "_" + relationsArray[relationsArray.length - 1].toLowerCase();

              String tableName = null;

              if (tablesDBNames.contains(tableName1)) tableName = tableName1;
              else if (tablesDBNames.contains(tableName2)) tableName = tableName2;
              else System.out.println("Доп таблицы не найдено");

              if (tableName != null && !tableName.isEmpty()) {
                if (tablesDB.get(tableName)
                        .contains(relationsArray[relationsArray.length - 1].toLowerCase() + "_id")) {
                  System.out.println("В таблице " + tableName + " найдено поле " + relationsArray[relationsArray.length - 1].toLowerCase());

                } else {
                  System.out.println("Ошибка!!! Поле  "+relationsArray[relationsArray.length - 1].toLowerCase() + " не в таблице");
                }
              }

            } else if (relationsArray[relationsArray.length - 3].equalsIgnoreCase("ManyToOne")) {
              if (tablesDB.get(tablesDBNames.get(j)).contains(relationsArray[0].toLowerCase() + "_id")) {
                System.out.println("В таблице " + tablesDBNames.get(j) + " найдено поле " + relationsArray[0]);
              }
              else {
                System.out.println("Ошибка!!! Поле  "+relationsArray[0] + " не в таблице");
              }
//
            } else if (relationsArray[relationsArray.length - 3].equalsIgnoreCase("OneToOne")) {
              if (tablesDB.get(tablesDBNames.get(j)).contains(relationsArray[0] + "_id")) {
                System.out.println("В таблице " + tablesDBNames.get(j) + " найдено поле " + relationsArray[0] + "_id");
              }
              else {
                System.out.println("Ошибка!!! Поле  "+relationsArray[0] + "_id");
              }

            }
          }
        }
      }
    }
  }
}
