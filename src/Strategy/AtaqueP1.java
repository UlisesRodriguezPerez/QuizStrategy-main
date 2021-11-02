package Strategy;

import ArtesMarciales.Ataque;
import Strategy.Jugador;
import Strategy.StrategyAtaque;
import java.util.concurrent.ThreadLocalRandom;

import java.util.ArrayList;


public class AtaqueP1 extends StrategyAtaque {

    public AtaqueP1(Jugador jugador){
        super(jugador);
    }

    @Override
    public ArrayList<Ataque> ataque() {
        ArrayList<Ataque> ataques = new ArrayList<>();
        int numeroDeAtaques = ThreadLocalRandom.current().nextInt(3, 6);

        for (int i = 0; i<numeroDeAtaques;i++){
            ataques.add(jugador.arteMarcialActual.ataque(jugador,jugador.enemigo));
//            System.out.println(jugador.arteMarcialActual.ataque(jugador,jugador.enemigo));
        }
        return ataques;
    }

}
