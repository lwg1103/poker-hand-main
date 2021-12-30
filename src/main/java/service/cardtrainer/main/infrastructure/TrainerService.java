package service.cardtrainer.main.infrastructure;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import service.cardtrainer.main.domain.PlayerState;
import service.cardtrainer.main.domain.Trainer;
import service.cardtrainer.main.infrastructure.dto.Card;
import service.cardtrainer.main.infrastructure.dto.Move;
import service.cardtrainer.main.infrastructure.dto.Note;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Objects;

@Component
public class TrainerService implements Trainer
{
    private boolean lastNote = true;
    @Override
    public boolean judgeMove(PlayerState move)
    {
        HttpClient client = HttpClient.newHttpClient();

        try {

            ObjectMapper objectMapper = new ObjectMapper();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("http://card-trainer:8080/judge-move"))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(objectMapper.writeValueAsString(move)))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            Note note = objectMapper.readValue(response.body(), new TypeReference<>() {});

            return Objects.equals(note.value, "ok");
        } catch (URISyntaxException | IOException | InterruptedException e) {
            System.out.println(e);
            return false;
        }
    }
}
