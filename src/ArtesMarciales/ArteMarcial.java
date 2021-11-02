package ArtesMarciales;

import Strategy.Jugador;
import Strategy.StrategyArteMarcial;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;


public abstract class ArteMarcial implements StrategyArteMarcial {

    private String nombre;
    private String imagen;
    protected ArrayList<Ataque> ataques = new ArrayList<>();

    public ArteMarcial(String nombre, String imagen) {
        this.nombre = nombre;
        this.imagen = imagen;
    }

    public Ataque ataque(Jugador ataca, Jugador atacado){
        int index = ThreadLocalRandom.current().nextInt(0, 3);
        switch (index){
            case 0:
                return ataque1(ataca, atacado);
            case 1:
                return ataque2(ataca, atacado);
            case 2:
                return ataque3(ataca, atacado);
            default:
                return null;
        }
    }

    public abstract Ataque ataque1(Jugador ataca,Jugador atacado);
    public abstract Ataque ataque2(Jugador ataca,Jugador atacado);
    public abstract AtaqueEspecial ataque3(Jugador ataca,Jugador atacado);

    public String getNombre() {
        return nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public ArrayList<Ataque> getAtaques() {
        return ataques;
    }
}
