package parser;

import java.util.Arrays;
import java.util.Optional;
import java.util.Stack;
import java.util.function.BiFunction;

public class ReverseNotationParser implements Parser {

    public int parse(String expression) {
        Stack<Integer> numbers = new Stack<>();

        Arrays.stream(expression.split(""))
            .forEach(s -> {
                Optional<Integer> number = getInt(s);
                if (number.isPresent()) {
                    numbers.push(number.get());
                } else {
                    Integer argumentTwo = numbers.pop();
                    Integer argumentOne = numbers.pop();
                    numbers.push(operation(s).apply(argumentOne, argumentTwo));
                }
            });

        return numbers.pop();
    }

    private BiFunction<Integer, Integer, Integer> operation(String operand) {
        switch (operand) {
            case "+": return (o1, o2) -> o1 + o2;
            case "-": return (o1, o2) -> o1 - o2;
            case "*": return (o1, o2) -> o1 * o2;
            case "/": return (o1, o2) -> o1 / o2;
            default: throw new UnsupportedOperationException("Unsupported operand " + operand);
        }
    }

    private Optional<Integer> getInt(String string) {
        try {
            return Optional.of(Integer.parseInt(string));
        } catch (NumberFormatException | NullPointerException nfe) {
            return Optional.empty();
        }
    }
}
