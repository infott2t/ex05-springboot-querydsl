package org.example;


import lombok.RequiredArgsConstructor;
import org.example.config.auth.dto.SessionUser;
import org.example.domain.address.AddressStr;
import org.example.domain.address.AddressStrService;
import org.example.domain.coperation.Coperation;
import org.example.domain.coperation.CoperationRepository;
import org.example.domain.coperation.CoperationService;
import org.example.domain.form.mypage.RoleRadioForm;

import org.example.domain.form.mypage.RoleRadioItemType;
import org.example.domain.member.MemberService;
import org.example.domain.phone.PhoneStr;
import org.example.domain.phone.PhoneStrService;
import org.example.domain.roleclass.admin.RoleADMIN;
import org.example.domain.roleclass.admin.RoleADMINService;
import org.example.domain.roleclass.company.RoleCOMPANY;
import org.example.domain.roleclass.company.RoleCOMPANYService;
import org.example.domain.roleclass.guest.RoleGUEST;
import org.example.domain.roleclass.user.RoleUSER;
import org.example.domain.roleclass.user.RoleUSERService;
import org.example.domain.serv.workplan.WorkPlanRepository;
import org.example.domain.serv.workplan.WorkPlanService;
import org.example.domain.user.Role;
import org.example.domain.user.User;
import org.example.domain.user.UserRepository;
import org.example.domain.user.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;

@RequiredArgsConstructor
@Controller
public class MyPageController {

    private final MemberService memberService;
    private final WorkPlanService workPlanService;
    private final WorkPlanRepository workPlanRepository;

    private final RoleUSERService roleUSERService;
    private final RoleCOMPANYService roleCOMPANYService;
    private final RoleADMINService roleADMINService;
    private final PhoneStrService phoneStrService;
    private final AddressStrService addressStrService;
    private final CoperationService coperationService;
    private final CoperationRepository coperationRepository;



    private final HttpSession httpSession;
    private final UserService userService;


    @GetMapping("/mypage/index")
    public String mypageIndex(Model model){
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        //회원 기본 정보를 저장할 User 객체 생성
        User userBase = null;
        String userEmail = user.getEmail();
        userBase = userService.findByEmail(userEmail);
        model.addAttribute("userBase", userBase);

        if(user!=null) {
            model.addAttribute("userNameStr", user.getName());

            if (user.getRole().equals("GUEST")) {
                model.addAttribute("userRoleStr", " 손님");
                model.addAttribute("addDataTF", false);
            } else if (user.getRole().equals("USER")) {
                model.addAttribute("userRoleStr", "사용자");
                model.addAttribute("addDataTF", true);
                model.addAttribute("updateTF", false);
                RoleUSER roleUSER = null;
                try {
                     //roleUSER = roleUSERService.findById(userBase.getId());
                     roleUSER = userBase.getRoleUser();
                }catch(Exception e){
                    RoleUSER roleUser = null;
                }
                if(roleUSER!=null) {
                    model.addAttribute("userAdd", roleUSER);
                }else{
                    model.addAttribute("userAdd", null);
                }

            } else if (user.getRole().equals("ADMIN")) {
                model.addAttribute("userRoleStr", "관리자");
                model.addAttribute("addDataTF", true);
                model.addAttribute("updateTF", false);
                RoleADMIN roleADMIN = null;
                try{
                   // roleADMIN = roleADMINService.findById(userBase.getId());
                    roleADMIN = userBase.getRoleAdmin();
                }catch(Exception e){
                    RoleADMIN roleAdmin = null;
                }

                if(roleADMIN!=null){
                    model.addAttribute("userAdd", roleADMIN);
                }else{
                    model.addAttribute("userAdd", null);
                }

            } else if (user.getRole().equals("COMPANY")) {
                model.addAttribute("userRoleStr", "기업회원");
                model.addAttribute("addDataTF", true);
                model.addAttribute("updateTF", false);
                RoleCOMPANY roleCOMPANY = null;
                try{
                   // roleCOMPANY = roleCOMPANYService.findById(userBase.getId());
                    roleCOMPANY = userBase.getRoleCompany();
                }catch(Exception e){
                    RoleCOMPANY roleCompany = null;
                }

                if(roleCOMPANY!=null){
                    model.addAttribute("userAdd", roleCOMPANY);
                }else{
                    model.addAttribute("userAdd", null);
                }

            }
        }
        model.addAttribute("roleRadioForm", new RoleRadioForm());

        return "mypage/index";
    }

