package com.example.hibernatetest.database;

public class InstructorApp {

    public static void main(String[] args) {
        CreateInstructorDao instructorDao = new CreateInstructorDao();
        CreateCourseDao courseDao = new CreateCourseDao();

        // crea un oggetto "instructor"
        System.out.println("Creazione di un oggetto instructor in corso...");
        Instructor tempInstructor = new Instructor("qwe", "asd", "gdfsafg");
        InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.youtube.com/asdgfgf", "videogames");
        Instructor tempInstructor2 = new Instructor("tyu","oiw","ewrtyu");
        InstructorDetail tempInstructorDetail2 = new InstructorDetail("http://www.youtube.com/hgshgh", "bncx");
        Course tempCourse = new Course("hjsjdsjdksl");
        Course tempCourse2 = new Course("shksajksaddsajlk");

        // associare gli oggetti
        tempInstructor.setInstructorDetail(tempInstructorDetail);
        tempInstructor2.setInstructorDetail(tempInstructorDetail2);
        tempInstructor.add(tempCourse);
        tempInstructor.add(tempCourse2);
        tempInstructor2.add(tempCourse);

        // salva l'oggetto student
        System.out.println("Salvataggio in corso...");
        // questo metodo salverà anche i dati nella tabella Instructor Detail, usando Cascade.ALL
        instructorDao.saveInstructor(tempInstructor);
        instructorDao.saveInstructor(tempInstructor2);
        instructorDao.associateInstructor(tempInstructor, tempInstructorDetail);
        instructorDao.associateInstructor(tempInstructor2, tempInstructorDetail2);
        courseDao.associateCourse(tempCourse);
        courseDao.associateCourse(tempCourse2);
        System.out.println("Salvataggio completato!");
//
//        if (tempInstructor != null){
//            System.out.println("Cancellazione: "+tempInstructor2);
//            instructorDao.deleteInstructor(tempInstructor2);
//        } else System.out.println("Parametro non trovato");

        System.out.println("tempInstructorDetail: " + tempInstructorDetail);
        System.out.println("tempInstructorDetail: " + tempInstructorDetail2);
        System.out.println("the Associated Instructor: " + tempInstructorDetail.getInstructor());
        System.out.println("the Associated Instructor: " + tempInstructorDetail2.getInstructor());

//        // recupera e stampa lista studenti
//        List<Student> students = studentDao.getStudents();
//        students.forEach(s -> System.out.println(s.getId() + " - " + s.getFirstName() + " - " + s.getLastName()+ " - " + s.getEmail()));
//
//        // recupera e stampa query studenti
//        List<Student> students1 = studentDao.getStudentsQuery();
//        students1.forEach(s -> System.out.println(s.getId() + " - " + s.getFirstName() + " - " + s.getLastName()+ " - " + s.getEmail()));

    }
}
