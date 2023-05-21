package com.emsi.schoolmangmvc.controller;

import com.emsi.schoolmangmvc.entity.Branch;
import com.emsi.schoolmangmvc.repositories.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BranchController {

    @Autowired
    private BranchRepository branchRepository;

    @GetMapping("/user/branch")
    public String branch(Model model){
        List<Branch> branchList = branchRepository.findAll();
        model.addAttribute("listBranch",branchList);
        return "branch";
    }


}
