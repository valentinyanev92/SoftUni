package _11_DefiningClasses.CarConstructor;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main_CarConstructor {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int cars = Integer.parseInt(scanner.nextLine());

        List<DefiningClasses_Lab.CarConstructor.Car_Constructor> carList = new LinkedList<>();
        for (int i = 0; i < cars; i++) {
            String[] carInfo = scanner.nextLine().split("\\s+");
            String brand = carInfo[0];
            if (carInfo.length > 1) {
                String model = carInfo[1];
                int horsePower = Integer.parseInt(carInfo[2]);

                DefiningClasses_Lab.CarConstructor.Car_Constructor car = new DefiningClasses_Lab.CarConstructor.Car_Constructor(brand, model, horsePower);
                carList.add(car);
            }else {
                DefiningClasses_Lab.CarConstructor.Car_Constructor car = new DefiningClasses_Lab.CarConstructor.Car_Constructor(brand);
                carList.add(car);

            }
        }

        carList.forEach( car -> System.out.print(car.printInfo()));
    }
}
