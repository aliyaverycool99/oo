package icmit.oodb.Lab3.domain;

public class Extra_salary {
    private long id;
    private String name;
    private int size;

    public Extra_salary(){

    }

    public Extra_salary(long id, String name, int size) {
        this.id = id;
        this.name = name;
        this.size = size;
    }

    @Override
    public String toString() {
        return "Extra salary {" +
                " Name ='" + name + '\'' +
                ", Size='" + size + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
