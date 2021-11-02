package Strategy;

import ArtesMarciales.ArteMarcial;
import ArtesMarciales.Ataque;
import Strategy.StrategyArteMarcial;
import Strategy.StrategyAtaque;
import Strategy.StrategyManager;
import Vista.AttackStrategiesEnum;

import java.util.ArrayList;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Jugador {

    public ArrayList<ArteMarcial> artesMarciales;
    private StrategyAtaque estrategiaAtaque;
    public ArteMarcial arteMarcialActual;
    private int vida;
    public Jugador enemigo;
    public ArrayList<ArteMarcial> artesEscogidas = new ArrayList<>();

    public Jugador(){
        this.vida = 2000;
        reasignarArtesMarciales();
    }

    public void reasignarArtesMarciales(){
        artesMarciales = new ArrayList<>();
        for(int i = 0;i<3;i++){
            int index = ThreadLocalRandom.current().nextInt(0, StrategyManager.getArtesMarciales().size());
            artesMarciales.add((ArteMarcial) StrategyManager.getArteMarcial(index));
//            artesMarciales.remove((ArteMarcial) StrategyManager.getArteMarcial(index));
        }
    }

    public void setEstrategiaAtaque(AttackStrategiesEnum attackType) {
        switch (attackType){
            case PLAYER1:
                this.estrategiaAtaque = new AtaqueP1(this);
                break;
            case PLAYER2:
                this.estrategiaAtaque = new AtaqueP2(this);
                break;
        }
    }

    public ArrayList<Ataque> getCombo(){
        return estrategiaAtaque.ataque();
    }

    public String recibirAtaques(ArrayList<Ataque> ataques){
        StringBuilder comboString = new StringBuilder();
        for (Ataque ataque:ataques) {
            ataque.apply();
            comboString.append(ataque);
        }
        return comboString.toString();
    }

    public void setEnemigo(Jugador enemigo) {
        this.enemigo = enemigo;
    }

    public void cura(int cura) {
        this.vida += cura;
    }

    public void recibirDano(int dano) {
        this.vida -= dano;
    }

    public StrategyAtaque getEstrategiaAtaque() {
        return estrategiaAtaque;
    }

    public StrategyArteMarcial getArteMarcialActual() {
        return arteMarcialActual;
    }

    public void setArteMarcialActual(ArteMarcial arteMarcialActual) {
        this.arteMarcialActual = arteMarcialActual;
    }

    public int getVida() {
        return vida;
    }

    public Jugador getEnemigo() {
        return enemigo;
    }

    //Desde pantalla
    //Cuando se toca generar combo => ataques1 = getCombo() , ataques2 = getCombo()
    //Cuando se ataca => Jugador1.recibirAtaques(ataques2)
    //Jugador2.recibirAtaques(ataque1)
    //Tomar en cuenta que ya se tiene el enemigo adentro...
}
