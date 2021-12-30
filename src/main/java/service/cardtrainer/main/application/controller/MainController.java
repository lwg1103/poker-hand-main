package service.cardtrainer.main.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import service.cardtrainer.main.domain.*;

import java.util.ArrayList;

@Controller
public class MainController
{
    @Autowired
    CardShuffler shuffler;
    @Autowired
    TableSeater tableSeater;
    @Autowired
    Trainer trainer;

    @GetMapping(path = "/index")
    public String handle(Model model)
    {
        PlayerState playerState = new PlayerState();
        newPosition(playerState);

        model.addAttribute("playerState", playerState);
        return "index";
    }

    @PostMapping("/index")
    public String handleFormSubmit(@ModelAttribute("playerState") PlayerState playerState, BindingResult result, Model model) {
        if (trainer.judgeMove(playerState)) {
            playerState.scoreOk();
            model.addAttribute("last", "Good!");
        } else {
            playerState.scoreWrong();
            model.addAttribute("last", "Wrong!");
        }

        newPosition(playerState);
        model.addAttribute("playerState", playerState);
        return "index";
    }

    private void newPosition(PlayerState playerMove)
    {
        ArrayList<Card> cards = shuffler.drawNCards(2);
        playerMove.setPosition(tableSeater.getRandomPosition());
        playerMove.setCard1(cards.get(0));
        playerMove.setCard2(cards.get(1));
    }
}
