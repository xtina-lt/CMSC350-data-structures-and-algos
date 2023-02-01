import java.util.*;
import java.util.regex.Pattern;

public class Evaluation {
    private Stack<String> operands = new Stack<>();
    private Stack<String> operators = new Stack<>();

    private List<String> getList(String e) {
        List<String> arrList = new ArrayList<>();
        arrList.add(Character.toString(e.charAt(0)));

        // split the string
        // add each to the list
        for (int i = 1; i < e.length(); i++) {
            // check if the first and second digit are combined
            char a = e.charAt(i - 1);
            char b = e.charAt(i);
            
            // keep going if space
            if (b == ' ') continue;

            if (Character.isDigit(b) && Character.isDigit(a)) {
                int last = (arrList.size() - 1);
                // add the combination of first digits
                // aka multiple digit number to the end
                arrList.set(last, arrList.get(last) + b);
            } else {
                // if not just add single digit
                arrList.add(Character.toString(b));
            }
        }
        return arrList;
    }

    private int getPrecedance(String e) {
        int result = 0;
        switch (e) {
            case "+":
            case "-":
                result = 1;
                break;
            case "*":
            case "/":
                result = 2;
        }
        return result;
    }

    private String calculate(String num2, String operator, String num1) throws DivideByZeroException {
        int a = Integer.parseInt(num1);
        int b = Integer.parseInt(num2);
        int result = 0;
        switch (operator) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            case "/":
                if (b == 0) {
                    throw new DivideByZeroException("Divison by zero");
                }
                result = a / b;
                break;
        }
        System.out.printf("%d %s %d = %d\n", a, operator, b, result);
        return Integer.toString(result);
    }

    public String eval(String calculate) throws DivideByZeroException, InvalidCharException, EmptyStackException {
        // 1) Split the strings
        List<String> lst = getList(calculate);
        System.out.println(lst);

        // 2) Read the strings
        for (String e : lst) {
            String operatorsReg = String.valueOf( Pattern.compile("[*/+\\-]") );
            String operandsReg = String.valueOf( Pattern.compile("[\\d.?]+") );
            if (!e.matches(operandsReg) && !e.matches(operatorsReg)
                && !e.equals("(") && !e.equals(")")) {
                throw new InvalidCharException();
            }

            // 3 ) Check for invalid characters
            if ( e.matches(operandsReg) ) {
                operands.push(e);
                System.out.printf("Operand: %s\n", e);
            } else if (e.equals("(")) {
                operators.push(e);
                System.out.printf("Operator (: %s\n", e);
            } else if (e.equals(")")) {
                System.out.printf(") Operator: %s\n", e);
                while (!operators.peek().equals("(")) {
                    operands.push(calculate(operands.pop(),
                            operators.pop(), operands.pop()));
                }
                operators.pop();
            // 4 ) calculate
            } else if (e.matches(operatorsReg)) {
                while (!operators.empty() && getPrecedance(operators.peek()) >= getPrecedance(e)) {
                    operands.push(calculate(operands.pop(), operators.pop(), operands.pop()));
                }
                operators.push(e);
                System.out.printf("Operator: %s\n", e);
            }
        }

        // when there is nothing left in the stack
        // show result
        while (!operators.empty()) {
            operands.push(calculate(operands.pop(), operators.pop(), operands.pop()));
            System.out.printf("result: %s\n", operands.peek());
        }
        return operands.pop();
    }





}

