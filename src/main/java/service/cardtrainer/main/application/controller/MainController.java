package service.cardtrainer.main.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.cardtrainer.main.domain.Card;
import service.cardtrainer.main.domain.CardShuffler;
import service.cardtrainer.main.domain.PlayerMove;
import service.cardtrainer.main.domain.TableSeater;

import java.util.ArrayList;

@Controller
public class MainController
{
    @Autowired
    CardShuffler shuffler;
    @Autowired
    TableSeater tableSeater;

    @GetMapping(path = "/index")
    public String handle(
            @RequestParam(defaultValue = "0", required = false) String ok,
            @RequestParam(defaultValue = "0", required = false) String wrong,
            Model model
    )
    {
        PlayerMove playerMove = new PlayerMove();
        newPosition(playerMove);
        playerMove.setOk(Integer.parseInt(ok));
        playerMove.setWrong(Integer.parseInt(wrong));

        model.addAttribute("playerMove", playerMove);
        return "index";
    }

    @PostMapping("/index")
    public String handleFormSubmit(@ModelAttribute("playerMove") PlayerMove playerMove, BindingResult result, Model model) {
        model.addAttribute("playerMove", playerMove);
        newPosition(playerMove);
        playerMove.setOk(playerMove.getOk()+1);
        return "index";
    }

    private void newPosition(PlayerMove playerMove)
    {
        ArrayList<Card> cards = shuffler.drawNCards(2);
        playerMove.setPosition(tableSeater.getRandomPosition());
        playerMove.setCard1(cards.get(0));
        playerMove.setCard2(cards.get(1));
    }
}
