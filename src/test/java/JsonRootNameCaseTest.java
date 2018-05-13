import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;

public class JsonRootNameCaseTest {

    @Test
    public void testJsonRootName() throws JsonProcessingException {
        JsonRootNameCase jsonRootNameCase = new JsonRootNameCase();
        jsonRootNameCase.id = UUID.randomUUID();
        jsonRootNameCase.name = "name_1";

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
        String result = mapper.writeValueAsString(jsonRootNameCase);
        System.out.println(result);
        assertThat(result, containsString("name_1"));
    }

}
