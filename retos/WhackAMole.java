import java.util.Scanner;

class WhackAMole {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final String AGUJERO = "(  )";
        final String AGUJERO_CON_MONIGOTE = "('')";
        final String AGUJERO_GOLPEADO = "[[]]";
        final String AGUJERO_CON_MONIGOTE_GOLPEADO = "[**]";
        final int TURNOS_MAXIMOS = 15;
        int aciertos=0;
        for (int turno = 1; turno <= TURNOS_MAXIMOS; turno++) {
            System.out.println("Turno:["+turno+"] / Aciertos:["+aciertos+"]");
            System.out.println("Golpe (entre 1 y 16)");
            int jugador = scanner.nextInt();
            int topo1 = (int) (Math.random() * 16) + 1;
            int topo2 = 0;
            boolean topoIgual = true;
            while (topoIgual) {
                topo2 = (int) (Math.random() * 16) + 1;
                topoIgual = topo1 == topo2;
            }
            for (int i = 1; i <= 16; i++) {
                if (i == topo1 && i == jugador) {
                    System.out.print(AGUJERO_CON_MONIGOTE_GOLPEADO);
                    aciertos++;
                } else if (i == topo2 && i == jugador) {
                    System.out.print(AGUJERO_CON_MONIGOTE_GOLPEADO);
                    aciertos++;
                } else if (i == topo1) {
                    System.out.print(AGUJERO_CON_MONIGOTE);
                } else if (i == jugador) {
                    System.out.print(AGUJERO_GOLPEADO);
                } else if (i == topo2) {
                    System.out.print(AGUJERO_CON_MONIGOTE);
                } else
                    System.out.print(AGUJERO);

                if (i % 4 == 0) {
                    System.out.println();
                }
            }
        }
        System.out.println("Fin de la partida.");
        System.out.println("Aciertos totales: "+aciertos);
        scanner.close();
    }
}
