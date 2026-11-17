package Base;

public class MotorCombate {

    public void iniciarCombate(Personaje heroe, Personaje enemigo) {
        System.out.println("=== COMBATE INICIADO ===");
        int turno = 1;
        while (heroe.getHp() > 0 && enemigo.getHp() > 0) {
            System.out.println("\n--- TURNO " + turno + " ---");
            ejecutarTurno(heroe, enemigo);
            if (enemigo.getHp() <= 0) break;
            ejecutarTurno(enemigo, heroe);
            turno++;
        }
        System.out.println("\n=== COMBATE FINALIZADO ===");
        if (heroe.getHp() > 0)
            System.out.println("Ganador: " + heroe.getDescripcion()
                    + " (HP restante: " + heroe.getHp() + ")");
        else
            System.out.println("Ganador: " + enemigo.getNombre()
                    + " (HP restante: " + enemigo.getHp() + ")");
    }

    private void ejecutarTurno(Personaje atacante, Personaje defensor) {
        ResultadoAtaque r = atacante.atacar(defensor);
        System.out.println(atacante.getDescripcion() + " usa "
                + atacante.getEstrategia().getClass().getSimpleName()
                + " sobre " + defensor.getNombre());
        System.out.println("  Daño: " + r.getDano()
                + (r.isCritico() ? " (¡CRÍTICO!)" : "")
                + " | Efecto: " + r.getEfecto());
        defensor.setHp(defensor.getHp() - r.getDano());
        System.out.println("  " + defensor.getNombre() + " HP: "
                + Math.max(0, defensor.getHp() + r.getDano()) + " -> " + defensor.getHp());
    }
}
