package org.example.domain.roleclass.guest;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class RoleGUESTRestController {

    private final RoleGUESTService roleGUESTService;

    @GetMapping(value="/api/v3/roleGUEST")
    public List<RoleGUESTApiDto> roleGUESTAll(){


        List<RoleGUESTApiDto> dto  = roleGUESTService.searchFindAllDesc();


        JSONArray jsonArr = new JSONArray();
        JSONObject obj = new JSONObject();
        obj.put("data", dto);
        jsonArr.add(obj);
        return jsonArr;
    }

}