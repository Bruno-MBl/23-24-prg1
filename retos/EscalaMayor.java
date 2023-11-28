import java.util.Scanner;

class EscalaMayor {
    public static void main(String[] args) {
        int nota = seleccionarNota();
        String[] notasEscala = calcularEscala(nota);
        calcularAcorde(notasEscala);

    }

    private static void calcularAcorde(String[] notasEscala) {
        System.out.println("El acorde de " + notasEscala[0] + " mayor esta conformado por:");
        System.out.print("[" + notasEscala[0] + "] / [" + notasEscala[2] + "] / [" + notasEscala[4] + "]");
    }

    private static String[] calcularEscala(int nota) {
        final int TONO = 2;
        final int SEMITONO = 1;
        String[] notas = { "Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si", "Do", "Do#",
                "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si" };
        int[] escalaMayor = { TONO, TONO, SEMITONO, TONO, TONO, TONO, SEMITONO };
        String[] notasEscala = new String[8];

        System.out.println("La escala de " + notas[nota] + " es:");
        for (int notaEscala = 0; notaEscala < notasEscala.length; notaEscala++) {
            notasEscala[notaEscala] = notas[nota];
            System.out.print("[" + notas[nota] + "] ");
            if (notaEscala < escalaMayor.length) {
                nota += escalaMayor[notaEscala];
            }
        }
        System.out.println();
        return notasEscala;
    }

    static int seleccionarNota() {
        Scanner scanner = new Scanner(System.in);
        String[] notas = { "Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si" };
        System.out.println("Ingrese una nota a trabajar:");
        for (int nota = 0; nota < notas.length; nota++) {
            System.out.print(nota + 1 + ":" + notas[nota] + "  ");
        }
        System.out.println();
        return (scanner.nextInt() - 1);
    }
}
