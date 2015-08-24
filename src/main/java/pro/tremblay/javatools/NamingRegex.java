package pro.tremblay.javatools;

import java.util.regex.Pattern;

/**
 * @author Henri Tremblay
 */
public class NamingRegex {

    public static Pattern loggerRegex() {
        return Pattern.compile("^(?:LOG(?:GER)?)|(?:log(?:ger)?)$");
    }

    public static Pattern constantRegex() {
        return Pattern.compile("^(?:[A-Z][A-Z0-9]*(_[A-Z0-9]+)*)|(?:log(?:ger)?)$");
    }
}
