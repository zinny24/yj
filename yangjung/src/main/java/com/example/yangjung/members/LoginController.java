package com.example.yangjung.members;


import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private MembersService membersService;

    @GetMapping("/login")
    public String viewLogin() {
        return "members/login";
    }

    @PostMapping("/login")
    public String doLogin(
            @RequestParam String userid,
            @RequestParam String passwd,
            Model model, HttpSession session) {

        boolean result = membersService.isLogin(userid, passwd, session);

        if( result ) {
            Member m = (Member) session.getAttribute("myMember");
            model.addAttribute("myMember", m);
            return "main";


        }else{
            model.addAttribute("msg", "아이디/비밀번호를 확인하세요.");
            return "members/login";
        }

    }

    @GetMapping("/logout")
    public String doLogout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

}
