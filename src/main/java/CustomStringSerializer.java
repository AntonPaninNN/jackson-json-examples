import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class CustomStringSerializer extends StdSerializer<String> {
    protected CustomStringSerializer(Class<String> t) {
        super(t);
    }

    public CustomStringSerializer() { this(null); }

    public void serialize(String s, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeString(s.toUpperCase());
    }
}
