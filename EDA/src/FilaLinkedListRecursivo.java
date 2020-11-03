import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        QueueUsingLinkedList queue = new QueueUsingLinkedList();
        String[] operation;
        
        do{
            operation = sc.nextLine().split(" ");
            switch (operation[0]) {
                case "add":
                    queue.add(Integer.parseInt(operation[1]));
                break;

                case "remove":
                    if(queue.isEmpty()){
                        System.out.println("empty");
                    }else{
                        queue.remove();
                    }
                break;

                case "search":
                    if(queue.isEmpty()){
                        System.out.println(-1);
                    }else{
                        System.out.println(queue.search(Integer.parseInt(operation[1])));
                    }
                break;

                case "element":
                    if(queue.isEmpty()){
                        System.out.println("empty");
                    }else{
                        System.out.println(queue.element());
                    }
                break;

                case "print":
                    if(queue.isEmpty()){
                        System.out.println("empty");
                    } else {
                        System.out.println(queue.print());
                    }
                    break;
            
                default:
                    break;
            }
        }while(!operation[0].equals("end"));

        sc.close();
    }
    
}

class QueueUsingLinkedList{

    RecursiveDoubleLinkedListImpl queueArray;
    int tail;
    
    public QueueUsingLinkedList() {
        this.queueArray = new RecursiveDoubleLinkedListImpl();
        tail = -1;
    }
    
    public void add(Integer element) {
        this.queueArray.insert(element);
    }

    public void remove(){
        this.queueArray.removeFirst();
    }

    public int element() {
        return this.queueArray.element();
    }

    public String print(){
        return this.queueArray.print();
    }

    public int search(Integer element){
        return this.queueArray.search(element);
    }

    public boolean isEmpty() {
        return this.queueArray.isEmpty();
    }
    
}

class RecursiveDoubleLinkedListImpl {
    private DoubleLinkedListNode head;
    private DoubleLinkedListNode tail;

    public RecursiveDoubleLinkedListImpl(){
        this.head = null;
        this.tail = null;
    }

    public boolean isEmpty(){
        return this.head == null;
    }

    public void insert(int element) {
        if(this.isEmpty()){
            this.head = new DoubleLinkedListNode();
            this.head.setData(element);
            this.tail = head;
        } else {
            this.recursiveInsert(element, head.getNext());
        }
    }

    private void recursiveInsert(int element, DoubleLinkedListNode node){
        if(node == null){
            node = new DoubleLinkedListNode();
            node.setPrevious(tail);
            node.setData(element);
            this.tail.setNext(node);
            this.tail = node;
        } else{
            recursiveInsert(element, node.getNext());
        }
    }

    public void removeFirst(){
        if(!this.isEmpty()){
            if(head.getNext() == null){
                head = null;
                tail = null;
            } else{
                head.getNext().setPrevious(null);
                head = head.getNext();
            }
        }
    }

    public int element(){
        return this.head.getData();
    }

    public int search(int element){
        int count = 0;

        if(!this.contains(element)){
            return -1;
        }

        if(this.head.getData() == element){
            return count;
        } else {
            count += rescursiveSearch(element, head.getNext());
        }
        return count;
    }

    private int rescursiveSearch(int element, DoubleLinkedListNode next) {

        if(next.getData() == element){
            return 1;
        } else {
            return 1 + rescursiveSearch(element, next.getNext());
        }
    }

    private boolean contains(int element){
        if(this.isEmpty()) return false;
        return containsRecursive(head, element);
    }

    private boolean containsRecursive(DoubleLinkedListNode node, int element) {
        if(node.getData() == element){
            return true;
        } else if(node.getNext() == null){
            return false;
        } else {
            return containsRecursive(node.getNext(),element);
        }
    }

    public String print() {
        String output = head.getData() + " ";
        return recursivePrint(output, head.getNext());
    }

    private String recursivePrint(String output, DoubleLinkedListNode next) {
        if(next == null){
            return output.trim();
        }
        output += next.getData() + " ";
        return recursivePrint(output, next.getNext());
    }

}

class DoubleLinkedListNode {
    private int data;
    private DoubleLinkedListNode next;
    private DoubleLinkedListNode previous;

    public DoubleLinkedListNode() {
    }

    public DoubleLinkedListNode(int data, DoubleLinkedListNode next, DoubleLinkedListNode previous) {
        this.data = data;
        this.next = next;
        this.previous = previous;
    }
    
    public int getData() {
        return data;
    }

    public void setData(int data) {
		this.data = data;
    }
    
	public void setNext(DoubleLinkedListNode next) {
        this.next = next;
    }
    
    public DoubleLinkedListNode getNext() {
        return next;
    }
    
    public DoubleLinkedListNode getPrevious() {
		return previous;
	}

	public void setPrevious(DoubleLinkedListNode previous) {
		this.previous = previous;
	}
}