    @ModelAttribute("roleRadioItemTypes")
    public RoleRadioItemType[] roleItemTypes() {
        return RoleRadioItemType.values();
    }
    @GetMapping("/mypage/updateInfoForm")
    public String updateInfoForm(Model model ){
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        //회원 기본 정보를 저장할 User 객체 생성
        User userBase = null;
        String userEmail = user.getEmail();
        userBase = userService.findByEmail(userEmail);
        model.addAttribute("userBase", userBase);

        if(user!=null) {
            model.addAttribute("userNameStr", user.getName());

            if (user.getRole().equals("GUEST")) {
                model.addAttribute("userRoleStr", " 손님");
                model.addAttribute("addDataTF", false);
            } else if (user.getRole().equals("USER")) {
                model.addAttribute("userRoleStr", "사용자");
                model.addAttribute("addDataTF", true);
                model.addAttribute("updateTF", true);
                RoleUSER roleUSER = null;
                try {
                    roleUSER = roleUSERService.findById(userBase.getId());
                }catch(Exception e){
                    RoleUSER roleUser = null;
                }
                if(roleUSER!=null) {
                    model.addAttribute("userAdd", roleUSER);
                }else{
                    model.addAttribute("userAdd", null);
                }

            } else if (user.getRole().equals("ADMIN")) {
                model.addAttribute("userRoleStr", "관리자");
                model.addAttribute("addDataTF", true);
                model.addAttribute("updateTF", true);
                RoleADMIN roleADMIN = null;
                try{
                    roleADMIN = roleADMINService.findById(userBase.getId());
                }catch(Exception e){
                    RoleADMIN roleAdmin = null;
                }

                if(roleADMIN!=null){
                    model.addAttribute("userAdd", roleADMIN);
                }else{
                    model.addAttribute("userAdd", null);
                }

            } else if (user.getRole().equals("COMPANY")) {
                model.addAttribute("userRoleStr", "기업회원");
                model.addAttribute("addDataTF", true);
                model.addAttribute("updateTF", true);
                RoleCOMPANY roleCOMPANY = null;
                try{
                    roleCOMPANY = roleCOMPANYService.findById(userBase.getId());
                }catch(Exception e){
                    RoleCOMPANY roleCompany = null;
                }

                if(roleCOMPANY!=null){
                    model.addAttribute("userAdd", roleCOMPANY);
                }else{
                    model.addAttribute("userAdd", null);
                }

            }
        }
        model.addAttribute("roleRadioForm", new RoleRadioForm());

        return "mypage/index";
    }

