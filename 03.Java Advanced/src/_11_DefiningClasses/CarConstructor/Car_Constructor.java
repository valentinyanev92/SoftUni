package DefiningClasses_Lab.CarConstructor;

public class Car_Constructor {

    private String brand;
    private String model;
    private int horsePower;

    public Car_Constructor(String brand) {
        this.brand = brand;
        this.model = "unknown";
        this.horsePower = -1;
    }

    public Car_Constructor(String brand, String model, int horsePower) {
        this.brand = brand;
        this.model = model;
        this.horsePower = horsePower;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public String printInfo() {
        return String.format("The car is: %s %s - %d HP.\n", brand, model, horsePower);
    }
}
