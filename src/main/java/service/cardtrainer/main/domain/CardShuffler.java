package service.cardtrainer.main.domain;

import java.util.ArrayList;

public interface CardShuffler
{
    public ArrayList<Card> drawNCards(int n);
}
