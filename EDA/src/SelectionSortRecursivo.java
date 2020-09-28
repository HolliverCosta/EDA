import java.util.Arrays;
import java.util.Scanner;

class SelectionSortRecursivo {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);

		String[] numeros = entrada.nextLine().split(" ");
		
		int[] numerosInteiros = new int[numeros.length];
			
		for(int i = 0;i<numeros.length;i++) {
			numerosInteiros[i] = Integer.valueOf(numeros[i]);
		}
		sort(numerosInteiros,0,numerosInteiros.length-1);
		
	}
public static void sort(int[] array, int leftIndex, int rightIndex) {
		
		if(leftIndex==rightIndex)return;
		
		int indice_menor = leftIndex;
		
		for(int i=leftIndex+1;i<=rightIndex;i++) {
			if(array[i]<array[indice_menor]) {
				indice_menor=i;
			}
		
		}
		swap(array, leftIndex, indice_menor);
		System.out.println(Arrays.toString(array));
		sort(array, leftIndex+1, rightIndex);
		
	}
		
	private static void swap(int[]array, int i, int j ) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
