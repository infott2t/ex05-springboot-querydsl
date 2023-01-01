package org.example.domain.serv.workplan;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class WorkPlanRestController {

    private final WorkPlanService workPlanService;

    @GetMapping(value="/api/v3/workPlan")
    public List<WorkPlanApiDto> workPlanAll(){


        List<WorkPlanApiDto> dto  = workPlanService.searchFindAllDesc();


        JSONArray jsonArr = new JSONArray();
        JSONObject obj = new JSONObject();
        obj.put("data", dto);
        jsonArr.add(obj);
        return jsonArr;
    }

}