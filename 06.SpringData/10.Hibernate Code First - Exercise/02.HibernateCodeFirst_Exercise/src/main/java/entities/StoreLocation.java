package entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "store_location")
public class StoreLocation extends BaseEntity {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    private int id;

    @Column(name = "location_name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "storeLocation")
    private Set<Sale> sales;

    public String getLocationName() {
        return name;
    }

    public void setLocationName(String locationName) {
        this.name = locationName;
    }

    public Set<Sale> getSales() {
        return sales;
    }

    public void setSales(Set<Sale> sales) {
        this.sales = sales;
    }
}
