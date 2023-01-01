package org.example;

import lombok.RequiredArgsConstructor;
import org.example.domain.coperation.Coperation;
import org.example.domain.coperation.CoperationRepository;
import org.example.domain.coperation.CoperationService;
import org.example.domain.member.MemberDto;
import org.example.domain.member.MemberService;
import org.example.domain.serv.workplan.WorkPlan;
import org.example.domain.serv.workplan.WorkPlanRepository;
import org.example.domain.serv.workplan.WorkPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Controller
public class BaseController {

    private final MemberService memberService;
    private final WorkPlanService workPlanService;
    private final WorkPlanRepository workPlanRepository;
    private final CoperationService coperationService;
    private final CoperationRepository coperationRepository;

    @GetMapping("/")
    public String indexDefault(Model model){

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


        model.addAttribute("coperationLists", coperationService.searchFindAllDesc());
        model.addAttribute("workPlanLists", workPlanService.searchFindAllDesc());

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
