package school.management.system;
import java.lang.String;

import java.util.Formatter;
import java.io.File;
import java.io.ObjectInput;
import java.io.Serializable;
import java.util.Scanner;
public class Student
{
    public static String FirstName;
    public static String  LastName;
    public static int Class;
    public static int RegNumber;
    public static String address;
    public static double FeesPaid=0;
    public static double FeesTotal =30000;//fees total
    public static double Balance=0;
    public static int units;
    public static String Grade;
    public static double Fees;
    public  Student()
    {
        this("","",0,0,
                "",0.0,0,"",0,0);
    }
    //initialize scopes
    public  Student(String First,String Last,int Class1,int Reg,
                    String Address,double Bal,int Subject,
                    String grade,double paid,double Total)
    {
        setFirstName(First);
        setlastName(Last);
        setlevel(Class1);
        setReg(Reg);
        setAddress(Address);
        setbalance(Bal);
        setSubject(Subject);
        setgrade(grade);
        setFeesPaid(paid);
        setFeesTotal(Total);
    }
    public void setFirstName(String First)
    {
        FirstName=First;
    }
    public static String getFirstName()
    {
        return FirstName;
    }
    public static void setlastName(String Last)
    {
        LastName=Last;
    }
    public static String getlastName()
    {
        return LastName;
    }
    public static void setlevel(int Class1)
    {
        Class1=Class;
    }
    public static int getlevel()
    {
        return Class;
    }
    public static void setReg(int Reg)
    {
        Reg=RegNumber;
    }
    public static int getReg()
    {
        return RegNumber;
    }
    public static void setAddress(String Address)
    {
        Address=address;
    }
    public static String getAddress()
    {
        return address;
    }
    public  void setbalance(double Bal)
    {
        Bal=Balance;
    }
    public static double getbalance()
    {
        return FeesTotal-FeesPaid;
    }
    public void setSubject(int Subject)
    {
        units=Subject;
    }
    public static int getSubject()
    {
        return units;
    }
    public void setgrade(String grade)
    {
        grade=Grade;
    }
    public static String getgrade()
    {
        return Grade;
    }
    public void setFeesPaid(double paid){paid=FeesPaid;}
    public static double getFeesPaid(){return FeesPaid;
    }
    public void setFeesTotal(double Total){Total=FeesTotal;}
    public static double getFeesTotal(){return FeesTotal;}

    public static double getRemainingFees(){
        return FeesTotal-FeesPaid;
    }
    @Override
    public String toString()
    {
        return String.format("%d/%d",RegNumber,FeesPaid);
    }

}

