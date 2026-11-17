package Decorator;

import Base.*;

public class AmuletoRegeneracionDecorator extends PersonajeDecorator {
    public AmuletoRegeneracionDecorator(Personaje personaje) {
        super(personaje);
    }

    @Override
    public int getDefensa() {
        return super.getDefensa() + 5;
    }

    @Override
    public ResultadoAtaque atacar(Personaje objetivo) {
        setHp(getHp() + 5);
        ResultadoAtaque dano = super.atacar(objetivo);
        return new ResultadoAtaque(dano.getDano(), dano.isCritico(), dano.getEfecto() + " (+5 HP regenerados)");
    }

    @Override
    public String getDescripcion() {
        return super.getDescripcion() + " + Amuleto Regeneración";
    }
}
