package org.example.domain.roleclass.company;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class RoleCOMPANYRestController {

    private final RoleCOMPANYService roleCOMPANYService;

    @GetMapping(value="/api/v3/roleCOMPANY")
    public List<RoleCOMPANYApiDto> roleCOMPANYAll(){


        List<RoleCOMPANYApiDto> dto  = roleCOMPANYService.searchFindAllDesc();


        JSONArray jsonArr = new JSONArray();
        JSONObject obj = new JSONObject();
        obj.put("data", dto);
        jsonArr.add(obj);
        return jsonArr;
    }

}