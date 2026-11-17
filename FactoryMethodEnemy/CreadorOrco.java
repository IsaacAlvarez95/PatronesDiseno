package FactoryMethodEnemy;

import Base.*;
import Strategy.AtaqueEspada;

public class CreadorOrco extends CreadorEnemigo {

    @Override
    public Personaje crearEnemigo(){
        //Nombre, HP, atk, def, vel
        Personaje p = new PersonajeBase("Orco", 240, 30, 15, 15);
        p.setEstrategia(new AtaqueEspada());
        return p;
    }
}
