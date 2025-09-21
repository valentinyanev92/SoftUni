package softuni.exam.models.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "sales")
public class Sale extends BaseClass{

    @Column
    private Boolean discounted;

    @Column(nullable = false, unique = true)
    private String number;

    @Column(name = "sale_date", nullable = false)
    private Date saleDate;

    @ManyToOne
    private Seller seller;

    @OneToMany (mappedBy = "sale")
    private Set<Device> devices;

    public Boolean getDiscounted() {
        return discounted;
    }

    public Date getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }

    public void setDiscounted(Boolean discounted) {
        this.discounted = discounted;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }


    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public Set<Device> getDevices() {
        return devices;
    }

    public void setDevices(Set<Device> devices) {
        this.devices = devices;
    }
}
