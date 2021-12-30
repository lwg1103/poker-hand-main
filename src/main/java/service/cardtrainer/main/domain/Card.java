package service.cardtrainer.main.domain;

public class Card
{
    private String figure;
    private String color;

    public Card()
    {
    }

    public Card(String figure, String color)
    {
        this.figure = figure.toLowerCase();
        this.color = color.toLowerCase();
    }

    public String getFigure()
    {
        return figure;
    }

    public void setFigure(String figure)
    {
        this.figure = figure.toLowerCase();
    }

    public String getColor()
    {
        return color;
    }

    public void setColor(String color)
    {
        this.color = color.toLowerCase();
    }
}
