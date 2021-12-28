package service.cardtrainer.main.domain;

public class PlayerState
{
    private String position;
    private Card card1;
    private Card card2;
    private String move;
    private int currentOk;
    private int currentWrong;

    public PlayerState()
    {
        card1 = new Card();
        card2 = new Card();
    }

    public String getPosition()
    {
        return position;
    }

    public void setCard1(Card card)
    {
        card1 = card;
    }
    public void setCard2(Card card)
    {
        card2 = card;
    }
    public void setCard1Figure(String figure)
    {
        card1.setFigure(figure);
    }
    public void setCard2Figure(String figure)
    {
        card2.setFigure(figure);
    }
    public void setCard1Color(String color)
    {
        card1.setColor(color);
    }
    public void setCard2Color(String color)
    {
        card2.setColor(color);
    }
    public void setPosition(String position)
    {
        this.position = position;
    }
    public String getCard1Figure()
    {
        return card1.getFigure();
    }
    public String getCard1Color()
    {
        return card1.getColor();
    }
    public String getCard2Figure()
    {
        return card2.getFigure();
    }
    public String getCard2Color()
    {
        return card2.getColor();
    }
    public String[] getMoves()
    {
        return new String[] {"wait / fold", "check", "raise"};
    }
    public String getMove()
    {
        return move;
    }
    public void setMove(String move)
    {
        this.move = move;
    }
    public int getOk()
    {
        return currentOk;
    }
    public void setOk(int currentOk)
    {
        this.currentOk = currentOk;
    }
    public int getTotal()
    {
        return currentOk + currentWrong;
    }
    public void setWrong(int currentWrong)
    {
        this.currentWrong = currentWrong;
    }
    public int getWrong()
    {
        return currentWrong;
    }
    public void scoreOk()
    {
        ++currentOk;
    }
    public void scoreWrong()
    {
        ++currentWrong;
    }
}
