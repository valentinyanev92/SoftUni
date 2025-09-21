package org.example.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonToObject {
    public static void main(String[] args) throws JsonProcessingException {

        String json = "{\n" +
                "  \"firstName\" : \"George\",\n" +
                "  \"lastName\" : \"Pertrov\",\n" +
                "  \"age\" : 23,\n" +
                "  \"address\" : {\n" +
                "    \"country\" : \"Madrid\",\n" +
                "    \"city\" : \"San Francisco\",\n" +
                "    \"street\" : \"CA\"\n" +
                "  },\n" +
                "  \"married\" : false\n" +
                "}";

        ObjectMapper mapper = new ObjectMapper();

        PersonDTO personDTO = mapper.readValue(json, PersonDTO.class);
        System.out.println(personDTO);
    }
}
