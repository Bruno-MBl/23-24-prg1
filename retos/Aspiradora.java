import java.util.Scanner;

public class Aspiradora {

    static final int NUMERO_SOFAS = 15;
    static final int PROBABILIDAD_SUCIEDAD_1 = 20;
    static final int PROBABILIDAD_SUCIEDAD_2 = 10;
    static final int PROBABILIDAD_SUCIEDAD_3 = 4;
    static final int PROBABILIDAD_SUCIEDAD_4 = 2;

    public static void main(String[] args) {
        final String GATO = "\"^\"";
        int[][] oficina = new int[10][25];
        int[] aspiradora = { 0, 0 };
        ensuciarOficina(oficina);
        añadirSofa(oficina);
        while (true) {
            mostrarOficina(oficina, aspiradora);
            moverAspiradoraAleatorio(aspiradora, oficina);
        }
    }

    private static void moverAspiradoraAleatorio(int[] aspiradora, int[][] oficina) {
        int[] movimiento = { 0, 0 };
        boolean puedeMoverse;
        do {
            movimiento[0] = 0;
            movimiento[1] = 0;
            int direccion = (int) (Math.random() * 7);
            if (direccion == 0 || direccion == 6 || direccion == 7) {
                movimiento[0] = -1;
            }
            if (direccion == 0 || direccion == 1 || direccion == 2) {
                movimiento[1] = 1;
            }
            if (direccion == 2 || direccion == 3 || direccion == 4) {
                movimiento[0] = 1;
            }
            if (direccion == 4 || direccion == 5 || direccion == 6) {
                movimiento[1] = -1;
            }
            movimiento[0] += aspiradora[0];
            movimiento[1] += aspiradora[1];
            puedeMoverse = movimiento[0] >= 0 && movimiento[0] < oficina.length && movimiento[1] >= 0
                    && movimiento[1] < oficina[0].length;
            if (puedeMoverse) {
                puedeMoverse = oficina[movimiento[0]][movimiento[1]] < 5;
            }
        } while (!puedeMoverse);
        aspiradora[0] = movimiento[0];
        aspiradora[1] = movimiento[1];
    }

    private static void moverAspiradoraAutomatico(int[] aspiradora, int[][] oficina) {
        int mayorSuciedad = 0;
        int[] suciedadMasProxima = new int[2];
        for (int i = 0; i < oficina.length; i++) {
            for (int j = 0; j < oficina[i].length; j++) {
                if (oficina[i][j] > mayorSuciedad && oficina[i][j] <= 4) {
                    mayorSuciedad = oficina[i][j];
                    if ((Math.abs(aspiradora[0] - i)
                            + Math.abs(aspiradora[0] - j)) < (Math.abs(aspiradora[0] - suciedadMasProxima[0])
                                    + Math.abs(aspiradora[1] - suciedadMasProxima[1]))) {
                        suciedadMasProxima[0]=i;
                        suciedadMasProxima[1]=j;
                    }
                }
            }
        }
    }

    private static void añadirSofa(int[][] oficina) {
        int[][] sofas = new int[NUMERO_SOFAS][2];
        for (int sofa = 0; sofa < NUMERO_SOFAS; sofa++) {
            sofas[sofa][0] = (int) (Math.random() * oficina.length);
            sofas[sofa][1] = (int) (Math.random() * oficina[0].length - 1);
            oficina[sofas[sofa][0]][sofas[sofa][1]] = 5;
        }
    }

    private static void ensuciarOficina(int[][] oficina) {
        for (int i = 0; i < oficina.length; i++) {
            for (int j = 0; j < oficina[i].length; j++) {
                if (PROBABILIDAD_SUCIEDAD_1 > random())
                    oficina[i][j] = 1;
                else if (PROBABILIDAD_SUCIEDAD_2 > random())
                    oficina[i][j] = 2;
                else if (PROBABILIDAD_SUCIEDAD_3 > random())
                    oficina[i][j] = 3;
                else if (PROBABILIDAD_SUCIEDAD_4 > random())
                    oficina[i][j] = 4;
            }
        }
    }

    private static void mostrarOficina(int[][] oficina, int[] aspiradora) {
        for (int i = 0; i < oficina.length; i++) {
            for (int j = 0; j < oficina[i].length; j++) {
                if (aspiradora[0] == i && aspiradora[1] == j) {
                    System.out.print("(0)");
                    oficina[i][j] -= oficina[i][j] > 0 ? 1 : 0;
                } else
                    System.out.print(traducir(oficina[i][j]));
            }
            System.out.println();
        }
        new Scanner(System.in).nextLine();
    }

    private static String traducir(int i) {
        String[] elementos = { " . ", "...", "ooo", "OOO", "***", "[#]" };
        return elementos[i];
    }

    private static int random() {
        return (int) (Math.random() * 100);
    }
}