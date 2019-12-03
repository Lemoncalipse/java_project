package com.example.sportsbetting.controller;

import com.example.sportsbetting.database.model.Currency;
import com.example.sportsbetting.database.model.Player;
import com.example.sportsbetting.database.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.time.LocalDate;

@Controller
@RequestMapping("player")
public class PlayerController {
    @Autowired
    PlayerService playerService;

    @PostMapping("/savePlayer")
    public String savePlayer(HttpServletRequest request) {
        try {
            String name = request.getParameter("name");
            LocalDate date_of_birth = LocalDate.parse(request.getParameter("date_of_birth"));
            Integer accountNumber = Integer.parseInt(request.getParameter("account_number"));
            Currency currency = Currency.valueOf(request.getParameter("currency"));
            BigDecimal balance = new BigDecimal(request.getParameter("balance"));

            String username = ((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
            Player player = playerService.getPlayerByEmail(username);

            player.setAccountNumber(accountNumber);
            player.setBalance(balance);
            player.setName(name);
            player.setCurrency(currency);
            player.setBirth(date_of_birth);

            playerService.save(player);
        } catch (Error e) {
            return e.getMessage();
        }
        return "redirect:/";
    }
}
