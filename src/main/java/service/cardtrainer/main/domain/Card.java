package service.cardtrainer.main.domain;

public class Card
{
    private String figure;
    private String color;

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
