package Exam_Preparation.E01_ElectricCar_8December2024;

import Exam_Preparation.E01_ElectricCar_8December2024.core.Controller;
import Exam_Preparation.E01_ElectricCar_8December2024.core.ControllerImpl;
import Exam_Preparation.E01_ElectricCar_8December2024.core.Engine;
import Exam_Preparation.E01_ElectricCar_8December2024.core.EngineImpl;

public class Main {
    public static void main(String[] args) {

        Controller controller = new ControllerImpl();
        Engine engine = new EngineImpl(controller);
        engine.run();
    }
}