import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.BeforeClass;
import org.junit.Test;
import rickandmorty.models.Characters;
import rickandmorty.models.Info;
import rickandmorty.models.Result;

import java.util.List;
import java.util.Objects;

import static rest.RestGet.Get;
import static org.junit.Assert.*;

public class RickAndMortyTestApi {

    static String url = "https://rickandmortyapi.com/api/character";
    static Characters characters;
    static ObjectMapper om = new ObjectMapper();

    @BeforeClass
    public static void beforeTest() throws JsonProcessingException {
        characters = om.readValue(Get(url), Characters.class);
    }

    @Test
    public void nextPageNotNull() throws JsonProcessingException {
        while (characters.info.next != null) {
            assertNotNull("Next page is null", characters.info.next);
            characters = om.readValue(Get(characters.info.next), Characters.class);
            for (Result n : characters.results) {
                System.out.println("name = " + n.name);
            }
        }

    }
}
