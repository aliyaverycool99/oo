package icmit.oodb.Lab4;

import icmit.oodb.Lab4.domain.*;

import java.util.List;

public class Service {

    public static Person findPersonByGender(List<Person> persons, Person.Gender searchGender) {
        Person result = null;

        for (Person person : persons) {
            if (person.getGender().equals(searchGender)) {
                result = person;
            }
        }

        return result;
    }

    //Поиск по ID человека
    public static Person findPersonByID(List<Person> persons, long searchID) {
        Person result = null;

        for (Person person : persons) {
            if (person.getId()== searchID) {
                result = person;
            }
        }

        return result;
    }

    //Поиск по имени человека
    public static Person findPersonByName(List<Person> persons, String searchName) {
        Person result = null;

        for (Person person : persons) {
            if (person.getName().equals(searchName)) {
                result = person;
            }
        }

        return result;
    }

    //Поиск по ID дополнительной оплаты
    public static Extra_salary findExtra_salaryByID(List<Extra_salary> extra_salaries, long searchID) {
        Extra_salary result = null;

        for (Extra_salary extra_salary : extra_salaries) {
            if (extra_salary.getId()== searchID) {
                result = extra_salary;
            }
        }
        return result;
    }

    //Поиск по названию дополнительной оплаты
    public static Extra_salary findExtra_salaryByName(List<Extra_salary> extra_salaries, String searchName) {
        Extra_salary result = null;

        for (Extra_salary extra_salary : extra_salaries) {
            if (extra_salary.getName().equals(searchName)) {
                result = extra_salary;
            }
        }
        return result;
    }

    //Поиск по ID должности
    public static Position findPositionByID(List<Position> positions, long searchID) {
        Position result = null;

        for (Position position : positions) {
            if (position.getId()== searchID) {
                result = position;
            }
        }
        return result;
    }

    //Поиск по названию должности
    public static Position findPositionByName(List<Position> positions, String searchName) {
        Position result = null;

        for (Position position : positions) {
            if (position.getName().equals(searchName)) {
                result = position;
            }
        }
        return result;
    }

    //Поиск по ID претендента на кадр
    public static Applicants findApplicantsByPerson(List<Applicants> applicantsList, Person person) {
        Applicants result = null;

        for (Applicants applicants : applicantsList) {
            if (applicants.getPerson().equals(person)) {
                result = applicants;
            }
        }
        return result;
    }

    //Поиск по ID претендента на кадр
    public static Applicants findApplicantsByID(List<Applicants> applicantsList, long ID) {
        Applicants result = null;

        for (Applicants applicants : applicantsList) {
            if (applicants.getID() == ID) {
                result = applicants;
            }
        }
        return result;
    }

    //Поиск по ID кадровика
//    public static Personnel findPersonnelByID(List<Personnel> personnelList, Person person) {
//        Personnel result = null;
//
//        for (Personnel personnel : personnelList) {
//            if (personnel.getPerson().equals(person)) {
//                result = personnel;
//            }
//        }
//        return result;
//    }
}
