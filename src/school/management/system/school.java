package school.management.system;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static school.management.system.Student.FeesPaid;
import static school.management.system.Student.FirstName;
import static school.management.system.Student.*;
import static school.management.system.Teacher.*;

public class school
{
    public static ArrayList <Teacher>teachersList=new ArrayList<Teacher>();
    public static ArrayList <Student> studentsList=new ArrayList<Student>();
    private static double TotalMoneyEarned;
    private static double TotalMoneySpent;
    public static List teacher;
    public static List student;
    public static double MoneyEarned;



    public school(ArrayList <Teacher>teachersList,ArrayList<Student>studentsList)
        {
            this.teacher=teachersList;
            this.student=studentsList;
            TotalMoneyEarned=FeesPaid +  MoneyEarned;
            double maintenance = 10000;
            TotalMoneySpent = salary + maintenance;
        }


    public static void add()//to register a new individual
    {
        Teacher teacher=new Teacher();
        Student student=new Student();
        Scanner input = new Scanner(System.in);
        System.out.println("Who do you wish to register ?\n");
        System.out.println("1:Enter 1 to add student");
        System.out.println("2.Enter 2 to add a teacher:");
        System.out.println("Or press any other number to view your List");
        System.out.println("");
        int choice = input.nextInt();
/*********************************************CASES**********************************************/
        switch (choice) {
            case 1:
                    System.out.print("Fill the student details i.e First Name," +
                            "Last Name,class or Department,RegNumber,grade,address and click enter\n");
                    while (input.hasNext())
                    {
                        //to insert the student into the list;

                        FirstName=input.next();
                        LastName=input.next();
                        Class=input.nextInt();
                        RegNumber=input.nextInt();
                        address=input.next();
                        units=input.nextInt();
                        System.out.print("Kindly enter Fees to be Paid\n");
                        FeesPaid=input.nextDouble();
                        System.out.printf("Your Fee balance  is:\n");
                        System.out.println(Student.getRemainingFees());
                        studentsList.add(new Student());
                        studentsList.add(new Student());
                        studentsList.add(new Student());
                        studentsList.add(new Student());
                        studentsList.add(new Student());
                        studentsList.add(new Student());
                        studentsList.add(new Student());
                        //to get student's balance
                        System.exit(0);
                    }

                break;
            case 2:

                    System.out.print("Please enter the New teacher details i.e Id,First Name,Last Name and int units to tutor and click Enter\n");
                    while (input.hasNext())
                    {//to insert new teacher into the system
                        teacher.Id=input.nextInt();
                        teacher.FirstName=input.next();
                        teacher.TlastName=input.next();
                        teacher.Units=input.nextInt();
                        teacher.salary=input.nextDouble();
                        teachersList.add(new Teacher());
                        for (int i=0;i<teachersList.size();i++)
                        {
                            System.out.printf("%s your salary is $10,000\n", getId());
                        }
                        }
            default:
                System.out.println("Loading...");
                System.out.printf("Invalid input try again for Registering!!!!!!\n");

        }
    }

    public static List <Teacher> getTeachers()
    {
        return teachersList;
    }
    public List <Student> getStudents()
    {
        return studentsList;
    }
    public double getTotalMoneyEarned()
    {return  TotalMoneyEarned;}
    public double getTotalMoneySpent()
    {
        return TotalMoneySpent;
    }
    public static void updateTotalMoneyEarned(double MoneyEarned)
    {
        TotalMoneyEarned+=MoneyEarned;
    }
    /**
     *  money spent by school to pay teachers
     *
     */
    public static void UpdateTotalMoneySpent(double moneyspent)
    {
        TotalMoneyEarned=TotalMoneyEarned -moneyspent;
        TotalMoneyEarned-=moneyspent;
    }
    public  static String FindStudent()
    {
        for(Student student : studentsList)
        {
            if (student.getReg()==RegNumber)
            {
                return FirstName;
            }
        }
        return null;
    }
    public static String FindTeacher()
    {
        for (Teacher teacher: teachersList)
        {
            if (teacher.getId()==Id)
            {
                return FirstName + TlastName + salary;
            }
        }
        return null;
    }

}
