package DefiningClasses_Lab.CarInfo;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main_CarInfo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int cars = Integer.parseInt(scanner.nextLine());

        List<DefiningClasses_Lab.CarInfo.Car> carList = new LinkedList<>();
        for (int i = 0; i < cars; i++) {
            String[] carInfo = scanner.nextLine().split("\\s+");
            String brand = carInfo[0];
            String model = carInfo[1];
            int horsePower = Integer.parseInt(carInfo[2]);

            DefiningClasses_Lab.CarInfo.Car car = new DefiningClasses_Lab.CarInfo.Car(brand, model, horsePower);
            carList.add(car);
        }

        carList.forEach( car -> System.out.print(car.printInfo()));
    }
}
