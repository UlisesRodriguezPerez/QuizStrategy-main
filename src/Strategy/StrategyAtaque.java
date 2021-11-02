package Strategy;

import ArtesMarciales.Ataque;

import java.util.ArrayList;

public abstract class StrategyAtaque {

    Jugador jugador;

    public StrategyAtaque(Jugador jugador){
        this.jugador = jugador;
    }

    public abstract ArrayList<Ataque> ataque();
}
