import java.util.Scanner;

class InsertSortRecursivo {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);

		String[] numeros = entrada.nextLine().split(" ");
		
		int[] numerosInteiros = new int[numeros.length];
			
		for(int i = 0;i<numeros.length;i++) {
			numerosInteiros[i] = Integer.valueOf(numeros[i]);
		}
		sort(numerosInteiros,numerosInteiros.length);
	}
	public static void sort(int[]array, int n) {
		if(n<=1)return;
		
		sort(array,n-1);
		
		int ultimo = array[n-1];
		int j = n-2;
		
		while(j>=0 && array[j] > ultimo) {
			array[j+1] = array[j];
			j--;
		}
		array[j+1] = ultimo;
	}
}
