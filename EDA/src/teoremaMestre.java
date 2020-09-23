import java.util.Scanner;

class teoremaMestre {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);

		String[] seq = entrada.nextLine().split(" ");

		int a = Integer.parseInt(seq[0]);
		int b = Integer.parseInt(seq[1]);
		int ord = Integer.parseInt(seq[2]);
		
		System.out.println(calcularTeoremaMestre(a, b, ord));
	}


	public static String calcularTeoremaMestre(int a,int b,int ord){
        String novaOrdem;

        if(ord < (int)(Math.log(a) / Math.log(b))){
            novaOrdem = Integer.toString((int) ((int) Math.log(a) / Math.log(b)));
            return "T(n) = theta(n**" + novaOrdem + "";

        } else if(ord == (int) (Math.log(a) / Math.log(b))) {
            return "T(n) = theta(n**" + ord + " * log n)";

        } else if(ord > ((int) Math.log(a) / Math.log(b))){
            return "T(n) = theta(n**" + ord + ")";
        }

        return "fail";
    }
}
