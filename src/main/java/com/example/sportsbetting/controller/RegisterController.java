package com.example.sportsbetting.controller;

import com.example.sportsbetting.database.model.Player;
import com.example.sportsbetting.database.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;

@Controller
@RequestMapping("register")
public class RegisterController {
    @Autowired
    PlayerService playerService;

    @GetMapping("")
    public String register(HttpServletRequest request) {
        return "register";
    }

    @PostMapping("")
    public String register(HttpServletRequest request, HttpServletResponse response) {
        String errorMessage = "Something went wrong.";
        try {
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String repassword = request.getParameter("repassword");

            System.out.println(1);
            if (
                    email.isEmpty() ||
                            password.isEmpty() ||
                            name.isEmpty()
            ) {
                throw new Exception("The username or password is missing");
            } else if (!password.equals(repassword)) {
                throw new Exception("The password is not matching!");
            }
            else {
                Player newPlayer = new Player.Builder()
                        .setName(name)
                        .setEmail(email)
                        .setPassword(password)
                        .setAccountNumber(1000)
                        .setBalance(new BigDecimal(1000))
                        .build();

                playerService.add(newPlayer);
                return "redirect:login";
            }
        } catch (NullPointerException err) {
            errorMessage = "The username or password property is missing";
        }
        catch (Exception e) {
            errorMessage = e.getMessage();
        }
        return errorMessage;
    }

}
