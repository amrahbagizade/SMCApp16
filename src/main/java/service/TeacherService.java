package service;

import DB.DB;
import dao.TeacherDao;
import entity.Teacher;

import java.sql.SQLException;
import java.util.Scanner;

public final class TeacherService {

    public static void addTeacher() throws SQLException {

        Scanner input = new Scanner(System.in);
        System.out.println("ADD TEACHER");
        Teacher teacher = new Teacher();

        System.out.println("Muellimin adini daxil edin:");
        String name = input.nextLine();
        teacher.setName(name);

        System.out.println("Muellimin soyadini daxil edin:");
        String surname = input.nextLine();
        teacher.setSurname(surname);

        System.out.println("Muellimin emailini daxil edin:");
        String email = input.nextLine();
        teacher.setEmail(email);

        System.out.println("Muellimin telefon nomresini daxil edin:");
        String phone = input.nextLine();
        teacher.setPhone(phone);

        System.out.println(teacher);
        TeacherDao.addTeacher(teacher);
        //DB.teachersTable.put(UUID.randomUUID().toString(), teacher);
    }

    public static void getAllTeachers() throws SQLException {
        System.out.println("GET ALL TEACHERS");
        System.out.println("*********************************************");
        TeacherDao.getAllTeacher().forEach(System.out::println);
        //TeacherDao.getAllTeacher().forEach(System.out::println);
        //        for (Map.Entry<String, Teacher> entry : DB.teachersTable.entrySet()) {
//            System.out.println("ID" + entry.getKey() + "Object" + entry.getValue());
//        }
        System.out.println("*********************************************");
    }

    public static void getOneTeacher() throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("GET ONE STUDENT");
        getAllTeachers();
        System.out.println("Muellimin ID-sini daxil edin:");
        String id = input.nextLine();
        System.out.println(TeacherDao.getTeacherById((Long.valueOf(id))));
//        Teacher teacher = DB.teachersTable.get(id);
//        System.out.println(teacher);
    }

    public static void updateTeacher() throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.println("UPDATE TEACHER");
        getAllTeachers();
        System.out.println("Deyishiklik etme istediyiniz muellimin ID-sini daxil ein:");
        String id = input.nextLine();
//        Teacher teacher = DB.teachersTable.get(id);
        Teacher teacher = TeacherDao.getTeacherById(Long.valueOf(id));

        System.out.println("Muellimin adini daxil edin:");
        String name = input.nextLine();
        teacher.setName(name);

        System.out.println("Muellimin soyadini daxil edin:");
        String surname = input.nextLine();
        teacher.setSurname(surname);

        System.out.println("Telebenin emailin daxil edin:");
        String email = input.nextLine();
        teacher.setEmail(email);

        System.out.println("Telebenin nomresini daxil edin:");
        String phone = input.nextLine();
        teacher.setPhone(phone);

        TeacherDao.updateTeacherById(teacher);
    }

    public static void deleteTeacher() throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("DELETE TEACHER");
        getAllTeachers();
        System.out.println("Silmek istediyiniz muellimin ID-sini daxil edin:");
        String id = input.nextLine();
        TeacherDao.deleteTeacher(Long.valueOf(id));
      //  DB.teachersTable.remove(id);
    }
}
