package org.example.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectToJson {
    public static void main(String[] args) throws JsonProcessingException {
        AddressDTO addressDTO = new AddressDTO("Madrid", "San Francisco", "CA");
        PersonDTO personDTO = new PersonDTO("George", "Pertrov", 23, false, addressDTO);

        ObjectMapper mapper = new ObjectMapper();

        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(personDTO);
        System.out.println(json);
    }
}
