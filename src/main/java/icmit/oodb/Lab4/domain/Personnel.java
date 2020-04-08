package icmit.oodb.Lab4.domain;


//Класс кадровиков
//В этом классе хранятся личные данные человека, его должность, дата его устройства на работу, его премия, список его дополнительных работ
//Также тут высчитывается его ЗП
//

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class Personnel{
    private long ID;
    private Applicants applicants;
    private Extra_salary salary;
//    private int itog;


    public Personnel(long ID, Applicants applicants, Extra_salary salary) {
        this.ID = ID;
        this.applicants = applicants;
        this.salary = salary;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public Applicants getApplicants() {
        return applicants;
    }

    public void setApplicants(Applicants applicants) {
        this.applicants = applicants;
    }

    public Extra_salary getSalary() {
        return salary;
    }

    public void setSalary(Extra_salary salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Personnel{" +
                "ID=" + ID +
                ", applicants=" + applicants +
                ", salary=" + salary +
                '}';
    }

}
