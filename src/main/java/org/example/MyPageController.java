package org.example;


import lombok.RequiredArgsConstructor;
import org.example.config.auth.dto.SessionUser;
import org.example.domain.coperation.CoperationRepository;
import org.example.domain.coperation.CoperationService;
import org.example.domain.form.mypage.RoleRadioForm;

import org.example.domain.form.mypage.RoleRadioItemType;
import org.example.domain.member.MemberService;
import org.example.domain.serv.workplan.WorkPlanRepository;
import org.example.domain.serv.workplan.WorkPlanService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class MyPageController {

    private final MemberService memberService;
    private final WorkPlanService workPlanService;
    private final WorkPlanRepository workPlanRepository;
    private final CoperationService coperationService;
    private final CoperationRepository coperationRepository;

    private final HttpSession httpSession;



    @GetMapping("/mypage/index")
    public String mypageIndex(Model model){
        SessionUser user = (SessionUser) httpSession.getAttribute("user");

        if(user!=null) {
            model.addAttribute("userNameStr", user.getName());

            if (user.getRole().equals("GUEST")) {
                model.addAttribute("userRoleStr", " 손님");
            } else if (user.getRole().equals("USER")) {
                model.addAttribute("userRoleStr", "일반회원");
            } else if (user.getRole().equals("ADMIN")) {
                model.addAttribute("userRoleStr", "관리자");
            } else if (user.getRole().equals("COMPANY")) {
                model.addAttribute("userRoleStr", "기업회원");
            }
        }
        model.addAttribute("roleRadioForm", new RoleRadioForm());

        return "mypage/index";
    }

    @ModelAttribute("roleRadioItemTypes")
    public RoleRadioItemType[] roleItemTypes() {
        return RoleRadioItemType.values();
    }

    @PostMapping("/mypage/changeRole")
    public String indexDefault(Model model, @RequestParam(value = "role", required = false) String role){
        System.out.println("Role::::: " + role);
        SessionUser user = (SessionUser) httpSession.getAttribute("user");

        if(user!=null){
            model.addAttribute("userName", user.getName());
            model.addAttribute("userRole", user.getRole());
        }


        return "mypage/index";
    }
}
