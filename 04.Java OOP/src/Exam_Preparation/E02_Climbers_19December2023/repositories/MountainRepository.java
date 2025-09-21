package Exam_Preparation.E02_Climbers_19December2023.repositories;

import Exam_Preparation.E01_ElectricCar_8December2024.entities.destination.Mountain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class MountainRepository implements Repository<Mountain> {

    private Collection<Mountain> mountains;

    public MountainRepository() {
        this.mountains = new ArrayList<>();
    }

    @Override
    public Collection<Mountain> getCollection() {
        return Collections.unmodifiableCollection(this.mountains);
    }

    @Override
    public void add(Mountain entity) {
        this.mountains.add(entity);
    }

    @Override
    public boolean remove(Mountain entity) {
        return this.mountains.remove(entity);
    }

    @Override
    public Mountain byName(String name) {
        return this.mountains.stream().filter(m -> m.getName().equals(name)).findFirst().orElse(null);
    }
}
