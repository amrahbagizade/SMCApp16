package DB;

import entity.Student;
import entity.Teacher;

import java.util.HashMap;
import java.util.Map;

public interface DB {
    Map<String, Student> studentsTable = new HashMap<>();
    Map<String, Teacher> teachersTable = new HashMap<>();

    String APP_USERNAME = "ADMIN";
    String APP_PASSWORD = "123";

}