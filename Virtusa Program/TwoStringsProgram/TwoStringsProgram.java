import java.util.Scanner;
import java.util.Stack;

public class TwoStringsProgram {

	public static void main(String[] args) {

		Scanner scanner1 = new Scanner(System.in);
		Scanner scanner2 = new Scanner(System.in);

		System.out.println("enter 1st string");
		String s1 = scanner1.nextLine();
		System.out.println("enter 2nd string");
		String s2 = scanner2.nextLine();

		StringBuilder op1 = new StringBuilder();
		StringBuilder op2 = new StringBuilder();

		Stack<String> stk1 = new Stack<>();
		Stack<String> stk2 = new Stack<>();

		for (int i = 0; i < s1.length(); i++) {
			stk1.push(String.valueOf(s1.charAt(i)));
		}
		for (int i = 0; i < s2.length(); i++) {
			stk2.push(String.valueOf(s2.charAt(i)));
		}

		while (!stk1.isEmpty()) {
			String ch = stk1.pop();
			if (!s2.toLowerCase().contains(ch.toLowerCase())) {
				op1.append(ch);
			}
		}
		while (!stk2.isEmpty()) {
			String ch = stk2.pop();
			if (!s1.toLowerCase().contains(ch.toLowerCase())) {
				op2.append(ch);
			}
		}

		System.out.println("op1 - " + op1.reverse());
		System.out.println("op2 - " + op2.reverse());

	}

}
