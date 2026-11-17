package FactoryMethodPersonaje;

import Base.*;
import Strategy.AtaqueFlecha;

public class CreadorArquero extends CreadorPersonaje {

    @Override
    public Personaje crearPersonaje(String nombre){
        validarNombre(nombre);
        //Nombre, HP, Atk, Def, Vel
        Personaje p = new PersonajeBase(nombre, 110, 20, 15, 25);
        p.setEstrategia(new AtaqueFlecha());

        return p;
    }
}
