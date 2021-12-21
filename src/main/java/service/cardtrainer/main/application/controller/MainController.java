package service.cardtrainer.main.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import service.cardtrainer.main.domain.Card;
import service.cardtrainer.main.domain.CardShuffler;

import java.util.ArrayList;

@Controller
public class MainController
{
    @Autowired
    CardShuffler shuffler;

    @GetMapping(path = "/index")
    public String handle(Model model) {
        ArrayList<Card> cards = shuffler.drawNCards(2);

        model.addAttribute("cards", cards);
        return "index";
    }
}
