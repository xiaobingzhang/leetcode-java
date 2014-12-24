package leetcode;

import java.util.Stack;

public class EvaluateReversePolishNotation {
	public static void main(String[] args) {
		EvaluateReversePolishNotation erp = new EvaluateReversePolishNotation();
		String[] tokens = { "3","-4","+"};
		int ret = erp.evalRPN(tokens);
		System.out.println(ret);
	}

	public int evalRPN(String[] tokens) {
		Stack<Integer> operand = new Stack<Integer>();
		int num1 = 0;
		int num2 = 0;
		for (String token : tokens) {
			if (token.equals("+") ||token.equals("-") ||token.equals("*") || token.equals("/")) {
				num1 = operand.pop();
				num2 = operand.pop();
			}
			switch (token) {
			case "+":
				operand.push((num2 + num1));
				break;
			case "-":
				operand.push((num2 - num1));
				break;
			case "*":
				operand.push((num2 * num1));
				break;
			case "/":
				operand.push((num2 / num1));
				break;
			default:
				operand.push(Integer.parseInt(token));
				break;
			}
		}
		return operand.pop();
	}
}
