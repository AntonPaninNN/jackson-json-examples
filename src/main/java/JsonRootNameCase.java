import com.fasterxml.jackson.annotation.JsonRootName;

import java.util.UUID;

@JsonRootName(value = "some_entity")
public class JsonRootNameCase {
    public UUID id;
    public String name;
}
