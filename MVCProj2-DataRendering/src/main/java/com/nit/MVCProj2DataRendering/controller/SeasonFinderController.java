package com.nit.MVCProj2DataRendering.controller;

import com.nit.MVCProj2DataRendering.service.ISeasonFinderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class SeasonFinderController {

    @Autowired
    private ISeasonFinderService seasonFinderService;

    @RequestMapping("/")
    public String showHome() {
        return "home";
    }

    @RequestMapping("/season")
    public String showSeason(Map<String, Object> map) {
        // use service
        String msg = seasonFinderService.findSeason();
        //Keep results in Model Attribute
        map.put("resultMsg", msg);
        // return lvn
        return "season";
    }

}
