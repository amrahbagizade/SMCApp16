package entity;


public class Student {
    private Long id;
    private String s_name;
    private String s_surname;
    private String s_email;
    private String s_phone;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public String getS_surname() {
        return s_surname;
    }

    public void setS_surname(String s_surname) {
        this.s_surname = s_surname;
    }

    public String getS_email() {
        return s_email;
    }

    public void setS_email(String s_email) {
        this.s_email = s_email;
    }

    public String getS_phone() {
        return s_phone;
    }

    public void setS_phone(String s_phone) {
        this.s_phone = s_phone;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", s_name='" + s_name + '\'' +
                ", s_surname='" + s_surname + '\'' +
                ", s_email='" + s_email + '\'' +
                ", s_phone='" + s_phone + '\'' +
                '}';
    }
}
