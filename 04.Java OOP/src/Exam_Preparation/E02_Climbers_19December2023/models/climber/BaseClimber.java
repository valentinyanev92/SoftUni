package Exam_Preparation.E02_Climbers_19December2023.models.climber;


import Exam_Preparation.E02_Climbers_19December2023.models.roster.Roster;
import Exam_Preparation.E02_Climbers_19December2023.models.roster.RosterImpl;

import static Exam_Preparation.E02_Climbers_19December2023.common.ExceptionMessages.CLIMBER_NAME_NULL_OR_EMPTY;
import static Exam_Preparation.E02_Climbers_19December2023.common.ExceptionMessages.CLIMBER_STRENGTH_LESS_THAN_ZERO;

public abstract class BaseClimber implements Climber {

    private String name;
    private double strength;
    private Roster roster;

    BaseClimber(String name, double strength) {
        setName(name);
        setStrength(strength);
        this.roster = new RosterImpl();
    }

    private void setName(String name) {
        name = name.trim();
        if (name.trim().isEmpty()) {
            throw new NullPointerException(CLIMBER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    protected void setStrength(double strength) {
        if (strength < 0) {
            throw new IllegalArgumentException(CLIMBER_STRENGTH_LESS_THAN_ZERO);
        }
        this.strength = strength;
    }

    private void setRoster(Roster roster) {
        this.roster = roster;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getStrength() {
        return this.strength;
    }

    @Override
    public boolean canClimb() {
        return this.strength > 0;
    }

    @Override
    public Roster getRoster() {
        return this.roster;
    }

    @Override
    public abstract void climb();
}
