package _14_Reflection_Exercises.P03_BarracksWars_ANewFactory.barracksWars;


import _14_Reflection_Exercises.P03_BarracksWars_ANewFactory.barracksWars.core.Engine;
import _14_Reflection_Exercises.P03_BarracksWars_ANewFactory.barracksWars.core.factories.UnitFactoryImpl;
import _14_Reflection_Exercises.P03_BarracksWars_ANewFactory.barracksWars.data.UnitRepository;
import _14_Reflection_Exercises.P03_BarracksWars_ANewFactory.barracksWars.interfaces.Repository;
import _14_Reflection_Exercises.P03_BarracksWars_ANewFactory.barracksWars.interfaces.UnitFactory;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        Runnable engine = new Engine(repository, unitFactory);
        engine.run();
    }
}
