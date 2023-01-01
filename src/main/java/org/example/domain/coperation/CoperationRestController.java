package org.example.domain.coperation;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class CoperationRestController {

    private final CoperationService  coperationService;

    @GetMapping(value="/api/v3/coperation")
    public List<CoperationApiDto> coperationAll(){


        List<CoperationApiDto> dto  = coperationService.searchFindAllDesc();


        JSONArray jsonArr = new JSONArray();
        JSONObject obj = new JSONObject();
        obj.put("data", dto);
        jsonArr.add(obj);
        return jsonArr;
    }

}