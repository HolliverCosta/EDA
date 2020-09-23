import java.util.Scanner;

class ElementosDuplicados {
	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		
		String[] numeros = entrada.nextLine().split(" ");
		
		String saida = "false";
		for(int i=0; i<numeros.length;i++) {
			for(int j=i+1; j<numeros.length;j++) {
				if(numeros[i].equals(numeros[j])) {
					saida = "true";
				}
			}
		}
		System.out.println(saida);
	}
	
}
