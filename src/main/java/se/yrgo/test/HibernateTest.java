package se.yrgo.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import se.yrgo.domain.Student;
import se.yrgo.domain.Tutor;

public class HibernateTest {

    private static SessionFactory sessionFactory = null;

    private static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Configuration configuration = new Configuration();
            configuration.configure();

            sessionFactory = configuration.buildSessionFactory();
        }

        return sessionFactory;
    }

    public static void main(String[] args) {

        SessionFactory sf = getSessionFactory();
        Session session = sf.openSession();

        Transaction tx = session.beginTransaction();

        Tutor newTutor = new Tutor("ABC234", "Natalie Woodward", 387787);
        Student student1 = new Student("Patrik Howard");
        Student student2 = new Student("Marie Sani");
        Student student3 = new Student("Tom Nikson");

        newTutor.addStudentToTeachingGroup(student1);
        newTutor.addStudentToTeachingGroup(student2);
        newTutor.addStudentToTeachingGroup(student3);

        List<Student> students = newTutor.getTeachingGroup();

        for (Student student : students) {
            session.save(student);
            System.out.println("saving " + student);
        }

        session.save(newTutor);
        System.out.println("saving " + newTutor);
        tx.commit();

        Tutor tutorFromDatabase = session.get(Tutor.class, 4); //checking the database in the terminal shows me that the ID of the tutor is 4

        List<Student> tutorsTeachingGroup = tutorFromDatabase.getTeachingGroup();

        System.out.println(tutorFromDatabase.getName() + "'s teaching group is: ");
        for (Student student : tutorsTeachingGroup) {
            System.out.println("---------------------");
            System.out.println(student);
        }
        System.out.println("---------------------");

        session.close();
    }

    
}
