package service.cardtrainer.main.domain;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class TableSeater
{
    private final ArrayList<String> positions = new ArrayList<>(){{add("dealer"); add("mid"); add("early");}};

    public String getRandomPosition()
    {
        return positions.get((int) (Math.random() * 3));
    }
}
