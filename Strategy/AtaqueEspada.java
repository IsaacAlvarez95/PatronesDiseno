package Strategy;

import Base.*;

public class AtaqueEspada implements EstrategiaAtaque{

    @Override
    public ResultadoAtaque atacar(Personaje atacante, Personaje objetivo) {
        int dano = Math.max(1, atacante.getAtaque() - (objetivo.getDefensa()/4));
        boolean critico = Math.random() < 0.1;
        int danoFinal;
        if (critico) danoFinal = (int) (dano * 1.5);
        else danoFinal = dano;

        return new ResultadoAtaque(danoFinal, critico, "Corte");
    }
}
