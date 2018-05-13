import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;

public class JsonRawValueCaseTest {

    @Test
    public void testJsonRawValue() throws JsonProcessingException {
        JsonRawValueCase jsonRawValueCase = new JsonRawValueCase();
        jsonRawValueCase.id = UUID.randomUUID();
        jsonRawValueCase.name = "name_1";
        jsonRawValueCase.json = "{\"key\":\"value\"}";

        String result = new ObjectMapper().writeValueAsString(jsonRawValueCase);
        System.out.println(result);
        assertThat(result, containsString("name_1"));
    }

}
