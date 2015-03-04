package pro.tremblay.javatools;

/**
 * Print the number of CPUs seen on a server
 */
public class NoOfCpu
{
    public static void main( String[] args ) {
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
