import java.util.Arrays;
import java.util.Scanner;

class CountingSortNegativo {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		String[] numeros = entrada.nextLine().split(" ");
		
		int k = entrada.nextInt();
		int menor = entrada.nextInt();
		
		int[] array = new int[numeros.length];
		for(int i = 0;i<numeros.length;i++) 
			array[i] = Integer.valueOf(numeros[i]);
		
		int range =  k - menor;
		int[] freq = new int[range+1];
       
        for (int i = 0; i < array.length; i++) {
            freq[array[i] - menor]++;
            System.out.println(Arrays.toString(freq));
        }
      
        for (int i = 0; i < freq.length-1; i++)
            freq[i+1] += freq[i];
        
        System.out.println("Cumulativa do vetor de contagem - " + Arrays.toString(freq));
        
        int[] arrayOrdenado = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            arrayOrdenado[freq[array[i]-menor]-1] = array[i];
            freq[array[i]-menor]--;
        }
        System.out.println(Arrays.toString(freq));
		System.out.println(Arrays.toString(arrayOrdenado));

	}

}
