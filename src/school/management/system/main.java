package school.management.system;
import java.lang.String;
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

    }
}
