package Strategy;

import ArtesMarciales.Ataque;

public interface StrategyArteMarcial {

    public Ataque ataque(Jugador ataca,Jugador atacado);
}
