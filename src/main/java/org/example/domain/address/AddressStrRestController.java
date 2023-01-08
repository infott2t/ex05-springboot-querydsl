package org.example.domain.address;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class AddressStrRestController {

    private final AddressStrService addressStrService;

    @GetMapping(value="/api/v3/addressStr")
    public List<AddressStrApiDto> addressStrAll(){


        List<AddressStrApiDto> dto  = addressStrService.searchFindAllDesc();


        JSONArray jsonArr = new JSONArray();
        JSONObject obj = new JSONObject();
        obj.put("data", dto);
        jsonArr.add(obj);
        return jsonArr;
    }

}