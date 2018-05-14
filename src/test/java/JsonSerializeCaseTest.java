import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;

public class JsonSerializeCaseTest {

    @Test
    public void testJsonSerialize() throws JsonProcessingException {
        JsonSerializeCase jsonSerializeCase = new JsonSerializeCase();
        jsonSerializeCase.id = UUID.randomUUID();
        jsonSerializeCase.name = "name_1";

        String result = new ObjectMapper().writeValueAsString(jsonSerializeCase);
        System.out.println(result);
        assertThat(result, containsString("NAME_1"));
    }

}
