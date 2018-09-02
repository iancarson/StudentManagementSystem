package school.management.system;
import java.util.Scanner;
import java.lang.String;
import java.io.File;
import java.util.Formatter;
import java.io.ObjectInput;
import java.io.Serializable;

public class Teacher
{
    public static int Id;
    public static String FirstName;
    public static String TlastName;
    public static double salary;
    public static int  Units;
    public Teacher()
    {
        this(0,"","",0.0,0);
    }
    public  Teacher(int id,String firstName,String lastName,double Salary,
                   int units)
    {
        setId(id);
        setfirstName(firstName);
        setlastName(lastName);
        setSalary(Salary);
        setunits(units);
    }
    public void setId(int id)
    {
        id=Id;
    }
    public static int getId()
    {
        return Id;
    }
    public void setfirstName(String firstName)
    {
        FirstName=firstName;
    }
    public static String getfirstName()
    {
        return FirstName;
    }
    public void setlastName(String lastName)
    {
        lastName=TlastName;
    }
    public static String getlastName()
    {
        return TlastName;
    }
    public void setSalary(double Salary)
    {
        salary=Salary;
    }
    public static double getSalary()
    {
        return salary;
    }
    public void setunits(int units)
    {
        units=Units;
    }
    public static int getunits()
    {
        return Units;
    }
}