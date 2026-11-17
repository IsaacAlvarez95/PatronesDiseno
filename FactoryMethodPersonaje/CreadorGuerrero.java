package FactoryMethodPersonaje;

import Base.*;
import Strategy.AtaqueEspada;

public class CreadorGuerrero extends CreadorPersonaje {

    @Override
    public Personaje crearPersonaje(String nombre){
        validarNombre(nombre);
        //Nombre, HP, Atk, Def, Vel
        Personaje p = new PersonajeBase(nombre, 120, 25, 15, 15);
        p.setEstrategia(new AtaqueEspada());

        return p;
    }

}
