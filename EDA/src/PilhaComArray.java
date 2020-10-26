import java.util.Scanner;

class PilhaComArray {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int size = sc.nextInt();
		String[] option;

		PilhaComArray pilha = new PilhaComArray(size);

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

			case "peek":
				System.out.println(peek());
				break;

			case "push":
				if (isFull()) {
					System.out.println("full");
					break;
				} else {
					push(Integer.parseInt(option[1]));
					break;
				}

			case "pop":
				if (isEmpty()) {
					System.out.println("empty");
					break;
				} else {
					pop();
					break;
				}

			default:
				break;
			}

		} while (!option[0].equals("end"));
	}

	static int[] array;
	static int top;

	public PilhaComArray(int size) {
		this.array = new int[size];
		this.top = -1;

	}

	private static boolean isEmpty() {
		return top == -1;
	}

	private static boolean isFull() {
		return top + 1 == array.length;
	}

	private static void push(int element) {
		if (!isFull()) {
			top += 1;
			array[top] = element;

		}
	}

	private static void pop() {
		if (!isEmpty())
			top--;
	}

	private static int peek() {
		return array[top];
	}

	private static String printString() {
		String out = "";

		for (int i = 0; i < top+1; i++) {
			out += Integer.toString(array[i]) + " ";
		}
		return out.trim();
	}

}
