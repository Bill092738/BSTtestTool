//License: MIT
//Main contributor: Bill092738, GPT-4o
//Passing this debug test will not guarantee that your BST implementation is correct!!!
//If you like this project, please consider giving it a star on GitHub!

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class BSTtestGenerator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            int mode = getMode(scanner);
            int[] range = getRange(scanner);
            int quantity = getQuantity(scanner, range[0], range[1]);

            String output = generateTestCase(mode, range[0], range[1], quantity);
            writeToFile(output, "Input.txt");

            System.out.println("Output successfully written to Input.txt");
        } catch (IllegalArgumentException e) {
            System.err.println("Input Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    private static int getMode(Scanner scanner) {
        System.out.print("Choose mode (1 for worst-case ordered, 2 for random): ");
        int mode = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        if (mode != 1 && mode != 2) {
            throw new IllegalArgumentException("Invalid mode selected. Please enter 1 or 2.");
        }
        return mode;
    }

    private static int[] getRange(Scanner scanner) {
        System.out.print("Enter the range of numbers (e.g., 1-10000): ");
        String rangeInput = scanner.nextLine();
        if (!rangeInput.matches("\\d+-\\d+")) {
            throw new IllegalArgumentException("Invalid range format. Please use the format 'start-end' (e.g., 1-10000).");
        }

        String[] rangeParts = rangeInput.split("-");
        int rangeStart = Integer.parseInt(rangeParts[0]);
        int rangeEnd = Integer.parseInt(rangeParts[1]);

        if (rangeStart > rangeEnd) {
            throw new IllegalArgumentException("Invalid range. The start of the range must be less than or equal to the end.");
        }

        return new int[]{rangeStart, rangeEnd};
    }

    private static int getQuantity(Scanner scanner, int rangeStart, int rangeEnd) {
        System.out.print("Enter the quantity of unique numbers to generate: ");
        int quantity = scanner.nextInt();
        if (quantity <= 0 || quantity > (rangeEnd - rangeStart + 1)) {
            throw new IllegalArgumentException("Invalid quantity. It must be greater than 0 and less than or equal to the range size.");
        }
        return quantity;
    }

    private static String generateTestCase(int mode, int rangeStart, int rangeEnd, int quantity) {
        StringBuilder sb = new StringBuilder();

        if (mode == 1) {
            System.out.println("Generating worst-case ordered test case...");
            for (int i = rangeStart; i < rangeStart + quantity; i++) {
                sb.append(i).append(",");
            }
        } else {
            System.out.println("Generating random test case...");
            HashSet<Integer> uniqueNumbers = new HashSet<>();
            Random random = new Random();

            while (uniqueNumbers.size() < quantity) {
                int randomNum = random.nextInt(rangeEnd - rangeStart + 1) + rangeStart;
                if (uniqueNumbers.add(randomNum)) {
                    sb.append(randomNum).append(",");
                }
            }
        }

        // Remove the last comma
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }

    private static void writeToFile(String content, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(content);
        } catch (IOException e) {
            throw new RuntimeException("An error occurred while writing to the file: " + e.getMessage());
        }
    }
}
