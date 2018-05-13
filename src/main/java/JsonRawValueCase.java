import com.fasterxml.jackson.annotation.JsonRawValue;

import java.util.UUID;

public class JsonRawValueCase {

    public UUID id;
    public String name;

    @JsonRawValue
    public String json;

}
