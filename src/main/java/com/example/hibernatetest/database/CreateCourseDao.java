package com.example.hibernatetest.database;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class CreateCourseDao {
    public void associateCourse(Course course) {
        int id=1;
        Transaction transaction = null;
        try (Session session = DatabaseConfig.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            session.get(Instructor.class, id);
            session.get(InstructorDetail.class, id);
            session.get(Course.class, id);
            // save the student object
            session.save(course);
            // commit transaction
            transaction.commit();
            //session.close();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
