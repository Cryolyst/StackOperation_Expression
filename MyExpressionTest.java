/* Thant Zarni Nay ID: 203007421 May_22
 *	
 * This program should be able to take in a math expression and check if the math expression is valid or not
 * If it is invalid, it should show why it is not a valid expression.
 * If it is valid, the program should create a postfix from the math expression and calculate the postfix expression and output the result.
 */
package StackOperationExpression.StackOperation_Expression;

import java.util.Scanner;

public class MyExpressionTest {

	public static void main(String[] args) {

		boolean valid;
		System.out.println("CS 211. Spring Quarter 2024");
		Scanner input = new Scanner(System.in);
		while (true) {
			System.out.printf("\nEnter a math expression: ");
			String expression = "";
			expression = input.nextLine();
			if (expression.length() == 0) {
				System.out.printf("\nBye!");
				break;
			} else {
				ExpressionEvaluation ee = new ExpressionEvaluation();
				valid = ee.expressionEvaluation(expression);
				if (valid) {
					System.out.println("Infix: " + expression);
					
					InfixToPostfix i2p = new InfixToPostfix();
					String postfix = i2p.infix2postfix(expression);
					System.out.println("postfix:" + postfix);
					
					PostFixEvaluation pe = new PostFixEvaluation();
					int result = pe.postfixEvaluation(postfix);
					System.out.println("result:" + result);
				} else {

				}
			}
		}

		input.close();
	}
}