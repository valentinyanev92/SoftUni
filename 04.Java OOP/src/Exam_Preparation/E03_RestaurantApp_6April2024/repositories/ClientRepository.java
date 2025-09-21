package Exam_Preparation.E03_RestaurantApp_6April2024.repositories;

import Exam_Preparation.E03_RestaurantApp_6April2024.models.client.Client;

import java.util.*;

public class ClientRepository implements Repository<Client> {

    private final Map<String, Client> clients;


    //TODO: not sure for constructor
    public ClientRepository() {
        this.clients = new LinkedHashMap<>();
    }


    @Override
    public Collection<Client> getCollection() {
        return Collections.unmodifiableCollection(clients.values());
    }

    @Override
    public void add(Client entity) {
            clients.put(entity.getName(), entity);

    }

    @Override
    public boolean remove(Client entity) {
        return clients.remove(entity.getName(), entity);
    }

    @Override
    public Client byName(String name) {
        return clients.get(name);
    }
}
