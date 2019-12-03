package com.example.sportsbetting.controller;

import com.example.sportsbetting.database.model.Player;
import com.example.sportsbetting.database.model.Wager;
import com.example.sportsbetting.database.service.PlayerService;
import com.example.sportsbetting.database.service.WagerService;
import com.example.sportsbetting.initializer.TestData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("")
public class AppController {
    @Autowired
    PlayerService playerService;
    @Autowired
    WagerService wagerService;
    @Autowired
    TestData testDataService;

    @RequestMapping("")
    public String index(Model model, HttpServletRequest request) {

        String username = ((UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();

        Player player = playerService.getPlayerByEmail(username);
        testDataService.GenerateData(player);

        List<Wager> wagers = wagerService.getWagersByPlayer(player);

        model.addAttribute("wagers", wagers);
        model.addAttribute("player", player);
        return "index";
    }

    @PostMapping("/removeWager")
    @ResponseBody
    public String removeWager(HttpServletRequest request) {
        try {
            String wager_id = request.getParameter("wager_id");
            wagerService.delete(Integer.parseInt(wager_id));
        } catch (Exception err) {
            return "Invalid ID!";
        }
        return "Deleted";
    }

}
