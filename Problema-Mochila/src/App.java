import java.util.Arrays;
import java.lang.Math;;



public class App {
    public static void main(String[] args) throws Exception {
        
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
    public int distEdProgDina(String A, String B){
        int m = A.length();
        int n = B.length();
        int custoExtra = 0;
        int matriz[][] = new int [m][n];

        for(int i = 1; i < m; i++){
            matriz[i][0] = matriz[i-1][0] + 1;
        }
        for(int j = 1; j< n; j++){
            matriz[0][j] = matriz[0][j-1] + 1;
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(A.charAt(i) == B.charAt(j)){
                    custoExtra = 0;
                }else{
                    custoExtra = 1;
                }
                matriz[i][j] = Math.min(matriz[i-1][j]+ 1, Math.min(matriz[i][j-1]+1, matriz[i-1][j-1]+custoExtra));    
                
            }
        }
        return matriz[m][n];
    }
}
