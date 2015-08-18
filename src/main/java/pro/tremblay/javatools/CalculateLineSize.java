package pro.tremblay.javatools;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Henri Tremblay
 */
public class CalculateLineSize {

    private static long count = 0, average = 0, min = Long.MAX_VALUE, max = 0;

    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.err.println("Usage: CalculateLineSize file");
            System.exit(1);
        }

        long start = System.currentTimeMillis();

        List<Long> lengths = new ArrayList<>(100_000);

        try(BufferedWriter out = new BufferedWriter(new FileWriter("output.csv"))) {
            Files.lines(Paths.get(args[0]))
                .forEach(l -> {
                    long length = l.length();
                    count++;
                    average += length;
                    if (length < min) {
                        min = length;
                    }
                    if (length > max) {
                        max = length;
                    }
                    lengths.add(length);
                    try {
                        out.write("" + length);
                        out.newLine();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
        }

        average /= count;

        long median;
        Collections.sort(lengths);
        if(count % 2 == 0) {
            int a = (int) (count / 2);
            int b = a + 1;
            median = (lengths.get(a) + lengths.get(b)) / 2;
        }
        else {
            median = count / 2 + 1;
            median = lengths.get((int) median);
        }

        double standardDeviation = 0;
        for (long i : lengths) {
            long diff = i - average;
            standardDeviation += diff * diff;
        }
        standardDeviation /= (count - 1);
        standardDeviation = Math.sqrt(standardDeviation);

        long end = System.currentTimeMillis();

        System.out.printf("Line count:         %10d%n", count);
        System.out.printf("Min:                %10d%n", min);
        System.out.printf("Max:                %10d%n", max);
        System.out.printf("Average:            %10d%n", average);
        System.out.printf("Median:             %10d%n", median);
        System.out.printf("Standard Deviation: %10d%n", (long) standardDeviation);

        System.out.println();
        System.out.println("Time: " + (end - start));
    }
}
