package com.example.sportsbetting.controller;

import com.example.sportsbetting.database.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("login")
public class LoginController {
    @Autowired
    PlayerService playerService;

    @GetMapping(value = "")
    public ModelAndView loginPage(@RequestParam(value = "error",required = false) String error,
                                  @RequestParam(value = "logout",	required = false) String logout) {

        ModelAndView model = new ModelAndView();

        if (error != null) {
            model.addObject("error", error);
        }

        if (logout != null) {
            model.addObject("message", "Logged out from JournalDEV successfully.");
        }

        model.setViewName("login");
        return model;
    }

    @RequestMapping("requestLogin")
    public String requestLogin(HttpServletRequest request) {
        request.getSession().setAttribute("USER_ID", "request");

        String errorMessage = "Something went wrong.";
        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            if (username.isEmpty() || password.isEmpty()) {
                throw new Exception("The username or password is missing");
            } else {
                request.getSession().setAttribute("USER_ID", "request");
                return "login.jsp";
            }
        } catch (NullPointerException err) {
            errorMessage = "The username or password property is missing";
        }
        catch (Exception e) {
            errorMessage = e.getMessage();
        }
        return "login";
    }
}
