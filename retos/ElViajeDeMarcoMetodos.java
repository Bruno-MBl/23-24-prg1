import java.util.Scanner;

class ElViajeDeMarcoMetodos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int PROBABILIDAD_LLUVIA_FUERTE = 10;
        final int PROBABILIDAD_LLUVIA_LEVE = 30 + PROBABILIDAD_LLUVIA_FUERTE;
        final int PROBABILIDAD_MONO_CANSADO = 25;
        final int PROBABILIDAD_MONO_ESCAPA = 15;
        final int PROBABILIDAD_AVISO = 50;
        int dia = 0;
        int distancia = 350;
        boolean marcoBusca = true;
        System.out.println("""
                DIARIO DEL VIAJE DE MARCO
                =========================
                    """);
        while (marcoBusca) {
            dia++;
            boolean lluviaSuave = false;
            boolean lluviaFuerte = false;
            boolean monoCansado = false;
            boolean monoPerdido = false;
            boolean marcoCorre = false;
            boolean lluviaSuaveMama = false;
            boolean lluviaFuerteMama = false;
            System.out.println("DIA " + dia);
            double tiempoAvanceMarco = ((Math.random() * 2) + 8);
            double velocidadMarco = (Math.random() * 5) + 5;
            double probabilidadLluvia = Math.random() * 100;
            if (PROBABILIDAD_LLUVIA_FUERTE > probabilidadLluvia) {
                velocidadMarco *= 0.25;
                lluviaFuerte = true;
            } else if (PROBABILIDAD_LLUVIA_LEVE > probabilidadLluvia) {
                velocidadMarco *= 0.75;
                lluviaSuave = true;
            } else {

            }

            double probabilidadMono = Math.random() * 100;
            if (PROBABILIDAD_MONO_ESCAPA > probabilidadMono) {
                monoPerdido = true;
                tiempoAvanceMarco -= 2;
            }
            if (PROBABILIDAD_MONO_CANSADO > probabilidadMono) {
                monoCansado = true;
                velocidadMarco *= 0.90;
            }
            double avanceMarco = tiempoAvanceMarco * velocidadMarco;
            distancia -= avanceMarco;
            double tiempoAvanceMama = (Math.random() * 3) + 6;
            double velocidadMama = (Math.random() * 3) + 6;
            probabilidadLluvia = Math.random() * 100;
            if (PROBABILIDAD_LLUVIA_FUERTE > probabilidadLluvia) {
                lluviaFuerteMama = true;
                velocidadMama *= 0.50;
            } else if (PROBABILIDAD_LLUVIA_LEVE > probabilidadLluvia) {
                lluviaSuaveMama = true;
                velocidadMama *= 0.75;
            }
            double avanceMama = velocidadMama * tiempoAvanceMama;
            distancia += avanceMama;
            if (distancia < 50 && distancia > 0) {
                double probabilidadAviso = Math.random() * 100;
                if (PROBABILIDAD_AVISO < probabilidadAviso) {
                    marcoCorre = true;
                    distancia -= 25;
                }
            }
            imprimirViaje(lluviaFuerte, lluviaSuave, monoCansado, monoPerdido, lluviaFuerteMama, lluviaSuaveMama,
                    marcoCorre, distancia);
            if (distancia <= 0) {
                marcoBusca = false;
                System.out.println(
                        "************************************************************\n" +
                                "Al final del día " + dia + " Marco encuentra a su madre!!!\n" +
                                "************************************************************");
            }
            scanner.nextLine();
        }
        scanner.close();

    }

    static void imprimirViaje(boolean lluviaFuerte, boolean lluviaSuave, boolean monoCansado, boolean monoPerdido,
            boolean lluviaFuerteMama, boolean lluviaSuaveMama, boolean marcoCorre, double distancia) {
        final String MONO_CANSADO = """
                            o_o
                 (_ _)     /|_|\\
                /(   )\\     / \\
                  o o       | |
                """;

        final String MONO_ESCAPA = """
                 o_o
                /|_|\\                  --     (> <)
                 / \\                    ---  /(   )\\
                 | |                     --    - -
                 """;
        final String MARCO_CAMINA = """
                 o_o
                /|_|\\  (o o)
                 / \\  /(   )\\
                 | |    - -
                 """;
        final String MARCO_CORRE = """
                       --      o_o
                         ---  /|_|\\
                        --     / \\
                       --      | |
                """;
        final String CARRO = """
                 _______
                |[]  [] |        _
                |_______|__--___/
                (o)    (o)  /\\ /\\
                    """;
        System.out.println("=".repeat(40));
        if (monoCansado && monoPerdido) {
            imprimirClima(lluviaFuerte, lluviaSuave);
            System.err.print(MONO_ESCAPA);
            System.out.println("_".repeat(40));
            imprimirClima(lluviaFuerte, lluviaSuave);
            System.out.print(MONO_CANSADO);
        } else if (monoCansado) {
            imprimirClima(lluviaFuerte, lluviaSuave);
            System.out.println(MONO_CANSADO);
        } else if (monoPerdido) {
            imprimirClima(lluviaFuerte, lluviaSuave);
            System.out.println(MONO_ESCAPA);
        } else {
            imprimirClima(lluviaFuerte, lluviaSuave);
            System.out.print(MARCO_CAMINA);
        }

        System.out.println(".".repeat(40));
        imprimirClima(lluviaFuerteMama, lluviaSuaveMama);
        System.out.println(CARRO);
        if (marcoCorre) {
            System.out.println("~".repeat(40));
            System.out.println(MARCO_CORRE);
        }
        if (distancia > 0 && distancia < 355) {
            System.out.println("█".repeat(40 - (int) (distancia / 9)) + "░".repeat((int) (distancia / 9))
                    + " " + (int) distancia + "km");
        } else if (distancia < 0) {
            System.out.println("█".repeat(40) + " 0 km");
        } else {
            System.out.println("░".repeat(40) + " " + (int) distancia + " km");
        }
    }

    private static void imprimirClima(boolean lluviaFuerte, boolean lluviaSuave) {
        final String LLUVIA_FUERTE = """
                 (@@@@)@@)      (@(@@@)      (@@@(@@@@)
                (@@@@(@@@)@@)  (@@@@(@@@)   (@@@@)@@@)@)
                 (@@@@@)@)      (@(@@@)       (@@)@@)@)
                """;
        final String LLUVIA_SUAVE = """
                   (   ) )        (  (   )
                (     )   )    (     (     )
                  (     )       (     )  )
                """;
        final String BUEN_TIEMPO = """
                 - O -
                 / | \\

                """;
        if (lluviaSuave)
            System.out.print(LLUVIA_SUAVE);
        else if (lluviaFuerte)
            System.out.print(LLUVIA_FUERTE);
        else
            System.out.print(BUEN_TIEMPO);
    }
}