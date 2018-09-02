package school.management.system;
import java.lang.String;
import java.util.*;

import static school.management.system.school.studentsList;
import static school.management.system.school.teachersList;

public class main
{
    Teacher teacher=new Teacher();
    Student student=new Student();
    public static void main(String args[])
    {

        school application;
        application = new school(teachersList,studentsList);
        application.add();
        Scanner input=new Scanner(System.in);
        System.out.println("Which list would you like to view?");
        System.out.println("1.Student List.");
        System.out.println("2.Teacher list.");
        System.out.println("3.Search a student or a teacher in the list(Type Id for Teacher and Reg for student)");
        int choice=input.nextInt();
        switch (choice)
        {
            case 1:
                System.out.println("The studentslist:");
                System.out.printf("%s %s", "First Name\t", Student.getFirstName());
                System.out.printf("%s %s", "Last Name\t", Student.getlastName());
                System.out.printf("%s %d", "class\t", Student.getlevel());
                System.out.printf("%s %d", "Reg Number\t", Student.getReg());
                System.out.printf("%s %s", "Address\t", Student.getAddress());
                System.out.printf("%s %d", "Subjects\t", Student.getSubject());
                System.out.printf("%s %f", "Balance\t", Student.getbalance());
                System.out.printf("%s %f", "Amount paid\t", Student.getFeesPaid());
                System.out.println(school.studentsList);
                System.out.println("\n");
                System.out.println("----\t------\t-----\t-----\t-----\t-----\t-----\t-------\t-----\t----\t");
                break;
            case 2:
                System.out.println("The TeachersList:\n");
                System.out.printf("%s %d", "ID number\t", Teacher.getId());
                System.out.printf("%s %s", "First Name:\t", Teacher.getfirstName());
                System.out.printf("%s %s", "Last Name\t\t", Teacher.getlastName(),"\t");
                System.out.printf("%s %f", "Your salary is:\t", Teacher.getSalary());
                System.out.printf("%s %d", "Number of your units\t\t", Teacher.getunits());
                System.out.println(school.teachersList);
            case 3:
                System.out.print("Enter the id or RegNumber to search for:\n");
                input.nextInt();
                System.out.print(school.FindStudent());
                System.out.println(school.FindTeacher());
                default:
                    System.out.println("Your list is empty!!!!!");
        }
    }
}
