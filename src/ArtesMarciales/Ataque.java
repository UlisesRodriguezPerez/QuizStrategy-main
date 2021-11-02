package ArtesMarciales;

import Strategy.Jugador;

public class Ataque {

    private int dano;
    protected String nombre;
    protected Jugador ataca;
    protected Jugador atacado;

    public Ataque(String nombre, int dano){
        this.nombre = nombre;
        this.dano = dano;
    }

    public Ataque(Jugador ataca, Jugador atacado, String nombre, int dano) {
        this.nombre = nombre;
        this.dano = dano;
        this.ataca = ataca;
        this.atacado = atacado;
    }


    public void apply() {
        danar();
    }

    public void danar() {
        atacado.recibirDano(dano);
    }

    public int getDano() {
        return dano;
    }

    public String getNombre() {
        return nombre;
    }

    public String toString() {
        return nombre;

    }

    public Jugador getAtaca() {
        return ataca;
    }

    public void setAtaca(Jugador ataca) {
        this.ataca = ataca;
    }

    public Jugador getAtacado() {
        return atacado;
    }

    public void setAtacado(Jugador atacado) {
        this.atacado = atacado;
    }
}
