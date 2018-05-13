import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;

public class JsonPropertyOrderCaseTest {

    @Test
    public void testJsonPropertyOrder() throws JsonProcessingException {
        JsonPropertyOrderCase jsonPropertyOrderCase = new JsonPropertyOrderCase();
        jsonPropertyOrderCase.id = UUID.randomUUID();
        jsonPropertyOrderCase.name = "name_1";

        String result = new ObjectMapper().writeValueAsString(jsonPropertyOrderCase);
        System.out.println(result);
        assertThat(result, containsString("name_1"));
    }

}
