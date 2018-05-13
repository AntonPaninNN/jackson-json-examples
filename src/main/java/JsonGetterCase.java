import com.fasterxml.jackson.annotation.JsonGetter;

import java.util.UUID;

public class JsonGetterCase {
    private UUID id;
    private String name;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonGetter("no_name")
    public String getName() {
        return name;
    }
}
