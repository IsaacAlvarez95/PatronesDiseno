package Decorator;

import Base.*;

public class BendicionDecorator extends PersonajeDecorator {
    public BendicionDecorator(Personaje personaje) {
        super(personaje);
    }

    @Override
    public int getAtaque() {
        return (int) Math.round(super.getAtaque() * 1.1);
    }

    @Override
    public int getDefensa() {
        return (int) Math.round(super.getDefensa() * 1.1);
    }

    @Override
    public int getVelocidad() {
        return (int) Math.round(super.getVelocidad() * 1.1);
    }

    @Override
    public String getDescripcion() {
        return super.getDescripcion() + " + Bendición";
    }
}