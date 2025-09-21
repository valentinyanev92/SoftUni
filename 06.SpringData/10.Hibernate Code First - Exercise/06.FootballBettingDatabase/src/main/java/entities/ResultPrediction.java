package entities;

import jakarta.persistence.*;
import values.PredictionTypes;

@Entity
@Table(name = "result_predictions")
public class ResultPrediction extends BaseEntity{

    @Enumerated(EnumType.STRING)
    @Column(name = "prediction")
    private PredictionTypes prediction;

    public PredictionTypes getPrediction() {
        return prediction;
    }

    public void setPrediction(PredictionTypes prediction) {
        this.prediction = prediction;
    }
}

