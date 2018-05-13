import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.util.UUID;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;

public class JsonGetterCaseTest {

    @Test
    public void testJsonGetter() throws JsonProcessingException {
        JsonGetterCase jsonGetterCase = new JsonGetterCase();
        jsonGetterCase.setId(UUID.randomUUID());
        jsonGetterCase.setName("name_1");

        String result = new ObjectMapper().writeValueAsString(jsonGetterCase);
        System.out.println(result);
        assertThat(result, containsString("name_1"));
    }

}
