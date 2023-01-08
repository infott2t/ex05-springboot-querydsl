package org.example;

import lombok.RequiredArgsConstructor;
import org.example.config.auth.dto.SessionUser;
import org.example.domain.coperation.Coperation;
import org.example.domain.coperation.CoperationRepository;
import org.example.domain.coperation.CoperationService;
import org.example.domain.member.Member;
import org.example.domain.member.MemberDto;
import org.example.domain.member.MemberService;
import org.example.domain.serv.workplan.WorkPlan;
import org.example.domain.serv.workplan.WorkPlanRepository;
import org.example.domain.serv.workplan.WorkPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;

@RequiredArgsConstructor
@Controller
public class BaseController {

    private final MemberService memberService;
    private final WorkPlanService workPlanService;
    private final WorkPlanRepository workPlanRepository;
    private final CoperationService coperationService;
    private final CoperationRepository coperationRepository;

    private final HttpSession httpSession;

    @GetMapping("/")
    public String indexDefault(Model model){

/*
        LocalDateTime insertDate = LocalDateTime.of(2023,6,1,0,0,0);
        LocalDateTime now = LocalDateTime.now();

        Coperation coperationA = Coperation.builder()
                .coperationName("A 푸드")
                .catchPrice("김치를 만들어보세요.")
                .build();

        Coperation coperationB = Coperation.builder()
                .coperationName("B 푸드")
                .catchPrice("반조리 음식. 이 일은 어떤가요.")
                .build();

        WorkPlan workPlanA1 = WorkPlan.builder()
                .workPlanTitle("배추 김치 만들기")
                .coperation(coperationA)
                .workPlanStatus("Y")
                .workPlanTag("음식, 요리")
                .workPlanStartDate(insertDate)
                .crateDate(now)
                .updateDate(now)
                .build();

        WorkPlan workPlanA2 = WorkPlan.builder()
                .workPlanTitle("제품 운반, 적재하기")
                .coperation(coperationA)
                .workPlanStatus("Y")
                .workPlanTag("음식, 창고")
                .workPlanStartDate(insertDate)
                .crateDate(now)
                .updateDate(now)
                .build();

        WorkPlan workPlanA3 = WorkPlan.builder()
                .workPlanTitle("제품 포장하기")
                .coperation(coperationA)
                .workPlanStatus("Y")
                .workPlanTag("음식, 포장")
                .workPlanStartDate(insertDate)
                .crateDate(now)
                .updateDate(now)
                .build();


        WorkPlan workPlanB1 = WorkPlan.builder()
                .workPlanTitle("음식 재료 다듬기")
                .coperation(coperationB)
                .workPlanStatus("Y")
                .workPlanTag("음식, 요리")
                .workPlanStartDate(insertDate)
                .crateDate(now)
                .updateDate(now)
                .build();

        WorkPlan workPlanB2 = WorkPlan.builder()
                .workPlanTitle("음식 재료 만들기")
                .coperation(coperationB)
                .workPlanStatus("Y")
                .workPlanTag("음식, 요리")
                .workPlanStartDate(insertDate)
                .crateDate(now)
                .updateDate(now)
                .build();

        WorkPlan workPlanB3 = WorkPlan.builder()
                .workPlanTitle("제품 포장하기")
                .coperation(coperationB)
                .workPlanStatus("Y")
                .workPlanTag("음식, 포장")
                .workPlanStartDate(insertDate)
                .crateDate(now)
                .updateDate(now)
                .build();

        coperationRepository.save(coperationA);
        coperationRepository.save(coperationB);

        workPlanRepository.save(workPlanA1);
        workPlanRepository.save(workPlanA2);
        workPlanRepository.save(workPlanA3);
        workPlanRepository.save(workPlanB1);
        workPlanRepository.save(workPlanB2);
        workPlanRepository.save(workPlanB3);
*/
        SessionUser user = (SessionUser) httpSession.getAttribute("user");



        model.addAttribute("coperationLists", coperationService.searchFindAllDesc());
        model.addAttribute("workPlanLists", workPlanService.searchFindAllDesc());
        if(user!=null){
            model.addAttribute("userNameStr", user.getName());
            model.addAttribute("user", user);
        }
        //세션 정보를 통해서, 뷰페이지 리턴 바꿈.
/*
        Member loginMember = (Member) session.getAttribute("loginMember");
        if(loginMember != null) {
            System.out.println(loginMember.getRole() + " ROLE--------------");
        }

        if(loginMember == null) {
            return "index_leaf";
        }else{
            if(loginMember.getRole().equals("ROLE_ADMIN")) {
                return "admin/index";
            } else if (loginMember.getRole().equals("ROLE_USER")) {
                return "index_leaf";
            } else if (loginMember.getRole().equals("ROLE_COMPANY")){
                return "company/index_leaf";
            }
        }

*/
        return "index_log_leaf";
    }

    @GetMapping("/signup")
    public String signupForm(Model model, HttpServletRequest request){
        //HttpSession session = request.getSession();
/*
        SessionUser user = (SessionUser) httpSession.getAttribute("user");

        if(user!=null){
            model.addAttribute("userName", user.getName());
        }
        model.addAttribute("member", new MemberDto());
        */

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

    @PostMapping("/login")
    public String login(HttpServletRequest request){

        HttpSession session = request.getSession();

        System.out.println("USER NAME : " + request.getParameter("username"));

        //session.setAttribute("role", "admin");
        //session.setAttribute("loginMember", member);

        return "index_leaf";
    }

    @GetMapping("/logout")
    public String logout(Model model, HttpServletRequest request, HttpServletResponse response){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if(authentication != null && authentication.isAuthenticated()){
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }
        HttpSession session = request.getSession();
        session.removeAttribute("user");
        session.invalidate();
        httpSession.invalidate();
        httpSession.removeAttribute("user");
        //model.addAttribute("userName", null);

        return "redirect:/";
    }
}
