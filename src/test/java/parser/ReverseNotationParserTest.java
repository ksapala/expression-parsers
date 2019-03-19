package parser;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReverseNotationParserTest {


    private ReverseNotationParser parser;

    @Before
    public void setUp() {
        this.parser = new ReverseNotationParser();
    }

    @Test
    public void shouldParseSimple() {
        // given
        String expression = "34+";

        // when
        int expected = this.parser.parse(expression);

        // then
        assertEquals(7, expected);
    }

    @Test
    public void shouldParseComplex() {
        // given
        String expression = "1239+5-*+";

        // when
        int expected = this.parser.parse(expression);

        // then
        assertEquals(15, expected);
    }
}