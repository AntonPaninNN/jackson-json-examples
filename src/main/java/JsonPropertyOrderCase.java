import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.UUID;

@JsonPropertyOrder({"name", "id"})
public class JsonPropertyOrderCase {

    public UUID id;
    public String name;

}
