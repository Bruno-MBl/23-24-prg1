public class RetoCCCFArrays {
    public static void main(String[] args) {
        final int HORAS_JORNADA = 12;
        final int PROBABILIDAD_CLIENTE = 50;
        final int MINIMO_ITEMS = 5;
        final int MAXIMO_ITEMS = 15;
        int[] cajas = { 0, 0, 0, 0 };
        int cola = 0;
        int colaVacia = 0;
        int clientesTotales = 0;
        int itemsVendidos = 0;

        for (int minuto = 1; minuto <= HORAS_JORNADA * 60; minuto++) {
            System.out.print("MINUTO " + minuto + " - ");
            double probabilidadCliente = Math.random() * 100;
            if (PROBABILIDAD_CLIENTE > probabilidadCliente) {
                cola++;
                System.out.print("Llega 1 persona - ");
            } else {
                System.out.print("No llega nadie  - ");
            }
            for (int caja = 0; caja < cajas.length; caja++) {
                if (cajas[caja] > 0) {
                    cajas[caja]--;
                    itemsVendidos++;
                } else if (cola > 0) {
                    cola--;
                    clientesTotales++;
                    cajas[caja] = (int) (Math.random() * (MAXIMO_ITEMS - MINIMO_ITEMS)) + MINIMO_ITEMS;
                }
            }

            System.out.println("En Cola: " + cola);
            System.out.println("Caja1:[" + cajas[0] + "] | Caja2:[" + cajas[1] + "] | Caja3:[" + cajas[2]
                    + "] | Caja4:[" + cajas[3] + "]");
            System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
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
}
