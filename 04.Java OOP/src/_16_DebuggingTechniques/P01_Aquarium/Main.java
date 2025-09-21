package _16_DebuggingTechniques.P01_Aquarium;


import _16_DebuggingTechniques.P01_Aquarium.core.EngineImpl;
import _16_DebuggingTechniques.P01_Aquarium.core.interfaces.Engine;

public class Main {
    public static void main(String[] args) {
        Engine engine = new EngineImpl();
        engine.run();
    }
}
