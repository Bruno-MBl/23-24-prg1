class RetoCCCF {
    public static void main(String[] args) {
        final int HORAS_JORNADA = 12;
        final int PROBABILIDAD_CLIENTE = 60;
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
            System.out.print("MINUTO "+minuto+" - ");
            double probabilidadCliente = Math.random() * 100;
            if (PROBABILIDAD_CLIENTE > probabilidadCliente) {
                cola++;
                System.out.print("Llega 1 persona - ");
            }else{
                System.out.print("No llega nadie  - ");
            }

            if (caja1Trabajando) {
                cargaCaja1--;
                itemsVendidos++;
                if (cargaCaja1 <= 0)
                    caja1Trabajando = false;
            } else if (cola > 0) {
                cola--;
                clientesTotales++;
                cargaCaja1 = (int) Math.random() * 10 + 5;
                caja1Trabajando = true;
            }
            if (caja2Trabajando) {
                cargaCaja2--;
                itemsVendidos++;
                if (cargaCaja2 <= 0)
                    caja2Trabajando = false;
            } else if (cola > 0) {
                cola--;
                clientesTotales++;
                cargaCaja2 = (int) Math.random() * 10 + 5;
                caja2Trabajando = true;
            }
            if (caja3Trabajando) {
                cargaCaja3--;
                itemsVendidos++;
                if (cargaCaja3 <= 0)
                    caja3Trabajando = false;
            } else if (cola > 0) {
                cola--;
                clientesTotales++;
                cargaCaja3 = (int) Math.random() * 10 + 5;
                caja3Trabajando = true;
            }
            if (caja4Trabajando) {
                cargaCaja4--;
                itemsVendidos++;
                if (cargaCaja4 <= 0)
                    caja4Trabajando = false;
            } else if (cola > 0) {
                cola--;
                clientesTotales++;
                cargaCaja4 = (int) Math.random() * 10 + 5;
                caja4Trabajando = true;
            }
            if (caja5Trabajando) {
                cargaCaja5--;
                itemsVendidos++;
                if (cargaCaja5 <= 0) {
                    caja5Trabajando = false;
                    if(clientesCaja5>=5&&cola<=15) clientesCaja5=0;
                }
            } else if (cola > 15 || clientesCaja5 < 5) {
                cola--;
                clientesTotales++;
                cargaCaja5 = (int) Math.random() * 10 + 5;
                caja5Trabajando = true;
                clientesCaja5++;
            }
            System.out.println("En Cola: "+cola);
            System.out.println("Caja1:["+cargaCaja1+"] | Caja2:["+cargaCaja2+"] | Caja3:["+cargaCaja3+"] | Caja4:["+cargaCaja4+"] | Caja5:["+cargaCaja5+"]");
            System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
            if (cola==0) colaVacia++;
        }
        System.out.println("RESUMEN");
        System.out.println("============================================================");
        System.out.println("Minutos con cola en cero      : "+colaVacia);
        System.out.println("Personas en la cola al cierre : "+cola);
        System.out.println("Personas atendidas en el dia  : "+clientesTotales);
        System.out.println("Articulos vendidos en el dia  : "+itemsVendidos);
        System.out.println("============================================================");
    }
}
