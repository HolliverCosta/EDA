import java.util.Arrays;
import java.util.Scanner;

class CountingSort {
public static void main(String[] args) {
	Scanner entrada = new Scanner(System.in);
	String [] numeros = entrada.nextLine().split(" ");
	int k = entrada.nextInt();
	
	int[] array = new int[numeros.length];
	for(int i = 0;i<numeros.length;i++) 
		array[i] = Integer.valueOf(numeros[i]);
	
	int[] freq = new int[k+1];
	for(int i = 0; i<array.length;i++) {
		freq[array[i]]+=1;
		System.out.println(imprimeVetor(freq));
	}
	for(int i = 1;i<freq.length;i++) {
		freq[i] +=freq[i-1];
	}
		System.out.println("Cumulativa do vetor de contagem - " + imprimeVetor(freq));
	int[]arrayOrdenado = new int[array.length];
	for(int i = array.length-1; i>=0;i--) {
		arrayOrdenado[freq[array[i]]-1] = array[i];
		freq[array[i]] -= 1;
		}
		System.out.println(imprimeVetor(freq));
		System.out.println(imprimeVetor(arrayOrdenado));
		
	}
	public static String imprimeVetor(int[] array){
    String vetor = "";
    for(int i = 0; i < array.length;i++)
        vetor+= Integer.toString((array[i]))+" ";
    
    return vetor.trim();
	}
}
