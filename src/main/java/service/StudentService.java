package service;


import dao.StudentDao;
import entity.Student;
import DB.DB;

import java.sql.SQLException;
import java.util.Scanner;

public final class StudentService {

    public static void addStudent() throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("ADD STUDENT");
        Student student = new Student();

        System.out.println("Telebenin adini daxil edin:");
        String name = input.nextLine();
        student.setName(name);

        System.out.println("Telebenin soyadini daxil edin:");
        String surname = input.nextLine();
        student.setSurname(surname);

        System.out.println("Telebenin emailini daxil edin:");
        String email = input.nextLine();
        student.setEmail(email);

        System.out.println("Telebenin nomresini daxil edin:");
        String phone = input.nextLine();
        student.setPhone(phone);

        System.out.println(student);
        StudentDao.addStudent(student);
        //  DB.studentsTable.put(UUID.randomUUID().toString(), student);

    }

    public static void getAllStudents() throws SQLException {
        System.out.println("GET ALL STUDENTS");
        System.out.println("*********************************************");

      // if ile sert yazmaq istesek bu usuldan istifade edirik  for(Student student: StudentDao.getAllStudent()){
      //      System.out.println(student);
      //}
        StudentDao.getAllStudent().forEach(System.out::println);
        //        for (Map.Entry<String, Student> entry : DB.studentsTable.entrySet()) {
//            System.out.println("ID" + entry.getKey() + "Object" + entry.getValue());
//        }
        System.out.println("*********************************************");
    }

    public static void getOneStudent() throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("GET ONE STUDENT");
        getAllStudents();
        System.out.println("Telebenin ID-sini daxil edin:");
        String id = input.nextLine();
        System.out.println(StudentDao.getStudentById(Long.valueOf(id)));
//        Student student = DB.studentsTable.get(id);
//        System.out.println(student);

    }

    public static void updateStudent() throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.println("UPDATE STUDENT");
        getAllStudents();
        System.out.println("Deyishiklik ucun telebenin id-sini daxil edin:");
        String id = input.nextLine();
//        Student student = DB.studentsTable.get(id);
        Student student = StudentDao.getStudentById(Long.valueOf(id)); //Id-e gore telebeni axtaririq.
        System.out.println("Telebenin adini daxil edin:");
        String name = input.nextLine();
        student.setName(name);

        System.out.println("Telebenin soyadini daxil edin:");
        String surname = input.nextLine();
        student.setSurname(surname);

        System.out.println("Telebenin emailini daxil edin:");
        String email = input.nextLine();
        student.setEmail(email);

        System.out.println("Telebenin nomresini daxil edin:");
        String phone = input.nextLine();
        student.setPhone(phone);
        StudentDao.updateStudentById(student); // yeni yaratdigimiz objecti atiriq metoda

    }

    public static void deleteStudent() throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("DELETE STUDENT STUDENT");
        getAllStudents();
        System.out.println("Silmek uchun telebenin ID-sini daxil edin:");
        String id = input.nextLine();
StudentDao.deleteStudent(Long.valueOf(id));
        //        DB.studentsTable.remove(id);


    }
}
