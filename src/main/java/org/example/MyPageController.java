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
import org.example.domain.user.Role;
import org.example.domain.user.User;
import org.example.domain.user.UserRepository;
import org.example.domain.user.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    private final UserService userService;


    @GetMapping("/mypage/index")
    public String mypageIndex(Model model){
        SessionUser user = (SessionUser) httpSession.getAttribute("user");

        if(user!=null) {
            model.addAttribute("userNameStr", user.getName());

            if (user.getRole().equals("GUEST")) {
                model.addAttribute("userRoleStr", " 손님");
            } else if (user.getRole().equals("USER")) {
                model.addAttribute("userRoleStr", "사용자");
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
    public String indexDefault(Model model, RoleRadioForm role){
        System.out.println("Role::::: " + role.getRoleRadioItemType());  // cmd 창에 출력, Role::::: COMPANY

        //저장되어 있는 세션의 user 정보를 가져옴
        SessionUser user = (SessionUser) httpSession.getAttribute("user");

        if(user!=null) {
            //세션의 email로 유저정보를 불러오고, 그 유저의 role을 변경
            String userEmail = user.getEmail();
            User userBase = userService.findByEmail(userEmail);

            if (role.getRoleRadioItemType().equals("GUEST")) {
                userBase.setRole(Role.GUEST);
                userService.save(userBase);
            } else if (role.getRoleRadioItemType().equals("USER")) {
                userBase.setRole(Role.USER);
                userService.save(userBase);
            } else if (role.getRoleRadioItemType().equals("COMPANY")) {
                userBase.setRole(Role.COMPANY);
                userService.save(userBase);
            } else if (role.getRoleRadioItemType().equals("ADMIN")) {
                userBase.setRole(Role.ADMIN);
                userService.save(userBase);
            }

            //저장되어 있는 세션의 user의 role을 변경
            user.setRole(role.getRoleRadioItemType());

            //세션에 롤을 변경해서 다시 저장.
            httpSession.setAttribute("user", new SessionUser(userBase));
            user = (SessionUser) httpSession.getAttribute("user");

            model.addAttribute("userNameStr", user.getName());

            if (user.getRole().equals("GUEST")) {
                model.addAttribute("userRoleStr", " 손님");
            } else if (user.getRole().equals("USER")) {
                model.addAttribute("userRoleStr", "사용자");
            } else if (user.getRole().equals("ADMIN")) {
                model.addAttribute("userRoleStr", "관리자");
            } else if (user.getRole().equals("COMPANY")) {
                model.addAttribute("userRoleStr", "기업회원");
            }
        }else{
            //세션이 null인 경우, 기본 index페이지로 이동
            return "index_log_leaf";
        }

        model.addAttribute("roleRadioForm", new RoleRadioForm());


        return "mypage/index";
    }
}
