import java.util.LinkedList;
import java.util.Scanner;

class WordCloud {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        String[] palavras = entrada.nextLine().split(" ");

        WordCloud wc = new WordCloud(palavras.length);

        for(String i : palavras){
            wc.put(i);
        }

        String option = entrada.nextLine();
        while(!option.equals("fim")){
            System.out.println(Integer.toString(wc.count(option)));
            option = entrada.nextLine();
        }
    }

    LinkedList<String>[] cloud;

    public WordCloud(int size){
        cloud = new LinkedList[size];
    }

    private int hash(String palavra, int i){
        return (Math.abs(palavra.hashCode() % cloud.length) + i);
    }

    public int count(String elemento){
        return cloud[indexOf(elemento)].size();
    }

    public void put(String palavra){
        int prob = 0;
        int hashCode = this.hash(palavra,prob);
        if(contains(palavra)){
            cloud[indexOf(palavra)].add(palavra);
        } else{
            while(cloud[hashCode] !=null){
                hashCode = hash(palavra,++prob);
            }
            cloud[hashCode] = new LinkedList<>();
            cloud[hashCode].add(palavra);
        }
    }

    private boolean contains(String palavra){
        int i = 0;
        int hashCode = hash(palavra,i);
        while(i < cloud.length && cloud[hashCode] != null){
            if(cloud[hashCode].contains(palavra)){
                return true;
            }
            hashCode = hash(palavra,++i);
        }
        return false;
    }

    private int indexOf(String palavra) {
        if (!contains(palavra)) return -1;
        int i = 0;
        int hashCode = hash(palavra, i);
        while (i < cloud.length && cloud[hashCode] != null) {
            if (cloud[hashCode].contains(palavra)) {
                return hashCode;
            }
            hashCode = hash(palavra, ++i);
        }
        return -1;
    }
}


