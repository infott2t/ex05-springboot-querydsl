package org.example.domain.roleclass.admin;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class RoleADMINRestController {

    private final RoleADMINService roleADMINService;

    @GetMapping(value="/api/v3/roleADMIN")
    public List<RoleADMINApiDto> roleADMINAll(){


        List<RoleADMINApiDto> dto  = roleADMINService.searchFindAllDesc();


        JSONArray jsonArr = new JSONArray();
        JSONObject obj = new JSONObject();
        obj.put("data", dto);
        jsonArr.add(obj);
        return jsonArr;
    }

}