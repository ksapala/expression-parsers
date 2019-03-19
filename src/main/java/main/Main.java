package main;

import parser.Parser;
import parser.ParserFactory;

public class Main {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        if (args == null || args.length < 2) {
            throw new IllegalArgumentException("Pass at least two arguments.");
        }
        Parser parser = ParserFactory.createParser(args[1]);
        int result = parser.parse(args[0]);
        System.out.println(result);
    }
}
