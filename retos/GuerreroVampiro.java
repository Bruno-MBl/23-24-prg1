import java.util.Scanner;

class GuerreroVampiro {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int PROBABILIDAD_ARMA_1 = 50;
        final int PROBABILIDAD_ARMA_2 = 25;
        final int PROBABILIDAD_ARMA_3 = 12;
        final int PROBABILIDAD_ATAQUE_1 = 90;
        final int PROBABILIDAD_ATAQUE_2 = 60;
        final int PROBABILIDAD_ATAQUE_3 = 40;
        final int PROBABILIDAD_DEFENDERSE = 80;
        final int VIDA_MAXIMA_GUERRERO = 150;
        boolean guerreroVivo = true;
        boolean vampiroVivo = true;
        int vidaGuerrero = VIDA_MAXIMA_GUERRERO;
        int vidaVampiro = 60;
        int turnosDePocion = 0;
        while (guerreroVivo && vampiroVivo) {
            System.out.println("Vida del guerrero: " + vidaGuerrero);
            System.out.println("Vida del vampiro: " + vidaVampiro);

            boolean opcionValida = false;
            int ataqueVampiro = 0;
            int ataqueGuerrero = 0;
            if (turnosDePocion > 0) {
                turnosDePocion--;
                if (turnosDePocion == 0)
                    vidaGuerrero = VIDA_MAXIMA_GUERRERO;
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
                    if ((opcion == 1 || opcion == 2 || opcion == 3) && vidaGuerrero < 30)
                        System.out.println("Estas demasiado debil y fallas el ataque");
                    else {
                        if (opcion == 1) {
                            System.out.println("Atacas con la daga");
                            if (PROBABILIDAD_ARMA_1 > probabilidadExito) {
                                System.out.println("El vampiro recibe el golpe");
                                ataqueGuerrero = 7;
                            } else
                                System.out.println("Fallaste el ataque");
                        } else if (opcion == 2) {
                            System.out.println("Atacas con la espada");
                            if (PROBABILIDAD_ARMA_2 > probabilidadExito) {
                                System.out.println("El vampiro recibe el golpe");
                                ataqueGuerrero = 15;
                            } else
                                System.out.println("Fallaste el ataque");
                        } else if (opcion == 3) {
                            System.out.println("Atacas con el hacha");
                            if (PROBABILIDAD_ARMA_3 > probabilidadExito) {
                                System.out.println("El vampiro recibe el golpe");
                                ataqueGuerrero = 30;
                            } else
                                System.out.println("Fallaste el ataque");
                        } else if (opcion == 4) {
                            System.out.println("Decides bloquear el ataque");
                            if (PROBABILIDAD_DEFENDERSE > probabilidadExito) {
                                System.out.println("Bloqueas con exito");
                                ataqueVampiro -= 5;
                            } else
                                System.out.println("Fallaste el bloqueo");
                        } else if (opcion == 5) {
                            System.out.println("Decides tomarte una pocion");
                            turnosDePocion = 3;
                        } else {
                            System.out.println("Esa no es una accion valida");
                            opcionValida = false;
                        }
                    }
                }
            }
            if (vidaVampiro < 20)
                System.out.println("El vampiro esta muy debil y falla el ataque");
            else {
                System.out.println("El vampiro ataca");
                int ataque = (int) (Math.random() * 3) + 1;
                double probabilidadExito = Math.random() * 100;
                if (ataque == 1) {
                    if (PROBABILIDAD_ATAQUE_1 > probabilidadExito) {
                        System.out.println("El vampiro te araña haciendote 5 de daño");
                        ataqueVampiro += 5;
                    } else
                        System.out.println("El vampiro falla su ataque");
                } else if (ataque == 2) {
                    if (PROBABILIDAD_ATAQUE_2 > probabilidadExito) {
                        System.out.println("El vampiro te golpea haciendote 10 de daño");
                        ataqueVampiro += 10;
                    } else
                        System.out.println("El vampiro falla su ataque");
                } else {
                    if (PROBABILIDAD_ATAQUE_3 > probabilidadExito) {
                        System.out.println("El vampiro te muerde haciendote 20 de daño");
                        ataqueVampiro += 20;
                    } else
                        System.out.println("El vampiro falla su ataque");
                }
            }
            vidaGuerrero -= ataqueVampiro > 0 ? ataqueVampiro : 0;
            vidaVampiro -= ataqueGuerrero;
            vampiroVivo = vidaVampiro > 0;
            guerreroVivo = vidaGuerrero > 0;
            if (vidaGuerrero < 30)
                vidaGuerrero += 2;
            if (vidaVampiro < 20)
                vidaVampiro += 2;
            System.out.println("_______________________________________________________________________________");
        }
        System.out.println("La batalla ha terminado");
        if (vampiroVivo)
            System.out.println("El vampiro ha salido victorioso");
        else
            System.out.println("El guerrero ha salido victorioso");
        scanner.close();
    }
}
