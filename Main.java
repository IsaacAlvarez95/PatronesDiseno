import Base.*;
import Decorator.*;
import FactoryMethodEnemy.*;
import FactoryMethodPersonaje.*;
import Strategy.*;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Nombre del héroe: ");
        String nombre = sc.nextLine();

        System.out.println("Elige clase: 1. Guerrero | 2. Mago | 3. Arquero | 4. Pícaro");
        int opcionClase = sc.nextInt();
        CreadorPersonaje creadorHeroe = switch (opcionClase) {
            case 1 -> new CreadorGuerrero();
            case 2 -> new CreadorMago();
            case 3 -> new CreadorArquero();
            default -> new CreadorPicaro();
        };
        Personaje heroe = creadorHeroe.crearPersonaje(nombre);

        boolean equipando = true;
        int itemsEquipados = 0;
        boolean[] itemsTomados = new boolean[5];
        Arrays.fill(itemsTomados, false);
        while (equipando && itemsEquipados < 3) {
            System.out.print("\nEquipar objeto (Max 3):");
            if(!itemsTomados[0]) System.out.print("1. Espada |");
            if(!itemsTomados[1]) System.out.print("2. Armadura |");
            if(!itemsTomados[2]) System.out.print("3. Veneno |");
            if(!itemsTomados[3]) System.out.print("4. Amuleto de Regeneración |");
            if(!itemsTomados[4]) System.out.print("5. Bendición |");
            System.out.println("0. Terminar");
            int opcionItem = sc.nextInt();
            if(opcionItem <= 0) equipando = false;
            else if(!itemsTomados[opcionItem-1]) {
                switch (opcionItem) {
                    case 1 -> heroe = new EspadaDecorator(heroe);
                    case 2 -> heroe = new ArmaduraDecorator(heroe);
                    case 3 -> heroe = new VenenoDecorator(heroe);
                    case 4 -> heroe = new AmuletoRegeneracionDecorator(heroe);
                    case 5 -> heroe = new BendicionDecorator(heroe);
                    case 0 -> equipando = false;
                }
                itemsTomados[opcionItem-1] = true;
                itemsEquipados++;
            }
        }


        System.out.println("\nHéroe: " + heroe.getDescripcion());
        System.out.println("ATK: " + heroe.getAtaque() + " | DEF: " + heroe.getDefensa()
                + " | VEL: " + heroe.getVelocidad() + " | HP: " + heroe.getHp());


        System.out.println("\nElige enemigo: 1. Goblin | 2. Orco");
        int opcionEnemigo = sc.nextInt();
        CreadorEnemigo creadorEnemigo = switch (opcionEnemigo) {
            case 1 -> new CreadorGoblin();
            default -> new CreadorOrco();
        };
        Personaje enemigo = creadorEnemigo.crearEnemigo();
        System.out.println("Enemigo: " + enemigo.getNombre() + " | HP: " + enemigo.getHp() + "\n");

        // 5. Iniciar Combate
        new MotorCombate().iniciarCombate(heroe, enemigo);
        sc.close();
    }
}