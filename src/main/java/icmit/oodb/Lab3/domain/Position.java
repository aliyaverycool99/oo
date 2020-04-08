package icmit.oodb.Lab3.domain;

//Список должностей


public class Position {
    private long id;
    private String name;
     int size;

    public Position() {
    }

    public Position (long id, String name, int size) {
        this.id = id;
        this.name = name;
        this.size = size;
    }

    @Override
    public String toString() {
        return "Position {" +
                "Name='" + name + '\'' +
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
