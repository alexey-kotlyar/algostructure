package com.aparamonov.algostructure.list;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.MINUTES;


public class ListUsage {

    public static void main(String[] args) {
        String filePath = "./datastructures/src/main/resources/testFile.txt";
        ArrayList<String> arrayList = new ArrayList<>();
        LinkedList<String> linkedList = new LinkedList<>();
        ListUsage test = new ListUsage();

        System.out.print("Enter amount of lines to generate into file: ");
        Scanner scanner = new Scanner(System.in);
        int amount = scanner.nextInt();
        test.generateFileWithData(amount, filePath);
        System.out.println("Finished write data to file");

        System.out.println("-------------> ArrayList usage:");
        test.appendToEnd(filePath, arrayList);
        test.appendToMiddle(filePath, arrayList);
        test.removeFromList(arrayList);

        System.out.println("-------------> LinkedList usage:");
        test.appendToEnd(filePath, linkedList);
        test.appendToMiddle(filePath, linkedList);
        test.removeFromList(linkedList);

    }

    /**
     * # Generates file and fills it with UUID per line
     *
     * @param linesAmount amount of UUID lines to generate
     * @param filePath path to file on filesystem
     */
    public void generateFileWithData(int linesAmount, String filePath) {
        try {
            Path path = Paths.get(filePath);
            Files.deleteIfExists(path);
            try (BufferedWriter writer = Files.newBufferedWriter(path)) {
                for(int i = 0; i < linesAmount; i++) {
                    String uuid = UUID.randomUUID().toString();
                    writer.write(uuid);
                    writer.newLine();
                }
                System.out.println("Finished write data to file");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * # Appends lines from given file to the END of the list
     *
     * @param filePath path to file which contains data
     * @param list datastructure - implementation of List interface:
     *             - ArrayList
     *             - LinkedList
     */
    public void appendToEnd(String filePath, List<String> list) {
        System.out.println("Appending to the end...");

        long startTime = System.currentTimeMillis();
        try (Stream<String> stream = Files.lines(Paths.get(filePath))) {
            stream.forEach(list::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();

        System.out.println("Append to the end took: " + measureTime(startTime, endTime));
    }

    /**
     * # Appends lines from given file to the MIDDLE of the list
     *
     * @param filePath path to file which contains data
     * @param list datastructure - implementation of List interface:
     *             - ArrayList
     *             - LinkedList
     */
    public void appendToMiddle(String filePath, List<String> list) {
        System.out.println("Appending to the middle...");
        System.out.println("List size: " + list.size());

        long startTime = System.currentTimeMillis();
        try (Stream<String> stream = Files.lines(Paths.get(filePath))) {
            stream.forEach(l -> list.add(list.size()/2, l));
        } catch (IOException e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();

        System.out.println("Append to the middle took: " + measureTime(startTime, endTime));
    }

    /**
     * # Removes lines from given list
     *
     * @param list datastructure - implementation of List interface:
     *             - ArrayList
     *             - LinkedList
     */
    public void removeFromList(List<String> list) {
        System.out.println("Removing lines from the list...");

        long startTime = System.currentTimeMillis();
        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }
        long endTime = System.currentTimeMillis();

        System.out.println("Removing lines from the list took: " + measureTime(startTime, endTime));
    }

    /**
     * # Measures time spent for operation
     *
     * @param startTime start time of operation
     * @param endTime end time of operation
     * @return String representation of difference between start and end time formatted as: `XX min, XX sec`
     */
    private String measureTime(long startTime, long endTime) {
        long timeDifference = endTime - startTime;
        return String.format("%02d min, %02d sec",
                MILLISECONDS.toMinutes(timeDifference),
                MILLISECONDS.toSeconds(timeDifference) -
                        MINUTES.toSeconds(MILLISECONDS.toMinutes(timeDifference))
        );
    }

}
