package org.example.springdataautomappingobjects.entities;

//@Entity
//@Table(name = "adresses")
public class Address {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column
    private int id;

//    @Column
    private String country;

//    @Column
    private String city;

//    @OneToMany(cascade = CascadeType.ALL)
//    private List<Employee> employee;


    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    public Address() {
    }

    public Address(String bg, String ruse) {
        this.country = bg;
        this.city = ruse;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

}
