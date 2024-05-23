package StackOperationExpression.StackOperation_Expression;

import java.util.HashMap;
import java.util.Stack;

public class ExpressionEvaluation {

	public boolean expressionEvaluation(String statement) {
		Stack<Character> stack = new Stack<>();
		HashMap<Character, Character> check = new HashMap<>();
		//HashMap for () and {}
		check.put('(', ')');
		check.put('{', '}');

		boolean valid = true;

		
		for (int j = 0; j < statement.length(); j++) { //For loop to loop through every word in the math expression
			char c = statement.charAt(j);

			if ((c == '{') || (c == '(')) {
				stack.push(c);
			}

			if (c == ')') { //Check to see if there is a pair of ()
				if (!stack.isEmpty()) {
					char PopedChar = stack.pop();
					if (check.get(PopedChar) != c) {
						printError(statement, j, 2);
						valid = false;
						break;
					}
				} else {
					printError(statement, j, 4);
					valid = false;
					break;
				}
			}

			if (c == '}') { //Check to see if there is a pair of {}
				if (!stack.isEmpty()) {
					char PopedChar = stack.pop();
					if (check.get(PopedChar) != c) {
						printError(statement, j, 1);
						valid = false;
						break;
					}
				} else {
					printError(statement, j, 5);
					valid = false;
					break;
				}

			}
		}

		if (!stack.isEmpty()) { //To make sure that there are no brackets left in the stack
			printError(statement, statement.length(), 3);
			valid = false;
		}
		return valid;
	}

	public static void printError(String statement, int location, int errorNo) {
		HashMap<Integer, String> errorMessage = new HashMap<>();

		errorMessage.put(1, " ) excepted ");
		errorMessage.put(2, " } excepted ");
		errorMessage.put(3, " close brackets");
		errorMessage.put(4, " ( missing");
		errorMessage.put(5, " { missing");

		System.out.println(statement);

		for (int i = 0; i < location; i++) {
			System.out.print(" ");
		}
		System.out.print("^ ");
		System.out.println(errorMessage.get(errorNo));

	}
}
