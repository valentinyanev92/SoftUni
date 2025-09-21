package org.example.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonToObject {
    public static void main(String[] args) {
        //Json To Object
        String json = "{\n" +
                "  \"firstName\": \"John\",\n" +
                "  \"lastName\": \"Doe\",\n" +
                "  \"age\": 30,\n" +
                "  \"birthDay\": \"26-07-2025\",\n" +
                "  \"address\": {\n" +
                "    \"country\": \"Bulgaria\",\n" +
                "    \"city\": \"Sofia\"\n" +
                "  },\n" +
                "  \"friends\": [\n" +
                "    \"Sasho\",\n" +
                "    \"George\",\n" +
                "    \"Stoqn\"\n" +
                "  ]\n" +
                "}";

        Gson gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .setDateFormat("yyyy-MM-dd")
                .setPrettyPrinting()
                .serializeNulls()
                .create();

        PersonDTO person = gson.fromJson(json, PersonDTO.class);
//        System.out.println(person);

        //Json to array
        String json2 = "[\n" +
                "  {\n" +
                "    \"firstName\": \"John\",\n" +
                "    \"lastName\": \"Doe\",\n" +
                "    \"age\": 30,\n" +
                "    \"birthDay\": \"26-07-2025\",\n" +
                "    \"address\": {\n" +
                "      \"country\": \"Bulgaria\",\n" +
                "      \"city\": \"Sofia\"\n" +
                "    },\n" +
                "    \"friends\": [\n" +
                "      \"Sasho\",\n" +
                "      \"George\",\n" +
                "      \"Stoqn\"\n" +
                "    ]\n" +
                "  },\n" +
                "  {\n" +
                "    \"firstName\": \"Sasha\",\n" +
                "    \"lastName\": \"Suzanova\",\n" +
                "    \"age\": 30,\n" +
                "    \"birthDay\": \"26-07-2025\",\n" +
                "    \"address\": {\n" +
                "      \"country\": \"Bulgaria\",\n" +
                "      \"city\": \"Sofia\"\n" +
                "    },\n" +
                "    \"friends\": [\n" +
                "      \"Sasha\",\n" +
                "      \"Georgega\",\n" +
                "      \"Stoqnka\"\n" +
                "    ]\n" +
                "  }\n" +
                "]";

        PersonDTO[] personDTOS = gson.fromJson(json2, PersonDTO[].class);
        for (PersonDTO personDTO : personDTOS) {
            System.out.println(personDTO);
        }
    }
}
