import java.util.Scanner;

class Caracol {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final String BORDE = "[__]              [__]";
        final String COCHE = "[__]    O-=-O     [__]";
        final String FONDO = "  []:. :. :. :. :.[] _ __ ";
        final String CARACOL = "  []    _@)_/'    [] _ __ ";
        final String CARACOL_FLOTA = "  []~~~~_@)_/'~~~~[] _ __ ";
        final String AGUA = "  []~~~~~~~~~~~~~~[] _ __ ";
        final String SUELO = "  [][][][][][][][][]";

        final int PROFUNDIDAD_MAX = 20;
        double profundidad = (Math.random() * 10) + 10;
        int dia = 0;
        boolean estaDentro = true;
        boolean estaVivo = true;
        boolean hayCoche;
        int subidaMaxima = 4;
        int nivelDeAgua = PROFUNDIDAD_MAX;
        int lluvia;
        int coche;
        double caido;
        double subido;

        System.out.println("El caracol cayó hasta " + profundidad);

        while (estaDentro && estaVivo) {
            dia++;
            caido = 0;
            subido = 0;
            hayCoche = false;
            if (dia > 20) {
                subidaMaxima = 3;
            } else if (dia > 10) {
                subidaMaxima = 2;
            }
            subido = (Math.random() * subidaMaxima - 1) + 1;
            lluvia = (int) (Math.random() * 100);

            if (lluvia <= 5) {
                nivelDeAgua -= 5;
            } else if (lluvia <= 5 + 10) {
                nivelDeAgua -= 2;
            }
            if (profundidad > nivelDeAgua) {
                profundidad = nivelDeAgua;
            }
            profundidad = profundidad - subido;
            if (profundidad <= 0) {
                estaDentro = false;
            } else {
                coche = (int) (Math.random() * 100);
                if (coche <= 35) {
                    caido += 2;
                    hayCoche = true;
                }
                caido += (Math.random() * 2);
                profundidad = profundidad + caido;
                if (profundidad > nivelDeAgua) {
                profundidad = nivelDeAgua;
            }
            }
            System.out.println("Dia [" + dia + "] / Sube: [" + subido + "] / Baja: [" + caido
                    + "] / Altura al final del día: [-" + profundidad + "]");
            if (dia == 50) {
                estaVivo = false;
            }
            if (hayCoche) {
                System.out.println(COCHE);
            } else {
                System.out.println(BORDE);
            }
            for (int nivel = 0; nivel <= PROFUNDIDAD_MAX; nivel++) {
                if ((int) profundidad == nivelDeAgua && profundidad == nivel) {
                    System.out.println(CARACOL_FLOTA + nivel);
                } else if ((int) profundidad == nivel) {
                    System.out.println(CARACOL + nivel);
                } else if (nivel >= nivelDeAgua) {
                    System.out.println(AGUA + nivel);
                } else {
                    System.out.println(FONDO + nivel);
                }
            }
            System.out.println(SUELO);

            scanner.nextLine();
        }
        if (estaVivo) {
            System.out.println("El caracol ha escapado");
        } else {
            System.out.println("El caracol ha muerto ha una profundidad de " + profundidad);
        }

    }
}