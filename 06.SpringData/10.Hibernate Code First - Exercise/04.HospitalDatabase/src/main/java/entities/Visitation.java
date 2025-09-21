package entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "visitations")
public class Visitation extends BaseEntity{

    @Column(name = "date", nullable = false)
    private LocalDate date;

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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
