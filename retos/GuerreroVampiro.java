import java.util.Scanner;

class GuerreroVampiro {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int PROBABILIDAD_ARMA_1 = 50;
        final int PROBABILIDAD_ARMA_2 = 25;
        final int PROBABILIDAD_ARMA_3 = 12;
        final int PROBABILIDAD_DEFENDERSE = 80;
        final int OPCION_ARMA_1 = 1;
        final int OPCION_ARMA_2 = 2;
        final int OPCION_ARMA_3 = 3;
        final int OPCION_DEFENDERSE = 4;
        final int OPCION_POCION = 5;
        final int DAÑO_ARMA_1 = 7;
        final int DAÑO_ARMA_2 = 15;
        final int DAÑO_ARMA_3 = 30;
        final int DAÑO_BLOQUEADO = 5;

        final int PROBABILIDAD_ATAQUE_1 = 90;
        final int PROBABILIDAD_ATAQUE_2 = 60;
        final int PROBABILIDAD_ATAQUE_3 = 40;
        final int OPCION_ATAQUE_1 = 1;
        final int OPCION_ATAQUE_2 = 2;
        final int DAÑO_ATAQUE_1 = 5;
        final int DAÑO_ATAQUE_2 = 10;
        final int DAÑO_ATAQUE_3 = 20;

        final int VIDA_MAXIMA_GUERRERO = 150;
        boolean guerreroVivo;
        boolean vampiroVivo;
        int vidaGuerrero = VIDA_MAXIMA_GUERRERO;
        int vidaVampiro = 60;
        int turnosDePocion = 0;
        do {
            System.out.println("Vida del guerrero: " + vidaGuerrero);
            System.out.println("Vida del vampiro: " + vidaVampiro);
            boolean opcionValida = false;
            int ataqueVampiro = 0;
            int ataqueGuerrero = 0;
            boolean guerreroDesmayado = vidaGuerrero < 30;
            boolean vampiroDesmayado = vidaVampiro < 20;
            if (turnosDePocion > 0) {
                turnosDePocion--;
                if (turnosDePocion == 0)
                    vidaGuerrero = VIDA_MAXIMA_GUERRERO;
            } else if (guerreroDesmayado) {
                System.out.println("Estas desmayado");
                vidaGuerrero += 2;
            } else {
                while (!opcionValida) {
                    opcionValida = true;
                    System.out.print("""
                            ===============================================================================
                            | Que accion quieres tomar:                                                   |
                            |    -(1) Atacar con la daga. Daño: 7, Probabilidad de acierto: 50%           |
                            |    -(2) Atacar con la espada. Daño: 15, Probabilidad de acierto: 25%        |
                            |    -(3) Atacar con el hacha. Daño: 30, Probabilidad de acierto: 12%         |
                            |    -(4) Defenderte. Daño bloqueado: 5, Probabilidad de exito: 80%           |
                            |    -(5) Tomarse una pocion. No se podran realizar acciones durante 3 turnos |
                            ===============================================================================
                            """);
                    int opcion = scanner.nextInt();
                    double probabilidadExito = Math.random() * 100;
                    if (opcion == OPCION_ARMA_1) {
                        System.out.println("Atacas con la daga");
                        if (PROBABILIDAD_ARMA_1 > probabilidadExito) {
                            System.out.println("El vampiro recibe el golpe");
                            ataqueGuerrero = DAÑO_ARMA_1;
                        } else
                            System.out.println("Fallaste el ataque");
                    } else if (opcion == OPCION_ARMA_2) {
                        System.out.println("Atacas con la espada");
                        if (PROBABILIDAD_ARMA_2 > probabilidadExito) {
                            System.out.println("El vampiro recibe el golpe");
                            ataqueGuerrero = DAÑO_ARMA_2;
                        } else
                            System.out.println("Fallaste el ataque");
                    } else if (opcion == OPCION_ARMA_3) {
                        System.out.println("Atacas con el hacha");
                        if (PROBABILIDAD_ARMA_3 > probabilidadExito) {
                            System.out.println("El vampiro recibe el golpe");
                            ataqueGuerrero = DAÑO_ARMA_3;
                        } else
                            System.out.println("Fallaste el ataque");
                    } else if (opcion == OPCION_DEFENDERSE) {
                        System.out.println("Decides bloquear el ataque");
                        if (PROBABILIDAD_DEFENDERSE > probabilidadExito) {
                            System.out.println("Bloqueas con exito");
                            ataqueVampiro -= DAÑO_BLOQUEADO;
                        } else
                            System.out.println("Fallaste el bloqueo");
                    } else if (opcion == OPCION_POCION) {
                        System.out.println("Decides tomarte una pocion");
                        turnosDePocion = 3;
                    } else {
                        System.out.println("Esa no es una accion valida");
                        opcionValida = false;
                    }
                }
            }
            vidaVampiro -= ataqueGuerrero;
            vampiroVivo = vidaVampiro > 0;
            if (vampiroVivo) {
                if (vampiroDesmayado) {
                    System.out.println("El vampiro esta desmayado");
                    vidaVampiro += 2;
                } else {
                    System.out.println("El vampiro ataca");
                    int ataque = (int) (Math.random() * 3) + 1;
                    double probabilidadExito = Math.random() * 100;
                    if (ataque == OPCION_ATAQUE_1) {
                        if (PROBABILIDAD_ATAQUE_1 > probabilidadExito) {
                            System.out.println("El vampiro te araña haciendote 5 de daño");
                            ataqueVampiro += DAÑO_ATAQUE_1;
                        } else
                            System.out.println("El vampiro falla su ataque");
                    } else if (ataque == OPCION_ATAQUE_2) {
                        if (PROBABILIDAD_ATAQUE_2 > probabilidadExito) {
                            System.out.println("El vampiro te golpea haciendote 10 de daño");
                            ataqueVampiro += DAÑO_ATAQUE_2;
                        } else
                            System.out.println("El vampiro falla su ataque");
                    } else {
                        if (PROBABILIDAD_ATAQUE_3 > probabilidadExito) {
                            System.out.println("El vampiro te muerde haciendote 20 de daño");
                            ataqueVampiro += DAÑO_ATAQUE_3;
                        } else
                            System.out.println("El vampiro falla su ataque");
                    }
                }
            }
            vidaGuerrero -= ataqueVampiro > 0 ? ataqueVampiro : 0;
            guerreroVivo = vidaGuerrero > 0;
            System.out.println("_______________________________________________________________________________");
        } while (guerreroVivo && vampiroVivo);
        System.out.println("La batalla ha terminado");
        System.out.println(vampiroVivo ? "El vampiro ha salido victorioso" : "El guerrero ha salido victorioso");
        scanner.close();
    }
}
