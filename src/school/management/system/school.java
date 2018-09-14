package school.management.system;
import dbConnection.dbConnection;

import java.sql.PreparedStatement;
import java.sql.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.sql.ResultSet.CONCUR_UPDATABLE;
import static school.management.system.Student.FeesPaid;
import static school.management.system.Student.FirstName;
import static school.management.system.Student.*;
import static school.management.system.Teacher.*;
public class school
{
    public static DecimalFormat df= new DecimalFormat("#.##");
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


    public void add()//to register a new individual
    {
        try {
            Teacher teacher = new Teacher();
            Student student = new Student();
            Scanner input = new Scanner(System.in);
            System.out.println("Select your Option:\n");
            System.out.println("1:Enter 1 to add student");
            System.out.println("2.Enter 2 to add a teacher:");
            System.out.println("3.Enter 3 to view your  Student List\n");
            System.out.println("4.Enter 4 to view your  Teacher List\n");
            System.out.println("5.Enter 5 to Search for a record.\n");
            System.out.println("6.Enter 6 to Delete a record.\n");
            int choice = input.nextInt();
/*********************************************CASES**********************************************/
            switch (choice) {
                case 1:
                    addStudent();

                    break;
                case 2:
                    addTeacher();
                    break;
                case 3:
                    StudentList();
                    break;
                case 4:
                    TeacherList();
                    break;
                case 5:
                    Search();
                    break;
                case 6:
                    Delete();
                    break;
                default:
                    System.out.println("Loading...");
                    System.out.println("Invalid input try again !!!!!!\n");
                    System.exit(0);

            }
        } catch (Exception ex) {
            ex.printStackTrace();
            Logger lgr=Logger.getLogger(school.class.getName());
            lgr.log(Level.WARNING,ex.getMessage(),ex);
        }
    }
    public  void   addStudent()
    {
        Scanner input=new Scanner(System.in);
        ResultSet rs=null;
        try {
            Connection conn = dbConnection.getConnection();
            String InsertStudent = "INSERT INTO StudentList VALUES (?,?,?,?,?,?,?)";
            assert (conn != null);
            PreparedStatement stmt = conn.prepareStatement(InsertStudent, CONCUR_UPDATABLE);
            System.out.println("Fill the student details:\n");
                //to insert the student into the list;
                System.out.println("First Name\n");
                stmt.setString(1, input.next());
                System.out.println("Last Name\n");
                stmt.setString(2, input.next());
                System.out.println("Class or Department\n");
                stmt.setInt(4, input.nextInt());
                System.out.println("RegNumber\n");
                stmt.setInt(3, input.nextInt());
                System.out.println("Units\n");
                stmt.setString(6, input.next());
                System.out.println("Address\n");
                stmt.setString(7, input.next());
                System.out.print("Kindly enter Fees to be Paid\n");
            FeesPaid=input.nextDouble();
            Balance=FeesTotal - FeesPaid;
            df.format(Balance);
                stmt.setDouble(5, Balance);
                System.out.print("Your Fee balance  is:\n");
                System.out.println(Balance);
                //to get student's balance
                stmt.executeUpdate();
                stmt.close();
                conn.close();

        } catch (Exception e) {
            System.err.println("Input mismatch Error");
            System.exit(1);
        }

    }
    public static  void addTeacher()
    {

        Scanner input=new Scanner(System.in);
        ResultSet rs=null;
        try {
            Connection conn = dbConnection.getConnection();
            String TeacherInsert = "INSERT INTO Admin VALUES(?,?,?,?,?)";
            assert (conn != null);
            PreparedStatement stmt = conn.prepareStatement(TeacherInsert);
                System.out.print("Please enter the New teacher details:\n");
                System.out.print("Id:\n");
                stmt.setInt(1, input.nextInt());
                System.out.print("First Name:\n");
                stmt.setString(2, input.next());
                System.out.print("Last Name:\n");
                stmt.setString(3, input.next());
                System.out.print("Units:\n");
                stmt.setInt(4, input.nextInt());
                System.out.print("Salary:\n");
                salary=input.nextDouble();
                df.format(salary);
            stmt.setDouble(5, salary);
                stmt.executeUpdate();
                stmt.close();
                conn.close();

        } catch (Exception e) {
            System.err.println("Error in input");
        }

    }
    public static void  StudentList() throws Exception {
        ResultSet rs=null;
        try {
            Connection conn = dbConnection.getConnection();
            String loadStudentList = "SELECT * FROM StudentList";
            assert (conn != null);
            rs = conn.createStatement().executeQuery(loadStudentList);
                System.out.println("The studentslist:");
                System.out.printf("%s ", "FirstName\t");
                System.out.printf("%s ", "LastName\t\t");
                System.out.printf("%s ", "RegNumber\t\t");
                System.out.printf("%s ", "class\t\t");
                System.out.printf("%s ", "Fee Balance\t\t");
                System.out.printf("%s ", "Units\t");
                System.out.printf("%s %s", "Address", "\n");
            while(rs.next()) {
                System.out.printf("%s %s", rs.getString("Fname"), "\t\t");
                System.out.printf("%s %s", rs.getString("Lname"), "\t\t\t");
                System.out.printf("%d %s", rs.getInt("RegNumber"), "\t\t\t");
                System.out.printf("%s %s", rs.getString("Class"), "\t\t");
                System.out.printf("%f %s", rs.getDouble("FeePaid"), "\t\t\t");
                System.out.printf("%d %s", rs.getInt("Units"), "\t\t");
                System.out.printf("%s %s", rs.getString("address"), "\t");
                System.out.println("\n");
                }
                System.out.printf("%s %s", "+----+\t++------++\t-----\t-----\t-----\t-----\t-----\t-------\t-----\t" +
                        "-----\t---------+++\t", "\n");
                rs.close();
                conn.close();
        }catch(SQLException e)
        {
            e.getMessage();
        }
    }
    public void TeacherList() throws Exception
    {
        Connection conn=dbConnection.getConnection();
        PreparedStatement stmt=null;
        ResultSet rs=null;
        try {
            String loadTeacherList = "SELECT * FROM Admin";
            assert (conn != null);
            stmt = conn.prepareStatement(loadTeacherList);
            rs = conn.createStatement().executeQuery(loadTeacherList);
                System.out.println("The TeachersList:\n");
                System.out.printf("%s ", "ID number\t");
                System.out.printf("%s ", "First Name:\t");
                System.out.printf("%s ", "Last Name\t\t");
                System.out.printf("%s ", "Number of your units\t\t");
                System.out.printf("%s ", "Your salary :\t\n");
            while(rs.next()) {
                System.out.printf("%d %s", rs.getInt(1), "\t\t\t");
                System.out.printf("%s %s", rs.getString(2), "\t\t\t");
                System.out.printf("%s %s", rs.getString(3), "\t\t\t");
                System.out.printf("%d %s", rs.getInt(4), "\t\t\t\t\t");
                System.out.printf("%f %s", rs.getDouble(5), "\t\t\n");
                stmt.executeQuery();
            }
            System.out.print("------\t---" + "+------\t\t\t--------\t\t\t-------------\t\t\t---------\n");
                stmt.close();
                rs.close();
                conn.close();
        }catch(Exception e)
        {
            e.getMessage();
        }
    }
    public void Search() throws Exception
    {
        Scanner input=new Scanner(System.in);
        System.out.println("Select the record to search for?");
        System.out.println("1.For student enter 1");
        System.out.println("2.For Teacher enter 2");
        int Ser=input.nextInt();
        switch(Ser) {
            case 1:
                try {
                    Connection conn = dbConnection.getConnection();
                    PreparedStatement stmt = null;
                    String Search = "SELECT * FROM StudentList WHERE RegNumber=?";
                    assert (conn != null);
                    stmt = conn.prepareStatement(Search);
                    System.out.print("Enter the  RegNumber to search for:\n");
                    stmt.setInt(1, input.nextInt());
                    ResultSet rs = stmt.executeQuery();
                    if (rs.next()) {
                        System.out.println("The searched student details:");
                        System.out.printf("%s %s", "First Name:\t\t", rs.getString(1));
                        System.out.printf("%s %s", "\nLast Name:\t\t", rs.getString(2));
                        System.out.printf("%s %d", "\nRegNumber:\t\t", rs.getInt(3));
                        System.out.printf("%s %s", "\nClass:\t\t\t", rs.getString(4));
                        System.out.printf("%s %f", "\nFee Balance:\t", rs.getDouble(5));
                        System.out.printf("%s %d", "\nUnits:\t\t\t", rs.getInt(6));
                        System.out.printf("%s %s %s", "\nAddress:\t\t", rs.getString(7), "\n\n");
                        stmt.executeQuery();
                        stmt.close();
                        conn.close();
                        rs.close();
                    } else {
                        System.out.println("Student doesn't exist in the database");
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.exit(1);
            case 2:
                try
                {
                    Connection conn = dbConnection.getConnection();
                    PreparedStatement stmt = null;
                    String Search = "SELECT * FROM Admin WHERE Id=?";
                    assert (conn != null);
                    stmt = conn.prepareStatement(Search);
                    System.out.print("Enter the  Id to search for:\n");
                    stmt.setInt(1, input.nextInt());
                    ResultSet rs = stmt.executeQuery();
                    if (rs.next()) {
                        System.out.println("The searched Teacher details:");
                        System.out.printf("%s %d", "Id:\t\t\t", rs.getInt(1));
                        System.out.printf("%s %s", "\nFirst Name:\t\t", rs.getString(2));
                        System.out.printf("%s %s", "\nLast Name:\t\t", rs.getString(3));
                        System.out.printf("%s %d", "\nUnits:\t\t\t", rs.getInt(4));
                        System.out.printf("%s %f %s", "\nSalary:\t", rs.getDouble(5),"\n\n");
                        stmt.executeQuery();
                        stmt.close();
                        conn.close();
                        rs.close();
                    } else {
                        System.out.println("Student doesn't exist in the database");
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
                }
        }
    public void Delete()
    {
        Scanner in=new Scanner(System.in);
        System.out.println("Who do you wish to delete?:" );
        System.out.println("1:Student");
        System.out.println("2:Teacher");
        int choice=in.nextInt();
        switch(choice)
        {
            case 1:
                try{
                    Connection conn=dbConnection.getConnection();
                    String Delsql="DELETE  FROM StudentList WHERE RegNumber=?";
                    assert (conn !=null);
                    PreparedStatement stmt=conn.prepareStatement(Delsql);
                    System.out.println("Enter the RegNumber of the Student to delete:");
                    stmt.setInt(1,in.nextInt());
                    stmt.executeUpdate();
                    System.out.println("Student deleted\n");
                    stmt.close();
                    conn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.exit(1);
            case 2:
                try
                {
                    Connection conn=dbConnection.getConnection();
                    String TeachDeL="DELETE FROM Admin WHERE Id=? ";
                    assert conn != null;
                    PreparedStatement stmt=conn.prepareStatement(TeachDeL);
                    stmt.setInt(1,in.nextInt());
                    System.out.println("Enter the id of the teacher to delete:");
                    System.out.println("The teacher record is deleted Successfully!!!");
                    stmt.close();
                    conn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
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
        TotalMoneyEarned=TotalMoneyEarned - moneyspent;
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
