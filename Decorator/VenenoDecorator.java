package Decorator;

import Base.*;

public class VenenoDecorator extends PersonajeDecorator {
    public VenenoDecorator(Personaje personaje) {
        super(personaje);
    }

    @Override
    public int getAtaque() {
        return super.getAtaque() + 5;
    }

    @Override
    public ResultadoAtaque atacar(Personaje objetivo) {
        //Ataque normal
        ResultadoAtaque dano = super.atacar(objetivo);
        int danoFinal = dano.getDano() + 5; // daño por veneno
        return new ResultadoAtaque(danoFinal, dano.isCritico(), dano.getEfecto() + " + Veneno");
    }

    @Override
    public String getDescripcion() {
        return super.getDescripcion() + " + Veneno";
    }
}
