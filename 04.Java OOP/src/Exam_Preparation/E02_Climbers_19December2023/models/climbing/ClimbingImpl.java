package Exam_Preparation.E02_Climbers_19December2023.models.climbing;

import Exam_Preparation.E02_Climbers_19December2023.models.climber.Climber;
import Exam_Preparation.E02_Climbers_19December2023.models.mountain.Mountain;

import java.util.Collection;

public class ClimbingImpl implements Climbing {

    @Override
    public void conqueringPeaks(Mountain mountain, Collection<Climber> climbers) {

        // TODO : not sure if it work !

        Collection<String> peaksList = mountain.getPeaksList();

        for (String peak : peaksList) {
            for (Climber climber : climbers) {
                if (climber.canClimb()){
                    climber.climb();
                    climber.getRoster().getPeaks().add(peak);
                    while (climber.canClimb()) {
                        climber.climb();
                    }
                }
            }
        }
    }
}
