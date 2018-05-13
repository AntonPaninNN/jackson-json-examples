import com.fasterxml.jackson.annotation.JsonAnyGetter;

import java.util.Map;

public class JsonAnyGetterCase {

    public String id;
    public String name;
    public Map<String, String> params;

    @JsonAnyGetter
    public Map<String, String> getParams() {
        return params;

    }

}
