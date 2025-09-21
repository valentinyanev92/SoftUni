package org.entitiesShampoo;

import jakarta.persistence.*;

@Entity
@Table(name = "shampoos")
public  class Shampoo extends BaseEntity{

    @Column(name = "brand")
    private String brand;

    @OneToOne
    @JoinColumn(nullable = false)
    private Label label;

    @ManyToOne
    @JoinColumn(name = "production_batch_id")
    private ProductionBatch productionBatch;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }
}
