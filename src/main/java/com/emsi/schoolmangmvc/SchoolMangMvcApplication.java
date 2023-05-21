package com.emsi.schoolmangmvc;

import com.emsi.schoolmangmvc.entity.Branch;
import com.emsi.schoolmangmvc.entity.Courses;
import com.emsi.schoolmangmvc.entity.Student;
import com.emsi.schoolmangmvc.entity.Teacher;
import com.emsi.schoolmangmvc.repositories.BranchRepository;
import com.emsi.schoolmangmvc.repositories.CoursesRepository;
import com.emsi.schoolmangmvc.repositories.StudentRepository;
import com.emsi.schoolmangmvc.repositories.TeacherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class SchoolMangMvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(SchoolMangMvcApplication.class, args);
    }

   //@Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository){
        return args -> {
           studentRepository.save(new Student(null,"imad",new Date(),'P',12));
            studentRepository.save(new Student(null,"aymane",new Date(),'A',33));
            studentRepository.save(new Student(null,"mohammed",new Date(),'P',12));
            studentRepository.save(new Student(null,"yassine",new Date(),'A',12));
            studentRepository.save(new Student(null,"ahmed",new Date(),'A',31));
            studentRepository.save(new Student(null,"youssef",new Date(),'A',40));
            studentRepository.save(new Student(null,"amine",new Date(),'A',12));

            studentRepository.findAll().forEach(s->{
                System.out.println(s.getName());
            });
        };
    }

    //@Bean
    CommandLineRunner commandLineRunner(TeacherRepository teacherRepository){
        return args -> {
            teacherRepository.save(new Teacher(null,"Ettamen",new Date(),11));
            teacherRepository.save(new Teacher(null,"Sadrafe",new Date(),6));
            teacherRepository.save(new Teacher(null,"Elmasoudi",new Date(),5));
            teacherRepository.save(new Teacher(null,"Bahou",new Date(),10));
            teacherRepository.save(new Teacher(null,"Ezzaki",new Date(),14));

            teacherRepository.findAll().forEach(t->{
                System.out.println(t.getName());
            });

        };
    }

    //@Bean
    CommandLineRunner commandLineRunner(BranchRepository branchRepository){
        return args -> {
            branchRepository.save(new Branch(null,"Software Engineering",true));
            branchRepository.save(new Branch(null,"Finance and audit Engineering",false));
            branchRepository.save(new Branch(null,"Civil Engineering",true));
          branchRepository.findAll().forEach(b->{
              System.out.println(b.getName());
          });
        };
    }
    //@Bean
    CommandLineRunner commandLineRunner(CoursesRepository coursesRepository){
        return args -> {
            coursesRepository.save(new Courses(null,"Software Engineering","Web Programmation","Mobile Programmation","Devops","Big Data"));
            coursesRepository.save(new Courses(null,"Finance and audit Engineering","Strategic Planning","Cost Control","Financial Services","Modelling Financial"));
            coursesRepository.save(new Courses(null,"Civil Engineering","Structural mechanics","Maths","Hydraulics","Engineering geology"));

            coursesRepository.findAll().forEach(c->{
                System.out.println(c.getBranch());
            });

        };
    }

}
