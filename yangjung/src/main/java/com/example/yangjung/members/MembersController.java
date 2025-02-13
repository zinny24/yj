package com.example.yangjung.members;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/members")
public class MembersController {

    @Autowired
    MembersRepository membersRepository;

    //register
    @GetMapping
    public String getRegister() {
        return "members/register";
    }


    @PostMapping("/save")
    public String doSave(@ModelAttribute Member member) {
        membersRepository.save(member);
        return "redirect:/login";
    }


    @GetMapping("/list")
    public String viewMembers(Model model) {
        List<Member> mList = membersRepository.findAll();

        model.addAttribute("mList", mList);
        return "members/list";
    }

}
