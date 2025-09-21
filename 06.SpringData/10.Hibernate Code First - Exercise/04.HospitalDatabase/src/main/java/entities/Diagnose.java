package entities;

import jakarta.persistence.*;

@Entity
@Table(name = "diagnoses")
public class Diagnose extends BaseEntity {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "comments")
    private String comments;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
