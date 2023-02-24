package com.ming.ch12.controller;

import com.ming.ch12.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.UUID;

/**
 * @author 贺春明
 * @date 2023/2/22
 */

@Controller
public class LoginController {
    @PostMapping("/userLogin")
    public String login(User user, HttpSession session) {
        user.setId(UUID.randomUUID().toString());
        session.setAttribute("user", user);
        return "redirect:/index.html";
    }

    @PostMapping("/userLogin2")
    public ModelAndView login2(User user, HttpSession session) {
        user.setId(UUID.randomUUID().toString());
        ModelAndView mav = new ModelAndView("index");
        return mav;
    }
}
