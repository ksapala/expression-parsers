package parser;

public class ParserFactory {

    private static final String PACKAGE = "parser.";

    public static Parser createParser(String className) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<Parser> aClass = (Class<Parser>) Class.forName(PACKAGE + className);
        return aClass.newInstance();
    }
}
