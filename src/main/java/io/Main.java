package io;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        File myFile = new File("/Users/hatef.palizgar/Desktop/java-advanced-features/java-advanced-features/src/main/java/io/input.txt");

        // read from a file
        readFromFile(myFile);

        File targetFile = new File("/Users/hatef.palizgar/Desktop/java-advanced-features/java-advanced-features/src/main/java/io/output.txt");

        // write to a file
        writeToFile(targetFile);

        // write an object to a file (serialization)
        Book book = new Book("Shakespear", "Romeo and Juliet", 500_000);

        writeObjectToFile(book);

        // read an object from a file (deserialization)
        readObjectFromFile(new File("/Users/hatef.palizgar/Desktop/java-advanced-features/java-advanced-features/src/main/java/io/book"));


        // TODO: What is `nio` package and when to use its classes for I/O operation?
    }

    // Hint: Keep your methods' definition order the same as their invocation order
    private static void readFromFile(File myFile) {
        /*
        // Approach 1
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(myFile));
            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {  // finally block makes sure the resource is always closed no matter the exception
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        */

        // Approach 2: try-with-resources
        // takes care of closing all resources automatically
        try (BufferedReader reader = new BufferedReader(new FileReader(myFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private static void writeToFile(File targetFile) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(targetFile, true))) {
            writer.write("\nHellooooooooooo");
            writer.write("\nByeeeeeeeee");
            writer.append("\n===============");
            // TODO: what's the difference between append() and write()
            // TODO: what is flush() method doing?
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeObjectToFile(Book book) {
        File file = new File("/Users/hatef.palizgar/Desktop/java-advanced-features/java-advanced-features/src/main/java/io/book");
        try (ObjectOutputStream objectStream = new ObjectOutputStream(new FileOutputStream(file))) {
            objectStream.writeObject(book); // This will store bookV2 object in a file called bookV2
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readObjectFromFile(File file) {
        try (ObjectInputStream objectStream = new ObjectInputStream(new FileInputStream(file))) {
            Book book = (Book) objectStream.readObject();  // casting Object -> Book
            System.out.println(book);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
