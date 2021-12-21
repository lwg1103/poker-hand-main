package service.cardtrainer.main.infrastructure;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import service.cardtrainer.main.domain.Card;
import service.cardtrainer.main.domain.CardShuffler;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

@Component
public class CardShufflerService implements CardShuffler
{
    @Override
    public ArrayList<Card> drawNCards(int n)
    {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = null;

        try {
            request = HttpRequest.newBuilder()
                    .uri(new URI("http://localhost:28888/draw/2"))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            ObjectMapper objectMapper = new ObjectMapper();
            ArrayList<Card> cards = objectMapper.readValue(response.body(), new TypeReference<ArrayList<Card>>(){});

            return cards;
        } catch (URISyntaxException | IOException | InterruptedException e) {
            return new ArrayList<>();
        }
    }
}
