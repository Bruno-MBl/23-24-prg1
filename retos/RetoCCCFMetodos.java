import java.util.Scanner;

class RetoCCCFMetodos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int HORAS_JORNADA = 12;
        final int PROBABILIDAD_CLIENTE = 60;
        final int MINIMO_ITEMS = 5;
        final int MAXIMO_ITEMS = 15;
        int cargaCaja1 = 0;
        int cargaCaja2 = 0;
        int cargaCaja3 = 0;
        int cargaCaja4 = 0;
        int cargaCaja5 = 0;
        boolean caja1Trabajando = false;
        boolean caja2Trabajando = false;
        boolean caja3Trabajando = false;
        boolean caja4Trabajando = false;
        boolean caja5Trabajando = false;
        int clientesCaja5 = 0;
        int cola = 0;
        int colaVacia = 0;
        int clientesTotales = 0;
        int itemsVendidos = 0;

        for (int minuto = 1; minuto <= HORAS_JORNADA * 60; minuto++) {
            double probabilidadCliente = Math.random() * 100;
            if (PROBABILIDAD_CLIENTE > probabilidadCliente)
                cola++;

            cargaCaja1 = caja1Trabajando ? cargaCaja1 : 0;
            cargaCaja2 = caja2Trabajando ? cargaCaja2 : 0;
            cargaCaja3 = caja3Trabajando ? cargaCaja3 : 0;
            cargaCaja4 = caja4Trabajando ? cargaCaja4 : 0;
            cargaCaja5 = caja5Trabajando ? cargaCaja5 : 0;

            if (caja1Trabajando) {
                cargaCaja1--;
                itemsVendidos++;
                if (cargaCaja1 <= 1)
                    caja1Trabajando = false;
            } else if (cola > 0) {
                cola--;
                clientesTotales++;
                cargaCaja1 = (int) (Math.random() * MAXIMO_ITEMS - MINIMO_ITEMS) + MINIMO_ITEMS;
                caja1Trabajando = true;
            }

            if (caja2Trabajando) {
                cargaCaja2--;
                itemsVendidos++;
                if (cargaCaja2 <= 1)
                    caja2Trabajando = false;
            } else if (cola > 0) {
                cola--;
                clientesTotales++;
                cargaCaja2 = (int) (Math.random() * MAXIMO_ITEMS - MINIMO_ITEMS) + MINIMO_ITEMS;
                caja2Trabajando = true;
            }

            if (caja3Trabajando) {
                cargaCaja3--;
                itemsVendidos++;
                if (cargaCaja3 <= 1)
                    caja3Trabajando = false;
            } else if (cola > 0) {
                cola--;
                clientesTotales++;
                cargaCaja3 = (int) (Math.random() * MAXIMO_ITEMS - MINIMO_ITEMS) + MINIMO_ITEMS;
                caja3Trabajando = true;
            }

            if (caja4Trabajando) {
                cargaCaja4--;
                itemsVendidos++;
                if (cargaCaja4 <= 1)
                    caja4Trabajando = false;
            } else if (cola > 0) {
                cola--;
                clientesTotales++;
                cargaCaja4 = (int) (Math.random() * MAXIMO_ITEMS - MINIMO_ITEMS) + MINIMO_ITEMS;
                caja4Trabajando = true;
            }

            if (caja5Trabajando) {
                cargaCaja5--;
                itemsVendidos++;
                if (cargaCaja5 <= 1) {
                    caja5Trabajando = false;
                    if (clientesCaja5 >= 5 && cola <= 15)
                        clientesCaja5 = 0;
                }
            } else if (cola > 15 || (clientesCaja5 < 5 && clientesCaja5 > 0)) {
                cola--;
                clientesTotales++;
                cargaCaja5 = (int) (Math.random() * MAXIMO_ITEMS - MINIMO_ITEMS) + MINIMO_ITEMS;
                caja5Trabajando = true;
                clientesCaja5++;
            }

            imprimirCajas(cargaCaja1, cargaCaja2, cargaCaja3, cargaCaja4, cargaCaja5, cola, minuto);
            System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
            scanner.nextLine();
            if (cola == 0)
                colaVacia++;
        }
        System.out.println("RESUMEN");
        System.out.println("============================================================");
        System.out.println("Minutos con cola en cero      : " + colaVacia);
        System.out.println("Personas en la cola al cierre : " + cola);
        System.out.println("Personas atendidas en el dia  : " + clientesTotales);
        System.out.println("Articulos vendidos en el dia  : " + itemsVendidos);
        System.out.println("============================================================");
    }

    public static void imprimirCajas(int cargaCaja1, int cargaCaja2, int cargaCaja3, int cargaCaja4, int cargaCaja5,
            int cola, int minuto) {
        System.out.println("Minuto: " + minuto);
        System.out.println("Cola: " + "[#]".repeat(cola));
        System.out.println("-".repeat(30));
        System.out.println("Caja 1: " + "[#]".repeat(cargaCaja1));
        System.out.println("Caja 2: " + "[#]".repeat(cargaCaja2));
        System.out.println("Caja 3: " + "[#]".repeat(cargaCaja3));
        System.out.println("Caja 4: " + "[#]".repeat(cargaCaja4));
        System.out.println("Caja 5: " + "[#]".repeat(cargaCaja5));
    }
}
