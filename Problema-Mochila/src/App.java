import java.util.Arrays;
import java.lang.Math;;



public class App {
    
    static int cont = 0;

    public static void main(String[] args) throws Exception {

        int n = 4; // 4, 8, 16, 32
        //int[] f = new int[n+128]; // 128, 1000, 10.000
        
        //System.out.println(memoizedFibo(f, n)+" contador: "+ cont);
        
        //System.out.println(fibo(n)+" contador: "+ cont);
        
        System.out.println(fiboRec(n)+" contador: "+ cont);
        
        //System.out.println(distEdProgDina("casa", "pai"));



    }
    public static int fiboRec(int n){
        cont++;
        if(n <= 1){
            return n;
    }
        else{
            int a = fiboRec(n - 1);
            int b = fiboRec(n - 2);
            return a + b;
        }
    }
    

    public static int fibo(int n){
        int[] f = new int[n+1];
        f[0] = 0; 
	    f[1] = 1;
	    for(int i = 2; i <= n;i++){
            f[i] = f[i-1] + f[i-2];
        }
        return f[n];
    }

  	public static int memoizedFibo(int[] f, int n) {
        for (int i = 0; i <= n; i++) {
            f[i] = -1;
        }
        return lookupFibo(f, n);
    }

    public static int lookupFibo(int[] f, int n) {
        if (f[n] >= 0) {
            return f[n];
        }
        if (n <= 1) {
            f[n] = n;
        } else {
            f[n] = lookupFibo(f, n-1) + lookupFibo(f, n-2);
        }
        return f[n];
    }

    public static void mochilaErrado() {
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

    public static int distEdProgDina(String A, String B){
        int m = A.length();
        int n = B.length();
        int custoExtra = 0;
        int matriz[][] = new int [m+1][n+1];
        // matriz[0][0] = 0;

        for(int i = 1; i <= m; i++){
            matriz[i][0] = matriz[i-1][0] + 1;
        }
        for(int j = 1; j<= n; j++){
            matriz[0][j] = matriz[0][j-1] + 1;
        }
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(A.charAt(i-1) == B.charAt(j-1)){
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
