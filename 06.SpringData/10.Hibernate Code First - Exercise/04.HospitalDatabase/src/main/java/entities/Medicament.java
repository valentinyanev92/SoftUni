package entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "medicaments")
public class Medicament extends BaseEntity{

    @Column(name = "name",unique = true, nullable = false)
    private String name;

//    @ManyToOne
//    @JoinColumn(name = "patient_id")
//    private Patient patient;
    @ManyToMany
    @JoinTable(name = "medicaments_patients",
            joinColumns = @JoinColumn(name = "medicament_id"),
            inverseJoinColumns = @JoinColumn(name = "patient_id"))
    private Set<Patient> medicament;

    public Set<Patient> getMedicament() {
        return medicament;
    }

    public void setMedicament(Set<Patient> medicament) {
        this.medicament = medicament;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
