package calculator;

import java.util.Stack;

public class Calculator {

    private final Stack<Integer> stack = new Stack<>();

    public int calculate(String string) {
        stack.push(Character.getNumericValue(string.charAt(0)));

        for (int i = 2; i < string.length(); i += 4) {
            char operator = string.charAt(i);
            int operand = Character.getNumericValue(string.charAt(i + 2));
            separate(operator, operand);
        }
        return stack.pop();
    }

    private void separate(Character operator, int operand) {
        if (operator == '+') {
            Integer pop = stack.pop();
            stack.add(add(pop, operand));
        } else if (operator == '-') {
            Integer pop = stack.pop();
            stack.add(subtract(pop, operand));
        } else if (operator == '*') {
            Integer pop = stack.pop();
            stack.add(multiply(pop, operand));
        } else if (operator == '/') {
            Integer pop = stack.pop();
            stack.add(divide(pop, operand));
        }
    }

    public int add(int valueOne, int valueTwo) {
        return valueOne + valueTwo;
    }

    public int subtract(int valueOne, int valueTwo) {
        return valueOne - valueTwo;
    }

    public int multiply(int valueOne, int valueTwo) {
        return valueOne * valueTwo;
    }

    public int divide(int valueOne, int valueTwo) {
        return valueOne / valueTwo;
    }
}
