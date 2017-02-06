package org.springframework.social.es.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.social.es.security.UserDetail;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping(value = "/")
    public String home(@AuthenticationPrincipal UserDetail userDetail, Model model) {
        model.addAttribute("email", userDetail.getUsername());
        model.addAttribute("name", userDetail.getNickName());
        return "home";
    }
}
