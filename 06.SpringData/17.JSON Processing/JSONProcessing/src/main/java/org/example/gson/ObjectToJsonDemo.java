package org.example.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.sql.Date;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ObjectToJsonDemo {
    public static void main(String[] args) {
        //Java object into JSON
        AddressDTO address = new AddressDTO("Bulgaria", "Sofia");
        PersonDTO person = new PersonDTO("John", "Doe", 30, true, Date.from(Instant.now()), address);
        PersonDTO person2 = new PersonDTO("Sasha", "Suzanova", 30, false, Date.from(Instant.now()), address);

        Gson gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()       //Only fields with @Expose!
                .setPrettyPrinting()                          //Easy to read format!
                .setDateFormat("dd-MM-YYYY")                  //Data format
                .serializeNulls()                             //Show null!
                .create();

        person.setFriends(List.of("Sasho", "George", "Stoqn"));
        person2.setFriends(List.of("Sasha", "Georgega", "Stoqnka"));

        String json = gson.toJson(person);
//        System.out.println(json);


        //ArrayList of objects to json
        List<PersonDTO> listOfPersons = new ArrayList<>();
        listOfPersons.add(person);
        listOfPersons.add(person2);
        String json2 = gson.toJson(listOfPersons);
        System.out.println(json2);
    }
}
