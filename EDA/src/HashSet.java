import java.util.Arrays;
import java.util.Scanner;

class MainHash{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int size = scan.nextInt();
        Hashset hashset = new Hashset(size);

        boolean value = true;
		String[] entrada;
		String option = "";
        
        while (value) {
            
            entrada = scan.nextLine().split(" ");
            option = entrada[0];
            
            switch(option){
                case "end":
                    value = false;
                    break;
                case "put":
                    int e = Integer.parseInt(entrada[1]);
                    hashset.put(e);
                    System.out.println(hashset.print());
                    break;

                case"remove":
                    int x = Integer.parseInt(entrada[1]);    
                    hashset.remove(x);
                    System.out.println(hashset.print());
                    break;
                case "contains":
                    int y = Integer.parseInt(entrada[1]);
                
                    System.out.println(hashset.contains(y)); 
                    break;
                
                }

        }
        scan.close();
	}

}

 class Hashset {

    Integer[] array;
    
    public Hashset(int size){
        this.array = new Integer[size];
    }
    private int hash(int key){
        return key % (this.array.length);
    }

    public void put(Integer element){
        if(element != null && !this.contains(element)){
            int sondagem = 0;
            int hash;

            while(sondagem < array.length){
                hash = (hash(element) + sondagem) % array.length;
                if(array[hash] == null){
                    array[hash] = element;
                    break;
                }
                sondagem++;
            }
        }

    }

    public void remove(Integer element){
        if(element != null && this.contains(element)){
            int sondagem = 0;
            int hash;

            while(sondagem < array.length){
                hash = (hash(element) + sondagem) % array.length;
                if(array[hash] != null && array[hash] == element){
                    array[hash] = null;
                    break;
                }
                sondagem++;
            }
        }

    }
    public boolean contains(Integer e){
        boolean retorno = false;
        if(e != null){
            int sondagem = 0;
            int hash;

            while(sondagem < array.length){
                hash = (hash(e) + sondagem) % array.length;
                if(array[hash] != null && array[hash] == e){
                    retorno = true;
                }
                sondagem++;
            }
        }
        return retorno;
    }
    public String print(){
        return Arrays.toString(array);
    }
    
}