package org.example.domain.roleclass.user;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class RoleUSERRestController {

    private final RoleUSERService roleUSERService;

    @GetMapping(value="/api/v3/roleUSER")
    public List<RoleUSERApiDto> roleUSERAll(){


        List<RoleUSERApiDto> dto  = roleUSERService.searchFindAllDesc();


        JSONArray jsonArr = new JSONArray();
        JSONObject obj = new JSONObject();
        obj.put("data", dto);
        jsonArr.add(obj);
        return jsonArr;
    }

}