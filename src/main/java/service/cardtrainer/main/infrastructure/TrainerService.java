package service.cardtrainer.main.infrastructure;

import org.springframework.stereotype.Component;
import service.cardtrainer.main.domain.PlayerState;
import service.cardtrainer.main.domain.Trainer;

@Component
public class TrainerService implements Trainer
{
    private boolean lastNote = true;
    @Override
    public boolean judgeMove(PlayerState move)
    {
        lastNote = !lastNote;

        return lastNote;
    }
}
