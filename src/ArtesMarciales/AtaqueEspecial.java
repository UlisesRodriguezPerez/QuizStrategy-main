package ArtesMarciales;

import Strategy.Jugador;

public class AtaqueEspecial extends Ataque{
    private int vida;
    private int danoExtra;

    public AtaqueEspecial(String nombre, int dano, int vida, int danoExtra) {
        super(nombre, dano);
        this.vida = vida;
        this.danoExtra = danoExtra;
    }
    
    public AtaqueEspecial(Jugador ataca,Jugador atacado,String nombre, int dano, int vida, int danoExtra) {
        super(ataca,atacado,nombre, dano);
        this.vida = vida;
        this.danoExtra = danoExtra;
        this.ataca = ataca;
        this.atacado = atacado;
    }

    public void danoExtra(){
        atacado.recibirDano(danoExtra);
    }

    public void curar(){
        ataca.cura(vida);
    }

    public void apply(){
        danar();
        danoExtra();
        curar();
    }

    public String toString(){
        String ataqueEspecial = "El " + nombre;
        if(vida > 0)
            ataqueEspecial += "Cura " + vida;
        if(danoExtra > 0 )
            ataqueEspecial += ", Daña" + danoExtra;

        return ataqueEspecial;
    }
}
