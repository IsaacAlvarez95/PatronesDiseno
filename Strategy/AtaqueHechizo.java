package Strategy;

import Base.*;

public class AtaqueHechizo implements EstrategiaAtaque {

    @Override
    public ResultadoAtaque atacar(Personaje atacante, Personaje objetivo) {
        int dano = Math.max(1, atacante.getAtaque() - (objetivo.getDefensa()/3));
        boolean critico = Math.random() < 0.2;
        int danoFinal;
        if (critico) danoFinal = (int) (dano * 1.5);
        else danoFinal = dano;

        return new ResultadoAtaque(danoFinal, critico, "Hechizo");
    }
}
