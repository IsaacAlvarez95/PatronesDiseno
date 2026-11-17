package Decorator;

import Base.*;

public class ArmaduraDecorator extends PersonajeDecorator {
    public ArmaduraDecorator(Personaje personaje) {
        super(personaje);
    }

    @Override
    public int getDefensa() {
        return super.getDefensa() + 10;
    }

    @Override
    public String getDescripcion() {
        return super.getDescripcion() + " + Armadura";
    }
}
