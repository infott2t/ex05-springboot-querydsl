package org.example.domain.phone;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class PhoneStrRestController {

    private final PhoneStrService phoneStrService;

    @GetMapping(value="/api/v3/phoneStr")
    public List<PhoneStrApiDto> phoneStrAll(){


        List<PhoneStrApiDto> dto  = phoneStrService.searchFindAllDesc();


        JSONArray jsonArr = new JSONArray();
        JSONObject obj = new JSONObject();
        obj.put("data", dto);
        jsonArr.add(obj);
        return jsonArr;
    }

}