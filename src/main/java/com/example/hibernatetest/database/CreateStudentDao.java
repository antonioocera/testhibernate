package com.example.hibernatetest.database;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CreateStudentDao {

    public void saveStudent(Student student) {
        Transaction transaction = null;
        try (Session session = DatabaseConfig.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.save(student);
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


    public List < Student > getStudents() {
        try (Session session = DatabaseConfig.getSessionFactory().openSession()) {
            return session.createQuery("FROM Student", Student.class).getResultList();
        }
    }

    public List < Student > getStudentsQuery() {
        try (Session session2 = DatabaseConfig.getSessionFactory().openSession()) {
            return session2.createQuery("FROM Student s WHERE s.firstName='Antonio' AND s.email LIKE '%gmail.com' OR s.lastName='lol'").getResultList();
        }
    }

}