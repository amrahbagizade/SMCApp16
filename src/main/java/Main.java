import service.StudentService;
import service.TeacherService;
import util.ApplicationUtil;


import java.util.Scanner;

public class Main {
    private static final String APP_MENU =
            "1.Student operations\n" +
                    "2.Teacher operations";
    private static final String STUDENT_MENU =
            "1. Add student\n" +
                    "2. Get all students\n" +
                    "3. Get one student\n" +
                    "4. Update student\n" +
                    "5. Delete student";
    private static final String TEACHER_MENU =
            "1.Add teacher\n" +
                    "2.Get all teachers\n" +
                    "3.Get one teacher\n" +
                    "4.Update teacher\n" +
                    "5.Delete teacher";

    public static void main(String[] args) throws Exception {


        Scanner input = new Scanner(System.in);
        boolean loggedIn = Boolean.parseBoolean(args[0]);

        if (!loggedIn) {

            System.out.println("Sisteme daxil olmaq ucun istifadeci adi ve shifreni daxil edin:");

            System.out.print("Istifadeci adi: ");
            String username = input.nextLine();
            System.out.print("Shifre: ");
            String password = input.nextLine();
            loggedIn = ApplicationUtil.login(username, password);

        }
        if (loggedIn) {
            System.out.println(APP_MENU);

            System.out.println("Daxil etmek istediyiniz modulu secin:");
            String clientselectedModule = input.nextLine();
            int selectedModule = ApplicationUtil.validateAndReturnNumberInput(clientselectedModule);

            if (selectedModule == 1) {
                System.out.println(STUDENT_MENU);

                System.out.println("Istifade etmek istediyiniz emeliyyati secin:");
                String clientselectedOperation = input.nextLine();

                int selectedOperation = ApplicationUtil.validateAndReturnNumberInput(clientselectedOperation);

                switch (selectedOperation) {
                    case 1:
                        StudentService.addStudent();
                        break;
                    case 2:
                        StudentService.getAllStudents();
                        break;
                    case 3:
                        StudentService.getOneStudent();
                        break;
                    case 4:
                        StudentService.updateStudent();
                        break;
                    case 5:
                        StudentService.deleteStudent();
                        break;
                    default:
                        ApplicationUtil.printError("Secilmish emeliyyat novune uygun emeliyyat movcud deyil");


                }
            } else if (selectedModule == 2) {
                System.out.println(TEACHER_MENU);

                System.out.println("Istifade etmek istediyiniz emeliyyati secin:");
                String clientSelectedOperation = input.nextLine();

                int selectedOperation = ApplicationUtil.validateAndReturnNumberInput(clientSelectedOperation);

                switch (selectedOperation) {
                    case 1:
                        TeacherService.addTeacher();
                        break;
                    case 2:
                        TeacherService.getAllTeachers();
                        break;
                    case 3:
                        TeacherService.getOneTeacher();
                        break;
                    case 4:
                        TeacherService.updateTeacher();
                        break;
                    case 5:
                        TeacherService.deleteTeacher();
                        break;
                    default:
                        ApplicationUtil.printError("Secilmish emeliyyat novune uygun emeliyyat movcud deyil");
                }


            } else {
                ApplicationUtil.printError("Secilmish modul nomresine uygun modul movcud deyil");
            }


        } else {
            ApplicationUtil.printError("Istifadeci melumatlari duzgun deyil");
        }


        ApplicationUtil.isStopped(args, input);

    }

}



