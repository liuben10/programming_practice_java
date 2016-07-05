package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Evaluator {
	
	Map<String, Operator> operation = new HashMap<String, Operator>(); 
	{
		operation.put("+",  BinaryOperation.ADD);
		operation.put("-", BinaryOperation.SUBTRACT);
		operation.put("*", BinaryOperation.MULTIPLY);
		operation.put("/", BinaryOperation.DIVIDE);	
	}
	
	private final List<String> ORDER_OF_OPERATIONS = Arrays.asList("+", "-", "*", "/");
	
	interface Operator {
		int execute(int a, int b);
	}
	
	enum BinaryOperation implements Operator {
		ADD {
			@Override
			public int execute(int a, int b) {
				return a + b;
			}
		},
		SUBTRACT {
			@Override
			public int execute(int a, int b) {
				return a - b;
			}
			
		},
		MULTIPLY {
			@Override
			public int execute(int a, int b) {
				return a * b;
			}
		},
		DIVIDE {
			@Override
			public int execute(int a, int b) {
				return a / b;
			}
		}
	}
	
	
	public static void main(String...args) {
		Evaluator evaluator = new Evaluator();
		System.out.println(evaluator.parse("33+44+55*123"));
	}
	
	public int evaluate(final String expression) {
		List<String> parsedExpression = parse(expression);
		return evaluateHelper(parsedExpression);
	}
	
	public int evaluateHelper(final List<String> parsedExpression) {
		if (parsedExpression.size() == 1) {
			return evaluateSingleExpression(parsedExpression.get(0));
		}
		String prevOp = "";
		int result = 0;
		for (Iterator<String> iterator = parsedExpression.iterator(); iterator.hasNext();) {
			String currentExpr = iterator.next();
			int currentVal = evaluate(currentExpr);
			String nextOp = "";
			if (iterator.hasNext()) {
				nextOp = iterator.next();
			}
			if (nextOp.equals("*") || nextOp.equals("/")) {
				int multResult = currentVal;
				while((nextOp.equals("*") || nextOp.equals("/")) && iterator.hasNext()) {
					String toMultiply = iterator.next();
					multResult = operation.get(nextOp).execute(multResult, evaluate(toMultiply));
					if (iterator.hasNext()) {
						nextOp = iterator.next();
					} else {
						break;
					}
				}
				if (prevOp == "") {
					result = multResult;
				} else {
					result = operation.get(prevOp).execute(result,  multResult);
				}
				prevOp = nextOp;
			} else {
				if (prevOp == "") {
					result = currentVal;
				} else {
					result = operation.get(prevOp).execute(result, currentVal);
				}
				prevOp = nextOp;
			}
		}
		return result;
	}
	
	int evaluateSingleExpression(String expression) {
		int evaluated;
		if (isExpression(expression)) {
			evaluated = evaluate(expression);
		} else {
			evaluated = Integer.parseInt(expression);
		}
		return evaluated;
	}
	
	public boolean isNumber(String value) {
		return value.matches("[0-9]+");
	}
	
	public boolean isOperator(String value) {
		return value.matches("[\\+\\-\\*/]");
	}
	
	public boolean isExpression(String value) {
		return !isNumber(value) && !isOperator(value);
	}
	
	public List<String> parse(final String expression) {
		String trimmedExpression = expression.replaceAll("\\s+", "");
		String subExpression = "";
		int subExpressionCount = 0;
		List<String> expressions = new ArrayList<String>();
		for (int i = 0; i < trimmedExpression.length(); i++) {
			String currentCharacter = trimmedExpression.substring(i, i+1);
			if (currentCharacter.matches("[0-9]")) {
				subExpression += currentCharacter;
			} else if (currentCharacter.matches("[\\+\\-\\*/]")) {
				if (subExpressionCount >= 1) {
					subExpression += currentCharacter;
				} else {
					if (subExpression != "")
						expressions.add(subExpression);
					subExpression = "";
					expressions.add(currentCharacter);
				}
			} else if (currentCharacter.matches("\\(")) {
				subExpressionCount += 1;
				if (subExpressionCount > 1)
					subExpression += currentCharacter;
			} else if (currentCharacter.matches("\\)")) {
				subExpressionCount -= 1;
				if (subExpressionCount == 0) {
					expressions.add(subExpression);
					subExpression = "";
				} else {
					subExpression += currentCharacter;
				}
			}
		}
		if (!subExpression.equals("")) {
			expressions.add(subExpression);
		}
		return expressions;
	}
}
