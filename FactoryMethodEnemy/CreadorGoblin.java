package FactoryMethodEnemy;

import Base.*;
import Strategy.AtaqueFlecha;

public class CreadorGoblin extends CreadorEnemigo{

    @Override
    public Personaje crearEnemigo(){
        //Nombre, HP, atk, def, vel
        Personaje p = new PersonajeBase("Goblin", 50, 20, 5, 10);
        p.setEstrategia(new AtaqueFlecha());

        return p;
    }

}
