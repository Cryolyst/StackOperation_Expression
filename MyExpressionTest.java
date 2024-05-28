
/* Thant Zarni Nay ID: 203007421 May_22
 *	
 * This program should be able to take in a math expression and check if the math expression is valid or not
 * If it is invalid, it should show why it is not a valid expression.
 * If it is valid, the program should create a postfix from the math expression and calculate the postfix expression and output the result.
 */

package StackOperationExpression.StackOperation_Expression;

import java.util.*;;

public class MyExpressionTest {

	public static void main(String[] args) {

		boolean valid;
		System.out.println("CS 211. Spring Quarter 2024");
		Scanner input = new Scanner(System.in);
		while (true) {
			try {
				System.out.printf("\nEnter a math expression: ");
				String expression = "";
				expression = input.nextLine();
				if (expression.length() == 0) {
					System.out.printf("\nBye!");
					break;
				} else {
					// Create a new instance to call the expressionEvaluation function
					ExpressionEvaluation ee = new ExpressionEvaluation();
					valid = ee.expressionEvaluation(expression);

					if (valid) { // if the expression is valid this is triggered
						System.out.println("Infix: " + expression);

						// Create a new instance of InFixToPostfix to calculate the Infix to postfix
						InfixToPostfix i2p = new InfixToPostfix();
						String postfix = i2p.infix2postfix(expression);
						System.out.println("postfix:" + postfix);

						// Create a new instance of PostFixEvaluation to calculate the postfix
						PostFixEvaluation pe = new PostFixEvaluation();
						int result = pe.postfixEvaluation(postfix);
						System.out.println("result:" + result);
					} else { // if the expression if invalid this is triggered
						System.out.println("Expression is invalid..");
					}
				}
			} catch (EmptyStackException e) { // To catch if there are multiple operators in a row
				System.out.println("ERROR multiple operators in a row..");
			} catch (Exception e) {
				System.out.println("An unknown error occured..");
			}
		}

		input.close();

	}
}