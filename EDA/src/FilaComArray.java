import java.util.Scanner;

class FilaComArray {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        String[] option;

        FilaComArray fila = new FilaComArray(size);


        do {
            option = sc.nextLine().split(" ");

            switch (option[0]) {
                case "print":
                    if (isEmpty()) {
                        System.out.println("empty");
                        break;
                    } else {
                        System.out.println(printString());
                        break;
                    }

                case "element":
                    if (isEmpty()) {
                        System.out.println("empty");
                        break;
                    } else {
                        System.out.println(element());
                        break;
                    }

                case "add":
                    if (isFull()) {
                        System.out.println("full");
                        break;
                    } else {
                        add(Integer.parseInt(option[1]));
                        break;
                    }

                case "remove":
                    if (isEmpty()) {
                        System.out.println("empty");
                        break;
                    } else {
                        remove();
                        break;
                    }

                default:
                    break;
            }

        }while (!option[0].equals("end"));
    }

    static int[] array;
    static int tail;


    public FilaComArray(int size){
        this.array = new int[size];
        this.tail = -1;

    }

    private static boolean isEmpty(){
        return tail == -1;
    }

    private static boolean isFull(){
        return tail+1 == array.length;
    }

    private static void add(int element){
        if (!isFull()){
             tail++;
             array[tail] = element;

        }
    }

    private static void remove(){
        if(!isEmpty()) {
            for (int i = 0; i < array.length - 1; i++) {
                array[i] = array[i + 1];
            }
            tail--;
        }
    }



    private static int element(){
        return array[0];
    }

    private static String printString(){
        String out = "";

        for(int i = 0; i <= tail; i++){
            out += Integer.toString(array[i]) + " ";
        }
        return out.trim();
    }

}
