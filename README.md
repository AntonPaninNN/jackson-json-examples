# jackson-json-examples
Simple examples of jackson (json framework) annotations

### 1. @JsonAnyGetter annotation
Allows to use Map data as some general property. For example this pojo:

```
public class JsonAnyGetterCase {
    public String id;
    public String name;
    public Map<String, String> params;

    @JsonAnyGetter
    public Map<String, String> getParams() {
        return params;

    }
}
```

with next test case:

```
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
```

return:

```
{
   "id": "SomeId",
   "name": "SomeName",
   "params": {
      "param1_key": "param1_value",
      "param2_key": "param2_value"
   },
   "param1_key": "param1_value",
   "param2_key": "param2_value"
}
```

As you can see the Map values were additionally printed as general properties:

```
"param1_key": "param1_value",
"param2_key": "param2_value"
```

### 2. @JsonGetter annotation
Allows to set key name for certain property:

```
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
```

As you can see @JsonGetter("no_name") changes "name" to "no_name". The next test:

```
@Test
    public void testJsonGetter() throws JsonProcessingException {
        JsonGetterCase jsonGetterCase = new JsonGetterCase();
        jsonGetterCase.setId(UUID.randomUUID());
        jsonGetterCase.setName("name_1");

        String result = new ObjectMapper().writeValueAsString(jsonGetterCase);
        System.out.println(result);
        assertThat(result, containsString("name_1"));
    }
```

prints:

```
{
   "id": "5061c6f5-ff16-4dc8-b762-f2c428e65ba9",
   "no_name": "name_1"
}
```

### 3. @JsonPropertyOrder annotation
Allows to specify the order of current properties:

```
@JsonPropertyOrder({"name", "id"})
public class JsonPropertyOrderCase {
    public UUID id;
    public String name;
}
```

The next test:

```
@Test
    public void testJsonPropertyOrder() throws JsonProcessingException {
        JsonPropertyOrderCase jsonPropertyOrderCase = new JsonPropertyOrderCase();
        jsonPropertyOrderCase.id = UUID.randomUUID();
        jsonPropertyOrderCase.name = "name_1";

        String result = new ObjectMapper().writeValueAsString(jsonPropertyOrderCase);
        System.out.println(result);
        assertThat(result, containsString("name_1"));
    }
```

shows:

```
{
   "name": "name_1",
   "id": "ee624e9f-9fae-4c4b-ae54-e687ce36349e"
}
```

and as you can see the properties order was changed.

### 4. @JsonRawValue annotation
Allows to set property value "as is". It's quite helpful while need to put some json as property value

```
public class JsonRawValueCase {
    public UUID id;
    public String name;

    @JsonRawValue
    public String json;
}
```

The next test:

```
@Test
    public void testJsonRawValue() throws JsonProcessingException {
        JsonRawValueCase jsonRawValueCase = new JsonRawValueCase();
        jsonRawValueCase.id = UUID.randomUUID();
        jsonRawValueCase.name = "name_1";
        jsonRawValueCase.json = "{\"key\":\"value\"}";

        String result = new ObjectMapper().writeValueAsString(jsonRawValueCase);
        System.out.println(result);
        assertThat(result, containsString("name_1"));
    }
```

shows:

```
{
   "id": "538710b5-464e-4526-8458-d07547847ab0",
   "name": "name_1",
   "json": {
      "key": "value"
   }
}
```

### 5. @JsonValue annotation
Applies only for one method per class and allows to specify just property value as output:

```
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
```

The next test:

```
@Test
    public void testJsonValue() throws JsonProcessingException {
        JsonValueCase jsonValueCase = new JsonValueCase();
        jsonValueCase.setName("name_1");
        jsonValueCase.setId(UUID.randomUUID());

        String result = new ObjectMapper().writeValueAsString(jsonValueCase);
        System.out.println(result);
        assertThat(result, containsString("name_1"));
    }
```

returns just:

```
"name_1"
```