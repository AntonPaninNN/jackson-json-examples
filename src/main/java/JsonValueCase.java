import com.fasterxml.jackson.annotation.JsonValue;

import java.util.UUID;

public class JsonValueCase {

    private UUID id;
    private  String name;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @JsonValue
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
