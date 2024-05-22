package StackOperationExpression.StackOperation_Expression;

import java.util.Scanner;
import java.util.Stack;

public class PostFixEvaluation {
	public int postfixEvaluation(String postfix) {
		int value1;
		int value2;
		int result = 0;
		Stack<Integer> stack = new Stack<>();
		Scanner input = new Scanner(postfix);

		while (input.hasNext()) {
			if (input.hasNextInt()) {
				stack.push(input.nextInt());
			} else {
				String token = input.next();

				value2 = stack.pop();
				value1 = stack.pop();

				if (token.equals("+")) {
					result = value1 + value2;
				} else if (token.equals("-")) {
					result = value1 - value2;
				} else if (token.equals("*")) {
					result = value1 * value2;
				} else if (token.equals("/")) {
					result = value1 / value2;
				}

				stack.push(result);
			}

		}
		input.close();
		return result;
	}
}
