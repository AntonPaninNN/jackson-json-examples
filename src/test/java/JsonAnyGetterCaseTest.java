import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;

public class JsonAnyGetterCaseTest {

    @Test
    public void testJsonAnyGetter() throws JsonProcessingException {
        JsonAnyGetterCase jsonAnyGetterCase = new JsonAnyGetterCase();
        jsonAnyGetterCase.id = "SomeId";
        jsonAnyGetterCase.name = "SomeName";
        jsonAnyGetterCase.params = new HashMap<String, String>();
        jsonAnyGetterCase.params.put("param1_key", "param1_value");
        jsonAnyGetterCase.params.put("param2_key", "param2_value");

        String result = new ObjectMapper().writeValueAsString(jsonAnyGetterCase);
        System.out.println(result);
        assertThat(result, containsString("param1_key"));
        assertThat(result, containsString("param2_value"));
    }

}
