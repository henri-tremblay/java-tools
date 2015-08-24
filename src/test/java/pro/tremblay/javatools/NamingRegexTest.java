package pro.tremblay.javatools;

import org.junit.Test;

import java.util.regex.Pattern;

import static org.junit.Assert.*;

/**
 * @author Henri Tremblay
 */
public class NamingRegexTest {

    @Test
    public void testLoggerRegex() throws Exception {
        assertTrue(matches("logger", NamingRegex.loggerRegex()));
        assertTrue(matches("LOGGER", NamingRegex.loggerRegex()));
        assertTrue(matches("log", NamingRegex.loggerRegex()));
        assertTrue(matches("logger", NamingRegex.loggerRegex()));
        assertFalse(matches("logGER", NamingRegex.loggerRegex()));
        assertFalse(matches("abc", NamingRegex.loggerRegex()));
        assertFalse(matches("alogger", NamingRegex.loggerRegex()));
    }

    @Test
    public void testConstantRegex() throws Exception {
        assertTrue(matches("A", NamingRegex.constantRegex()));
        assertTrue(matches("AB_CD_EF", NamingRegex.constantRegex()));
        assertTrue(matches("logger", NamingRegex.constantRegex()));
        assertTrue(matches("log", NamingRegex.constantRegex()));
        assertFalse(matches("a", NamingRegex.constantRegex()));
        assertFalse(matches("a_b", NamingRegex.constantRegex()));
        assertFalse(matches("aAB_CD", NamingRegex.constantRegex()));
        assertFalse(matches("AB_CDa", NamingRegex.constantRegex()));
    }

    private static boolean matches(String s, Pattern pattern) {
        return pattern.matcher(s).matches();
    }
}