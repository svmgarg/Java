package serialization.basic;

import java.io.Serializable;

public class Employee implements Serializable {

/*
    private String name;
*/
    private long id;
    private String type;

 /*   public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
*/
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

/*
    private static final long serialVersionUID = 1L;
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", type='" + type + '\'' +
                ", serialversionUId='" + serialVersionUID + '\'' +
                '}';
    }*/


}
