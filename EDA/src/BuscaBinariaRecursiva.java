import java.util.Scanner;

class BuscaBinariaRecursiva {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);

		String[] numeros = entrada.nextLine().split(" ");

		String n = entrada.nextLine();
		int numeroProcurado = Integer.parseInt(n);

		int inicio = 0;

		int fim = numeros.length - 1;
		
		int[] numerosInteiros = new int[numeros.length];
        for (int i = 0; i < numeros.length; i++)
            numerosInteiros[i] = Integer.valueOf(numeros[i]);

		BuscaBinariaRecursiva.indexOf(numerosInteiros, numeroProcurado, inicio, fim);
	}

	public static int indexOf(int[] seq, int n, int inicio, int fim) {

		if (inicio <= fim) {
			int indiceMeio = (inicio + fim) / 2;
			System.out.println(indiceMeio);

			if (seq[indiceMeio] == n)
				return indiceMeio;

			if (n < seq[indiceMeio])
				return indexOf(seq, n, inicio, indiceMeio - 1);
			else
				return indexOf(seq, n, indiceMeio + 1, fim);
		} else {
			System.out.println(-1);
			return -1;
		}

	}
}