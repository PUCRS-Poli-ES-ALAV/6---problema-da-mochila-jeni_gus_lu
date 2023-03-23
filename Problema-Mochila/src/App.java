import java.util.Arrays;



public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        int[] pesos  = new int[]{31, 29, 44, 53, 38 ,63, 85, 89, 82, 23};
        int[] valores  = new int[]{ 57, 49, 68, 60, 43, 67, 84, 87, 72, 92};
        double[][] razao = new double[pesos.length][3];

        int capacidade = 190;
        int usado = 0;
        int valorFinal = 0;

        for (int n = 0; n < razao.length; n++ ) {
            razao[n][0] = valores[n];
            razao[n][1] = pesos[n];
            razao[n][2] = valores[n]/(pesos[n] * 1.0);
            
            System.out.println(Arrays.toString(razao[n]));
        }

        java.util.Arrays.sort(razao, new java.util.Comparator<double[]>() {
            public int compare(double[] a, double[] b) {
                return Double.compare(a[2], b[2]);
            }
        });
        System.out.println();
        for (int n = 0; n < razao.length; n++ ) {
            System.out.println(Arrays.toString(razao[n]));
        }
        

        for (int n = razao.length - 1; n >= 0; n-- ) {
            if (usado + razao[n][1] <= capacidade) {
                usado +=  razao[n][1];
                valorFinal += razao[n][0];

                System.out.println("mochila: "+ razao[n][0] + " " + razao[n][1] );
            }
        }


    }
}
