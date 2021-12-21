package service.cardtrainer.main.domain;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

public interface CardShuffler
{
    public ArrayList<Card> drawNCards(int n);
}
