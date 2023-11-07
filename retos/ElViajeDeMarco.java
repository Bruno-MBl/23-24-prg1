import java.util.Scanner;

class ElViajeDeMarco {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
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
            System.out.println("DIA " + dia);
            double tiempoAvanceMarco = ((Math.random() * 2) + 8);
            double velocidadMarco = (Math.random() * 5) + 5;
            double probabilidadLluvia = Math.random() * 100;
            if (PROBABILIDAD_LLUVIA_FUERTE > probabilidadLluvia) {
                System.out.println("¡Ha llovido muchísimo!");
                velocidadMarco *= 0.25;
            } else if (PROBABILIDAD_LLUVIA_LEVE > probabilidadLluvia) {
                System.out.println("Ha llovido un poco");
                velocidadMarco *= 0.75;
            } else {
                System.out.println("Ha hecho un buen día");
            }

            double probabilidadMono = Math.random() * 100;
            if (PROBABILIDAD_MONO_ESCAPA > probabilidadMono) {
                System.out.println("¡He perdido tiempo buscando a Amedio!");
                tiempoAvanceMarco -= 2;
            }
            if (PROBABILIDAD_MONO_CANSADO > probabilidadMono) {
                System.out.println("Amedio se ha cansado");
                velocidadMarco *= 0.90;
            }
            double avanceMarco = tiempoAvanceMarco * velocidadMarco;
            distancia -= avanceMarco;
            System.out.println("Avance " + tiempoAvanceMarco + " horas a " + velocidadMarco + " Km/h recorriendo "
                    + avanceMarco + " Km");

            double tiempoAvanceMama = (Math.random() * 3) + 6;
            double velocidadMama = (Math.random() * 3) + 6;
            probabilidadLluvia = Math.random() * 100;
            if (PROBABILIDAD_LLUVIA_FUERTE > probabilidadLluvia) {
                System.out.println("¡A mama le ha llovido muchisimo!");
                velocidadMama *= 0.50;
            } else if (PROBABILIDAD_LLUVIA_LEVE > probabilidadLluvia) {
                System.out.println("A mama le ha llovido un poco");
                velocidadMama *= 0.75;
            } else {
                System.out.println("A mama le ha hecho un buen dia");
            }
            double avanceMama = velocidadMama * tiempoAvanceMama;
            distancia += avanceMama;
            System.out.println("Mama pudo avanzar " + tiempoAvanceMama + " horas a " + velocidadMama
                    + " Km/h recorriendo " + avanceMama + " Km");
            if (distancia < 50) {
                double probabilidadAviso = Math.random() * 100;
                if (PROBABILIDAD_AVISO < probabilidadAviso) {
                    System.out.println("A Marco le dicen que han visto a su mamá, y rompe a correr!!!");
                    distancia -= 25;
                }
            }
            if (distancia <= 0) {
                marcoBusca = false;
                System.out.println(
                        "************************************************************\n" +
                        "Al final del día " + dia + " Marco encuentra a su madre!!!\n" +
                        "************************************************************");
            }
            else{
                System.out.println("Al final del día "+dia+" la distancia entre Marco y su Madre es de "+distancia+" Km");
            }
            scanner.nextLine();
        }
        scanner.close();
    }
}
