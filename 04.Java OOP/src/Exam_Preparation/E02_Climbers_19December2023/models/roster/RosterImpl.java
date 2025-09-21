package Exam_Preparation.E02_Climbers_19December2023.models.roster;

import java.util.ArrayList;
import java.util.Collection;

public class RosterImpl implements Roster {

    private Collection<String> peaks;

    public RosterImpl() {
        this.peaks = new ArrayList<>();
    }

    @Override
    public Collection<String> getPeaks() {
        return this.peaks;
    }
}
