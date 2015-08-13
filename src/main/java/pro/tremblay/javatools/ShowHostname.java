package pro.tremblay.javatools;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author Henri Tremblay
 */
public class ShowHostname {

    public static void main(String[] args) throws UnknownHostException {
        System.out.println(InetAddress.getLocalHost().getHostName());
    }
}
