package org.example;

import lombok.RequiredArgsConstructor;
import org.example.domain.member.MemberDto;
import org.example.domain.member.MemberService;
import org.example.domain.serv.workplan.WorkPlan;
import org.example.domain.serv.workplan.WorkPlanRepository;
import org.example.domain.serv.workplan.WorkPlanRepositoryImpl;
import org.example.domain.serv.workplan.WorkPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Controller
public class BaseController {
    @Autowired
    private MemberService memberService;
    @Autowired
    private WorkPlanService workPlanService;
    @Autowired
    private WorkPlanRepository workPlanRepository;

    @GetMapping("/")
    public String indexDefault(Model model){

        LocalDateTime insertDate = LocalDateTime.of(2021,6,1,0,0,0);
        LocalDateTime now = LocalDateTime.now();

        WorkPlan workPlan = WorkPlan.builder()
                .workPlanTitle("배추 김치 만들기")
                .workPlanCooperation("A 푸드")
                .workPlanStatus("Y")
                .workPlanTag("음식, 요리")
                .workPlanStartDate(insertDate)
                .crateDate(now)
                .updateDate(now)
                .build();

        WorkPlan workPlan0 = WorkPlan.builder()
                .workPlanTitle("제품 운반, 적재하기")
                .workPlanCooperation("A 푸드")
                .workPlanStatus("Y")
                .workPlanTag("음식, 창고")
                .workPlanStartDate(insertDate)
                .crateDate(now)
                .updateDate(now)
                .build();

        WorkPlan workPlan1 = WorkPlan.builder()
                .workPlanTitle("음식 재료 다듬기")
                .workPlanCooperation("B 푸드")
                .workPlanStatus("Y")
                .workPlanTag("음식, 요리")
                .workPlanStartDate(insertDate)
                .crateDate(now)
                .updateDate(now)
                .build();

        WorkPlan workPlan2 = WorkPlan.builder()
                .workPlanTitle("음식 재료 만들기")
                .workPlanCooperation("B 푸드")
                .workPlanStatus("Y")
                .workPlanTag("음식, 요리")
                .workPlanStartDate(insertDate)
                .crateDate(now)
                .updateDate(now)
                .build();

        workPlanRepository.save(workPlan);
        workPlanRepository.save(workPlan0);
        workPlanRepository.save(workPlan1);
        workPlanRepository.save(workPlan2);

        model.addAttribute("workPlanList", workPlanService.searchFindAllDesc());

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
