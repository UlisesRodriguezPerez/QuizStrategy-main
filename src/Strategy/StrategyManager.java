package Strategy;

import ArtesMarciales.*;
import java.util.ArrayList;

public class StrategyManager {

    private static ArrayList<StrategyArteMarcial> artesMarciales = new ArrayList<>();

    public static StrategyArteMarcial getArteMarcial(int index) {
        return artesMarciales.get(index);
    }

    public static void llenar(){
        artesMarciales.add(new Bananazos("Bananzos","src/ArtesMarciales/ImagenesStrategias/bananazo.jpg"));
        artesMarciales.add(new Boxeo("Boxeo", "src/ArtesMarciales/ImagenesStrategias/boxeo.png"));
        artesMarciales.add(new Gatos("Gatos", "src/ArtesMarciales/ImagenesStrategias/gato-.png"));
        artesMarciales.add(new JiuJitsu("JiuJitsu", "src/ArtesMarciales/ImagenesStrategias/Jiu-Jitsu.jpg"));
        artesMarciales.add(new Judo("Judo", "src/ArtesMarciales/ImagenesStrategias/judo.png"));
        artesMarciales.add(new Karate("Karate", "src/ArtesMarciales/ImagenesStrategias/karate.png"));
        artesMarciales.add(new KungFu("Kungfu", "src/ArtesMarciales/ImagenesStrategias/kungfu.png"));
        artesMarciales.add(new Lucha("Lucha", "src/ArtesMarciales/ImagenesStrategias/lucha.png"));
        artesMarciales.add(new MuaiThai("Muaithai", "src/ArtesMarciales/ImagenesStrategias/muay-thai.jpg"));
        artesMarciales.add(new Taekwondo("Taekwondo", "src/ArtesMarciales/ImagenesStrategias/taekwondo.png"));
    }

    public static ArrayList<StrategyArteMarcial> getArtesMarciales() {
        return artesMarciales;
    }
}
