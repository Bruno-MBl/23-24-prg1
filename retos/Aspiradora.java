public class Aspiradora {

    public static void main(String[] args) {
        int[][] oficina = new int[10][25];
        oficina = ensuciarOficina(oficina);
        oficina=añadirSofa(oficina);
        mostrarOficina(oficina);
    }

    private static int[][] añadirSofa(int[][] oficina) {
        int[] sofa1={(int)Math.random()*oficina.length,(int)Math.random()*oficina[0].length-1};
        int[] sofa2={(int)Math.random()*oficina.length,(int)Math.random()*oficina[0].length-1};
        while(sofa1[0]==sofa2[0]&&(sofa1[1]-sofa2[1]<=1||sofa2[1]-sofa1[1]<=1)){
            sofa2[0]=(int)Math.random()*oficina.length;
            sofa2[1]=(int)Math.random()*oficina[0].length-1;
        }
        oficina[sofa1[0]][sofa1[1]]=5;
        oficina[sofa1[0]][sofa1[1]+1]=6;
        oficina[sofa2[0]][sofa2[1]]=5;
        oficina[sofa2[0]][sofa2[1]+1]=6;
        return oficina;
    }

    private static int[][] ensuciarOficina(int[][] oficina) {
        final int PROBABILIDAD_SUCIEDAD_1 = 20;
        final int PROBABILIDAD_SUCIEDAD_2 = 10;
        final int PROBABILIDAD_SUCIEDAD_3 = 4;
        final int PROBABILIDAD_SUCIEDAD_4 = 2;
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
        return oficina;
    }

    private static void mostrarOficina(int[][] oficina) {
        for (int i = 0; i < oficina.length; i++) {
            for (int j = 0; j < oficina[i].length; j++) {
                System.out.print(traducir(oficina[i][j]));
            }
            System.out.println();
        }
    }

    private static String traducir(int i) {
        String[] elementos = { " . ", "...", "ooo", "OOO", "***", "(0)", "\"^\"","[##","##]"};
        return elementos[i];
    }

    private static int random() {
        return (int) (Math.random() * 100);
    }
}