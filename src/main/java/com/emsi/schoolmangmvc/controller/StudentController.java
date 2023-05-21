package com.emsi.schoolmangmvc.controller;

import javax.validation.Valid;
import com.emsi.schoolmangmvc.entity.Student;
import com.emsi.schoolmangmvc.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping(path = "/user/index")
    public String Students(Model model,
                           @RequestParam(name = "page",defaultValue = "0") int page,
                           @RequestParam(name = "size",defaultValue = "5") int size,
                           @RequestParam(name = "keyword",defaultValue = "") String keyword){
        // pour la pagination
        Page<Student> pageStudents = studentRepository.findByNameContains(keyword,PageRequest.of(page,size));
        model.addAttribute("listStudents",pageStudents  .getContent());
        //getContent => donner la liste students de la page
        model.addAttribute("pages",new int[pageStudents.getTotalPages()]);
        model.addAttribute("currentPage",page);
        model.addAttribute("keyword",keyword);
        return "students";
    }

    @GetMapping("/admin/delete")
    public String delete(Long id, String keyword, int page){
        studentRepository.deleteById(id);
        return "redirect:/user/index?page="+page+"&keyword="+keyword;
        //redirection sous la page
    }


    // possible de supp
    /**
     *   @GetMapping("/home")
     *     public String home(){
     *         return "home";
     *     }
     */

    @GetMapping("/home")
    public String homePage(){
        return "home";
    }

    @GetMapping("/")
    public String home(){
        return "redirect:/home";
    }

    @GetMapping("/user/students")
    @ResponseBody //methode return un format json
    public List<Student> studentList(){
        return studentRepository.findAll();
    }

    @GetMapping("/admin/formStudents")
    public String formStudent(Model model){
        model.addAttribute("student",new Student());
        return "formStudents";
    }

    @PostMapping(path = "/admin/save")
    public String save(Model model, @Valid Student student, BindingResult bindingResult,
                       @RequestParam(defaultValue = "0") int page,
                       @RequestParam(defaultValue = "") String keyword){
        if(bindingResult.hasErrors()) return "formStudents";
        studentRepository.save(student);
        return "redirect:/user/index?page="+page+"&keyword="+keyword;
    }

    @GetMapping("/admin/editStudent")
    public String editStudent(Model model, Long id, String keyword, int page){
        Student student = studentRepository.findById(id).orElse(null);
        if (student==null) throw new RuntimeException("Student Not here");
        model.addAttribute("student",student);
        model.addAttribute("page",page);
        model.addAttribute("keyword",keyword);
        return "editStudent";
    }

    @GetMapping("/about")
    public String about(){
        return "about";
    }

    @GetMapping("/contact")
    public String contact(){
        return "contact";
    }



}
