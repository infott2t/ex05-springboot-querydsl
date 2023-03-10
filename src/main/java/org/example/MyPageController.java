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
        //?????? ?????? ????????? ????????? User ?????? ??????
        User userBase = null;
        String userEmail = user.getEmail();
        userBase = userService.findByEmail(userEmail);
        model.addAttribute("userBase", userBase);

        if(user!=null) {
            model.addAttribute("userNameStr", user.getName());

            if (user.getRole().equals("GUEST")) {
                model.addAttribute("userRoleStr", " ??????");
                model.addAttribute("addDataTF", false);
            } else if (user.getRole().equals("USER")) {
                model.addAttribute("userRoleStr", "?????????");
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
                model.addAttribute("userRoleStr", "?????????");
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
                model.addAttribute("userRoleStr", "????????????");
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
    @GetMapping("/mypage/index2")
    public String myPageIndex(Model model){
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        //?????? ?????? ????????? ????????? User ?????? ??????
        User userBase = null;
        String userEmail = user.getEmail();
        userBase = userService.findByEmail(userEmail);
        model.addAttribute("userBase", userBase);

        if(user!=null) {
            model.addAttribute("userNameStr", user.getName());

            if (user.getRole().equals("GUEST")) {
                model.addAttribute("userRoleStr", " ??????");
                model.addAttribute("addDataTF", false);
            } else if (user.getRole().equals("USER")) {
                model.addAttribute("userRoleStr", "?????????");
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
                model.addAttribute("userRoleStr", "?????????");
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
                model.addAttribute("userRoleStr", "????????????");
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
        return "mypage/default/index2";
    }

    @ModelAttribute("roleRadioItemTypes")
    public RoleRadioItemType[] roleItemTypes() {
        return RoleRadioItemType.values();
    }
    @GetMapping("/mypage/updateInfoForm")
    public String updateInfoForm(Model model ){
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        //?????? ?????? ????????? ????????? User ?????? ??????
        User userBase = null;
        String userEmail = user.getEmail();
        userBase = userService.findByEmail(userEmail);
        model.addAttribute("userBase", userBase);

        if(user!=null) {
            model.addAttribute("userNameStr", user.getName());

            if (user.getRole().equals("GUEST")) {
                model.addAttribute("userRoleStr", " ??????");
                model.addAttribute("addDataTF", false);
            } else if (user.getRole().equals("USER")) {
                model.addAttribute("userRoleStr", "?????????");
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
                model.addAttribute("userRoleStr", "?????????");
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
                model.addAttribute("userRoleStr", "????????????");
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
        //?????? ?????? ????????? ????????? User ?????? ??????
        User userBase = null;
        String userEmail = user.getEmail();
        userBase = userService.findByEmail(userEmail);
        model.addAttribute("userBase", userBase);

        //user??? role ????????? ????????????.
        String userRole = user.getRole();
        //role??? ??????, ??????????????? ??????.
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
        System.out.println("Role::::: " + role.getRoleRadioItemType());  // cmd ?????? ??????, Role::::: COMPANY
        if(role.getRoleRadioItemType()==null){
            return new RedirectView("/mypage/index");
        }
        //???????????? ?????? ????????? user ????????? ?????????
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        //?????? ?????? ????????? ????????? User ?????? ??????
        User userBase = null;

        //????????? Role??? ?????? ????????? ????????? ?????? ??????
        RoleGUEST roleGUEST = null;
        RoleUSER roleUSER = null;
        RoleCOMPANY roleCOMPANY = null;
        //??????????????? ???????????? 2.
        Coperation coperation = null;

        RoleADMIN roleAdmin = null;
        System.out.println("user::::: " + user);  // cmd ?????? ??????, userEmail:::::

        if(user!=null) {
            //????????? email??? ??????????????? ????????????, ??? ????????? role??? ??????
            String userEmail = user.getEmail();
            System.out.println("userEmail::::: " + userEmail);  // cmd ?????? ??????, userEmail:::::
            userBase = userService.findByEmail(userEmail);
            //????????? ???????????? ??????.
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


            //???????????? ?????? ????????? user??? role??? ??????
            user.setRole(role.getRoleRadioItemType());

            //????????? ?????? ???????????? ?????? ??????.
            httpSession.setAttribute("user", new SessionUser(userBase));
            user = (SessionUser) httpSession.getAttribute("user");

            model.addAttribute("userNameStr", user.getName());

            if (user.getRole().equals("GUEST")) {
                model.addAttribute("userRoleStr", " ??????");
                model.addAttribute("addDataTF", false);
            } else if (user.getRole().equals("USER")) {
                model.addAttribute("userRoleStr", "?????????");
                model.addAttribute("addDataTF", true);
            } else if (user.getRole().equals("ADMIN")) {
                model.addAttribute("userRoleStr", "?????????");
                model.addAttribute("addDataTF", true);
            } else if (user.getRole().equals("COMPANY")) {
                model.addAttribute("userRoleStr", "????????????");
                model.addAttribute("addDataTF", true);
            }
        }else{
            //????????? null??? ??????, ?????? index???????????? ??????

            return new RedirectView("/");
        }


        //????????? ???????????? ????????????.
        if(userBase.getRole().equals(Role.GUEST)) {
            //????????? ??????, ??????????????? ????????????, null??? ??????.
            model.addAttribute("userAdd", null);
        }else if(userBase.getRole().equals(Role.USER)) {
            //???????????? ??????, ??????????????? ???????????? ??????.
            try {
                roleUSER = roleUSERService.findById(userBase.getId());
            }catch(Exception e){
               roleUSER=null;
            }
            model.addAttribute("userAdd", roleUSER);
        }else if(userBase.getRole().equals(Role.COMPANY)) {
            //??????????????? ??????, ??????????????? ???????????? ??????.
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
            //???????????? ??????, ??????????????? ???????????? ??????.
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
