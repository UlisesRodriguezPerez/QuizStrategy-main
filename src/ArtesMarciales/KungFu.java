package ArtesMarciales;
import Strategy.Jugador;

public class KungFu extends ArteMarcial{

    public KungFu(String nombre, String imagen) {
        super(nombre, imagen);
        setAtaques();
    }

    public Ataque ataque1(Jugador ataca, Jugador atacado){
        this.ataques.get(0).setAtaca(ataca);
        this.ataques.get(0).setAtacado(atacado);
        return this.ataques.get(0);
    }

    public Ataque ataque2(Jugador ataca, Jugador atacado){
        this.ataques.get(1).setAtaca(ataca);
        this.ataques.get(1).setAtacado(atacado);
        return this.ataques.get(1);
    }

    public AtaqueEspecial ataque3(Jugador ataca, Jugador atacado){
        this.ataques.get(2).setAtaca(ataca);
        this.ataques.get(2).setAtacado(atacado);
        return (AtaqueEspecial) this.ataques.get(2);
    }

    public void setAtaques(){
        this.ataques.add(new Ataque("Puños", 30));
        this.ataques.add(new Ataque("Kuan tsu",41));
        this.ataques.add(new AtaqueEspecial("Pei tsu",45, 30, 14));
    }

}
