package org.example;

import lombok.RequiredArgsConstructor;
import org.example.domain.member.MemberDto;
import org.example.domain.member.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequiredArgsConstructor
@Controller
public class BaseController {
    @Autowired
    private MemberService memberService;

    @GetMapping("/")
    public String indexDefault(){
        return "index_leaf";
    }

    @GetMapping("/signup")
    public String signupForm(Model model){
        model.addAttribute("member", new MemberDto());
        return "signupForm";
    }

    @GetMapping("/test/board")
    public String testBoard(){
        return "test/board";
    }

    @PostMapping("/signup")
    public String signup( MemberDto memberDto){
        memberService.signup(memberDto);
        return "redirect:/";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }
}
