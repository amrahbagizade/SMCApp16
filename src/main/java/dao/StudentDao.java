package dao;
import DB.DBConfig;
import entity.Student;
import util.ApplicationUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class StudentDao {

    //bu method bizim yazdigimiz melumatlari Database-e yazir.

    public static void addStudent(Student student) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DBConfig.getConnection1(); //database ile yaratdigimiz connection-a qosuluruq
            String sql = "INSERT INTO SMAppOne.student(name,surname,email,phone) VALUES(?,?,?,?)";
            if (Objects.nonNull(connection)) //Connection eger null deyilse ishlesin
            {
                statement = connection.prepareStatement(sql); //sql-i connection ucun hazirla ve menimset statement-a
                statement.setString(1, student.getName());
                statement.setString(2, student.getSurname());
                statement.setString(3, student.getEmail());
                statement.setString(4, student.getPhone());
                statement.execute(); //icini doldurduqdan sonra statement-i play et
            }
        } catch (Exception ex) {
            ApplicationUtil.printError("Telebe elave edilmedi");
        } finally {
            connection.close();
            statement.close(); // xeta bash verse de bash vermese de finally bloku hemishe ishe dushur
        }
    }

    public static List<Student> getAllStudent() throws SQLException {
        List<Student> students = new ArrayList<Student>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;  //Bu bizim javadaki cedvelimizdir.
        String sql = "SELECT s.id,s.name, s.surname, s.email, s.phone FROM smappone.student s";
        try {
            connection = DBConfig.getConnection1();
            if (Objects.nonNull(connection)) {
                statement = connection.prepareStatement(sql); //string-i sql scriptine cevirir
                resultSet = statement.executeQuery(); //buda eynile statement-i play edir.
                //hemin melumatlar resulSet obyektine yigildi. indide onun icinden ashaghidaki shekilde oxuyacaghiq:
                while (resultSet.next()) {
                    Student student = new Student();
                    student.setId(resultSet.getLong("ID"));
                    student.setName(resultSet.getString("NAME"));
                    student.setSurname(resultSet.getString("SURNAME"));
                    student.setEmail(resultSet.getString("EMAIL"));
                    student.setPhone(resultSet.getString("PHONE"));
                    students.add(student);
                }
            }

        } catch (Exception ex) {
            ApplicationUtil.printError("Bazaya qoshulmada xeta yarandi");
        } finally {
            connection.close();
            statement.close();
            resultSet.close();
        }

        return students;
    }

    public static Student getStudentById(Long id) throws SQLException {
        Student student = new Student();
        List<Student> students = new ArrayList<Student>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;  //Bu bizim javadaki cedvelimizdir.
        String sql = "SELECT s.id,s.name, s.surname, s.email, s.phone FROM SMAppOne.student s WHERE s.id=?";
        try {
            connection = DBConfig.getConnection1();
            if (Objects.nonNull(connection)) {
                statement = connection.prepareStatement(sql); //string-i sql scriptine cevirir
                statement.setLong(1, id); //filan id-li melumat gelmelidi
                resultSet = statement.executeQuery(); //buda eynile statement-i play edir.
                //hemin melumatlar resulSet obyektine yigildi. indide onun icinden ashaghidaki shekilde oxuyacaghiq:

                while (resultSet.next()) { //Cedveli oxuyuruq

                    student.setId(resultSet.getLong("ID"));
                    student.setName(resultSet.getString("NAME"));
                    student.setSurname(resultSet.getString("SURNAME"));
                    student.setEmail(resultSet.getString("EMAIL"));
                    student.setPhone(resultSet.getString("PHONE"));
                    students.add(student); // cedveli yigiriq obyektin icine
                }

            }

        } catch (Exception ex) {
            ApplicationUtil.printError("Bazaya qoshulmada xeta yarandi");
        } finally {
            connection.close();
            statement.close();
            resultSet.close();
        }

        return student;
    }

    public static boolean updateStudentById(Student student) throws Exception {

        boolean isUpdated = false;
        Connection connection = null;
        PreparedStatement statement = null;
        String sql = "UPDATE SMAppOne.student s Set s.name=?, s.surname=?, s.email=?, s.phone=? Where s.id=?";

try{
    connection = DBConfig.getConnection1(); //database ile yaratdigimiz connection-a qosuluruq
    if (Objects.nonNull(connection)) //Connection eger null deyilse ishlesin
    {
        statement = connection.prepareStatement(sql); //sql-i connection ucun hazirla ve menimset statement-a
        statement.setString(1, student.getName());
        statement.setString(2, student.getSurname());
        statement.setString(3, student.getEmail());
        statement.setString(4, student.getPhone());
        statement.setLong(5,student.getId());
        statement.execute(); //icini doldurduqdan sonra statement-i play et
        isUpdated = true;
    }

}catch(Exception ex){
    ApplicationUtil.printError("Bazada melumat tapilmadi ");
}finally{
    connection.close();
    statement.close();

}  return isUpdated;
    }
}
