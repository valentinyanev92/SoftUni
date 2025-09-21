package Exam_Preparation.E02_Climbers_19December2023.repositories;

import Exam_Preparation.E02_Climbers_19December2023.models.climber.Climber;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class ClimberRepository implements Repository<Climber> {

    private Collection<Climber> climbers;

    public ClimberRepository() {
        this.climbers = new ArrayList<>();
    }

    public void add(Climber climber){
        this.climbers.add(climber);
    }

    public boolean remove(Climber climber){
        return this.climbers.remove(climber);
    }

    public Climber byName(String name){
        return this.climbers.stream().filter(c -> c.getName().equals(name)).findFirst().orElse(null);
    }

    public Collection<Climber> getCollection(){
        return Collections.unmodifiableCollection(this.climbers);
    }
}
