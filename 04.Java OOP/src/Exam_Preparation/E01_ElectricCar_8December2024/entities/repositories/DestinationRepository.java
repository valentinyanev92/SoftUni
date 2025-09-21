package Exam_Preparation.E01_ElectricCar_8December2024.entities.repositories;

import Exam_Preparation.E01_ElectricCar_8December2024.entities.destination.Destination;

import java.util.*;

public class DestinationRepository implements Repository<Destination> {

    private final Map<String, Destination> destinations;

    public DestinationRepository() {
        this.destinations = new HashMap<>();
    }

    @Override
    public Collection<Destination> getCollection() {
        return Collections.unmodifiableCollection(destinations.values());
    }

    @Override
    public void add(Destination destination) {
        this.destinations.put(destination.getName(), destination);
    }

    @Override
    public boolean remove(Destination destination) {
        return this.destinations.remove(destination.getName()) != null;
    }

    @Override
    public Destination byName(String name) {
        return destinations.get(name);
    }
}