    @PostMapping("/mypage/addInfo")
    public RedirectView addInfo(Model model, String phoneNumber, String addr1, String addr2, String addr3){
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        LocalDateTime now = LocalDateTime.now();
        //회원 기본 정보를 저장할 User 객체 생성
        User userBase = null;
        String userEmail = user.getEmail();
        userBase = userService.findByEmail(userEmail);
        model.addAttribute("userBase", userBase);

        //user의 role 정보를 가져온다.
        String userRole = user.getRole();
        //role에 따라, 전화번호를 저장.
        if(userRole.equals("USER")) {
            RoleUSER roleUSER = null;
            try{
                roleUSER = roleUSERService.findById(userBase.getId());

                PhoneStr phoneStr0 = PhoneStr.builder()
                        .phoneNumber(phoneNumber)
                        .build();
                phoneStrService.save(phoneStr0);

                AddressStr addressStr0 = AddressStr.builder()
                        .zipCode(addr1)
                        .addr1(addr2)
                        .addr2(addr3)
                        .build();
                addressStrService.save(addressStr0);


                roleUSER.setAddressStr(addressStr0);
                roleUSER.setPhoneStr(phoneStr0);
                roleUSERService.save(roleUSER);
                userBase.setRoleUser(roleUSER);
                userService.save(userBase);
            }catch(Exception e){
                roleUSER=null;

                PhoneStr phoneStr0 = PhoneStr.builder()
                        .phoneNumber(phoneNumber)
                        .build();
                phoneStrService.save(phoneStr0);
                AddressStr addressStr0 = AddressStr.builder()
                        .zipCode(addr1)
                        .addr1(addr2)
                        .addr2(addr3)
                        .build();
                addressStrService.save(addressStr0);

                RoleUSER roleUSER0= RoleUSER.builder()
                        .addressStr(addressStr0)
                        .phoneStr(phoneStr0)
                        .build();
                roleUSERService.save(roleUSER0);
                userBase.setRoleUser(roleUSER0);
                userService.save(userBase);
            }


        }else if(userRole.equals("COMPANY")) {
            RoleCOMPANY roleCOMPANY = null;
            try{
                roleCOMPANY = roleCOMPANYService.findById(userBase.getId());

                PhoneStr phoneStr0 = PhoneStr.builder()
                        .phoneNumber(phoneNumber)
                        .build();
                phoneStrService.save(phoneStr0);

                AddressStr addressStr0 = AddressStr.builder()
                        .zipCode(addr1)
                        .addr1(addr2)
                        .addr2(addr3)
                        .build();
                addressStrService.save(addressStr0);

                roleCOMPANY.setAddressStr(addressStr0);
                roleCOMPANY.setPhoneStr(phoneStr0);
                roleCOMPANYService.save(roleCOMPANY);

                userBase.setRoleCompany(roleCOMPANY);
                userService.save(userBase);

            }catch(Exception e){
                roleCOMPANY=null;
                PhoneStr phoneStr0 = PhoneStr.builder()
                        .phoneNumber(phoneNumber)
                        .build();
                phoneStrService.save(phoneStr0);
                AddressStr addressStr0 = AddressStr.builder()
                        .zipCode(addr1)
                        .addr1(addr2)
                        .addr2(addr3)
                        .build();
                addressStrService.save(addressStr0);
                RoleCOMPANY roleCOMPANY0 = new RoleCOMPANY();
                roleCOMPANY0= RoleCOMPANY.builder()
                        .addressStr(addressStr0)
                        .phoneStr(phoneStr0)
                        .createDate(now)
                        .build();
                roleCOMPANYService.save(roleCOMPANY0);

                userBase.setRoleCompany(roleCOMPANY0);
                userService.save(userBase);
            }
        }else if(userRole.equals("ADMIN")) {
            RoleADMIN roleADMIN = null;
            try {
                roleADMIN = roleADMINService.findById(userBase.getId());

                PhoneStr phoneStr0 = PhoneStr.builder()
                        .phoneNumber(phoneNumber)
                        .build();
                phoneStrService.save(phoneStr0);

                AddressStr addressStr0 = AddressStr.builder()
                        .zipCode(addr1)
                        .addr1(addr2)
                        .addr2(addr3)
                        .build();
                addressStrService.save(addressStr0);

                roleADMIN.setAddressStr(addressStr0);
                roleADMIN.setPhoneStr(phoneStr0);
                roleADMINService.save(roleADMIN);

                userBase.setRoleAdmin(roleADMIN);
                userService.save(userBase);
            }catch(Exception e){
                roleADMIN=null;
                PhoneStr phoneStr0 = PhoneStr.builder()
                        .phoneNumber(phoneNumber)
                        .build();
                phoneStrService.save(phoneStr0);
                AddressStr addressStr0 = AddressStr.builder()
                        .zipCode(addr1)
                        .addr1(addr2)
                        .addr2(addr3)
                        .build();
                addressStrService.save(addressStr0);
                RoleADMIN roleADMIN0 = new RoleADMIN();
                roleADMIN0= RoleADMIN.builder()
                        .addressStr(addressStr0)
                        .phoneStr(phoneStr0)
                        .createDate(now)
                        .build();
                roleADMINService.save(roleADMIN0);

                userBase.setRoleAdmin(roleADMIN0);
                userService.save(userBase);
            }
        }

        return new RedirectView("/mypage/index");
    }
    @PostMapping("/mypage/changeRole")
    public RedirectView indexDefault(Model model, RoleRadioForm role){
        System.out.println("Role::::: " + role.getRoleRadioItemType());  // cmd 창에 출력, Role::::: COMPANY
        if(role.getRoleRadioItemType()==null){
            return new RedirectView("/mypage/index");
        }
        //저장되어 있는 세션의 user 정보를 가져옴
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        //회원 기본 정보를 저장할 User 객체 생성
        User userBase = null;

        //회원의 Role별 추가 정보를 저장할 객체 생성
        RoleGUEST roleGUEST = null;
        RoleUSER roleUSER = null;
        RoleCOMPANY roleCOMPANY = null;
        //기업회원의 추가정보 2.
        Coperation coperation = null;

        RoleADMIN roleAdmin = null;
        System.out.println("user::::: " + user);  // cmd 창에 출력, userEmail:::::

        if(user!=null) {
            //세션의 email로 유저정보를 불러오고, 그 유저의 role을 변경
            String userEmail = user.getEmail();
            System.out.println("userEmail::::: " + userEmail);  // cmd 창에 출력, userEmail:::::
            userBase = userService.findByEmail(userEmail);
            //회원의 기본정보 저장.
            model.addAttribute("userBase", userBase);

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
                model.addAttribute("addDataTF", false);
            } else if (user.getRole().equals("USER")) {
                model.addAttribute("userRoleStr", "사용자");
                model.addAttribute("addDataTF", true);
            } else if (user.getRole().equals("ADMIN")) {
                model.addAttribute("userRoleStr", "관리자");
                model.addAttribute("addDataTF", true);
            } else if (user.getRole().equals("COMPANY")) {
                model.addAttribute("userRoleStr", "기업회원");
                model.addAttribute("addDataTF", true);
            }
        }else{
            //세션이 null인 경우, 기본 index페이지로 이동

            return new RedirectView("/");
        }


