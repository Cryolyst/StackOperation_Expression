package StackOperationExpression.StackOperation_Expression;

import java.util.Scanner;

public class MyExpressionTest {

	public static void main(String[] args) {

		boolean valid;
		System.out.println("CS 211. Spring Quarter 2024");
		Scanner input = new Scanner(System.in);
		while (true) {
			System.out.println("Enter a math expression: ");
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
				}else {
					
				}
			}
		}
	}
}