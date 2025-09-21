package softuni.exam.models.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class DealerInputDto {

    @XmlElement(name = "average_monthly_turnover")
    @NotNull
    @Positive
    private String averageMonthlyTurnover;

    @XmlElement(name = "birthday")
    @NotNull
    private String birthday;

    @XmlElement(name = "first_name")
    @NotNull
    @Size(min =  2, max = 30)
    private String firstName;

    @XmlElement(name = "last_name")
    @NotNull
    @Size(min = 2, max = 30)
    private String lastName;

    @XmlElement(name = "salary")
    @NotNull
    @Positive
    private Double salary;

    @XmlElement(name = "offering_car_id")
    @NotNull
    private Long offeringCar;

    public String getAverageMonthlyTurnover() {
        return averageMonthlyTurnover;
    }

    public void setAverageMonthlyTurnover(String averageMonthlyTurnover) {
        this.averageMonthlyTurnover = averageMonthlyTurnover;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Long getOfferingCar() {
        return offeringCar;
    }

    public void setOfferingCar(Long offeringCar) {
        this.offeringCar = offeringCar;
    }
}
