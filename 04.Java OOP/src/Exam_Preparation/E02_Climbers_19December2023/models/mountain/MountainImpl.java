package Exam_Preparation.E02_Climbers_19December2023.models.mountain;

import java.util.ArrayList;
import java.util.Collection;

import static Exam_Preparation.E02_Climbers_19December2023.common.ExceptionMessages.MOUNTAIN_NAME_NULL_OR_EMPTY;

public class MountainImpl implements Mountain {

    private String name;
    private Collection<String> peakList;

    public MountainImpl(String name) {
        setName(name);
        this.peakList = new ArrayList<>();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(MOUNTAIN_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public Collection<String> getPeaksList() {
        return peakList;
    }

    @Override
    public String getName() {
        return name;
    }
}
