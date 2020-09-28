import java.util.Arrays;
import java.util.Scanner;

class InsertOrdenadoUltimo {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		String[] numeros = entrada.nextLine().split(" ");
		
		int[] numerosInteiros = new int[numeros.length];
		
		for(int i = 0;i<numeros.length;i++) {
			numerosInteiros[i] = Integer.valueOf(numeros[i]);
		}
		sort(numerosInteiros);
		
	}
	public static void sort(int[] array) {
		int i = array.length-1;
		
		while(i>0 && array[i]<array[i-1]) {
			int auxiliar = array[i];
			array[i] = array[i-1];
			array[i-1] = auxiliar;
			i-=1;
		}
		System.out.println(Arrays.toString(array));
	}
}
