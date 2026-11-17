package FactoryMethodPersonaje;

import Base.*;
import Strategy.AtaqueHechizo;

public class CreadorMago extends CreadorPersonaje {

    @Override
    public Personaje crearPersonaje(String nombre){
        validarNombre(nombre);
        //Nombre, HP, Atk, Def, Vel
        Personaje p = new PersonajeBase(nombre, 100, 20, 10, 20);
        p.setEstrategia(new AtaqueHechizo());

        return p;
    }
}
