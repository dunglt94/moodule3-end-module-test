package model;

public class Student {
    private int id;
    private String code;
    private String name;
    private String clazz;

    public Student() {}

    public Student(String code, String name, String clazz) {
        this.code = code;
        this.name = name;
        this.clazz = clazz;
    }

    public Student(int id, String code, String name, String clazz) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.clazz = clazz;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }
}