        //회원의 추가정보 가져오기.
        if(userBase.getRole().equals(Role.GUEST)) {
            //손님의 경우, 추가정보가 없으므로, null로 저장.
            model.addAttribute("userAdd", null);
        }else if(userBase.getRole().equals(Role.USER)) {
            //사용자의 경우, 추가정보를 가져와서 저장.
            try {
                roleUSER = roleUSERService.findById(userBase.getId());
            }catch(Exception e){
               roleUSER=null;
            }
            model.addAttribute("userAdd", roleUSER);
        }else if(userBase.getRole().equals(Role.COMPANY)) {
            //기업회원의 경우, 추가정보를 가져와서 저장.
            try{
                roleCOMPANY = roleCOMPANYService.findById(userBase.getId());
            }catch(Exception e){
                roleCOMPANY=null;
            }
            try{
               coperation = coperationService.findById(roleCOMPANY.getCoperation().getId());
            }catch(Exception e){
                coperation=null;
            }


            model.addAttribute("userAdd", roleCOMPANY);
        }else if(userBase.getRole().equals(Role.ADMIN)) {
            //관리자의 경우, 추가정보를 가져와서 저장.
            try{
                roleAdmin = roleADMINService.findById(userBase.getId());
            }catch(Exception e){
                roleAdmin=null;
            }

            model.addAttribute("userAdd", roleAdmin);
        }

        model.addAttribute("roleRadioForm", new RoleRadioForm());

        return new RedirectView("/mypage/index");

    }
}
