package com.example.hibernatetest.database;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class CreateInstructorDao {

    public void saveInstructor(Instructor instructor) {
        Transaction transaction = null;
        try (Session session = DatabaseConfig.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.save(instructor);
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
    public void deleteInstructor(Instructor instructor) {
        int id=2;
        Transaction transaction = null;
        try (Session session = DatabaseConfig.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            session.load(InstructorDetail.class, id);
            // delete the student object
            session.delete(instructor);
            // commit transaction
            transaction.commit();
            session.close();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    public void associateInstructor(Instructor instructor, InstructorDetail instructorDetail) {
        int id=1;
        Transaction transaction = null;
        try (Session session = DatabaseConfig.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            session.get(Instructor.class, id);
            session.get(InstructorDetail.class, id);
            // commit transaction
            transaction.commit();
            session.close();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}