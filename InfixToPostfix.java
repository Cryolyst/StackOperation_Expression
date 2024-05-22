package StackOperationExpression.StackOperation_Expression;

import java.util.HashMap;
import java.util.Stack;

public class InfixToPostfix {

	public static HashMap<Character, Integer> precedence = new HashMap<>();

	public String infix2postfix(String infix) {

		String post = "";
		loadPrecedence();
		Stack<Character> stack = new Stack<>();

		for (int j = 0; j < infix.length(); j++) {
			char c = infix.charAt(j);

			//For single digit
			if (Character.isDigit(c)) {
				post += c;
			}
			
			//For multi digit
			if (j+1 >= infix.length() || !Character.isDigit(infix.charAt(j))) {
				post += " ";
			}

			if ((c == '{') || (c == '(')) {
				stack.push(c);
			}

			if (c == '}') {

				char p = ' ';
				while (stack.peek() != '{') {
					p = stack.pop();
					post += p;
				}
				p = stack.pop();
			}

			if (c == ')') {

				char p = ' ';
				while (stack.peek() != '(') {
					p = stack.pop();
					post += p;
				}
				p = stack.pop();
			}

			if (c == '+' || c == '-' || c == '*' || c == '/') {
				while (!stack.isEmpty() && precedence.get(stack.peek()) >= precedence.get(c)) {
					char p = stack.pop();
					post += p + " "; 
				}
				stack.push(c);
			}
		}
		while (!stack.isEmpty()) {
			char p = stack.pop();
			post += p;
		}
		return post;
	}

	public static void loadPrecedence() {
		precedence.put('+', 1);
		precedence.put('-', 1);
		precedence.put('*', 2);
		precedence.put('/', 2);
		precedence.put('(', 0);
		precedence.put('{', 0);
	}

}
