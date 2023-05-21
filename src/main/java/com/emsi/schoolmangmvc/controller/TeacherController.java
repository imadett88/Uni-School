package com.emsi.schoolmangmvc.controller;

import javax.validation.Valid;
import lombok.AllArgsConstructor;
import com.emsi.schoolmangmvc.entity.Teacher;
import com.emsi.schoolmangmvc.repositories.TeacherRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@AllArgsConstructor


public class TeacherController {
    private TeacherRepository teacherRepository;
    @GetMapping(path = "/user/indexT")
    public String Teacher(Model model,  @RequestParam(name = "page",defaultValue = "0") int page,
                          @RequestParam(name = "size",defaultValue = "5") int size,
                          @RequestParam(name = "keyword",defaultValue = "") String keyword){
        Page<Teacher> pageteachers = teacherRepository.findByNameContains(keyword,PageRequest.of(page,size));
        model.addAttribute("Listteachers",pageteachers.getContent());
        model.addAttribute("pages",new int[pageteachers.getTotalPages()]);
        model.addAttribute("currentPage",page);
        model.addAttribute("keyword",keyword);
        return "teacher";
    }
    @GetMapping(path = "/admin/Delete")
    public String delete(Long id, String keyword,int page){
        teacherRepository.deleteById(id);
        return "redirect:/user/indexT?page="+page+"&keyword="+keyword;
    }
    @GetMapping(path = "/user/teachers")
    @ResponseBody
    public List<Teacher>teacherList(){
        return teacherRepository.findAll();
    }

    @GetMapping("/admin/formTeacher")
    public String formTeacher(Model model){
        model.addAttribute("teacher",new Teacher());
        return "formTeacher";
    }
    @PostMapping(path = "/admin/add")
    public  String add (Model model , @Valid Teacher teacher, BindingResult bindingResult, @RequestParam(defaultValue = "0") int page,
                        @RequestParam(defaultValue = "") String keyword){
        if (bindingResult.hasErrors()) return "formteacher";
        teacherRepository.save(teacher);
        return "redirect:/user/indexT?page="+page+"&keyword="+keyword;
    }
    @GetMapping("/admin/editTeacher")
    public String editTeacher(Model model, Long id, String keyword,int page){
        Teacher teacher=teacherRepository.findById(id).orElse(null);
        if (teacher==null) throw new RuntimeException("Teacher not found");
        model.addAttribute("teacher",teacher);
        model.addAttribute("page",page);
        model.addAttribute("keyword",keyword);
        return "editTeacher";
    }




}