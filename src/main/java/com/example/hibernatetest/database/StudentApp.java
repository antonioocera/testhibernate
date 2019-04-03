package com.example.hibernatetest.database;

import java.util.List;

public class StudentApp {

    public static void main(String[] args) {
        CreateStudentDao studentDao = new CreateStudentDao();

        // crea un oggetto "student"
        System.out.println("Creazione di un oggetto student in corso...");
        Student tempStudent = new Student("Antonio", "Ocera", "antonio.ocera@gmail.com");
        Student tempStudent2 = new Student("asd", "lol", "asd@lol.com");
        Student tempStudent3 = new Student("abcd","efgh","asd@asd.asd");

        // salva l'oggetto student
        System.out.println("Salvataggio in corso...");
        studentDao.saveStudent(tempStudent);
        studentDao.saveStudent(tempStudent2);
        studentDao.saveStudent(tempStudent3);
        System.out.println("Salvataggio completato!");

        // recupera e stampa lista studenti
        List<Student> students = studentDao.getStudents();
        students.forEach(s -> System.out.println(s.getId() + " - " + s.getFirstName() + " - " + s.getLastName()+ " - " + s.getEmail()));

        // recupera e stampa query studenti
        List<Student> students1 = studentDao.getStudentsQuery();
        students1.forEach(s -> System.out.println(s.getId() + " - " + s.getFirstName() + " - " + s.getLastName()+ " - " + s.getEmail()));

    }
}
