package Exam_Preparation.E01_ElectricCar_8December2024.entities.car;

public class BaseCar implements Car {

    private String model;
    private int batteryCapacity;
    private int mileage;

    public BaseCar(String model, int batteryCapacity) {
        this.setModel(model);
        this.setBatteryCapacity(batteryCapacity);
        this.mileage = 0;
    }

    public void setModel(String model) {
        if (model.isEmpty() || model.trim().isEmpty()) {
            throw new IllegalArgumentException("Car model cannot be null or empty.");
        }
        this.model = model;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    @Override
    public int getMileage() {
        return mileage;
    }

    public void setBatteryCapacity(int batteryCapacity) {
        if (batteryCapacity < 0) {
            batteryCapacity = 0;
        }
        this.batteryCapacity = batteryCapacity;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    @Override
    public void drive() {
        this.setBatteryCapacity(getBatteryCapacity() - 15);
        this.setMileage(getMileage() + 25);
    }
}
