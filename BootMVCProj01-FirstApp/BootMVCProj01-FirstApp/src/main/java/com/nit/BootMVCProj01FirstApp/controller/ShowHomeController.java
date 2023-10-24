package com.nit.BootMVCProj01FirstApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ShowHomeController {

    @RequestMapping("/home")
    public String showHome() {
        // return LVN
        return "welcome";
    }

    @RequestMapping("/")
    public String launchPage() {
        // return LVN
        return "welcome";
    }

}
