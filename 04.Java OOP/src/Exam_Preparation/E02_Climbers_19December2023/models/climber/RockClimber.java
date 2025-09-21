package Exam_Preparation.E02_Climbers_19December2023.models.climber;

public class RockClimber extends BaseClimber{

    private static final double INITIAL_STRENGTH = 120;
    private static final double DECREASE_STRENGTH = 60;

    public RockClimber(String name){
        super(name, INITIAL_STRENGTH);
    }

    @Override
    public void climb() {
        if (this.canClimb()) {
            double strength = this.getStrength();

            if (DECREASE_STRENGTH > strength) {
                this.setStrength(0);
            }else {
                this.setStrength(strength - DECREASE_STRENGTH);
            }
        }
    }
}
