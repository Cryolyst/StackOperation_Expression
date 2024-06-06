	package StackOperationExpression.StackOperation_Expression;

import java.util.HashMap;
import java.util.Stack;

public class InfixToPostfix {

	public static HashMap<Character, Integer> precedence = new HashMap<>();

	public String infix2postfix(String infix) {

		String post = "";
		loadPrecedence();
		Stack<Character> stack = new Stack<>(); //A stack to store the characters of the expression

		for (int j = 0; j < infix.length(); j++) {
			char c = infix.charAt(j);

			// For single digit
			if (Character.isDigit(c)) {
				post += c;
			}

			// For multi digit
			if (j + 1 >= infix.length() || !Character.isDigit(infix.charAt(j))) {
				post += " ";
			}

			if ((c == '{') || (c == '(')) { 
				stack.push(c);
			}

			if (c == '}') {

				char p = ' ';
				while (stack.peek() != '{') { // To pop all the characters in the stack until {
					p = stack.pop();
					post += p + " ";
				}
				p = stack.pop(); // Removes the {
			}

			if (c == ')') {

				char p = ' ';
				while (stack.peek() != '(') { // To pop all the characters in the stack until (
					p = stack.pop();
					post += p + " ";
				}
				p = stack.pop(); // Removes the (
			}

			if (c == '+' || c == '-' || c == '*' || c == '/') { // Check for operands and pop it according to the precedence
				while (!stack.isEmpty() && precedence.get(stack.peek()) >= precedence.get(c)) {
					char p = stack.pop();
					post += p + " ";
				}
				stack.push(c);
			}
		}
		while (!stack.isEmpty()) {
			char p = stack.pop();
			post += " " + p;
		}
		return post;
	}

	public static void loadPrecedence() { // A method to prioritize the operands in order
		precedence.put('+', 1);
		precedence.put('-', 1);
		precedence.put('*', 2);
		precedence.put('/', 2);
		precedence.put('(', 0);
		precedence.put('{', 0);
	}

}
