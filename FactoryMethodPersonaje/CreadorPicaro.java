package FactoryMethodPersonaje;

import Base.*;
import Strategy.AtaquePuñalada;

public class CreadorPicaro extends CreadorPersonaje {

    @Override
    public Personaje crearPersonaje(String nombre){
        validarNombre(nombre);
        //Nombre, HP, Atk, Def, Vel
        Personaje p = new PersonajeBase(nombre, 90, 25, 10, 20);
        p.setEstrategia(new AtaquePuñalada());

        return p;
    }
}
