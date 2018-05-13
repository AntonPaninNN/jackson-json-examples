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
```\s\s
