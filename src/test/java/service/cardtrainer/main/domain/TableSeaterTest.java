package service.cardtrainer.main.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.thymeleaf.util.ArrayUtils;

import static org.junit.jupiter.api.Assertions.*;

class TableSeaterTest
{
    private final String[] validValues = {"dealer", "mid", "early"};
    TableSeater testSubject;

    @Test
    public void itReturnsValidPositionEveryTime()
    {
        for (int i=0; i<100; i++) {
            assertTrue(ArrayUtils.contains(validValues, testSubject.getRandomPosition()));
        }
    }

    @BeforeEach
    void setUp()
    {
        testSubject = new TableSeater();
    }
}