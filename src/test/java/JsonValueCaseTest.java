import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;

public class JsonValueCaseTest {

    @Test
    public void testJsonValue() throws JsonProcessingException {
        JsonValueCase jsonValueCase = new JsonValueCase();
        jsonValueCase.setName("name_1");
        jsonValueCase.setId(UUID.randomUUID());

        String result = new ObjectMapper().writeValueAsString(jsonValueCase);
        System.out.println(result);
        assertThat(result, containsString("name_1"));
    }

}
