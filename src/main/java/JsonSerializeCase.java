import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.UUID;

public class JsonSerializeCase {
    public UUID id;

    @JsonSerialize(using = CustomStringSerializer.class)
    public String name;
}
